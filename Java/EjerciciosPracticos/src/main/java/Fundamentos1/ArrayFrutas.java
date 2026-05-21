package Fundamentos1;

public class ArrayFrutas {
    public static void main(String[] args) {
        // Creamos un array de Strings con 4 elementos
        String[] frutas = {"Manzana", "Plátano", "Naranja", "Fresa"};

        System.out.println("Mi lista de frutas contiene " + frutas.length + " elementos:");

        // Recorremos el array usando un bucle for
        for (int i = 0; i < frutas.length; i++) {
            System.out.println("Fruta " + (i + 1) + ": " + frutas[i]);
        }
    }
}
