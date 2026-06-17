package main.java.Proyectos.Extra.MutxamelPort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AppPuerto {
    private static ArrayList<Barco> inventarioBarcos = new ArrayList<>();
    private static int contadorMatriculas = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Datos de prueba iniciales
        contadorMatriculas++;
        inventarioBarcos.add(new Pesquero(contadorMatriculas, "Mar de Alborán", 15, 450));
        contadorMatriculas++;
        inventarioBarcos.add(new Yate(contadorMatriculas, "Poseidón XL", 45, true)); // Barco antiguo (>30 días)
        contadorMatriculas++;
        inventarioBarcos.add(new Yate(contadorMatriculas, "Brisa Marina", 10, false));

        // Alta interactiva
        try {
            registrarBarco();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        mostrarYates();
        zarparBarcosAntiguos();
    }

    public static void registrarBarco() {
        System.out.println("Tipo de embarcación: 1. Pesquero | 2. Yate");
        int opcion = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Nombre del barco:");
        String nombre = scanner.nextLine().trim();

        System.out.println("Días de estancia:");
        int dias = Integer.parseInt(scanner.nextLine().trim());

        int nuevoId = contadorMatriculas + 1;
        Barco nuevoBarco = null;

        if (opcion == 1) {
            System.out.println("Introduce los kg de pescado capturados:");
            int kg = Integer.parseInt(scanner.nextLine().trim());
            // b) Lanzamiento de RuntimeException personalizada si la carga es negativa
            if (kg < 0) {
                throw new RuntimeException("ERROR: No se permiten registros con pérdidas de carga");
            }
            nuevoBarco = new Pesquero(nuevoId, nombre, dias, kg);
        } else if (opcion == 2) {
            System.out.println("¿Es una embarcación de gran lujo? (true/false):");
            boolean lujo = Boolean.parseBoolean(scanner.nextLine().trim());
            nuevoBarco = new Yate(nuevoId, nombre, dias, lujo);
        }

        if (nuevoBarco != null) {
            inventarioBarcos.add(nuevoBarco);
            contadorMatriculas = nuevoId;
            System.out.println("Embarcación amarrada con éxito.");
            ejecutarTasa(nuevoBarco); // Ejecución polimórfica del cobro
        }
    }

    public static void ejecutarTasa(Barco b) {
        b.calcularTasa();
    }

    public static void mostrarYates() {
        System.out.println("\n--- LISTADO DE YATES REGISTRADOS ---");
        for (Barco b : inventarioBarcos) {
            if (b instanceof Yate) {
                Yate y = (Yate) b;
                System.out.println("Matrícula: " + y.getMatricula() + " | Nombre: " + y.getNombre() + " | ¿Lujo?: " + y.isEsDeLujo());
            }
        }
    }

    public static void zarparBarcosAntiguos() {
        System.out.println("\n--- INVENTARIO ANTES DEL ZARPE ---");
        for (Barco b : inventarioBarcos) System.out.println(b);

        System.out.println("\nZarpando barcos con contratos vencidos (>30 días)...");
        Iterator<Barco> it = inventarioBarcos.iterator();
        while (it.hasNext()) {
            Barco b = it.next();
            if (b.getDiasAmarre() > 30) {
                it.remove(); // Remoción del registro de forma segura
            }
        }

        System.out.println("\n--- INVENTARIO TRAS LAS SALIDAS ---");
        for (Barco b : inventarioBarcos) System.out.println(b);
    }
}
