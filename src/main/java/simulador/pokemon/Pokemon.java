package simulador.pokemon;

public abstract class Pokemon {
    private String nombre;
    // El nombre del Pokémon.
    
    private double salud;
    //Puntos de vida del Pokémon.
    
    private double puntosDeAtaque;
    // La potencia base de los ataques del Pokémon
    
    private TipoPokemon.Tipos tipo;
    //El tipo elemental del Pokémon, basado en la enumeración TipoPokemon.
    
    private Estado.Estados estado;
    //El tipo elemental del Pokémon, basado en la enumeración TipoPokemon.

    public Pokemon(String nombre, double salud, double puntosDeAtaque, TipoPokemon.Tipos tipo, Estado.Estados estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    

    
    public abstract void atacar(Pokemon oponente);
    //Realiza un ataque al oponente, teniendo en cuenta las ventajas y desventajas de tipo.
 
    public abstract void recibirDaño(int daño);
    // Reduce la salud del Pokémon basado en el daño recibido.
    
    public abstract void entrenar();
    //Mejora las estadísticas del Pokémon.

    public String getNombre() {
        return nombre;
    }

    public double getSalud() {
        return salud;
    }

    public double getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public TipoPokemon.Tipos getTipo() {
        return tipo;
    }

    public Estado.Estados getEstado() {
        return estado;
    }
}
