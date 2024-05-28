package simulador.pokemon;

public abstract class Pokemon {

    private String nombre;
    // El nombre del Pokémon.

    private double salud;
    //Puntos de vida del Pokémon.

    private double puntosDeAtaque;
    // La potencia base de los ataques del Pokémon

    private TipoPokemon tipo;
    //El tipo elemental del Pokémon, basado en la enumeración TipoPokemon.

    private Estado.Estados estado;
    //El tipo elemental del Pokémon, basado en la enumeración TipoPokemon.

    public Pokemon(String nombre, double salud, double puntosDeAtaque, TipoPokemon tipo, Estado.Estados estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }

    public double atacar(Pokemon oponente) {
        Double saludOponete = oponente.getSalud();
        double multiplicador = TipoPokemon.multiplicadorDaño(this.tipo, oponente.getTipo());
        double daño = saludOponete - (this.puntosDeAtaque * multiplicador);
        return daño;
    }
    //Realiza un ataque al oponente, teniendo en cuenta las ventajas y desventajas de tipo.

    public double recibirDaño(double daño) {
        double salud = this.salud - daño;
        return salud;
    }

    public void entrenar() {
        this.puntosDeAtaque += 20;
        this.salud += 5;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalud() {
        return salud;
    }

    public double getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public Estado.Estados getEstado() {
        return estado;
    }
}
