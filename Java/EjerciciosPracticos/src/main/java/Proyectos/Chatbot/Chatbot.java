package Proyectos.Chatbot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chatbot {

    private Map<String, String> respuestas;

    public Chatbot() {
        respuestas = new HashMap<>();
        respuestas.put("hola",    "Hola, ¿En qué te puedo ayudar?");
        respuestas.put("¿cómo estás?", "¡Estoy listo para ayudarte!");
        respuestas.put("como estas",   "¡Estoy listo para ayudarte!");
        respuestas.put("adiós",   "¡Hasta luego!");
        respuestas.put("adios",   "¡Hasta luego!");
        respuestas.put("gracias", "¡De nada! Que tengas un buen día.");
    }

    public String responder(String entrada) {
        String clave = entrada.trim().toLowerCase();
        return respuestas.getOrDefault(clave, "No te entiendo :(");
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chatbot: Bienvenido! Escribe <salir> cuando quieras acabar la conversación...");

        while (true) {
            System.out.print("Tú: ");
            String entrada = sc.nextLine();

            if (entrada.trim().equalsIgnoreCase("salir")) {
                System.out.println("Chatbot: ¡Adiós!");
                break;
            }

            System.out.println("Chatbot: " + responder(entrada));
        }

        sc.close();
    }
}
