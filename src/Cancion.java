import java.time.LocalDate;

public class Cancion {
    private String titulo;
    private Persona nombre;
    private String leyenda;
    private int reproducciones;
    private Popularidad popularidad;
    private LocalDate ultimaHora;
    private Album album;
    private int likes;
    private int dislikes;

    public Cancion(String titulo, Persona nombre, String leyenda, int reproducciones, Popularidad popularidad, LocalDate ultimaHora, Album album, int likes, int dislikes) {
        this.titulo = titulo;
        this.nombre = nombre;
        this.leyenda = leyenda;
        this.reproducciones = reproducciones;
        this.popularidad = popularidad;
        this.ultimaHora = ultimaHora;
        this.album = album;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Persona getNombre() {
        return nombre;
    }

    public void setNombre(Persona nombre) {
        this.nombre = nombre;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproduccion) {
        this.reproducciones = reproduccion;
    }

    public Popularidad getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(Popularidad popularidad) {
        this.popularidad = popularidad;
    }

    public LocalDate getUltimaHora() {
        return ultimaHora;
    }

    public void setUltimaHora(LocalDate ultimaHora) {
        this.ultimaHora = ultimaHora;
    }


    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void agregarLike() { this.likes++; }
    public void agregarDislike() { this.dislikes++; }
    
    public void mostrarLeyenda(){
        getPopularidad().cambiarLeyenda(titulo, album.getTitulo(), nombre.getNombre(), album.getAnio());
        System.out.println(popularidad.getIcono().texto() + " - " + popularidad.getLeyenda());
    }

    public void definirPopularidad() {
        if (reproducciones <= 1000 && popularidad != Popularidad.NORMAL) { // Si tiene menos de mil likes, su popularidad tiene que ser normal
            setPopularidad(Popularidad.NORMAL);
        }
        if (popularidad == Popularidad.NORMAL && getReproducciones() > 1000) { // Si tiene más y ademas su popularidad es normal, su popularidad pasa a ser euge
            setPopularidad(Popularidad.AUGE);
        }

        if (popularidad == Popularidad.AUGE) {
            if (getDislikes() >= 5000) { // Si su pop. es euge y tiene mas de 5000 dislikes, pasa a ser normalito
                setPopularidad(Popularidad.NORMAL);
            } else if (getReproducciones() > 50000 && getLikes() > 20000) { // pero si tiene mas de 50000 reproducciones y tiene mas de 20mil likes, pasa a ser tendencia
                setPopularidad(Popularidad.TENDENCIA);
            }
        }

        if (popularidad == Popularidad.TENDENCIA && ultimaHora.isBefore(LocalDate.now().minusDays(1))) { // si es tendencia, pero su ultima repro fue hace 24 horas, pasa a ser normal. El isBefore ve si ultimahora es de hace 24 horas o mas
            setPopularidad(Popularidad.NORMAL);
        }
    }
}
