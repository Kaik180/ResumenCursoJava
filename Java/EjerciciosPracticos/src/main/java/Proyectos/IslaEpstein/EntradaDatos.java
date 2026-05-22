package Proyectos.IslaEpstein;

import java.util.LinkedList;
import java.util.Queue;

public class EntradaDatos {

    static Queue<Famoso> datos;

    public static void generarDatos(){

        datos = new LinkedList<>();
        datos.offer(new Famoso("Elon Musk", "EEUU", "Empresario", 52));
        datos.offer(new Famoso("Donald Trump", "EEUU", "Político", 78));
        datos.offer(new Famoso("Cristiano Ronaldo", "Portugal", "Futbolista", 39));
        datos.offer(new Famoso("Shakira", "Colombia", "Cantante", 47));
        datos.offer(new Famoso("Keanu Reeves", "Canadá", "Actor", 59));
        datos.offer(new Famoso("Elon Musk", "EEUU", "Empresario", 52));
        datos.offer(new Famoso("Elon Musk", "EEUU", "Empresario", 52));
        datos.offer(new Famoso("El Cromas", "España", "Youtuber", 16));
        datos.offer(new Famoso("The American Shockas Jr", "EEUU", "Youtuber", 15));
        datos.offer(new Famoso("Santiago Abascal", "España", "Político", 52));
        datos.offer(new Famoso("Donald Trump", "EEUU", "Político", 78));
        datos.offer(new Famoso("Emmanuel Macron", "Francia", "Político", 46));
        datos.offer(new Famoso("Lionel Messi", "Argentina", "Futbolista", 37));
        datos.offer(new Famoso("Serena Williams", "EEUU", "Tenista", 42));
        datos.offer(new Famoso("LeBron James", "EEUU", "Baloncestista", 39));
        datos.offer(new Famoso("Lamine Yamal", "España", "Futbolista", 16));

    }

    public static Queue<Famoso> getDatosActuales(){

        return datos;

    }

}
