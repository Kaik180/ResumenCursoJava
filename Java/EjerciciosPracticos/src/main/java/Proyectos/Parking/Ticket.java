package Proyectos.Parking;

import java.util.Random;

public class Ticket implements Acciones {

    private String  matricula;
    private Integer minutos;
    private Estado  estado;

    public Ticket(String matricula, Integer minutos, Estado estado) {
        this.matricula = matricula;
        this.minutos   = minutos;
        this.estado    = estado;
    }

    // Getters y setters
    public String  getMatricula() { return matricula; }
    public Integer getMinutos()   { return minutos;   }
    public Estado  getEstado()    { return estado;    }
    public void    setEstado(Estado estado) { this.estado = estado; }
    public void    setMatricula(String matricula) { this.matricula = matricula; }

    // -------------------------------------------------------
    // Genera una matrícula aleatoria (4 dígitos + 3 letras)
    // y cambia el estado a GENERADO
    // -------------------------------------------------------
    @Override
    public void generar() {
        String letras  = "BCDFGHJKLMNPQRSTVWXYZ";
        String numeros = "0123456789";
        Random rnd = new Random();

        StringBuilder mat = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            mat.append(numeros.charAt(rnd.nextInt(numeros.length())));
        }
        for (int i = 0; i < 3; i++) {
            mat.append(letras.charAt(rnd.nextInt(letras.length())));
        }

        System.out.println("Leyendo matricula...");
        this.matricula = mat.toString();
        System.out.println("Matricula: " + this.matricula);
        this.estado = Estado.GENERADO;
        System.out.println("Ticket generado.");
    }

    // -------------------------------------------------------
    // Muestra bienvenida y cambia el estado a RECOGIDO
    // -------------------------------------------------------
    @Override
    public void recoger() {
        System.out.println("Recoja su ticket...");
        this.estado = Estado.RECOGIDO;
        System.out.println("BIENVENIDO!");
    }

    // -------------------------------------------------------
    // Simula el pago: muestra mensajes y cambia estado a PAGADO
    // -------------------------------------------------------
    @Override
    public void pagar() {
        System.out.println("Pagando...");
        this.estado = Estado.PAGADO;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula
             + " - minutos: " + minutos
             + " - estado: " + estado;
    }
}
