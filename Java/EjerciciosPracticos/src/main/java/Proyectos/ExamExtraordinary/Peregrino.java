package main.java.Proyectos.ExamExtraordinary;

import java.util.Objects;

public abstract class Peregrino implements AccionProtocolaria {

    private Integer numReserva;
    private String nombre;
    private EstadoPeregrino estado;

    public Peregrino(Integer numReserva, String nombre) {
        this.numReserva = numReserva;
        this.nombre = nombre;
        estado=EstadoPeregrino.SOLICITUD_OK;
    }

    public Integer getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(Integer numReserva) {
        this.numReserva = numReserva;
    }

    public EstadoPeregrino getEstado() {
        return estado;
    }

    public void setEstado(EstadoPeregrino estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Peregrino{" +
                "numReserva=" + numReserva +
                ", nombre='" + nombre + '\'' +
                ", estado=" + estado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Peregrino peregrino = (Peregrino) o;
        return Objects.equals(numReserva, peregrino.numReserva);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numReserva);
    }

    @Override
    public void recibirBesico() {

        System.out.println("El Papa le da un besico en la frente a " + nombre + " y l@ despacha con una sonrisa");
    }

}
