package Matrices;

public class GestionParking {
    public static void main(String[] args) {

        // 1. DECLARACIÓN E INICIALIZACIÓN
        // Nuestro parking tiene 3 pisos (filas) y 4 plazas por piso (columnas).
        // Representaremos: 0 = Plaza Libre, 1 = Plaza Ocupada.
        int[][] parking = {
                {1, 0, 1, 1}, // Piso 0 (Fila 0) -> 3 ocupados, 1 libre
                {0, 0, 1, 0}, // Piso 1 (Fila 1) -> 1 ocupado, 3 libres
                {1, 1, 0, 1}  // Piso 2 (Fila 2) -> 3 ocupados, 1 libre
        };

        System.out.println("=================================================");
        System.out.println("1. ACCESO DIRECTO Y MODIFICACIÓN");
        System.out.println("=================================================");
        // Queremos saber el estado de la plaza en el Piso 1, Columna 2
        int estadoPlaza = parking[1][2];
        System.out.println("Estado inicial de la plaza [Piso 1][Plaza 2]: " + (estadoPlaza == 1 ? "Ocupado" : "Libre"));

        // Un coche acaba de aparcar en el Piso 1, Columna 0 (estaba libre, pasa a ocupado)
        System.out.println("-> Aparcando coche en [Piso 1][Plaza 0]...");
        parking[1][0] = 1; // Modificación directa apuntando a la coordenada


        System.out.println("\n=================================================");
        System.out.println("2. RECORRIDO COMPLETO (Dibujar el Mapa del Parking)");
        System.out.println("=================================================");
        /* * ¿Cómo se recorre? El primer bucle (i) controla las filas. El segundo bucle (j) recorre
         * cada columna de esa fila antes de pasar a la siguiente.
         * parking.length nos da el número de filas (3).
         * parking[i].length nos da el número de columnas de esa fila específica (4).
         */

        System.out.println("MAPA DEL PARKING ACTUALIZADO:");
        for (int i = 0; i < parking.length; i++) {
            System.out.print("Piso " + i + " ->  ");
            for (int j = 0; j < parking[i].length; j++) {
                // Imprimimos un símbolo visual dependiendo del valor numérico
                if (parking[i][j] == 1) {
                    System.out.print("[X] "); // X = Ocupado
                } else {
                    System.out.print("[ ] "); // Espacio vacío = Libre
                }
            }
            System.out.println(); // Salto de línea al terminar cada piso (fila)
        }


        System.out.println("\n=================================================");
        System.out.println("3. OPERACIONES MATEMÁTICAS Y BÚSQUEDA");
        System.out.println("=================================================");
        // Vamos a contar cuántos coches hay en total en el parking (sumar elementos)
        int totalCoches = 0;
        int totalPlazas = 0;

        for (int i = 0; i < parking.length; i++) {
            for (int j = 0; j < parking[i].length; j++) {
                if (parking[i][j] == 1) {
                    totalCoches++;
                }
                totalPlazas++;
            }
        }

        System.out.println("Coches detectados por el radar: " + totalCoches);
        System.out.println("Plazas totales disponibles en el recinto: " + totalPlazas);
        System.out.println("Porcentaje de ocupación: " + ((double)totalCoches / totalPlazas * 100) + "%");


        System.out.println("\n=================================================");
        System.out.println("4. ANÁLISIS POR FILAS (¿Qué piso está más lleno?)");
        System.out.println("=================================================");
        /*
         * A veces no necesitas sumar toda la matriz, sino analizar fila por fila por separado.
         * Reiniciamos el contador al empezar cada bucle exterior.
         */
        for (int i = 0; i < parking.length; i++) {
            int cochesEnEstePiso = 0;
            for (int j = 0; j < parking[i].length; j++) {
                if (parking[i][j] == 1) {
                    cochesEnEstePiso++;
                }
            }
            System.out.println("Piso " + i + " tiene " + cochesEnEstePiso + " plazas ocupadas de " + parking[i].length);
        }
    }
}
