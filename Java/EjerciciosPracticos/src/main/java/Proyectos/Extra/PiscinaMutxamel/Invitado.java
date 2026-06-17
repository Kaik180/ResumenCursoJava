package main.java.Proyectos.Extra.PiscinaMutxamel;

import java.time.LocalDate;

public class Invitado extends Bañista {
    private LocalDate fechaVisita;

    public Invitado(Integer numero, String nombre, int edad, TipoUsuario tipo, LocalDate fechaVisita) {
        super(numero, nombre, edad, tipo);
        this.fechaVisita = fechaVisita;
    }

    public LocalDate getFechaVisita() { return fechaVisita; }
    public void setFechaVisita(LocalDate fechaVisita) { this.fechaVisita = fechaVisita; }

    @Override
    public void pagar() {
        System.out.println("Invitado (entrada de tipo " + getTipo() + ") pagando " + getTipo().getPrecio() + "€");
    }
}
