package Proyectos.IslaEpstein;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
public class Famoso implements Comparable<Famoso>{

    private String nombre;
    private String pais;
    private String profesion;
    private int edad;

    public Famoso(String nombre, String pais, String profesion, int edad) {
        this.nombre = nombre;
        this.pais = pais;
        this.profesion = profesion;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Famoso famoso = (Famoso) o;
        return edad == famoso.edad && Objects.equals(nombre, famoso.nombre) && Objects.equals(pais, famoso.pais) && Objects.equals(profesion, famoso.profesion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pais, profesion, edad);
    }

    @Override
    public int compareTo(Famoso o) {

        int comparar = pais.compareTo(o.getPais());

        if (comparar != 0){
            return comparar;
        }

        return nombre.compareTo(o.getNombre());

    }

}
