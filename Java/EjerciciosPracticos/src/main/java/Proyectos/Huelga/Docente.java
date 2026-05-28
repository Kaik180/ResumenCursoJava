package Proyectos.Huelga;

public class Docente implements AccionesHuelga {
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getDiasHuelga() {
        return diasHuelga;
    }

    public void setDiasHuelga(Integer diasHuelga) {
        this.diasHuelga = diasHuelga;
    }

    public EstadoDocente getEstado() {
        return estado;
    }

    public void setEstado(EstadoDocente estado) {
        this.estado = estado;
    }

    public Docente(String dni, Integer diasHuelga, EstadoDocente estado) {
        this.dni = dni;
        this.diasHuelga = diasHuelga;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " - días huelga: " + diasHuelga + " - estado: " + estado;
    }

    String dni;
    Integer diasHuelga;
    EstadoDocente estado;


    @Override
    public void Secundar() {
        this.diasHuelga = 1;
        this.estado = EstadoDocente.EN_HUELGA;
    }

    @Override
    public void AsignarServiciosMinimos() {

    }

    @Override
    public void Finalizar() {
        this.diasHuelga = 0;
        this.estado = EstadoDocente.ACTIVO;

    }
}
