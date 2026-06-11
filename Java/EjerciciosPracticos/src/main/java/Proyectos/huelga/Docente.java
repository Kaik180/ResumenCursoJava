package Proyectos.huelga;

import java.util.Objects;

public class Docente implements AccionesHuelga{

    private String dni;
    private Integer diasHuelga;
    private EstadoDocente estado;

    public Docente(String dni, int diasHuelga, EstadoDocente estado) {
        this.dni = dni;
        this.diasHuelga = diasHuelga;
        this.estado = estado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getDiasHuelga() {
        return diasHuelga;
    }

    public void setDiasHuelga(int diasHuelga) {
        this.diasHuelga = diasHuelga;
    }

    public EstadoDocente getEstado() {
        return estado;
    }

    public void setEstado(EstadoDocente estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "dni='" + dni + '\'' +
                ", diasHuelga=" + diasHuelga +
                ", estado=" + estado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Docente docente = (Docente) o;
        return Objects.equals(dni, docente.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    @Override
    public void secundar() {

        setDiasHuelga(1);
        setEstado(EstadoDocente.EN_HUELGA);

    }

    @Override
    public void asignarServiciosMinimos() {

        setEstado(EstadoDocente.SERVICIOS_MINIMOS);

    }

    @Override
    public void finalizar() {

        System.out.println("Docente " + this + " finalizando huelga...");
        setEstado(EstadoDocente.ACTIVO);

    }

}
