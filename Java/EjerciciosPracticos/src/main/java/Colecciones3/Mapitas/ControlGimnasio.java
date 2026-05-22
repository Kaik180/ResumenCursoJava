package Colecciones3.Mapitas;

import java.util.HashMap;
import java.util.Map;

public class ControlGimnasio {
    public static void main(String[] args) {

        // Declaramos el "mapita":
        // - Clave (Key): El número de carné del socio (String)
        // - Valor (Value): El objeto Socio completo
        Map<String, Socio> padronSocios = new HashMap<>();

        System.out.println("=================================================");
        System.out.println("1. REGISTRAR SOCIOS -> (.put)");
        System.out.println("=================================================");
        // Añadimos elementos al mapa asociando su clave con su valor
        padronSocios.put("SOC-101", new Socio("Carlos Gómez", "Mensual", true));
        padronSocios.put("SOC-202", new Socio("Lucía Martínez", "VIP", true));
        padronSocios.put("SOC-303", new Socio("Andrés Pérez", "Anual", false)); // No ha pagado

        System.out.println("Socios registrados en la base de datos con éxito.");


        System.out.println("\n=================================================");
        System.out.println("2. ESCÁNER DE LA ENTRADA -> (.get y .containsKey)");
        System.out.println("=================================================");
        // Simulamos que alguien pasa una tarjeta por el torno de la entrada
        String codigoTarjeta = "SOC-303";

        // .containsKey(clave) comprueba si esa clave existe en el mapa en menos de un milisegundo
        if (padronSocios.containsKey(codigoTarjeta)) {
            // .get(clave) nos recupera el objeto Socio completo vinculado a esa tarjeta
            Socio socioEnPuerta = padronSocios.get(codigoTarjeta);
            System.out.println("Tarjeta detectada. Leyendo datos de: " + socioEnPuerta.getNombre());

            if (socioEnPuerta.isMensualidadPagada()) {
                System.out.println("-> [ACCESO CONCEDIDO] ¡Bienvenido al gimnasio!");
            } else {
                System.out.println("-> [ACCESO DENEGADO] Alerta: Tienes un recibo pendiente de pago.");
            }
        } else {
            System.out.println("-> [ERROR] Código de tarjeta no reconocido en el sistema.");
        }


        System.out.println("\n=================================================");
        System.out.println("3. ACTUALIZACIÓN DIRECTA DE DATOS");
        System.out.println("=================================================");
        // Andrés ("SOC-303") va a recepción y paga su deuda.
        // No necesitamos buscarlo con un bucle for en toda la lista, vamos directos a su clave:
        System.out.println("Modificando estado de cuenta para SOC-303...");

        padronSocios.get("SOC-303").setMensualidadPagada(true);

        System.out.println("Datos actualizados: " + padronSocios.get("SOC-303"));


        System.out.println("\n=================================================");
        System.out.println("4. RECORRER EL MAPA (Listado de Recepción)");
        System.out.println("=================================================");
        /* * Para recorrer un mapa entero, le pedimos su "Set de parejas" usando .entrySet()
         * Cada pareja es un Map.Entry que contiene la Key y el Value por separado.
         */
        System.out.println("LISTADO COMPLETO DE SOCIOS:");
        for (Map.Entry<String, Socio> pareja : padronSocios.entrySet()) {
            String carné = pareja.getKey(); // Sacamos la clave
            Socio datos = pareja.getValue(); // Sacamos el valor

            System.out.println("ID: " + carné + " -> " + datos);
        }
    }
}
