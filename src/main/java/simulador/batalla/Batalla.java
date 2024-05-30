package simulador.batalla;

import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;

public class Batalla {

    /**
     * Complejidad Temporal: O(n)
     * Este método controla el flujo de la batalla entre dos Pokémones hasta que uno de ellos queda sin salud. 
     * El bucle while que controla la batalla se ejecuta hasta que la salud de uno de los Pokémones llega a cero. Dentro del bucle, se realizan operaciones de ataque y recepción de daño, ambas con una complejidad constante O(1).
     * Por lo tanto, la complejidad total del bucle depende del número de rondas de la batalla, que puede variar dependiendo de la fuerza y resistencia de los Pokémones involucrados. En el peor de los casos, la complejidad puede ser lineal 
     * en función del tiempo que tarda en derrotarse a uno de los Pokémones.
     * @param pokemon1
     * @param pokemon2
     * @param entrenador1
     * @param entrenador2 
     */
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2, Entrenador entrenador1, Entrenador entrenador2) {
        while ((pokemon1.getSalud() > 0) && (pokemon2.getSalud() > 0)) {
            pokemon2.recibirDaño(pokemon1.atacar(pokemon2));
            if (pokemon2.getSalud() > 0) {
                pokemon1.recibirDaño(pokemon2.atacar(pokemon1));
            }
        }
        if (pokemon1.getSalud() > 0 && pokemon2.getSalud() <= 0) {
            System.out.println("Felicidaes!!! " + entrenador1.getNombre());
            System.out.println("Tu" + pokemon1.getNombre() + " fue el ganador de la batalla");
        } else if (pokemon2.getSalud() > 0 && pokemon1.getSalud() <= 0) {
            System.out.println("Felicidaes!!! " + entrenador2.getNombre());
            System.out.println("Tu" + pokemon2.getNombre() + " fue el ganador de la batalla");
        } else if (pokemon1.getSalud() <= 0 && pokemon2.getSalud() <= 0) {
            System.out.println("Uff!, Que batalla!");
            System.out.println("Ambos Pokémones se derrotaron");
            System.out.println("Es un empate");
        }
        
    }// Controla el flujo de la batalla entre dos Pokémones.

}
