import java.time.LocalDate;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Persona artista = new Persona("Coldplay", "Jesus", 49, LocalDate.of(2000, 10, 2), 45454545);
        HashSet<Cancion> canciones = new HashSet<>();

        Album album = new Album("A rush of Blood to the Head", canciones, 2002);

        Cancion cancion = new Cancion("The Scientist", artista, "", 0, Popularidad.NORMAL, LocalDate.now(), album, 0, 0);

        System.out.println("\n CASO 1: The Scientist recién se lanza (tiene popularidad normal)");
        cancion.definirPopularidad();
        System.out.println(cancion.getPopularidad());
        cancion.mostrarLeyenda();

        cancion.setReproducciones(1500);
        System.out.println("\n CASO 2: The Scientist está en auge por superar el mínimo de reproducciones esperadas");
        cancion.definirPopularidad();
        System.out.println(cancion.getPopularidad());
        cancion.mostrarLeyenda();

        cancion.setDislikes(6000);
        System.out.println("\n CASO 3: Baja del auge por tener muchos dislikes");
        cancion.definirPopularidad();
        System.out.println(cancion.getPopularidad());
        cancion.mostrarLeyenda();


        cancion.setReproducciones(60000);
        cancion.setLikes(25000);
        cancion.setDislikes(0);
        System.out.println("\n CASO 4:  The Scientist es tendencia por récord de reproducciones y cantidad de personas que le gusta el tema");
        cancion.setPopularidad(Popularidad.AUGE);
        cancion.definirPopularidad();
        System.out.println(cancion.getPopularidad());
        cancion.mostrarLeyenda();


        cancion.setUltimaHora(LocalDate.now().minusDays(2));
        System.out.println("\n CASO 5:• The Scientist era tendencia, per vuelve a ser normal por no ser escuchada en las últimas horas");
        cancion.definirPopularidad();
        System.out.println(cancion.getPopularidad());
        cancion.mostrarLeyenda();
    }
}
