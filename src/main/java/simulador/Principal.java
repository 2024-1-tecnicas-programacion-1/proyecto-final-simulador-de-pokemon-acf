package simulador;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
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
        Pokemon Shellder = new Shellder("Shellder", 30, 65, TipoPokemon.AGUA, Estado.Estados.NORMAL);
        Pokemon caterpie = new Caterpie("Caterpie", 45, 30, TipoPokemon.BICHO, Estado.Estados.NORMAL);
        Pokemon jolteon = new Jolteon("Jolteon ", 65, 65, TipoPokemon.ELECTRICO, Estado.Estados.NORMAL);
        Pokemon drowzee = new Drowzee("Drowzee", 60, 48, TipoPokemon.PSIQUICO, Estado.Estados.NORMAL);
        Pokemon diglett = new Diglett("Diglett", 10, 55, TipoPokemon.TIERRA, Estado.Estados.NORMAL);
        Pokemon articuno = new Articuno("Articuno ", 90, 85, TipoPokemon.HIELO.VOLADOR, Estado.Estados.NORMAL);
        Pokemon snorlax = new Snorlax("Snorlax", 160, 110, TipoPokemon.NORMAL, Estado.Estados.NORMAL);
        Pokemon hitmonlee = new Hitmonlee("Hitmonlee", 50, 120, TipoPokemon.LUCHA, Estado.Estados.NORMAL);
        Pokemon tentacool = new Tentacool("Tentacool", 40, 40, TipoPokemon.AGUA.VENENO, Estado.Estados.NORMAL);
        Entrenador entrenador = new Entrenador("", listaPokemones);
        Entrenador entrenador1 = new Entrenador("", listaPokemones);
        Entrenador entrenador2 = new Entrenador("", listaPokemones);
        LinkedList<Pokemon> listaPokemonesDisponibles = new LinkedList<>();
        listaPokemonesDisponibles.addAll(List.of(charmander, Shellder, caterpie, jolteon, drowzee, diglett, articuno, snorlax, hitmonlee, tentacool));

        System.out.println("Bienvenido al Simulador de Batallas Pokémon");
        System.out.println("Elige el numeral de la sección a la que deseas entrar");
        System.out.println("1. Gestionar Entrenadores");
        System.out.println("2. Gestionar Pokémones");
        System.out.println("3. Iniciar Batalla");
        System.out.println("4. Salir");
        String opcion = sc.next();
        do {
            switch (opcion) {
                case "1"://1. Gestionar Entrenadores
                    System.out.println("Bienvenido a Gestionar Entrenadores");
                    System.out.println("Elige el numeral de la sección a la que deseas entrar");
                    System.out.println("1. Registrar nuevo entrenador");
                    System.out.println("2. Ver lista de entrenadores");
                    System.out.println("3. Seleccionar un entrenador");
                    System.out.println("4. Volver al menú principal");
                    opcion = sc.next();
                    do {
                        switch (opcion) {
                            case "1"://1. Registrar nuevo entrenador
                                System.out.println("Por favor ingrese el nombre del entrenador que quiere agregar");
                                String nombreEntrenador = sc.next();
                                Entrenador entrenadorNuevo = new Entrenador(nombreEntrenador, listaPokemones);
                                listaEntrenadores.add(entrenadorNuevo);
                                System.out.println("Listo, tu entrenador ya fue agregado :)");
                                System.out.println("A que otra seccion del menú quieres ingresar?");
                                opcion=sc.next();
                                break;
                            case "2"://2. Ver lista de entrenadores
                                System.out.print("Los entrenadores registrados son: ");
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    System.out.println(listaEntrenadores.get(i).getNombre());
                                }
                                break;
                            case "3"://3. Seleccionar un entrenador
                                System.out.println("Elige el nombre del entrenador que deseas elegir");
                                String nombreEntrenadorElegir = sc.nextLine();
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    if (nombreEntrenadorElegir.equals(listaEntrenadores.get(i).getNombre())) {
                                        entrenador = listaEntrenadores.get(i);
                                    } else {
                                        System.out.println("Ese entenador no existe :(");
                                    }
                                }
                                System.out.println("Elige el numeral de la sección a la que deseas entrar");
                                System.out.println("1. Ver equipo de Pokémones");
                                System.out.println("2. Agregar Pokémon al equipo");
                                System.out.println("3. Entrenar Pokémon");
                                System.out.println("4. Volver a Gestionar Entrenadores");
                                opcion = sc.next();
                                do {
                                    switch (opcion) {
                                        case "1"://1. Ver equipo de Pokémones
                                            entrenador.mostrarPokemones();
                                            break;
                                        case "2"://2. Agregar Pokémon al equipo
                                            System.out.println("Los pokémones que puedes añadir a tu equipo son:");
                                            for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
                                                System.out.println(listaPokemonesDisponibles.get(i).getNombre());
                                            }
                                            System.out.println("Entonces, ¿que Pokémon quieres agregar a tu equipo?, escribe Fin "
                                                    + "cuando ya no quieras agregar mas Pokémones a tu equipo");
                                            String nombrePokemonAgregar = sc.nextLine();
                                            do {
                                                for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
                                                    if (nombrePokemonAgregar.equals(listaPokemonesDisponibles.get(i).getNombre())) {
                                                        entrenador.agregarPokemon(listaPokemonesDisponibles.get(i));
                                                    }
                                                }
                                            } while (!"Fin".equals(nombrePokemonAgregar));
                                            break;
                                        case "3"://3. Entrenar Pokémon
                                            System.out.println("Los pokémones que puedes entrenar en tu equipo son:");
                                            entrenador.mostrarPokemones();
                                            System.out.println("Entonces, ¿que Pokémon quieres mejorar en tu equipo?, escribe Fin "
                                                    + "cuando ya no quieras mejorear ninguno mas Pokémones a tu equipo");
                                            String nombrePokemonEntrenar = sc.nextLine();
                                            do {
                                                for (int i = 0; i < listaPokemones.size(); i++) {
                                                    if (nombrePokemonEntrenar.equals(listaPokemones.get(i).getNombre())) {
                                                        entrenador.entrenarPokemon(listaPokemones.get(i));
                                                    }
                                                }
                                            } while (!nombrePokemonEntrenar.equals("Fin"));
                                            break;
                                        case "4"://4. Volver a Gestionar Entrenadores
                                            break;
                                    }
                                } while (!"4.".equals(opcion));
                            case "4"://4. Volver al menú principal
                                break;
                        }
                    } while (!"4".equals(opcion));
                case "2"://"2. Gestionar Pokémones"
                    System.out.println("Bienvenido a Gestionar Pokémones");
                    System.out.println("Elige el numeral de la sección a la que deseas entrar");
                    System.out.println("1. Ver todos los Pokémones registrados");
                    System.out.println("2. Registrar nuevo Pokémon");
                    System.out.println("3. Volver al menú principal");
                    opcion = sc.next();
                    do {
                        switch (opcion) {
                            case "1"://1. Ver todos los Pokémones registrados
                                for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
                                    System.out.println(listaPokemonesDisponibles.get(i).getNombre());
                                }
                                break;
                            case "2"://2. Registrar nuevo Pokémon
                                System.out.println("¿Que Pokémon quieres registrar?");
                                for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
                                    System.out.println(i + "). " + listaPokemonesDisponibles.get(i).getNombre());
                                }
                                int numeroPokemon = sc.nextInt();
                                Pokemon nuevoPokemon = listaPokemonesDisponibles.get(numeroPokemon);
                                listaPokemonesDisponibles.add(nuevoPokemon);
                                break;
                            case "3"://3. Volver al menú principal

                                break;
                        }
                    } while (!"3".equals(opcion));
                    break;

                case "3": //Iniciar Batalla
                    do {
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
                            case "1"://1. Elegir entrenador 1
                                System.out.println("¿Que entrenador quieres elegir para la batalla?");
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    System.out.println(i + "). " + listaEntrenadores.get(i));
                                }
                                String nombreEntenadorElegirUno = sc.nextLine();
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    if (nombreEntenadorElegirUno.equals(listaEntrenadores.get(i).getNombre())) {
                                        entrenador1 = listaEntrenadores.get(i);
                                    }
                                }
                                break;
                            case "2"://2. Elegir entrenador 2
                                System.out.println("¿Que entrenador quieres elegir para la batalla?");
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    System.out.println(i + "). " + listaEntrenadores.get(i));
                                }
                                String nombreEntenadorElegirDos = sc.nextLine();
                                for (int i = 0; i < listaEntrenadores.size(); i++) {
                                    if (nombreEntenadorElegirDos.equals(listaEntrenadores.get(i).getNombre())) {
                                        entrenador2 = listaEntrenadores.get(i);
                                    }
                                }
                                break;
                            case "3"://3. Seleccionar Pokémon de entrenador 1                           
                                System.out.println("Los pokémones que tienes disponibles son: ");
                                entrenador1.mostrarPokemones();
                                System.out.println("Ahora, ¿Que pokémon quieres elegir?");
                                String palabraBusqueda = sc.next();
                                entrenador1.prepararBatalla(palabraBusqueda);
                                break;
                            case "4"://4. Seleccionar Pokémon de entrenador 2
                                System.out.println("Los pokémones que tienes disponibles son: ");
                                entrenador1.mostrarPokemones();
                                System.out.println("Ahora, ¿Que pokémon quieres elegir?");
                                palabraBusqueda = sc.next();
                                entrenador2.prepararBatalla(palabraBusqueda);
                                break;

                            case "5"://5. Comenzar batalla

                                break;
                            case "6"://6. Volver al menú principal

                                break;
                        }
                    } while (!"6".equals(opcion));

                    break;
                case "4": //4. Volver al menú principal

                    break;
            }
        } while (!"4".equals(opcion));
    }

    public void gestionarEntrenadores(){


    }
}
