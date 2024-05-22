package simulador.entrenador;

import java.util.LinkedList;

public class Entrenador {
    private String nombre;
    private LinkedList<Pokemon> listaPokemones;

    public Entrenador(String nombre, LinkedList<Pokemon> listaPokemones) {
        this.nombre = nombre;
        this.listaPokemones = listaPokemones;
    }
    
    public void agregarPokemon(Pokemon pokemon){
        listaPokemones.add(pokemon);    
    }
    // Añade un Pokémon al equipo del entrenador.
    
    public void entrenarPokemon(Pokemon pokemon){
    
    }
    //Selecciona un Pokémon para entrenar, mejorando sus estadísticas.
    
    public String mostrarPokemones(){
        for (int i = 0; i < listaPokemones.size(); i++) {
            return listaPokemones.get(i);
        }
        return null;
    }
    // Muestra una lista de los Pokémones actuales del entrenador.
    
    public Pokemon prepararBatalla(){
        String palabraBusqueda=null;
        for (int i = 0; i < listaPokemones.size(); i++) {
            Pokemon nombrePokemonBusqueda=listaPokemones.get(i);
            if(palabraBusqueda==nombrePokemonBusqueda.getNombre()){
                return listaPokemones.get(i);
            }
        }
    }
    // Selecciona un Pokémon de su equipo para participar en una batalla.
}
