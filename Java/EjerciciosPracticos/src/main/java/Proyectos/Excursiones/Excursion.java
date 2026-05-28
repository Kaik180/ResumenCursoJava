package Proyectos.Excursiones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Excursion {

    private String nombre_actividad;
    private String localidad;
    private double precio;
    private List<String>     profesores;
    private List<Estudiante> listaAsistentes;

    public Excursion(String nombre_actividad, String localidad, double precio) {
        this.nombre_actividad = nombre_actividad;
        this.localidad        = localidad;
        this.precio           = precio;
        this.profesores       = new ArrayList<>();
        this.listaAsistentes  = new ArrayList<>();
    }

    // Getters
    public String getNombre_actividad() { return nombre_actividad; }
    public String getLocalidad()        { return localidad;        }
    public double getPrecio()           { return precio;           }

    /**
     * Pide por teclado el nombre del profesor y lo añade a la lista.
     */
    public void insertarProfesor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del profesor/a para la excursión en " + localidad);
        String nombreProf = sc.nextLine();
        profesores.add(nombreProf);
        System.out.println("Profesor añadido correctamente a la excursión " + nombre_actividad);
    }

    /**
     * Pide los datos de un estudiante por teclado y lo añade si no está duplicado.
     */
    public void inscribirAsistente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creando estudiante...");
        System.out.println("Inserta los apellidos:");
        String apellidos = sc.nextLine();
        System.out.println("Inserta el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Inserta el curso:");
        String curso = sc.nextLine();
        System.out.println("Inserta su edad:");
        int edad = Integer.parseInt(sc.nextLine().trim());

        Estudiante nuevo = new Estudiante(apellidos, nombre, curso, edad);

        if (listaAsistentes.contains(nuevo)) {
            System.out.println("El estudiante ya existe en la lista de asistentes a la actividad " + nombre_actividad);
        } else {
            listaAsistentes.add(nuevo);
            System.out.println("Añadido correctamente el estudiante " + nuevo + ".");
        }
    }

    /**
     * Imprime la lista de asistentes ordenada por curso y apellidos.
     */
    public void verAsistentes() {
        Collections.sort(listaAsistentes);
        System.out.println("Lista de inscritos para la actividad " + nombre_actividad + ":");
        if (listaAsistentes.isEmpty()) {
            System.out.println("  (Sin asistentes)");
            return;
        }
        for (int i = 0; i < listaAsistentes.size(); i++) {
            Estudiante e = listaAsistentes.get(i);
            System.out.printf("[%d]. %s - %s, %s (%d años).%n",
                i + 1,
                e.getCurso(),
                e.getApellidos(),
                e.getNombre(),
                e.getEdad());
        }
    }

    /**
     * Devuelve el importe total: precio × número de asistentes inscritos.
     */
    public double calcularImporteIngreso() {
        return precio * listaAsistentes.size();
    }

    /**
     * Elimina de la lista todos los asistentes con edad estrictamente menor a 'edad'.
     * Solución provisional — ver pregunta teórica para la solución definitiva.
     */
    public void eliminarAsistentesPorEdad(int edad) {
        listaAsistentes.removeIf(e -> e.getEdad() < edad);
    }
}
