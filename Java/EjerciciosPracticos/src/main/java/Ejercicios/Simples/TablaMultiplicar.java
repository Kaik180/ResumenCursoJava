package Ejercicios.Simples;
import java.util.Scanner;

public class TablaMultiplicar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿De qué número quieres ver la tabla de multiplicar?: ");
        int numero = scanner.nextInt();

        System.out.println("Tabla del " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}