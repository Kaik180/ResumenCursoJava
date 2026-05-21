package Ejercicios.Intermedio;
import java.util.Random;
import java.util.Scanner;

public class GeneradorContrasenas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // El conjunto de caracteres que usaremos para construir la contraseña
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$*";

        System.out.print("Introduce la longitud deseada para tu contraseña: ");
        int longitud = scanner.nextInt();

        StringBuilder contrasena = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            // Selecciona un índice aleatorio de nuestra cadena de caracteres
            int indice = random.nextInt(caracteres.length());
            // Añade el carácter correspondiente a la contraseña
            contrasena.append(caracteres.charAt(indice));
        }

        System.out.println("Tu contraseña segura generada es: " + contrasena.toString());
    }
}
