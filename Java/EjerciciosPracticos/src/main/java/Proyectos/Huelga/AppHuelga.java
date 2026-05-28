package Proyectos.Huelga;

import java.util.Scanner;

public class AppHuelga {
   static CentroEducativo centro;

    static void main() {

    }
    static void verSeguimiento(){
       int docenteTrabajando=0;
        for (Docente d : centro.getHuelguistas()){
            if (d.getEstado() != EstadoDocente.EN_HUELGA) {
                docenteTrabajando++;
            }

        }
        if (docenteTrabajando==0){
            System.out.println("HUELGA TOTAL");
        }else {
            System.out.println("HUELGA PARCIAL (["+docenteTrabajando+"] docentes trabajando");
        }

    }
    static Docente validacion(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame el dni de un docente ^^");
        String dniIntroducido = teclado.nextLine();
        System.out.println("Validando. . .");
        Docente docenteEncontrado = centro.validarDocente(dniIntroducido);

        if (docenteEncontrado != null) {
            System.out.println("Docente en huelga validado correctamente.");
            return docenteEncontrado;
        } else {
            System.out.println("El docente no existe como huelguista.");
            return new Docente(dniIntroducido, 0, EstadoDocente.ACTIVO);
        }

    }
    static void insertarHuelguista(){
    Docente d = validacion();
    if (d.estado == EstadoDocente.EN_HUELGA){
        throw new ExceptionEnHuelga("Error: El docente ya esta en huelga");
    }else {
    d.Secundar();
    centro.getHuelguistas().add(d);
    }
    }
    static void calcularDescuentoSalarial(){
    Docente d =validacion();
    if (d.estado == EstadoDocente.EN_HUELGA){
    System.out.println("Dias: "+d.diasHuelga+" - Descuento por dia: "+centro.getDescuentoSalarialDiario()+"€");
    double total = d.diasHuelga* centro.getDescuentoSalarialDiario();
    System.out.println("Importe total: "+total+"€.");
    }

    }
    static void abandoarHuelga(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame el dni de un docente ^^");
        String dniIntroducido = teclado.nextLine();
        Docente docenteEncontrado = centro.validarDocente(dniIntroducido);
        if (docenteEncontrado != null) {
            System.out.println("No se ha podido finalizar la huelga. El docente no existe en la lista de huelguistas");
            centro.mostrarHuelguistasActuales();

        } else {
            docenteEncontrado.Finalizar();

        }
    }
    static void listadoConselleria(){

    }
    static void generarEstadisticas(){

    }

}
