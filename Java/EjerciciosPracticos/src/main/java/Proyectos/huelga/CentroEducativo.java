package Proyectos.huelga;

import java.util.*;

public class CentroEducativo {

    static Random aleatorio = new Random();

    private String nombre;
    private int platillaTotal;
    private double descuentoSalarialDiario;
    public HashSet<Docente> huelguistas;

    public CentroEducativo(String nombre, int platillaTotal, double descuentoSalarialDiario) {
        this.descuentoSalarialDiario = descuentoSalarialDiario;
        this.platillaTotal = platillaTotal;
        this.nombre = nombre;
        huelguistas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlatillaTotal() {
        return platillaTotal;
    }

    public void setPlatillaTotal(int platillaTotal) {
        this.platillaTotal = platillaTotal;
    }

    public double getDescuentoSalarialDiario() {
        return descuentoSalarialDiario;
    }

    public void setDescuentoSalarialDiario(double descuentoSalarialDiario) {
        this.descuentoSalarialDiario = descuentoSalarialDiario;
    }

    public HashSet<Docente> getHuelguistas() {
        return huelguistas;
    }

    public void setHuelguistas(HashSet<Docente> huelguistas) {
        this.huelguistas = huelguistas;
    }

    @Override
    public String toString() {
        return "CentroEducativo{" +
                "nombre='" + nombre + '\'' +
                ", platillaTotal=" + platillaTotal +
                ", descuentoSalarialDiario=" + descuentoSalarialDiario +
                ", huelguistas=" + huelguistas +
                '}';
    }

    public void generarHuelguistasAleatorios(){

        int docentes_huelga = aleatorio.nextInt(10)+5;

        for (int i = 0; i < docentes_huelga ; i++) {

            String dni = generarDniAleatorio();

            int dias_huelga = aleatorio.nextInt(7)+1;

            huelguistas.add(new Docente(dni,dias_huelga,EstadoDocente.EN_HUELGA));

        }

    }

    public static String generarDniAleatorio(){

        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";

        String dni = "";

        for (int i = 0; i < 8; i++) {

            dni += numeros.charAt(aleatorio.nextInt(numeros.length()));

        }

        dni += letras.charAt(aleatorio.nextInt(numeros.length()));

        return dni;

    }

    public void mostrarHuelguistasActuales(){

        int contador = 0;

        for (Docente docente : huelguistas){
            System.out.println(++contador + ". DNI: " + docente.getDni() + " - días huelga: " + docente.getDiasHuelga() + " - estado: " + docente.getEstado());
        }

    }

    public Docente validarDocente(String dni){

        System.out.println("Validando...");

        for (Docente docente : huelguistas){
            if (docente.getDni().equals(dni)){
                return docente;
            }
        }
        return null;
    }

    public void sortearServiciosMinimos(){

        ArrayList<Docente> listaHuelguistas = new ArrayList<>(huelguistas);

        Docente docente = listaHuelguistas.get(aleatorio.nextInt(huelguistas.size()));

        docente.asignarServiciosMinimos();

        System.out.println("Servicios mínimos asignados a " + docente);

        mostrarHuelguistasActuales();

    }

    public void limpiarRegistro(){

        System.out.println("Borrando huelguistas activos...");

        Iterator<Docente> it = huelguistas.iterator();

        while(it.hasNext()){
            if (it.next().getEstado().equals(EstadoDocente.ACTIVO)){
                it.remove();
            }
        }

        mostrarHuelguistasActuales();

    }

    public void insertarHuelguista(Docente docente){
        huelguistas.add(docente);
    }

}
