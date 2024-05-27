package simulador.pokemon;

public class Articuno extends Pokemon {

    public Articuno(String nombre, double salud, double puntosDeAtaque, TipoPokemon tipo, Estado.Estados estado) {
        super(nombre, salud, puntosDeAtaque, tipo, estado);
    }

    public void atacar(Pokemon oponente) {
        Double saludOponete = oponente.getSalud();
        double multiplicador = TipoPokemon.multiplicadorDaño(this.tipo, oponente.getTipo());
        double daño = this * multiplicador;
    }
    
    

}
