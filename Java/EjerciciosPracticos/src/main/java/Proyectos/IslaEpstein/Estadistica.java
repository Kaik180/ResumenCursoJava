package Proyectos.IslaEpstein;

import lombok.Getter;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.*;

@Getter
@ToString
public class Estadistica implements Informes{

    private TreeMap<Famoso,Integer> estadisticas;

    public Estadistica(ArrayList<Famoso> listaEpstein) {
        this.estadisticas = new TreeMap<>();
        calcular(listaEpstein);
    }

    public void calcular(ArrayList<Famoso> listaEpstein){

        for (Famoso famoso : listaEpstein){
            estadisticas.put(famoso, estadisticas.getOrDefault(famoso,0)+1);
        }

        System.out.println("Estadísticas generadas:");

        for (Map.Entry<Famoso,Integer> mapita : estadisticas.entrySet()){

            System.out.println(" --" + mapita.getKey().getNombre() + ": " + mapita.getValue() +  " visita/s.");

        }

    }

    @Override
    public void verPoliticos() {

        System.out.println("\nIdentificando a la clase política...");

        for (Map.Entry<Famoso,Integer> mapita : estadisticas.entrySet()){

            if (mapita.getKey().getProfesion().equalsIgnoreCase("político")){
                System.out.println(" --" + mapita.getKey().getNombre() + " representando a " + mapita.getKey().getPais() + ".");
            }

        }

    }

    @Override
    public void informeJuzgado() {

        System.out.println("\nListado ordenado por paises: ");

        for (Map.Entry<Famoso,Integer> mapita : estadisticas.entrySet()){

            System.out.println(" #" + mapita.getKey().getPais() + " - " + mapita.getKey().getNombre() + ".");

        }

    }

    @Override
    public void verRanking() {

        ArrayList<Map.Entry<Famoso,Integer>> lista = new ArrayList<>(estadisticas.entrySet());

        lista.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int aux = 1;

        System.out.println("\nRanking (famosos con más de una visita): ");
        for (Map.Entry<Famoso,Integer> famoso : lista){
            if (famoso.getValue() > 1){
                System.out.println(" #" + aux + " " + famoso.getKey().getNombre() + " (" + famoso.getValue() + " visita/s)");
                aux++;
            }
        }

    }
}
