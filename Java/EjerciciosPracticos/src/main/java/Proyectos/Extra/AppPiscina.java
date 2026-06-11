package Proyectos.Extra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AppPiscina {
    // a) Atributos estáticos solicitados
    private static ArrayList<Bañista> listaBañistas = new ArrayList<>();
    private static int ultimoNumero = 0; // Lleva el control automático del ID secuencial

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicialización de datos de prueba corregidos (según apartado f)
        ultimoNumero++;
        listaBañistas.add(new Adulto(ultimoNumero, "patricia", 20, TipoUsuario.ADULTO));
        ultimoNumero++;
        listaBañistas.add(new Adulto(ultimoNumero, "pablo", 30, TipoUsuario.ADULTO));
        ultimoNumero++;
        listaBañistas.add(new Niño(ultimoNumero, "pepe", 12, TipoUsuario.NIÑO, "34565432"));
        ultimoNumero++;
        listaBañistas.add(new Niño(ultimoNumero, "carla", 8, TipoUsuario.NIÑO, "8569512"));
        ultimoNumero++;
        listaBañistas.add(new Invitado(ultimoNumero, "Fran", 40, TipoUsuario.INVITADO, LocalDate.now()));
        ultimoNumero++;
        listaBañistas.add(new Invitado(ultimoNumero, "Marta", 12, TipoUsuario.INVITADO, LocalDate.now()));

        // Ejemplo de ejecución del alta de usuario
        try {
            altaUsuario();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Demostración de listado de invitados
        mostrarInvitados();

        // Demostración de borrado de invitados diarios
        eliminarInvitados();
    }

    // b) Método altaUsuario()
    public static void altaUsuario() {
        System.out.println("*** APP DE MANTENIMIENTO DE LA PISCINA DE MUTXAMEL ***");
        System.out.println("Alta de usuarios...");
        System.out.println("1. Adulto");
        System.out.println("2. Niños (<=16 años)");
        System.out.println("3. Invitados (pase diario)");
        System.out.print("Elige un tipo: ");

        int opcion = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Introduce el nombre del nuevo bañista: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("Introduce la edad: ");
        int edad = Integer.parseInt(scanner.nextLine().trim());

        // d) Validar edad menor a 0 usando captura previa o provocando la excepción encapsulada
        if (edad < 0) {
            System.out.println("ERROR. No puede insertar bañistas que no han nacido.");
            return;
        }

        // b) Auto-incremento de número secuencial y único
        int nuevoId = ultimoNumero + 1;

        Bañista nuevoBañista = null;

        if (opcion == 1) {
            nuevoBañista = new Adulto(nuevoId, nombre, edad, TipoUsuario.ADULTO);
        } else if (opcion == 2) {
            // b) Lanzar excepción personalizada (RuntimeException) si NIÑO supera los 16 años
            if (edad > 16) {
                throw new RuntimeException("ERROR al crear un NIÑO. Edad " + edad + " no permitida");
            }
            System.out.print("Introduce el teléfono del adulto responsable: ");
            String tel = scanner.nextLine().trim();
            nuevoBañista = new Niño(nuevoId, nombre, edad, TipoUsuario.NIÑO, tel);
        } else if (opcion == 3) {
            // b) Si es INVITADO, fecha_visita es la fecha actual
            nuevoBañista = new Invitado(nuevoId, nombre, edad, TipoUsuario.INVITADO, LocalDate.now());
        }

        if (nuevoBañista != null) {
            listaBañistas.add(nuevoBañista);
            ultimoNumero = nuevoId; // Confirmamos la actualización del último ID válido utilizado
            System.out.println("Nuevo bañista creado.");

            // c) Lanzar el método cobrar automáticamente antes de finalizar
            cobrar(nuevoBañista);
        }
    }

    // c) Método cobrar(Bañista bañista)
    public static void cobrar(Bañista bañista) {
        bañista.pagar();
    }

    // e) Método mostrarInvitados() del día de hoy
    public static void mostrarInvitados() {
        System.out.println("\n*** APP DE MANTENIMIENTO DE LA PISCINA DE MUTXAMEL ***");
        System.out.println("Lista de invitados en el día de hoy:");
        LocalDate hoy = LocalDate.now();

        for (Bañista b : listaBañistas) {
            if (b instanceof Invitado) {
                Invitado inv = (Invitado) b;
                if (inv.getFechaVisita().equals(hoy)) {
                    System.out.println("Número: " + inv.getNumero());
                    System.out.println("Nombre: " + inv.getNombre());
                    System.out.println("Edad: " + inv.getEdad());
                }
            }
        }
    }

    // f) Método eliminarInvitados() de hoy usando Iterator para evitar ConcurrentModificationException
    public static void eliminarInvitados() {
        System.out.println("\n*** APP DE MANTENIMIENTO DE LA PISCINA DE MUTXAMEL ***");
        System.out.println("Estado antes de eliminar:");
        for (Bañista b : listaBañistas) {
            System.out.println(b);
        }

        System.out.println("Eliminando invitados de hoy...");
        LocalDate hoy = LocalDate.now();
        Iterator<Bañista> iterator = listaBañistas.iterator();

        while (iterator.hasNext()) {
            Bañista b = iterator.next();
            if (b instanceof Invitado) {
                Invitado inv = (Invitado) b;
                if (inv.getFechaVisita().equals(hoy)) {
                    iterator.remove();
                }
            }
        }

        System.out.println("Estado después de eliminar:");
        for (Bañista b : listaBañistas) {
            System.out.println(b);
        }
    }
}
