import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class testYoutube {

    private Persona artista;
    private Album album;
    private Cancion cancion;

    @BeforeEach
    public void setUp() {
        artista = new Persona("Coldplay", "Jesus", 49, LocalDate.of(2000, 10, 2), 45454545);
        album = new Album("A rush of Blood to the Head", new HashSet<>(), 2002);
        cancion = new Cancion("The Scientist", artista, "", 0, Popularidad.NORMAL, LocalDate.now(), album, 0, 0);
    }

    @Test
    public void testPopularidadNormalAlInicio() {
        System.out.println("\nCASO 1");
        cancion.definirPopularidad(); // Tendria que dar el valor popu normal.
        assertEquals(Popularidad.NORMAL, cancion.getPopularidad()); // Compara el valor que quiero con el valor obtenido, es decir, yo quiero que sea normal y para ver si lo hizo bien lo comparo con la popularidad actual.
        System.out.println("La cancion es " + cancion.getPopularidad() + ", por lo tanto funciona como espero");
    }

    @Test
    public void testPopularidadAugePorReproducciones() {
        System.out.println("\nCASO 2");
        cancion.setReproducciones(1500); // Pongoi las reproducciones para que pueda ser Auge
        cancion.definirPopularidad(); //  Hago que sea Auge
        assertEquals(Popularidad.AUGE, cancion.getPopularidad()); // Si funciono el valor que tengo tendria que ser Auge
        System.out.println("La cancion es " + cancion.getPopularidad() + ", por lo tanto funciona como espero");
    }

    @Test
    public void testPopularidadNormalPorDislikes() {
        System.out.println("\nCASO 3");
        cancion.setReproducciones(1500); // Agrego para que sea Auge
        cancion.definirPopularidad(); // Hago que sea Auge
        cancion.setDislikes(6000);  // le agrego dislikes para que sea normal
        cancion.definirPopularidad(); // lo convierto a normal
        assertEquals(Popularidad.NORMAL, cancion.getPopularidad()); // Verifico si esta correcto
        System.out.println("La cancion es " + cancion.getPopularidad() + ", por lo tanto funciona como espero");
    }

    @Test
    public void testPopularidadTendenciaPorLikesYReproducciones() {
        System.out.println("\nCASO 4");
        cancion.setReproducciones(60000);
        cancion.setLikes(25000);
        cancion.setDislikes(0); //Agrego los minimos para que sea Tendencia
        cancion.setPopularidad(Popularidad.AUGE); // para que sea tendencia primero tiene que ser Auge
        cancion.definirPopularidad(); // lo hago tendencia
        assertEquals(Popularidad.TENDENCIA, cancion.getPopularidad()); // resultado que espero: tendencia - resultado que obtengo: tendencia
        System.out.println("La cancion es " + cancion.getPopularidad() + ", por lo tanto funciona como espero");
    }

    @Test
    public void testPopularidadNormalPorNoEscucharRecientemente() {
        System.out.println("\nCASO 5");
        cancion.setReproducciones(60000);
        cancion.setLikes(25000);
        cancion.setDislikes(0);
        cancion.definirPopularidad(); // hago que sea tendencia
        System.out.println("Ahora la cancion es: " + cancion.getPopularidad());
        cancion.setUltimaHora(LocalDate.now().minusDays(2)); //Hago que la ultima reproduccion sea ayer
        cancion.definirPopularidad(); // lo convierto en normal
        assertEquals(Popularidad.NORMAL, cancion.getPopularidad()); // verifico si es correcto
        System.out.println("La cancion es " + cancion.getPopularidad() + ", por lo tanto funciona como espero");
    }
}