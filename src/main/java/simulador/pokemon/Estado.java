package simulador.pokemon;

public class Estado {

    public enum Estados {
        NORMAL, DEBILITADO;

        public static String estadoPokemon(Estados estadoPokemon) {
            switch (estadoPokemon) {
                case NORMAL:
                    return "El Pokémon esta listo para la battalla :)";
                case DEBILITADO:
                    return "El Pokémon no esta listo para la battalla, pues se encuentra"
                            + "debilitado :(";
            }
            return null;
        }
    }
}
