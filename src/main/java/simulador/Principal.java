package simulador;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import simulador.batalla.Batalla;
import simulador.entrenador.Entrenador;
import simulador.persistencia.ArchivosConexion;
import simulador.pokemon.*;

public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static LinkedList<Entrenador> listaEntrenadores = new LinkedList<>();
    static LinkedList<Pokemon> listaPokemonesDisponibles = new LinkedList<>();
    private static Entrenador entrenadorSeleccionado = null;
    private static Entrenador entrenador1 = null;
    private static Entrenador entrenador2 = null;
    private static Pokemon pokemon1 = null;
    private static Pokemon pokemon2 = null;
    private static Batalla batalla = new Batalla();
    
    public static void main(String[] args) {
        agregarPokemones();
        System.out.println("Bienvenido al Simulador de Batallas Pokémon");
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    gestionarEntrenadores();
                    break;
                case 2:
                    gestionarPokemones();
                    break;
                case 3:
                    iniciarBatalla();
                    break;
                case 4:
                    salir = true;
                    break;
            }
        }
    }
    
    final String NOMBRE_ARCHIVO = "guardado_pokémon";

    /*
    *Complejidad Temporal: O(n)
    *Este método itera sobre una lista predefinida de Pokémon y los agrega uno por uno a la lista de Pokémon disponibles.
    */
    public static void agregarPokemones() {
        listaPokemonesDisponibles.addAll(List.of(
                new Charmander("Charmander", 39, 52, TipoPokemon.FUEGO, Estado.Estados.NORMAL),
                new Shellder("Shellder", 30, 65, TipoPokemon.AGUA, Estado.Estados.NORMAL),
                new Caterpie("Caterpie", 45, 30, TipoPokemon.BICHO, Estado.Estados.NORMAL),
                new Jolteon("Jolteon", 65, 65, TipoPokemon.ELECTRICO, Estado.Estados.NORMAL),
                new Drowzee("Drowzee", 60, 48, TipoPokemon.PSIQUICO, Estado.Estados.NORMAL),
                new Diglett("Diglett", 10, 55, TipoPokemon.TIERRA, Estado.Estados.NORMAL),
                new Articuno("Articuno", 90, 85, TipoPokemon.HIELO.VOLADOR, Estado.Estados.NORMAL),
                new Snorlax("Snorlax", 160, 110, TipoPokemon.NORMAL, Estado.Estados.NORMAL),
                new Hitmonlee("Hitmonlee", 50, 120, TipoPokemon.LUCHA, Estado.Estados.NORMAL),
                new Tentacool("Tentacool", 40, 40, TipoPokemon.AGUA.VENENO, Estado.Estados.NORMAL)
        ));
    }
    
    ArchivosConexion.guardar (listaPokemonesDisponibles, NOMBRE_ARCHIVO);
    listaPokemonesDisponibles = (LinkedList<Pokemon>)ArchivosConexion.leer(NOMBRE_ARCHIVO);
    

    /**
     * Complejidad Temporal: O(1)
     *Este método simplemente imprime el menú principal, lo que implica una operación constante sin importar el tamaño de los datos.
     */
    public static void mostrarMenu() {
        System.out.println("Elige el numeral de la sección a la que deseas entrar");
        System.out.println("1. Gestionar Entrenadores");
        System.out.println("2. Gestionar Pokémones");
        System.out.println("3. Iniciar Batalla");
        System.out.println("4. Salir");
    }

    /**
     * Complejidad Temporal: O(n)
     *Este método muestra un menú y realiza operaciones basadas en la selección del usuario, lo que implica una complejidad lineal en función del número de opciones.
     */
    public static void gestionarEntrenadores() {
        boolean salirGestionarEntrenadores = false;
        while (!salirGestionarEntrenadores) {
            System.out.println("Bienvenido a Gestionar Entrenadores");
            System.out.println("Elige el numeral de la sección a la que deseas entrar");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrarNuevoEntrenador();
                    break;
                case 2:
                    verListaEntrenadores();
                    break;
                case 3:
                    seleccionarEntrenador();
                    break;
                case 4:
                    salirGestionarEntrenadores = true;
                    break;
            }
        }
    }

    /**
     * Complejidad Temporal: O(1)
     * Agrega un nuevo entrenador a la lista de entrenadores, lo que implica una operación constante.
     */
    public static void registrarNuevoEntrenador() {//Registrar Entrenadore de case: 1 de gestionarEntrenadores
        System.out.println("Por favor ingrese el nombre del entrenador que quiere agregar");
        String nombreEntrenador = sc.next();
        Entrenador entrenadorNuevo = new Entrenador(nombreEntrenador, new LinkedList<>());
        listaEntrenadores.add(entrenadorNuevo);
        System.out.println("Listo, tu entrenador ya fue agregado :)");
    }

    /**
     * Complejidad Temporal: O(n)
     * Itera sobre la lista de entrenadores e imprime sus nombres, lo que implica una complejidad lineal en función del número de entrenadores.
     */
    public static void verListaEntrenadores() {
        System.out.println("Los entrenadores registrados son: ");
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            System.out.println(listaEntrenadores.get(i).getNombre());
        }
    }

    /**
     * Complejidad Temporal: O(n)
     * Busca un entrenador en la lista de entrenadores, lo que implica una complejidad lineal en función del número de entrenadores.
     */
    public static void seleccionarEntrenador() {
        System.out.println("Elige el nombre del entrenador que deseas elegir");
        // Consumir el salto de linea pendiente
        String nombreEntrenadorElegir = sc.next();
        boolean entrenadorEncontrado = false;
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            if (nombreEntrenadorElegir.equalsIgnoreCase(listaEntrenadores.get(i).getNombre())) {
                entrenadorSeleccionado = listaEntrenadores.get(i);
                entrenadorEncontrado = true;
                gestionarEntrenadorSeleccionado();
                break;
            }
        }
        if (!entrenadorEncontrado) {
            System.out.println("Ese entrenador no existe :(");
        }
    }
    
    /**
     * Complejidad Temporal: O(n)
     * Este método muestra un menú y realiza operaciones basadas en la selección del usuario, lo que implica una complejidad lineal en función del número de opciones.
     */
    public static void gestionarEntrenadorSeleccionado() {
        boolean volverGestionarEntrenadores = false;
        while (!volverGestionarEntrenadores) {
            System.out.println("Elige el numeral de la sección a la que deseas entrar");
            System.out.println("1. Ver equipo de Pokémones");
            System.out.println("2. Agregar Pokémon al equipo");
            System.out.println("3. Entrenar Pokémon");
            System.out.println("4. Volver a Gestionar Entrenadores");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    entrenadorSeleccionado.mostrarPokemones();
                    break;
                case 2:
                    agregarPokemonAlEquipo();
                    break;
                case 3:
                    entrenarPokemon();
                    break;
                case 4:
                    volverGestionarEntrenadores = true;
                    break;
            }
        }
    }

    /**
     * Complejidad Temporal: O(n^2)
     * Itera sobre la lista de Pokémon disponibles y luego, dentro de un bucle while, busca el Pokémon seleccionado por 
     * el usuario en la lista de Pokémon disponibles. La complejidad resultante es cuadrática.
     */
    public static void agregarPokemonAlEquipo() {
        System.out.println("Los pokémones que puedes añadir a tu equipo son:");
        for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
            System.out.println(listaPokemonesDisponibles.get(i).getNombre());
        }
        System.out.println("Entonces, ¿qué Pokémon quieres agregar a tu equipo?");
        System.out.println("Escribe el nombre del que deseas elegir o escribe ");
        System.out.println("Fin cuando ya no quieras agregar más Pokémones a tu equipo");
        // Consumir el salto de línea pendiente
        String nombrePokemonAgregar = sc.next();
        while (!"Fin".equalsIgnoreCase(nombrePokemonAgregar)) {
            boolean pokemonEncontrado = false;
            for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
                if (nombrePokemonAgregar.equalsIgnoreCase(listaPokemonesDisponibles.get(i).getNombre())) {
                    entrenadorSeleccionado.agregarPokemon(listaPokemonesDisponibles.get(i));
                    pokemonEncontrado = true;
                    break;
                }
            }
            if (!pokemonEncontrado) {
                System.out.println("Ese Pokémon no está disponible.");
            }
            System.out.println("Escribe otro Pokémon o Fin para terminar:");
            nombrePokemonAgregar = sc.next();
        }
    }

    /**
     * Complejidad Temporal: O(n)
     * Busca un Pokémon en la lista de Pokémon del entrenador seleccionado, 
     * lo que implica una complejidad lineal en función del número de Pokémon en el equipo.
     */
    public static void entrenarPokemon() {
        if (entrenadorSeleccionado.getListaPokemones().isEmpty() == true) {
            System.out.println("No tienes ningún Pokémon disponible para entrenar :(");
        } else {
            System.out.println("Los pokémones que puedes entrenar en tu equipo son:");
            entrenadorSeleccionado.mostrarPokemones();
            System.out.println("Entonces, ¿qué Pokémon quieres mejorar en tu equipo?");
            String nombrePokemonEntrenar = sc.next();
            boolean pokemonEntrenarEncontrado = false;
            for (int i = 0; i < entrenadorSeleccionado.getListaPokemones().size(); i++) {
                if (nombrePokemonEntrenar.equalsIgnoreCase(entrenadorSeleccionado.getListaPokemones().get(i).getNombre())) {
                    entrenadorSeleccionado.entrenarPokemon(entrenadorSeleccionado.getListaPokemones().get(i));
                    pokemonEntrenarEncontrado = true;
                    break;
                } else {
                    if (!pokemonEntrenarEncontrado) {
                        System.out.println("Ese Pokémon no está en tu equipo.");
                    }
                }
            }
        }
    }

    /**
     * Complejidad Temporal: O(n)
     * Este método muestra un menú y realiza operaciones basadas en la selección del usuario, 
     * lo que implica una complejidad lineal en función del número de opciones.
     */
    public static void gestionarPokemones() {
        boolean salirGestionarPokemones = false;
        while (!salirGestionarPokemones) {
            System.out.println("Bienvenido a Gestionar Pokémones");
            System.out.println("Elige el numeral de la sección a la que deseas entrar");
            System.out.println("1. Ver todos los Pokémones registrados");
            System.out.println("2. Registrar nuevo Pokémon");
            System.out.println("3. Volver al menú principal");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    verTodosLosPokemonesRegistrados();
                    break;
                case 2:
                    registrarNuevoPokemon();
                    break;
                case 3:
                    salirGestionarPokemones = true;
                    break;
            }
        }
    }

    /**
     * Complejidad Temporal: O(n)
     * Itera sobre la lista de Pokémon disponibles e imprime sus nombres, 
     * lo que implica una complejidad lineal en función del número de Pokémon
     */
    
    public static void verTodosLosPokemonesRegistrados() {
        for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
            System.out.println(listaPokemonesDisponibles.get(i).getNombre());
        }
    }

    /**
     * Complejidad Temporal: O(1)
     * Agrega un nuevo Pokémon a la lista de Pokémon disponibles, lo que implica una operación constante.
     */
    public static void registrarNuevoPokemon() {
        System.out.println("¿Qué Pokémon quieres registrar?,"
                + " Si te decides por alguno, escribe su numeral pls :)");
        for (int i = 0; i < listaPokemonesDisponibles.size(); i++) {
            System.out.println(i + "). " + listaPokemonesDisponibles.get(i).getNombre());
        }
        int numeroPokemon = sc.nextInt();
        
        Pokemon nuevoPokemon = listaPokemonesDisponibles.get(numeroPokemon);
        listaPokemonesDisponibles.add(nuevoPokemon);
    }

