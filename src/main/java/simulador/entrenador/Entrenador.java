package simulador.entrenador;

import java.util.LinkedList;
import simulador.pokemon.Pokemon;

public class Entrenador {

    private String nombre;
    private LinkedList<Pokemon> listaPokemones;

    /**
     * Complejidad Temporal: O(1)
     * El constructor inicializa los atributos del entrenador, lo que implica una operación constante.
     * @param nombre
     * @param listaPokemones 
     */
    public Entrenador(String nombre, LinkedList<Pokemon> listaPokemones) {
        this.nombre = nombre;
        this.listaPokemones = listaPokemones;
    }
    
    /**
     * Complejidad Temporal: O(1)
     * Agrega un Pokémon a la lista de Pokémon del entrenador, lo que implica una operación constante.
     * @param pokemon 
     */
    public void agregarPokemon(Pokemon pokemon) {
        listaPokemones.add(pokemon);
    }
    // Añade un Pokémon al equipo del entrenador.

    /**
     * Complejidad Temporal: O(1)
     * Entrena un Pokémon específico, lo que implica una operación constante.
     * @param pokemon 
     */
    public void entrenarPokemon(Pokemon pokemon) {
        System.out.println("Entrenando con mucho chocolate y pesas a: "+ pokemon.getNombre());
        pokemon.entrenar();
    }
    //Selecciona un Pokémon para entrenar, mejorando sus estadísticas.

    /**
     * Complejidad Temporal: O(n)
     * Itera sobre la lista de Pokémon del entrenador e imprime sus nombres, lo que implica una complejidad lineal en función del número de Pokémon en el equipo.
     */
    public void mostrarPokemones() {
        if (listaPokemones.isEmpty() != true) {
            for (int i = 0; i < listaPokemones.size(); i++) {
                System.out.println(listaPokemones.get(i).getNombre());;
            }
        } else {
            System.out.println("No tienes ningún Pokémon :(" + "!Te deseo suerte con eso¡");
        }
    }
    // Muestra una lista de los Pokémones actuales del entrenador.

    /**
     * Complejidad Temporal: O(n)
     * Itera sobre la lista de Pokémon del entrenador para buscar un Pokémon específico por su nombre, lo que implica una complejidad lineal en función del número de Pokémon en el equipo.

     * @param palabraBusquda
     * @return 
     */
    public Pokemon prepararBatalla(String palabraBusquda) {
        if (listaPokemones.isEmpty() != true) {
            for (int i = 0; i < listaPokemones.size(); i++) {
                if (palabraBusquda.equalsIgnoreCase(listaPokemones.get(i).getNombre())) {
                    Pokemon pokemonBatalla = listaPokemones.get(i);
                    return pokemonBatalla;
                }
            }
        } else {
            System.out.println("No tienes ningún Pokémon :(" + "!Te deseo suerte con eso¡");
        }
        return null;
    }
    // Selecciona un Pokémon de su equipo para participar en una batalla.
    
    /**
     * Complejidad Temporal: O(1)
     * Devuelve la lista de Pokémon del entrenador, lo que implica una operación constante.
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Complejidad Temporal: O(1)
     * Devuelve la lista de Pokémon del entrenador, lo que implica una operación constante.
     * @return 
     */
    public LinkedList<Pokemon> getListaPokemones() {
        return listaPokemones;
    }
    
    /**
     * Complejidad Temporal: O(1)
     * Establece el nombre del entrenador, lo que implica una operación constante.

     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Complejidad Temporal: O(1)
     * Establece la lista de Pokémon del entrenador, lo que implica una operación constante.
     * @param listaPokemones 
     */
    public void setListaPokemones(LinkedList<Pokemon> listaPokemones) {
        this.listaPokemones = listaPokemones;
    }

}
