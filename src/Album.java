import java.util.HashSet;

public class Album  {
    private String titulo;
    private HashSet<Cancion> canciones;
    private int anio;

    public Album(String titulo, HashSet<Cancion> canciones, int anio) {
        this.titulo = titulo;
        this.canciones = canciones;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public HashSet<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(HashSet<Cancion> canciones) {
        this.canciones = canciones;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
