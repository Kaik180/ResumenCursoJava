package Ejercicios.Simples;
import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una palabra o frase: ");
        String texto = scanner.nextLine();

        // Limpiamos el texto: quitamos espacios y lo pasamos a minúsculas
        String limpio = texto.replace(" ", "").toLowerCase();

        // Invertimos la cadena
        String invertida = new StringBuilder(limpio).reverse().toString();

        if (limpio.equals(invertida)) {
            System.out.println("\"" + texto + "\" es un palíndromo.");
        } else {
            System.out.println("\"" + texto + "\" no es un palíndromo.");
        }
    }
}