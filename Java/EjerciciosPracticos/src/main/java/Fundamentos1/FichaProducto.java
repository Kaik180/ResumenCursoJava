package Fundamentos1;


public class FichaProducto {
    public static void main(String[] args) {
        // 1. Declaración de variables con sus tipos de datos
        String nombreProducto = "Auriculares Bluetooth";
        int stock = 25;
        double precio = 49.99;
        boolean disponibleEnTienda = true;

        // 2. Mostrar los datos en la consola
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Unidades disponibles: " + stock);
        System.out.println("Precio unitario: " + precio + "€");
        System.out.println("¿Está a la venta?: " + disponibleEnTienda);
    }
}
