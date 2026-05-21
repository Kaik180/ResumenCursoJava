package Ejercicios.Avanzado.GestorBiblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorBiblioteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> catalogo = new ArrayList<>();

        // Añadimos libros iniciales al catálogo usando nuestra clase Libro
        catalogo.add(new Libro("Cien años de soledad", "Gabriel García Márquez"));
        catalogo.add(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes"));
        catalogo.add(new Libro("1984", "George Orwell"));

        int opcion;
        do {
            System.out.println("\n--- BIBLIOTECA VIRTUAL ---");
            System.out.println("1. Ver catálogo de libros");
            System.out.println("2. Pedir prestado un libro");
            System.out.println("3. Devolver un libro");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer del teclado

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Catálogo ---");
                    for (Libro l : catalogo) {
                        System.out.println(l); // Llama automáticamente al toString() de Libro
                    }
                    break;
                case 2:
                    System.out.print("Escribe el título exacto del libro que quieres: ");
                    String tPrestar = sc.nextLine();
                    buscarYProcesarLibro(catalogo, tPrestar, false);
                    break;
                case 3:
                    System.out.print("Escribe el título del libro que devuelves: ");
                    String tDevolver = sc.nextLine();
                    buscarYProcesarLibro(catalogo, tDevolver, true);
                    break;
                case 4:
                    System.out.println("Cerrando el sistema de biblioteca...");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 4);

        sc.close();
    }

    // Método auxiliar para buscar el libro en la lista y cambiar su estado
    private static void buscarYProcesarLibro(ArrayList<Libro> lista, String titulo, boolean esDevolucion) {
        for (Libro l : lista) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                if (esDevolucion) {
                    if (!l.isDisponible()) {
                        l.setDisponible(true);
                        System.out.println("¡Gracias! El libro \"" + l.getTitulo() + "\" ha sido devuelto.");
                    } else {
                        System.out.println("Este libro ya figuraba como disponible.");
                    }
                } else {
                    if (l.isDisponible()) {
                        l.setDisponible(false);
                        System.out.println("Trámite completado. Te has llevado: " + l.getTitulo());
                    } else {
                        System.out.println("Lo sentimos, ese libro ya está prestado actualmente.");
                    }
                }
                return; // Salimos del método en cuanto encontramos el libro
            }
        }
        System.out.println("No se encontró ningún libro con ese título.");
    }
}
