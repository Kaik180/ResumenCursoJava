package main.java.Proyectos.Extra.PiscinaMutxamel;

public abstract class Bañista {
    private Integer numero;
    private String nombre;
    private int edad;
    private TipoUsuario tipo;

    public Bañista(Integer numero, String nombre, int edad, TipoUsuario tipo) {
        this.numero = numero;
        this.nombre = nombre;
        setEdad(edad); // Se utiliza el setter encapsulado para asegurar la validación
        this.tipo = tipo;
    }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }

    // Apartado d): Validación estricta del rango de edad admitido
    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("ERROR. No puede insertar bañistas que no han nacido.");
        }
        this.edad = edad;
    }

    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }

    // Método abstracto polimórfico
    public abstract void pagar();

    @Override
    public String toString() {
        return numero + " " + nombre + " " + edad + " " + tipo;
    }
}
