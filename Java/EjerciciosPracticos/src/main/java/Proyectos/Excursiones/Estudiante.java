package Proyectos.Excursiones;

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante> {

    private String apellidos;
    private String nombre;
    private String curso;
    private int edad;

    public Estudiante(String apellidos, String nombre, String curso, int edad) {
        this.apellidos = apellidos;
        this.nombre    = nombre;
        this.curso     = curso;
        this.edad      = edad;
    }

    // Getters
    public String getApellidos() { return apellidos; }
    public String getNombre()    { return nombre;    }
    public String getCurso()     { return curso;     }
    public int    getEdad()      { return edad;      }

    // Dos estudiantes son iguales si tienen los mismos apellidos, nombre y curso
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante e = (Estudiante) o;
        return apellidos.equalsIgnoreCase(e.apellidos)
            && nombre.equalsIgnoreCase(e.nombre)
            && curso.equalsIgnoreCase(e.curso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellidos.toLowerCase(), nombre.toLowerCase(), curso.toLowerCase());
    }

    // Ordenación: primero por curso, luego por apellidos
    @Override
    public int compareTo(Estudiante otro) {
        int porCurso = this.curso.compareToIgnoreCase(otro.curso);
        if (porCurso != 0) return porCurso;
        int porApellidos = this.apellidos.compareToIgnoreCase(otro.apellidos);
        if (porApellidos != 0) return porApellidos;
        return this.nombre.compareToIgnoreCase(otro.nombre);
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " del curso " + curso;
    }
}
