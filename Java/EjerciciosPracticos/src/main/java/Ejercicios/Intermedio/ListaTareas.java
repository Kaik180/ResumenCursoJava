package Ejercicios.Intermedio;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaTareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tareas = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\n--- LISTA DE TAREAS ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Ver tareas");
            System.out.println("3. Eliminar tarea completada");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Escribe la tarea: ");
                    String tarea = scanner.nextLine();
                    tareas.add(tarea);
                    System.out.println("Tarea añadida.");
                    break;
                case 2:
                    if (tareas.isEmpty()) {
                        System.out.println("No tienes tareas pendientes. ¡Al día!");
                    } else {
                        System.out.println("\nTareas pendientes:");
                        for (int i = 0; i < tareas.size(); i++) {
                            System.out.println((i + 1) + ". [ ] " + tareas.get(i));
                        }
                    }
                    break;
                case 3:
                    if (tareas.isEmpty()) {
                        System.out.println("No hay tareas para eliminar.");
                    } else {
                        System.out.print("Introduce el número de la tarea a eliminar: ");
                        int indice = scanner.nextInt() - 1;
                        if (indice >= 0 && indice < tareas.size()) {
                            System.out.println("Eliminada: " + tareas.remove(indice));
                        } else {
                            System.out.println("Número de tarea inválido.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 4);
    }
}
