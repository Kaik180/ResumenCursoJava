package POO2.AbstraccionYInterfaces;

public class PrincipalAbstraccion {
    public static void main(String[] args) {
        // Creamos el teléfono inteligente
        TelefonoInteligente miMovil = new TelefonoInteligente("iPhone 15", "600-123-456");

        System.out.println("=== Probando métodos heredados de la Interfaz e implementados en la Clase Abstracta ===");
        miMovil.encender();

        System.out.println("\n=== Probando el método abstracto propio de la Clase Abstracta ===");
        miMovil.ejecutarFuncionPrincipal();

        System.out.println("\n=== Probando el apagado ===");
        miMovil.apagar();
    }
}
