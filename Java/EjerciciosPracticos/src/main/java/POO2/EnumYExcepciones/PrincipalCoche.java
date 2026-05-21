package POO2.EnumYExcepciones;

import POO2.TodoEnUno.SinCombustibleException;

public class PrincipalCoche {
    public static void main(String[] args) {

        System.out.println("=== Caso 1: Coche con combustible ===");
        Coche cocheBuenEstado = new Coche("Toyota", 40);

        try {
            cocheBuenEstado.arrancar();
            cocheBuenEstado.viajar(50);
        } catch (SinCombustibleException e) {
            System.out.println("Este bloque no se ejecutará porque este coche sí tiene gasolina.");
        }


        System.out.println("\n=== Caso 2: Coche sin combustible ===");
        Coche cocheVacio = new Coche("Ferrari", 0);

        System.out.println("Estado antes del intento: " + cocheVacio.getEstado());

        try {
            // Esto va a fallar y disparará el código hacia el bloque 'catch'
            cocheVacio.arrancar();
            cocheVacio.viajar(100); // Esta línea nunca llegará a ejecutarse

        } catch (SinCombustibleException e) {
            // Capturamos el error personalizado y mostramos su mensaje
            System.out.println("[ALERTA EN PANEL]: " + e.getMessage());
            System.out.println("Estado después del fallo: " + cocheVacio.getEstado());
        }
    }
}