/**
 * Complejidad Temporal: O(n)
 * Este método muestra un menú y realiza operaciones basadas en la selección del usuario, 
 * lo que implica una complejidad lineal en función del número de opciones.
 */
public static void iniciarBatalla() {
    while (true) {
        System.out.println("Bienvenido a Iniciar Batalla");
        System.out.println("Elige el numeral de la sección a la que deseas entrar");
        System.out.println("1. Elegir entrenador 1");
        System.out.println("2. Elegir entrenador 2");
        System.out.println("3. Seleccionar Pokémon de entrenador 1");
        System.out.println("4. Seleccionar Pokémon de entrenador 2");
        System.out.println("5. Comenzar batalla");
        System.out.println("6. Volver al menú principal");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                elegirEntrenador1();
                break;
            case 2:
                elegirEntrenador2();
                break;
            case 3:
                seleccionarPokemonEntrenador1();
                break;
            case 4:
                seleccionarPokemonEntrenador2();
                break;
            case 5:
                comenzarBatalla();
                break; // Salir del método una vez que la batalla haya comenzado
            case 6:
                break; // Salir del método si se elige volver al menú principal
        }
    }
}

    /**
     * Complejidad Temporal: O(n)
     * Busca un entrenador en la lista de entrenadores, 
     * lo que implica una complejidad lineal en función del número de entrenadores.
     */
    public static void elegirEntrenador1() {
        System.out.println("¿Qué entrenador quieres elegir para la batalla?");
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            System.out.println((i + 1) + "). " + listaEntrenadores.get(i).getNombre());
        }
        System.out.println("Escribe el nombre del que quieras elegir pls :)");
        String nombreEntrenadorElegirUno = sc.next();
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            if (nombreEntrenadorElegirUno.equals(listaEntrenadores.get(i).getNombre())) {
                entrenador1 = listaEntrenadores.get(i);
            }
        }
        System.out.println(entrenador1.getNombre());
    }

    /**
     * Complejidad Temporal: O(n)
     * Busca un entrenador en la lista de entrenadores, 
     * lo que implica una complejidad lineal en función del número de entrenadores.
     */
    public static void elegirEntrenador2() {
        System.out.println("¿Qué entrenador quieres elegir para la batalla?");
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            System.out.println((i + 1) + "). " + listaEntrenadores.get(i).getNombre());
        }
        System.out.println("Escribe el nombre del que quieras elegir pls :)");
        String nombreEntrenadorElegirDos = sc.next();
        for (int i = 0; i < listaEntrenadores.size(); i++) {
            if (nombreEntrenadorElegirDos.equals(listaEntrenadores.get(i).getNombre())) {
                entrenador2 = listaEntrenadores.get(i);
            }
        }
        System.out.println(entrenador2.getNombre());
    }

    /**
     * Complejidad Temporal: O(n)
     * Busca un Pokémon en la lista de Pokémon del entrenador seleccionado, 
     * lo que implica una complejidad lineal en función del número de Pokémon en el equipo.
     */
    public static void seleccionarPokemonEntrenador1() {
        if (entrenador1 != null) {
            System.out.println("Los pokémones que tienes disponibles son: ");
            entrenador1.mostrarPokemones();
            System.out.println("Ahora, ¿qué Pokémon quieres elegir?");
            String palabraBusqueda = sc.next();
            pokemon1 = entrenador1.prepararBatalla(palabraBusqueda);
            if (pokemon1 == null) {
                System.out.println("No se encontró ese Pokémon en tu equipo :( .");
            }
        } else {
            System.out.println("Primero debes seleccionar al Entrenador 1.");
        }
        System.out.println(pokemon1.getNombre());
    }
    
    /**
     * Complejidad Temporal: O(n)
     * Busca un Pokémon en la lista de Pokémon del entrenador seleccionado, 
     * lo que implica una complejidad lineal en función del número de Pokémon en el equipo.
     */
    public static void seleccionarPokemonEntrenador2() {
        if (entrenador2 != null) {
            System.out.println("Los pokémones que tienes disponibles son: ");
            entrenador2.mostrarPokemones();
            System.out.println("Ahora, ¿qué Pokémon quieres elegir?");
            String palabraBusqueda = sc.next();
            pokemon2 = entrenador2.prepararBatalla(palabraBusqueda);
            if (pokemon2 == null) {
                System.out.println("No se encontró ese Pokémon en tu equipo :( .");
            }
        } else {
            System.out.println("Primero debes seleccionar al Entrenador 2.");
        }
        System.out.println(pokemon2.getNombre());
    }

        /**
         * Complejidad Temporal: O(1)
         * Verifica si los entrenadores y los Pokémon seleccionados están disponibles, 
         * lo que implica una operación constante.
         */
    public static void comenzarBatalla() {
        if (entrenador1 == null || entrenador2 == null) {
            System.out.println("Debes seleccionar ambos entrenadores antes de comenzar la batalla.");
        } else if (pokemon1 == null || pokemon2 == null) {
            System.out.println("Debes seleccionar ambos Pokémon antes de comenzar la batalla.");
        } else {
            batalla.iniciarBatalla(pokemon1, pokemon2, entrenador1, entrenador2);
        }
    }
}
