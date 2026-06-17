package main.java.Proyectos.Extra.MutxamelPort;

public class Pesquero extends Barco {
    private int kgPescado;

    public Pesquero(Integer matricula, String nombre, int diasAmarre, int kgPescado) {
        super(matricula, nombre, diasAmarre);
        this.kgPescado = kgPescado;
    }

    @Override
    public void calcularTasa() {
        double tasa = getDiasAmarre() * TarifaPuerto.PESQUERO.getPrecioDia();
        System.out.println("Pesquero " + getNombre() + " - Tasa fija generada: " + tasa + "€ por sus capturas.");
    }
}
