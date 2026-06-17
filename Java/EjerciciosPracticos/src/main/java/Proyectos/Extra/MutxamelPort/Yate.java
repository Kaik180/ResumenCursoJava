package main.java.Proyectos.Extra.MutxamelPort;

public class Yate extends Barco {
    private boolean esDeLujo;

    public Yate(Integer matricula, String nombre, int diasAmarre, boolean esDeLujo) {
        super(matricula, nombre, diasAmarre);
        this.esDeLujo = esDeLujo;
    }

    public boolean isEsDeLujo() { return esDeLujo; }

    @Override
    public void calcularTasa() {
        double tasaBase = getDiasAmarre() * TarifaPuerto.YATE.getPrecioDia();
        if (esDeLujo) {
            tasaBase += 100.0; // Suplemento por servicio de limpieza de lujo
        }
        System.out.println("Yate " + getNombre() + " - Tasa total facturada: " + tasaBase + "€.");
    }
}
