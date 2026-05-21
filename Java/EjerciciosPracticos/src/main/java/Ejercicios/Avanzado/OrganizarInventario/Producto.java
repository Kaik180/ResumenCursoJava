package Ejercicios.Avanzado.OrganizarInventario;

public class Producto {
    private int id;
    private String nombre;
    private int stock;

    // Constructor
    public Producto(int id, String nombre, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Producto: " + nombre + " | Unidades en Stock: " + stock;
    }
}
