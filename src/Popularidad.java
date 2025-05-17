public enum Popularidad {
    TENDENCIA(Icono.FIRE), NORMAL(Icono.MUSICAL_NOTE), AUGE(Icono.ROCKET);

    private Icono icono;
    private String leyenda;

    Popularidad(Icono icono) {
        this.icono = icono;
    }

    public Icono getIcono() {
        return icono;
    }

    public void setIcono(Icono icono) {
        this.icono = icono;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public void cambiarLeyenda(String titulo, String album, String artista, int anioAlbum){
        if (icono == Icono.MUSICAL_NOTE) { // Si es normal, tiene que tener esta leyenda
            String leyendaa = (artista + "-" + album + "-" + titulo);
            setLeyenda(leyendaa);
        } else if (icono == Icono.ROCKET) { // Si es auge, tiene que tener esta leyenda
            String leyendaa = (artista + "-" + titulo + "(" + album + "-" + anioAlbum + ")");
            setLeyenda(leyendaa);
        }
        else { // Si no es auge ni normal, es decir, es tendencia, tiene que tener esta leyenda
            String leyendaa = (titulo + "-" + artista + "(" + album + "-" + anioAlbum + ")");
            setLeyenda(leyendaa);
        }
    }
}
