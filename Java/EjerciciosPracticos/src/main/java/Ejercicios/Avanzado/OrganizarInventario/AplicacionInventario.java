package Ejercicios.Avanzado.OrganizarInventario;

import java.util.ArrayList;
import java.util.Scanner;

public class AplicacionInventario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Producto> inventario = new ArrayList<>();

        // Inicializamos nuestro almacén con algunos productos de prueba
        inventario.add(new Producto(101, "Portátil i7", 12));
        inventario.add(new Producto(102, "Ratón Gamer", 45));
        inventario.add(new Producto(103, "Teclado Mecánico", 20));

        int opcion;
        do {
            System.out.println("\n--- CONTROL DE INVENTARIO ---");
            System.out.println("1. Listar existencias (Stock)");
            System.out.println("2. Actualizar stock de un producto");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.println("\n--- Almacén Actual ---");
                for (Producto p : inventario) {
                    System.out.println(p);
                }
            } else if (opcion == 2) {
                System.out.print("Introduce el ID del producto: ");
                int idBuscar = sc.nextInt();

                boolean encontrado = false;
                for (Producto p : inventario) {
                    if (p.getId() == idBuscar) {
                        encontrado = true;
                        System.out.print("¿Cuál es el nuevo stock total para " + p.getNombre() + "?: ");
                        int nuevoStock = sc.nextInt();

                        if (nuevoStock >= 0) {
                            p.setStock(nuevoStock);
                            System.out.println("¡Stock actualizado correctamente!");
                        } else {
                            System.out.println("Error: El stock no puede ser un número negativo.");
                        }
                        break; // Rompe el bucle for tras encontrar el producto
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontró ningún producto con el ID " + idBuscar);
                }
            }
        } while (opcion != 3);

        System.out.println("Cerrando el software de inventario...");
        sc.close();
    }
}
