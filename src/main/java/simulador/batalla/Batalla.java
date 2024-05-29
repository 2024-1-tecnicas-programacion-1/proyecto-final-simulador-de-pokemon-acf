package simulador.batalla;

import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;

public class Batalla {

    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2, Entrenador entrenador1, Entrenador entrenador2) {
        while ((pokemon1.getSalud() > 0) && (pokemon2.getSalud() > 0)) {
            pokemon2.recibirDaño(pokemon1.atacar(pokemon2));
            pokemon1.recibirDaño(pokemon2.atacar(pokemon1));
            if (pokemon2.getSalud() <= 0) {
                System.out.println("Felicidaes!!! " + entrenador1.getNombre());
                System.out.println("Tu" + pokemon1.getNombre() + " fue el ganador de la batalla");
            } else {
                if (pokemon2.getSalud() <= 0) {
                    System.out.println("Felicidaes!!! " + entrenador2.getNombre());
                    System.out.println("Tu" + pokemon2.getNombre() + " fue el ganador de la batalla");
                }
            }
        }
    }// Controla el flujo de la batalla entre dos Pokémones.
}
