package Fundamentos1;

public class CalcularDescuento {
    public static void main(String[] args) {
        double precioOriginal = 80.0;
        double porcentajeDescuento = 0.15; // Equivale al 15%

        // Operaciones aritméticas
        double descuentoEfectuado = precioOriginal * porcentajeDescuento;
        double precioFinal = precioOriginal - descuentoEfectuado;

        System.out.println("Precio original: " + precioOriginal + "€");
        System.out.println("Descuento ahorrado: " + descuentoEfectuado + "€");
        System.out.println("Precio final a pagar: " + precioFinal + "€");
    }
}