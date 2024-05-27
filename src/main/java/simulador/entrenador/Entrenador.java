package simulador.entrenador;

import java.util.LinkedList;
import simulador.pokemon.Pokemon;

public class Entrenador {

    private String nombre;
    private LinkedList<Pokemon> listaPokemones;

    public Entrenador(String nombre, LinkedList<Pokemon> listaPokemones) {
        this.nombre = nombre;
        this.listaPokemones = listaPokemones;
    }

    public void agregarPokemon(Pokemon pokemon) {
        listaPokemones.add(pokemon);
    }
    // Añade un Pokémon al equipo del entrenador.

    public void entrenarPokemon(Pokemon pokemon) {
        double daño =pokemon.getPuntosDeAtaque()+20;
        double salud =pokemon.getSalud()+5;
    }
    //Selecciona un Pokémon para entrenar, mejorando sus estadísticas.

    public void mostrarPokemones() {
        for (int i = 0; i < listaPokemones.size(); i++) {
            String pokemonLista = listaPokemones.get(i).getNombre();
            System.out.println(i + ")." + pokemonLista);
        }
    }
    // Muestra una lista de los Pokémones actuales del entrenador.

    public Pokemon prepararBatalla() {
        if (listaPokemones.isEmpty() != true) {
            System.out.println("Los pokémones que tienes disponibles son: ");
            mostrarPokemones();
            System.out.println("Ahora, ¿Que pokémon quieres elegir?");
            String palabraBusqueda = null;
            for (int i = 0; i < listaPokemones.size(); i++) {
                String nombrePokemonBusqueda = listaPokemones.get(i).getNombre();
                if (palabraBusqueda.equals(nombrePokemonBusqueda)) {
                    Pokemon pokemonBatalla = listaPokemones.get(i);
                    return pokemonBatalla;
                }
            }
        } else {
            System.out.println("No tienes ningún Pokémon :(" + "/n !Te deseo suerte con eso¡");
        }
        return null;
    }
    // Selecciona un Pokémon de su equipo para participar en una batalla.

    public String getNombre() {
        return nombre;
    }

    public LinkedList<Pokemon> getListaPokemones() {
        return listaPokemones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaPokemones(LinkedList<Pokemon> listaPokemones) {
        this.listaPokemones = listaPokemones;
    }
    
}
