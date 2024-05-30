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
        System.out.println("Entrenando con mucho chocolate y pesas a: "+ pokemon.getNombre());
        pokemon.entrenar();
    }
    //Selecciona un Pokémon para entrenar, mejorando sus estadísticas.

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
