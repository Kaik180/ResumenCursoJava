package Ejercicios.Simples;
import java.util.Scanner;

public class ConversorTemperatura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecciona la conversión:");
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            System.out.print("Introduce los grados Celsius: ");
            double celsius = scanner.nextDouble();
            double fahrenheit = (celsius * 9 / 5) + 32;
            System.out.println(celsius + "°C equivalen a " + fahrenheit + "°F");
        } else if (opcion == 2) {
            System.out.print("Introduce los grados Fahrenheit: ");
            double fahrenheit = scanner.nextDouble();
            double celsius = (fahrenheit - 32) * 5 / 9;
            System.out.println(fahrenheit + "°F equivalen a " + celsius + "°C");
        } else {
            System.out.println("Opción no válida.");
        }
    }
}
