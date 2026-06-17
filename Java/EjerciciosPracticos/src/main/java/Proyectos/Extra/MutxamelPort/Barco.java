package main.java.Proyectos.Extra.MutxamelPort;

public abstract class Barco {
    private Integer matricula;
    private String nombre;
    private int diasAmarre;

    public Barco(Integer matricula, String nombre, int diasAmarre) {
        this.matricula = matricula;
        this.nombre = nombre;
        setDiasAmarre(diasAmarre); // Validación encapsulada
    }

    public Integer getMatricula() { return matricula; }
    public String getNombre() { return nombre; }

    public int getDiasAmarre() { return diasAmarre; }
    public void setDiasAmarre(int diasAmarre) {
        if (diasAmarre < 1) {
            throw new IllegalArgumentException("ERROR: Un barco debe amarrar al menos 1 día.");
        }
        this.diasAmarre = diasAmarre;
    }

    public abstract void calcularTasa();

    @Override
    public String toString() {
        return "Matrícula: " + matricula + " | " + nombre + " (" + diasAmarre + " días amarrado)";
    }
}
