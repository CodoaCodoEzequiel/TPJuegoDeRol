
package tpjuegoderol;

import java.util.List;

public class Juego {
    
    private List<Jugador> listaJugadores;
    private Jugador jugadorTurnoActual;
    private Jugador jugadorAdversario;
    private int cantidadDeTurnos;

    public Juego(List<Jugador> jugadores, int cantidadDeTurnos)
    {            
        this.listaJugadores = jugadores;
        this.cantidadDeTurnos = cantidadDeTurnos;
    }

    public void seleccionarQuienPeleaPrimero()
    {
        int p =  (int) (Math.random() * this.listaJugadores.size());            
        this.jugadorTurnoActual = listaJugadores.get(p);
        System.out.println("Inicia el jugador: " + this.jugadorTurnoActual.getNombre());
    }

    public void play()
    {
        if (this.listaJugadores.size() < 2) { System.out.println("No hay jugadores suficientes..."); return; } 
        jugadorAdversario = seleccionarAdversario(); // El adversario es cualquiera que no sea si mismo y tenga vida > 0
        System.out.println(jugadorTurnoActual.getNombre() + " golpea a " + jugadorAdversario.getNombre());
        jugadorTurnoActual.golpear(jugadorAdversario);
        System.out.println(jugadorAdversario.getNombre() + " quedó con vida: " + jugadorAdversario.getVida());
        jugadorTurnoActual = jugadorAdversario; // el que fue víctima es el que pasa a tener el poder (si quedó vivo)
        if (jugadorAdversario.getVida() <= 0){ System.out.println("Jugador: " + jugadorAdversario.getNombre() + " Murió."); return; } // Cuando muere un jugador el juego termina
        if (this.cantidadDeTurnos == 0) { System.out.println("Fin, todos vivos"); return; } // Cuando se agotan los turnos el juego termina
        this.cantidadDeTurnos--;
        play(); // Llamo recursivamente para el siguiente turno
    }       

    public void mostrarResultado()
    {
        System.out.println("el resultado del juego fue:");
        for (int i = 0; i < this.listaJugadores.size(); i++)
        {
            System.out.println("Jugador: " + listaJugadores.get(i).getNombre() + " Vida: " + listaJugadores.get(i).getVida());
        }            
    }     

    private Jugador seleccionarAdversario()
    {
        Jugador adversario = null;  
        while (true)
        {  
            int jugador =  (int) (Math.random() * this.listaJugadores.size());  

            if (listaJugadores.get(jugador).getNombre() != jugadorTurnoActual.getNombre() && listaJugadores.get(jugador).getVida() > 0)
            {
                adversario = listaJugadores.get(jugador);
                return adversario;
            }
        }
    }
    
}
