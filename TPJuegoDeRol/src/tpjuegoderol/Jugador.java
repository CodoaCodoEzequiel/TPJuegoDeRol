
package tpjuegoderol;

public class Jugador {
    
    private String nombre;
    private int vida;
  
    public Jugador(String nombre)
    {
        this.vida = 100;
        this.nombre = nombre;
    }   
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getVida() {
        return vida;
    }
    
    public void setVida(int vida) {
        this.vida -= vida;
    }    
    
    public void golpear(Jugador adversario)
    {
        int n =  (int) (Math.random() * 10) + 1;
        adversario.setVida(n);             
    }    
}
