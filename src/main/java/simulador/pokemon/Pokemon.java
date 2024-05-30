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

    /**
     * Complejidad Temporal: O(1)
     * El constructor inicializa los atributos del Pokémon, lo que implica una operación constante.
     * @param nombre
     * @param salud
     * @param puntosDeAtaque
     * @param tipo
     * @param estado 
     */
    public Pokemon(String nombre, double salud, double puntosDeAtaque, TipoPokemon tipo, Estado.Estados estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }

    /**
     * Complejidad Temporal: O(1)
     * Calcula el daño que un Pokémon inflige a otro Pokémon durante un ataque, teniendo en cuenta las ventajas y desventajas de tipo. Las operaciones dentro del método son operaciones aritméticas simples, lo que implica una complejidad constante.

     * @param oponente
     * @return 
     */
    public double atacar(Pokemon oponente) {
        Double saludOponete = oponente.getSalud();
        double multiplicador = TipoPokemon.multiplicadorDaño(this.tipo, oponente.getTipo());
        double daño = saludOponete - (this.puntosDeAtaque * multiplicador);
        return daño;
    }
    //Realiza un ataque al oponente, teniendo en cuenta las ventajas y desventajas de tipo.

    /**
     * Complejidad Temporal: O(1)
     * Calcula la salud restante del Pokémon después de recibir un cierto daño. Las operaciones dentro del método son operaciones aritméticas simples, lo que implica una complejidad constante.

     * @param daño
     * @return 
     */
    public double recibirDaño(double daño) {
        double salud = this.salud - daño;
        return salud;
    }

    /**
     * Complejidad Temporal: O(1)
     * Incrementa los puntos de ataque y la salud del Pokémon en una cantidad fija. Las operaciones dentro del método son operaciones aritméticas simples, lo que implica una complejidad constante.

     */
    public void entrenar() {
        this.puntosDeAtaque += 20;
        this.salud += 5;
    }

    /**
     * Complejidad Temporal: O(1)
     * Devuelve el nombre del Pokémon, lo que implica una operación constante.
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Complejidad Temporal: O(1)
     * Devuelve la salud del Pokémon, lo que implica una operación constante.

     * @return 
     */
    public double getSalud() {
        return salud;
    }

    /**
     * Complejidad Temporal: O(1)
     * Devuelve los puntos de ataque del Pokémon, lo que implica una operación constante.
     * @return 
     */
    public double getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    /**
     * Complejidad Temporal: O(1)
     * Devuelve el tipo del Pokémon, lo que implica una operación constante.
     * @return 
     */
    public TipoPokemon getTipo() {
        return tipo;
    }

    /**
     * Complejidad Temporal: O(1)
     * Devuelve el estado del Pokémon, lo que implica una operación constante.
     * @return 
     */
    public Estado.Estados getEstado() {
        return estado;
    }
}
