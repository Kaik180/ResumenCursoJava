package Ejercicios.Intermedio;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionContactos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> contactos = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE CONTACTOS ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre y teléfono del contacto: ");
                    String nuevoContacto = scanner.nextLine();
                    contactos.add(nuevoContacto);
                    System.out.println("¡Contacto guardado!");
                    break;
                case 2:
                    if (contactos.isEmpty()) {
                        System.out.println("La agenda está vacía.");
                    } else {
                        System.out.println("\nLista de Contactos:");
                        for (int i = 0; i < contactos.size(); i++) {
                            System.out.println((i + 1) + ". " + contactos.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("Saliendo de la agenda...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
}
