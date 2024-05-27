package simulador.batalla;

import simulador.pokemon.Pokemon;

public class Batalla {

    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        Tipos atacante=pokemon1;
        double ataquePokemon1 = pokemon1.getPuntosDeAtaque();
        double saludPokemon1= pokemon1.getSalud();
        String tipoPokemon1= pokemon1.getTipo();
        double ataquePokemon2 = pokemon2.getPuntosDeAtaque();
        double saludPokemon2= pokemon2.getSalud();
        String tipoPokemon2= pokemon2.getTipo();
        
        while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            
        }

    }
    // Controla el flujo de la batalla entre dos Pokémones.
}
