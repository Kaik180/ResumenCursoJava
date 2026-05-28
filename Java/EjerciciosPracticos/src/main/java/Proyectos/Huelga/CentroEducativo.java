package Proyectos.Huelga;

import Colecciones3.GamingHUB.CanalStreaming;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class CentroEducativo {

    private String nombre;
    private int plantillaTotal;
    private double descuentoSalarialDiario =95.5;
    private Collection<Docente> huelguistas;

    public CentroEducativo(String nombre, int plantillaTotal, double descuentoSalarialDiario) {
        this.nombre = nombre;
        this.plantillaTotal = plantillaTotal;
        this.descuentoSalarialDiario = descuentoSalarialDiario;
        this.huelguistas = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlantillaTotal() {
        return plantillaTotal;
    }

    public void setPlantillaTotal(int plantillaTotal) {
        this.plantillaTotal = plantillaTotal;
    }

    public double getDescuentoSalarialDiario() {
        return descuentoSalarialDiario;
    }

    public void setDescuentoSalarialDiario(double descuentoSalarialDiario) {
        this.descuentoSalarialDiario = descuentoSalarialDiario;
    }

    public Collection<Docente> getHuelguistas() {
        return huelguistas;
    }

    public void setHuelguistas(Collection<Docente> huelguistas) {
        this.huelguistas = huelguistas;
    }

    public String toString() {
        return "CentroEducativo{" +
                "nombre='" + nombre + '\'' +
                ", plantillaTotal=" + plantillaTotal +
                ", huelguistas=" + huelguistas +
                '}';
    }

    void generarHuelguistasAleatorios() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        Random random = new Random();

        while (huelguistas.size() < 10) {
            String dniStr = "";

            for (int y = 0; y < 8; y++) {
                dniStr += numeros.charAt(random.nextInt(numeros.length()));
            }

            dniStr += letras.charAt(random.nextInt(letras.length()));

            Integer diaHuelga = random.nextInt(8) + 1;

            Docente nuevoDocente = new Docente(dniStr, diaHuelga, EstadoDocente.EN_HUELGA);

            huelguistas.add(nuevoDocente);
        }
    }

    void mostrarHuelguistasActuales() {
        System.out.println("*** DOCENTES EN HUELGA ***");
        int contador = 1;
        for (Docente d : huelguistas) {
            System.out.println(contador + ". " + d);
            contador++;
        }
    }

    void sortearServiciosMinimos() {

    }

    void limpiarRegistros() {
        Iterator<Docente> iterador = huelguistas.iterator();

        while (iterador.hasNext()) {
            Docente docente = iterador.next();
            if (docente.getEstado() == EstadoDocente.ACTIVO) {
                iterador.remove();
            }
        }
        mostrarHuelguistasActuales();
    }
    Docente validarDocente(String dni) {
        for (Docente d : huelguistas){
            if (d.dni.equals(dni)){
                return d;
            }
        }
        return null;

    }
}