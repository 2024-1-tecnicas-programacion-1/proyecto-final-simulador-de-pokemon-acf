package simulador.pokemon;

public abstract class Pokemon {
    private String nombre;
    // El nombre del Pokémon.
    
    private double salud;
    //Puntos de vida del Pokémon.
    
    private double puntosDeAtaque;
    // La potencia base de los ataques del Pokémon
    
    private String tipo;
    //El tipo elemental del Pokémon, basado en la enumeración TipoPokemon.
    
    private String estado;
    //El tipo elemental del Pokémon, basado en la enumeración TipoPokemon.
    
    
    public Pokemon(String nombre, double salud, double puntosDeAtaque, String tipo, String estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    public abstract void atacar();
    //Realiza un ataque al oponente, teniendo en cuenta las ventajas y desventajas de tipo.
 
    public abstract void recibirDaño(int daño);
    // Reduce la salud del Pokémon basado en el daño recibido.
    
    public abstract void entrenar();
    //Mejora las estadísticas del Pokémon.
    
}
