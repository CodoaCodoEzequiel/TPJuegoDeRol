package tpjuegoderol;

import java.util.ArrayList;
import java.util.List;
/** 
 * @author Ezequiel Nicolás Veltri
 */

public class TPJuegoDeRol {
    
    public static void main(String[] args) {
        
        int cantidadDeTurnos = 1000;
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(new Jugador("Maria"));
        jugadores.add(new Jugador("Pedro"));
        jugadores.add(new Jugador("Ramiro"));
        // Descomentar para agregar más jugadores
//        jugadores.add(new Jugador("Marcela"));
//        jugadores.add(new Jugador("Romina"));
//        jugadores.add(new Jugador("Alberto"));

        Juego juego = new Juego(jugadores, cantidadDeTurnos);
        juego.seleccionarQuienPeleaPrimero();
        juego.play();
        juego.mostrarResultado();        
    }    
}
