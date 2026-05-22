package Colecciones3.GamingHUB;

import java.util.Comparator;

// Esta clase le enseña a Java a ordenar los canales de Mayor a Menor popularidad
public class ComparadorEspectadores implements Comparator<CanalStreaming> {
    @Override
    public int compare(CanalStreaming c1, CanalStreaming c2) {
        // Multiplicamos por -1 o invertimos el orden para que sea descendente (de más visto a menos visto)
        return Integer.compare(c2.getEspectadores(), c1.getEspectadores());
    }
}