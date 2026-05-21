package Ejercicios.Avanzado.JuegoRol;

import java.util.Random;
import java.util.Scanner;

public class JuegoRol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Nombra a tu héroe: ");
        String nombreHeroe = sc.nextLine();

        // Creamos dos instancias independientes de la clase Personaje
        Personaje heroe = new Personaje(nombreHeroe, 100, 20);
        Personaje orco = new Personaje("Orco Salvaje", 80, 15);

        System.out.println("\n¡Un " + orco.getNombre() + " salvaje aparece!");

        while (heroe.estaVivo() && orco.estaVivo()) {
            System.out.println("\n=== TU TURNO ===");
            System.out.println("Tu vida: " + heroe.getVida() + " | Vida del " + orco.getNombre() + ": " + orco.getVida());
            System.out.println("1. Atacar con espada");
            System.out.println("2. Usar poción de curación (+25 de vida)");
            System.out.print("Acción: ");
            int accion = sc.nextInt();

            if (accion == 1) {
                int dano = heroe.getAtaqueBase() + rand.nextInt(10);
                orco.setVida(orco.getVida() - dano);
                System.out.println("¡Golpeas al " + orco.getNombre() + " haciendo " + dano + " puntos de daño!");
            } else if (accion == 2) {
                heroe.curar(25);
            } else {
                System.out.println("Te quedas confundido y pierdes el turno.");
            }

            // Turno del Monstruo
            if (orco.estaVivo()) {
                System.out.println("\n=== TURNO DEL ENEMIGO ===");
                int danoEnemigo = orco.getAtaqueBase() + rand.nextInt(8);
                heroe.setVida(heroe.getVida() - danoEnemigo);
                System.out.println("El " + orco.getNombre() + " te ruge y te causa " + danoEnemigo + " puntos de daño.");
            }
        }

        System.out.println("\n=== FIN DE LA BATALLA ===");
        if (heroe.estaVivo()) {
            System.out.println("¡Victoria! Has derrotado al " + orco.getNombre() + ". ¡Eres una leyenda!");
        } else {
            System.out.println("Has caído en combate... Fin de la partida.");
        }

        sc.close();
    }
}