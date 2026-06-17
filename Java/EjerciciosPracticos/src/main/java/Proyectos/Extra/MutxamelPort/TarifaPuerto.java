package main.java.Proyectos.Extra.MutxamelPort;

public enum TarifaPuerto {
    PESQUERO(10.0), RECREO(25.0), YATE(60.0);

    private final double precioDia;
    TarifaPuerto(double precioDia) { this.precioDia = precioDia; }
    public double getPrecioDia() { return precioDia; }
}
