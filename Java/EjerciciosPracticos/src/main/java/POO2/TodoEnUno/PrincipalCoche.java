package POO2.TodoEnUno;

public class PrincipalCoche {
    public static void main(String[] args) {

        System.out.println("=== CASO 1: COCHE CON GASOLINA ===");
        Coche cocheOk = new Coche("Toyota", 30);

        try {
            cocheOk.arrancar();
            cocheOk.viajar(20);
        } catch (SinCombustibleException e) {
            System.out.println("Este catch no se ejecutará porque este coche sí arranca.");
        }

        System.out.println("\n=== CASO 2: COCHE SIN GASOLINA ===");
        Coche cocheVacio = new Coche("Ferrari", 0);

        try {
            // Esto obligatoriamente va a fallar y saltará directo al bloque 'catch'
            cocheVacio.arrancar();
            cocheVacio.viajar(100); // Esta línea se la saltará
        } catch (SinCombustibleException e) {
            // Aquí capturamos el fallo de tu archivo de excepción
            System.out.println("[AVISO PANEL]: " + e.getMessage());
            System.out.println("Estado del coche: " + cocheVacio.getEstado());
        }
    }
}
