package Colecciones3.GamingHUB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.Collections;

public class PlataformaGaming {
    public static void main(String[] args) {

        // Canales de ejemplo
        CanalStreaming stream1 = new CanalStreaming("Ibai", "Maratón de Charlas", 45000);
        CanalStreaming stream2 = new CanalStreaming("Rubius", "Minecraft", 22000);
        CanalStreaming stream3 = new CanalStreaming("AuronPlay", "GTA V", 35000);
        CanalStreaming stream4 = new CanalStreaming("TheGrefg", "Fortnite", 18000);

        System.out.println("=================================================");
        System.out.println("1. ARRAYLIST -> Carrusel de Portada de la App");
        System.out.println("=================================================");
        /* * ¿Para qué sirve? Para almacenar listas donde el orden de inserción importa y se accede por posición.
         * ¿Por qué aquí? La portada de nuestra app muestra un "top" fijo de canales recomendados.
         * ArrayList guarda los datos contiguos en memoria, lo que permite que la app consulte el canal de la
         * posición 0, 1 o 2 de manera instantánea (O(1)).
         */
        ArrayList<CanalStreaming> portada = new ArrayList<>();
        portada.add(stream1);
        portada.add(stream2);
        portada.add(stream3);

        System.out.println("Canal principal destacado en el banner: " + portada.get(0));


        System.out.println("\n=================================================");
        System.out.println("2. LINKEDLIST -> Cola de Espera para Soporte Técnico");
        System.out.println("=================================================");
        /* * ¿Para qué sirve? Para estructuras tipo FIFO (Cola) o LIFO (Pila) donde añadimos y quitamos datos sin parar.
         * ¿Por qué aquí? Cuando los usuarios abren un ticket de soporte, entran en una cola lineal.
         * LinkedList no usa arrays internos; son nodos enlazados con flechas. Añadir al final (.addLast) o
         * atender al primero (.removeFirst) no requiere mover ningún elemento en memoria, es inmediato.
         */
        LinkedList<String> colaTickets = new LinkedList<>();
        colaTickets.addLast("Ticket#1: Error con la suscripción de @Ibai");
        colaTickets.addLast("Ticket#2: Reporte de comportamiento en chat");
        colaTickets.addLast("Ticket#3: Problemas de lag en el stream");

        System.out.println("Atendiendo ahora mismo: " + colaTickets.removeFirst());
        System.out.println("Siguiente ticket en espera: " + colaTickets.peekFirst());


        System.out.println("\n=================================================");
        System.out.println("3. HASHSET -> Lista Negra de Usuarios Baneados");
        System.out.println("=================================================");
        /* * ¿Para qué sirve? Para asegurar que no haya elementos duplicados y buscar cosas a la velocidad de la luz.
         * ¿Por qué aquí? Si un usuario intenta escribir en el chat global, el sistema debe comprobar si está baneado.
         * Un HashSet no tiene orden, pero gracias a los algoritmos de Hash, comprobar si un nombre está en la lista
         * negra tarda lo mismo si hay 10 baneados que si hay 10 millones (O(1)).
         */
        HashSet<String> usuariosBaneados = new HashSet<>();
        usuariosBaneados.add("troll_99");
        usuariosBaneados.add("spammer_bot");
        usuariosBaneados.add("troll_99"); // Intento duplicado, el Set lo ignora automáticamente.

        String usuarioIntentandoComentar = "troll_99";
        if (usuariosBaneados.contains(usuarioIntentandoComentar)) {
            System.out.println("Bloqueado: El usuario '" + usuarioIntentandoComentar + "' no puede hablar.");
        }


        System.out.println("\n=================================================");
        System.out.println("4. HASHMAP -> Directorio de Servidores por ID");
        System.out.println("=================================================");
        /* * ¿Para qué sirve? Para asociar parejas de Clave -> Valor (Diccionarios).
         * ¿Por qué aquí? Cada streamer tiene un ID único de transmisión de video. Almacenamos el ID entero
         * como clave, y el objeto `CanalStreaming` como valor. No tenemos que buscar fila por fila; le damos el ID y nos da el canal.
         */
        HashMap<Integer, CanalStreaming> directorioEmisiones = new HashMap<>();
        directorioEmisiones.put(9001, stream1); // ID 9001 -> Ibai
        directorioEmisiones.put(4512, stream2); // ID 4512 -> Rubius
        directorioEmisiones.put(7777, stream4); // ID 7777 -> TheGrefg

        int idBuscado = 4512;
        System.out.println("Emitiendo en el ID " + idBuscado + ": " + directorioEmisiones.get(idBuscado));


        System.out.println("\n=================================================");
        System.out.println("5. COMPARADORES Y ORDENAMIENTO -> Ranking en Vivo");
        System.out.println("=================================================");
        /* * ¿Para qué sirve? Para ordenar colecciones usando un criterio personalizado que tú decidas.
         * ¿Por qué aquí? Tenemos una lista desordenada de canales en un ArrayList. Usamos `Collections.sort`
         * inyectándole nuestro `ComparadorEspectadores`. Java reorganiza el ArrayList de mayor a menor audiencia.
         */
        ArrayList<CanalStreaming> listaModificar = new ArrayList<>();
        listaModificar.add(stream4); // 18k
        listaModificar.add(stream1); // 45k
        listaModificar.add(stream3); // 35k

        Collections.sort(listaModificar, new ComparadorEspectadores());

        System.out.println("Ranking de canales más vistos ahora mismo:");
        for (CanalStreaming canal : listaModificar) {
            System.out.println(" > " + canal);
        }


        System.out.println("\n=================================================");
        System.out.println("6. TREESET -> Tabla de Récords Autooridnada");
        System.out.println("=================================================");
        /* * ¿Para qué sirve? Para garantizar que los elementos sean ÚNICOS y estén SIEMPRE ORDENADOS en tiempo real.
         * ¿Por qué aquí? En lugar de ordenar la lista a mano a cada rato, el TreeSet recibe el comparador en su
         * constructor. En cuanto haces un `.add()`, el TreeSet busca la posición exacta del elemento para mantener el orden.
         */
        TreeSet<CanalStreaming> rankingAutomatico = new TreeSet<>(new ComparadorEspectadores());
        rankingAutomatico.add(stream2); // Rubius (22k)
        rankingAutomatico.add(stream4); // TheGrefg (18k) -> Se va abajo solo
        rankingAutomatico.add(stream1); // Ibai (45k) -> Salta al primer puesto automáticamente

        System.out.println("El streamer líder absoluto en el TreeSet es: " + rankingAutomatico.first());


        System.out.println("\n=================================================");
        System.out.println("7. ITERADORES -> Limpieza automática por Inactividad");
        System.out.println("=================================================");
        /* * ¿Para qué sirve? Para recorrer colecciones y poder borrar elementos de forma segura mientras caminas por ella.
         * ¿Por qué aquí? Si intentas hacer un `for (CanalStreaming c : lista)` y dentro metes un `lista.remove(c)`,
         * Java explota con un error `ConcurrentModificationException`. El Iterator actúa como un puntero seguro
         * que puede mutar la lista sin corromper el bucle.
         */
        ArrayList<CanalStreaming> canalesActivos = new ArrayList<>();
        canalesActivos.add(new CanalStreaming("StreamerNovato", "Retro", 0)); // Canal vacío
        canalesActivos.add(stream1); // Ibai
        canalesActivos.add(new CanalStreaming("BotCanal", "Pruebas", 0));  // Canal vacío

        Iterator<CanalStreaming> iterador = canalesActivos.iterator();

        while (iterador.hasNext()) {
            CanalStreaming canal = iterador.next();
            // Si el canal tiene 0 espectadores, lo tiramos del servidor para ahorrar recursos
            if (canal.getEspectadores() == 0) {
                iterador.remove(); // Borrado seguro
                System.out.println("Desconectando canal inactivo de: @" + canal.getNombreStreamer());
            }
        }

        System.out.println("Canales que se mantienen online en el servidor: " + canalesActivos.size());
    }
}
