package Colecciones3.GamingHUB;

import java.util.Objects;

public class CanalStreaming {
    private String nombreStreamer;
    private String juego;
    private int espectadores;

    public CanalStreaming(String nombreStreamer, String juego, int espectadores) {
        this.nombreStreamer = nombreStreamer;
        this.juego = juego;
        this.espectadores = espectadores;
    }

    public String getNombreStreamer() { return nombreStreamer; }
    public String getJuego() { return juego; }
    public int getEspectadores() { return espectadores; }

    // OBLIGATORIO para HashSet y HashMap: Define la identidad del canal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CanalStreaming that = (CanalStreaming) o;
        // Si el nombre del streamer es igual, el canal es el mismo
        return Objects.equals(nombreStreamer, that.nombreStreamer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreStreamer);
    }

    @Override
    public String toString() {
        return "@" + nombreStreamer + " jugando a " + juego + " (" + espectadores + " Viewers)";
    }
}
