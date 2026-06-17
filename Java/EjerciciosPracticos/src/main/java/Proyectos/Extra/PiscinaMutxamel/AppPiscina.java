package main.java.Proyectos.Extra.PiscinaMutxamel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AppPiscina {
    // Atributos estáticos solicitados en el diseño estructural
    private static ArrayList<Bañista> listaBañistas = new ArrayList<>();
    private static int ultimoNumero = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Carga de los registros de prueba (Apartado f) con IDs válidos y secuenciales
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

        // 1. Demostración interactiva de alta de usuario
        try {
            altaUsuario();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 2. Demostración del método mostrarInvitados() del día
        mostrarInvitados();

        // 3. Demostración del método eliminarInvitados() antes del cierre
        eliminarInvitados();
    }

    // b) Método de gestión para dar de alta nuevos Bañistas
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

        // d) Interceptar de manera controlada errores por ingreso de años negativos
        if (edad < 0) {
            System.out.println("ERROR. No puede insertar bañistas que no han nacido.");
            return;
        }

        int nuevoId = ultimoNumero + 1;
        Bañista nuevoBañista = null;

        if (opcion == 1) {
            nuevoBañista = new Adulto(nuevoId, nombre, edad, TipoUsuario.ADULTO);
        } else if (opcion == 2) {
            // b) Lanzamiento obligatorio de RuntimeException si el Niño supera el límite de 16 años
            if (edad > 16) {
                throw new RuntimeException("ERROR al crear un NIÑO. Edad " + edad + " no permitida");
            }
            System.out.print("Introduce el teléfono del adulto responsable: ");
            String tel = scanner.nextLine().trim();
            nuevoBañista = new Niño(nuevoId, nombre, edad, TipoUsuario.NIÑO, tel);
        } else if (opcion == 3) {
            nuevoBañista = new Invitado(nuevoId, nombre, edad, TipoUsuario.INVITADO, LocalDate.now());
        }

        if (nuevoBañista != null) {
            listaBañistas.add(nuevoBañista);
            ultimoNumero = nuevoId; // Se consolida el ID incremental creado con éxito
            System.out.println("Nuevo bañista creado.");

            // c) Cobro automatizado acoplado internamente
            cobrar(nuevoBañista);
        }
    }

    // c) Método cobrar delegado
    public static void cobrar(Bañista bañista) {
        bañista.pagar();
    }

    // e) Listado filtrado polimórficamente de Invitados en la fecha en curso
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

    // f) Borrado seguro mediante Iterator para prevenir un ConcurrentModificationException
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
