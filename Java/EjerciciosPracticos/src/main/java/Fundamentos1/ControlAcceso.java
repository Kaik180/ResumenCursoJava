package Fundamentos1;

public class ControlAcceso {
    public static void main(String[] args) {
        int edadUsuario = 19;

        // Estructura condicional if/else
        if (edadUsuario >= 18) {
            System.out.println("Acceso concedido. Eres mayor de edad.");
        } else {
            System.out.println("Acceso denegado. Eres menor de edad.");
        }
    }
}
