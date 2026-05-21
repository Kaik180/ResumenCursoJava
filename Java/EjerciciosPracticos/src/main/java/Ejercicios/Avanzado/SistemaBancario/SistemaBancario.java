package Ejercicios.Avanzado.SistemaBancario;

import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el nombre del titular: ");
        String nombre = sc.nextLine();

        // Instanciamos el objeto usando la clase externa
        CuentaBancaria cuenta = new CuentaBancaria(nombre, 500.00);
        int opcion;

        do {
            System.out.println("\n--- CAJERO AUTOMÁTICO ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Titular: " + cuenta.getTitular() + " | Saldo actual: $" + cuenta.getSaldo());
                    break;
                case 2:
                    System.out.print("Cantidad a depositar: $");
                    double dep = sc.nextDouble();
                    cuenta.depositar(dep);
                    break;
                case 3:
                    System.out.print("Cantidad a retirar: $");
                    double ret = sc.nextDouble();
                    cuenta.retirar(ret);
                    break;
                case 4:
                    System.out.println("Gracias por usar nuestros servicios.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }
}