package Proyectos.Extra;


public abstract class Bañista {
    // d) Aplicando encapsulación: visibilidad 'private'
    private Integer numero;
    private String nombre;
    private int edad;
    private TipoUsuario tipo;

    public Bañista(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        this.numero = numero;
        this.nombre = nombre;
        setEdad(edad); // Usamos el setter para validar el rango de edad
        this.tipo = tipo;
    }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }

    // d) Controlar que no se puedan dar de alta bañistas con edades < 0
    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("ERROR. No puede insertar bañistas que no han nacido.");
        }
        this.edad = edad;
    }

    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }

    public abstract void pagar();

    @Override
    public String toString() {
        return numero + " " + nombre + " " + edad + " " + tipo;
    }
}