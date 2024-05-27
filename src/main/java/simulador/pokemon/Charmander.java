
package simulador.pokemon;


public class Charmander extends Pokemon{

    public Charmander(String nombre, double salud, double puntosDeAtaque, TipoPokemon.Tipos tipo, Estado.Estados estado) {
        super(nombre, salud, puntosDeAtaque, tipo, estado);
    }

    

    public void atacar(Pokemon oponente) {
        
    }

    public void recibirDaño(int daño) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void entrenar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
