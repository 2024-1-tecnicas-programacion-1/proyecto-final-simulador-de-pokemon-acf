package simulador;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import simulador.batalla.Batalla;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Articuno;
import simulador.pokemon.Caterpie;
import simulador.pokemon.Charmander;
import simulador.pokemon.Diglett;
import simulador.pokemon.Drowzee;
import simulador.pokemon.Estado;
import simulador.pokemon.Hitmonlee;
import simulador.pokemon.Jolteon;
import simulador.pokemon.Pokemon;
import simulador.pokemon.Shellder;
import simulador.pokemon.Snorlax;
import simulador.pokemon.Tentacool;
import simulador.pokemon.TipoPokemon;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Entrenador> listaEntrenadores = new LinkedList<>();
        LinkedList<Pokemon> listaPokemones = new LinkedList<>();
        Pokemon charmander = new Charmander("Charmander", 39, 52, TipoPokemon.FUEGO, Estado.Estados.NORMAL);
        Pokemon shellder = new Shellder("Shellder", 30, 65, TipoPokemon.AGUA, Estado.Estados.NORMAL);
        Pokemon caterpie = new Caterpie("Caterpie", 45, 30, TipoPokemon.BICHO, Estado.Estados.NORMAL);
        Pokemon jolteon = new Jolteon("Jolteon ", 65, 65, TipoPokemon.ELECTRICO, Estado.Estados.NORMAL);
        Pokemon drowzee = new Drowzee("Drowzee", 60, 48, TipoPokemon.PSIQUICO, Estado.Estados.NORMAL);
        Pokemon diglett = new Diglett("Diglett", 10, 55, TipoPokemon.TIERRA, Estado.Estados.NORMAL);
        Pokemon articuno = new Articuno("Articuno ", 90, 85, TipoPokemon.HIELO.VOLADOR, Estado.Estados.NORMAL);
        Pokemon snorlax = new Snorlax("Snorlax", 160, 110, TipoPokemon.NORMAL, Estado.Estados.NORMAL);
        Pokemon hitmonlee = new Hitmonlee("Hitmonlee", 50, 120, TipoPokemon.LUCHA, Estado.Estados.NORMAL);
        Pokemon tentacool = new Tentacool("Tentacool", 40, 40, TipoPokemon.AGUA.VENENO, Estado.Estados.NORMAL);
        Entrenador entrenador = null;
        Entrenador entrenador1 = null;
        Entrenador entrenador2 = null;
        LinkedList<Pokemon> listaPokemonesDisponibles = new LinkedList<>();
        listaPokemonesDisponibles.addAll(List.of(charmander, shellder, caterpie, jolteon, drowzee, diglett, articuno, snorlax, hitmonlee, tentacool));
        Pokemon pokemon1 = null;
        Pokemon pokemon2 = null;
        Batalla batalla = new Batalla();
        System.out.println("Bienvenido al Simulador de Batallas Pokémon");
        boolean salir = false;

        while (!salir) {
            System.out.println("Elige el numeral de la sección a la que deseas entrar");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar Pokémones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            String opcion = sc.next();

            switch (opcion) {
                case "1": // 1. Gestionar Entrenadores
                    boolean salirGestionarEntrenadores = false;
                    while (!salirGestionarEntrenadores) {
                        System.out.println("Bienvenido a Gestionar Entrenadores");
                        System.out.println("Elige el numeral de la sección a la que deseas entrar");
                        System.out.println("1. Registrar nuevo entrenador");
                        System.out.println("2. Ver lista de entrenadores");
                        System.out.println("3. Seleccionar un entrenador");
                        System.out.println("4. Volver al menú principal");
                        opcion = sc.next();

                        switch (opcion) {
                            case "1": // 1. Registrar nuevo entrenador
                                System.out.println("Por favor ingrese el nombre del entrenador que quiere agregar");
                                String nombreEntrenador = sc.next();
                                Entrenador entrenadorNuevo = new Entrenador(nombreEntrenador, listaPokemones);
                                listaEntrenadores.add(entrenadorNuevo);
                                System.out.println("Listo, tu entrenador ya fue agregado :)");
                                break;
                            case "2": // 2. Ver lista de entrenadores
                                System.out.println("Los entrenadores registrados son: ");
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    System.out.println(listaEntrenadores.get(i).getNombre());
                                }
                                break;
                            case "3": // 3. Seleccionar un entrenador
                                System.out.println("Elige el nombre del entrenador que deseas elegir");
                                sc.nextLine(); // Consumir el salto de linea pendiente
                                String nombreEntrenadorElegir = sc.nextLine();
                                boolean entrenadorEncontrado = false;
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    if (nombreEntrenadorElegir.equals(listaEntrenadores.get(i).getNombre())) {
                                        entrenador = listaEntrenadores.get(i);
                                        entrenadorEncontrado = true;
                                        break;
                                    }
                                }
                                if (!entrenadorEncontrado) {
                                    System.out.println("Ese entrenador no existe :(");
                                    break;
                                }
                                boolean volverGestionarEntrenadores = false;
                                while (!volverGestionarEntrenadores) {
                                    System.out.println("Elige el numeral de la sección a la que deseas entrar");
                                    System.out.println("1. Ver equipo de Pokémones");
                                    System.out.println("2. Agregar Pokémon al equipo");
                                    System.out.println("3. Entrenar Pokémon");
                                    System.out.println("4. Volver a Gestionar Entrenadores");
                                    opcion = sc.next();

                                    switch (opcion) {
                                        case "1": // 1. Ver equipo de Pokémones
                                            entrenador.mostrarPokemones();
                                            break;
                                        case "2": // 2. Agregar Pokémon al equipo
                                            System.out.println("Los pokémones que puedes añadir a tu equipo son:");
                                            for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
                                                System.out.println(listaPokemonesDisponibles.get(i).getNombre());
                                            }
                                            System.out.println("Entonces, ¿qué Pokémon quieres agregar a tu equipo?");
                                            System.out.println("Escribe el nombre del que deseas elegir o escribe ");
                                            System.out.println("Fin cuando ya no quieras agregar más Pokémones a tu equipo");
                                            sc.nextLine(); // Consumir el salto de línea pendiente
                                            String nombrePokemonAgregar = sc.nextLine();
                                            while (!"Fin".equalsIgnoreCase(nombrePokemonAgregar)) {
                                                boolean pokemonEncontrado = false;
                                                for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
                                                    if (nombrePokemonAgregar.equalsIgnoreCase(listaPokemonesDisponibles.get(i).getNombre())) {
                                                        entrenador.agregarPokemon(listaPokemonesDisponibles.get(i));
                                                        pokemonEncontrado = true;
                                                        break;
                                                    }
                                                }
                                                if (!pokemonEncontrado) {
                                                    System.out.println("Ese Pokémon no está disponible.");
                                                }
                                                System.out.println("Escribe otro Pokémon o Fin para terminar:");
                                                nombrePokemonAgregar = sc.nextLine();
                                            }
                                            break;
                                        case "3": // 3. Entrenar Pokémon
                                            System.out.println("Los pokémones que puedes entrenar en tu equipo son:");
                                            entrenador.mostrarPokemones();
                                            System.out.println("Entonces, ¿qué Pokémon quieres mejorar en tu equipo?, escribe Fin "
                                                    + "cuando ya no quieras mejorar más Pokémones en tu equipo");
                                            sc.nextLine();
                                            String nombrePokemonEntrenar = sc.nextLine();
                                            while (!"Fin".equalsIgnoreCase(nombrePokemonEntrenar)) {
                                                boolean pokemonEntrenarEncontrado = false;
                                                for (int i = 0; i < listaPokemones.size(); i++) {
                                                    if (nombrePokemonEntrenar.equalsIgnoreCase(listaPokemones.get(i).getNombre())) {
                                                        entrenador.entrenarPokemon(listaPokemones.get(i));
                                                        pokemonEntrenarEncontrado = true;
                                                        break;
                                                    }
                                                }
                                                if (!pokemonEntrenarEncontrado) {
                                                    System.out.println("Ese Pokémon no está en tu equipo.");
                                                }
                                                System.out.println("Escribe otro Pokémon que quieras mejorar de tu equipo o Fin para terminar:");
                                                nombrePokemonEntrenar = sc.nextLine();
                                            }
                                            break;
                                        case "4": // 4. Volver a Gestionar Entrenadores
                                            volverGestionarEntrenadores = true;
                                            break;
                                    }
                                }
                                break;
                            case "4": // Volver al menú principal
                                salirGestionarEntrenadores = true;
                                break;
                        }
                    }
                    break;
                case "2": // Gestionar Pokémones
                    boolean salirGestionarPokemones = false;
                    while (!salirGestionarPokemones) {
                        System.out.println("Bienvenido a Gestionar Pokémones");
                        System.out.println("Elige el numeral de la sección a la que deseas entrar");
                        System.out.println("1. Ver todos los Pokémones registrados");
                        System.out.println("2. Registrar nuevo Pokémon");
                        System.out.println("3. Volver al menú principal");
                        opcion = sc.next();

                        switch (opcion) {
                            case "1": // Ver todos los Pokémones registrados
                                for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
                                    System.out.println(listaPokemonesDisponibles.get(i).getNombre());
                                }
                                break;
                            case "2": // Registrar nuevo Pokémon
                                System.out.println("¿Qué Pokémon quieres registrar?,"
                                        + " Si te decides por alguno, escribe su numeral  pls :)");
                                for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
                                    System.out.println(i + "). " + listaPokemonesDisponibles.get(i).getNombre());
                                }
                                int numeroPokemon = sc.nextInt();
                                Pokemon nuevoPokemon = listaPokemonesDisponibles.get(numeroPokemon);
                                listaPokemonesDisponibles.add(nuevoPokemon);
                                break;
                            case "3": // Volver al menú principal
                                salirGestionarPokemones = true;
                                break;
                        }
                    }
                    break;
                case "3": // Iniciar Batalla
                    boolean salirIniciarBatalla = false;
                    while (!salirIniciarBatalla) {
                        System.out.println("Bienvenido a Iniciar Batalla");
                        System.out.println("Elige el numeral de la sección a la que deseas entrar");
                        System.out.println("1. Elegir entrenador 1");
                        System.out.println("2. Elegir entrenador 2");
                        System.out.println("3. Seleccionar Pokémon de entrenador 1");
                        System.out.println("4. Seleccionar Pokémon de entrenador 2");
                        System.out.println("5. Comenzar batalla");
                        System.out.println("6. Volver al menú principal");
                        opcion = sc.next();

                        switch (opcion) {
                            case "1": // Elegir entrenador 1
                                System.out.println("¿Qué entrenador quieres elegir para la batalla?, escribe el nombre del que "
                                        + "quieras elegir pls:)");
                                sc.nextLine(); // Consumir el salto de línea pendiente
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    System.out.println(i + "). " + listaEntrenadores.get(i).getNombre());
                                }
                                String nombreEntrenadorElegirUno = sc.nextLine();
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    if (nombreEntrenadorElegirUno.equals(listaEntrenadores.get(i).getNombre())) {
                                        entrenador1 = listaEntrenadores.get(i);
                                    }
                                }
                                break;
                            case "2": // Elegir entrenador 2
                                System.out.println("¿Qué entrenador quieres elegir para la batalla?, escribe el nombre del que "
                                        + "quieras elegir pls:)");
                                sc.nextLine(); // Consumir el salto de línea pendiente
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    System.out.println(i + "). " + listaEntrenadores.get(i).getNombre());
                                }
                                String nombreEntrenadorElegirDos = sc.nextLine();
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    if (nombreEntrenadorElegirDos.equals(listaEntrenadores.get(i).getNombre())) {
                                        entrenador2 = listaEntrenadores.get(i);
                                    }
                                }
                                break;
                            case "3": // Seleccionar Pokémon de entrenador 1
                                if (entrenador1 != null) {
                                    System.out.println("Los pokémones que tienes disponibles son: ");
                                    entrenador1.mostrarPokemones();
                                    System.out.println("Ahora, ¿qué Pokémon quieres elegir?");
                                    String palabraBusqueda = sc.next();
                                    pokemon1 = entrenador1.prepararBatalla(palabraBusqueda);
                                    if (pokemon1 == null) {
                                        System.out.println("No se encontró el Pokémon especificado.");
                                    }
                                } else {
                                    System.out.println("Primero debes seleccionar al Entrenador 1.");
                                }
                                break;
                            case "4": // Seleccionar Pokémon de entrenador 2
                                if (entrenador2 != null) {
                                    System.out.println("Los pokémones que tienes disponibles son: ");
                                    entrenador2.mostrarPokemones();
                                    System.out.println("Ahora, ¿qué Pokémon quieres elegir?");
                                    String palabraBusqueda = sc.next();
                                    pokemon2 = entrenador2.prepararBatalla(palabraBusqueda);
                                    if (pokemon2 == null) {
                                        System.out.println("No se encontró el Pokémon especificado.");
                                    }
                                } else {
                                    System.out.println("Primero debes seleccionar al Entrenador 2.");
                                }
                                break;
                            case "5": // Comenzar batalla
                                if (pokemon1 == null || pokemon2 == null) {
                                    System.out.println("Debes seleccionar ambos Pokémon antes de comenzar la batalla.");
                                } else if (entrenador1 == null || entrenador2 == null) {
                                    System.out.println("Debes seleccionar ambos entrenadores antes de comenzar la batalla.");
                                } else {
                                    batalla.iniciarBatalla(pokemon1, pokemon2, entrenador1, entrenador2);
                                }
                                break;
                            case "6": // Volver al menú principal
                                salirIniciarBatalla = true;
                                break;
                        }
                    }
                    break;
                case "4": // Salir
                    salir = true;
                    break;
            }
        }
    }
}
