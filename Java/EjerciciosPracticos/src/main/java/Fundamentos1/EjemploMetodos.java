package Fundamentos1;

public class EjemploMetodos {

    // Este es nuestro método personalizado. Recibe un texto y no devuelve nada (void)
    public static void saludarUsuario(String nombre) {
        System.out.println("¡Hola " + nombre + "! Bienvenido a tu curso de Java.");
    }

    public static void main(String[] args) {
        // Llamamos al método varias veces pasando diferentes argumentos
        saludarUsuario("Carlos");
        saludarUsuario("Lucía");
        saludarUsuario("Andrés");
    }
}