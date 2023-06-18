package services;

import model.*;
import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;
import java.util.*;


public class SistemaImpl implements Sistema {
    //Lista Array usada para guardar datos con el orden del archivo
    ArrayList<pokemon> listaArray = new ArrayList<pokemon>();
    //Lisa linked usada para guardar los pokemon de manera  alfabetica
    LinkedList<pokemon> listaLinked = new LinkedList<pokemon>();

    private final listaPokemon lista = new listaPokemon();
    public SistemaImpl() throws IOException {
        this.cargarDatos();
    }

    /**
     * Subprograma usado para cargar el archivo "kanto.txt" y cargarlo en el sistema
     * @throws IOException
     */
    public void cargarDatos() throws IOException {
        ArchivoEntrada archivoEntrada = new ArchivoEntrada("kanto.txt");
        int pos = 0;
        // reviso la cantidad de instrumentos que hay en la lista
        while (!archivoEntrada.isEndFile()){
            archivoEntrada.getRegistro();
            pos++;
        }
        archivoEntrada.close();

        archivoEntrada = new ArchivoEntrada("kanto.txt");
        //variables usadas para leer los datos
        int idInt;
        String id,etapa,evolucion1,evolucion2,evolucion3,tipo1,tipo2;
        for (int i = 0; i < pos; i++) {
            Registro registro = archivoEntrada.getRegistro();

            id = registro.getString();

            //Se revisa si la linea esta vacia o es nula
            if (id == null || id.equals("")){
                continue;
            }
            //Se limpia el id y se vuelve un Integer
            id = Utils.limpiarString(id);
            idInt = Utils.toInteger(id);

            String nombre = registro.getString();
            nombre = Utils.limpiarString(nombre);

            etapa = registro.getString();
            etapa = Utils.limpiarString(etapa);

            evolucion1 = registro.getString();
            evolucion1 = Utils.limpiarString(evolucion1);

            evolucion2 = registro.getString();
            evolucion2 = Utils.limpiarString(evolucion2);

            if (nombre.equalsIgnoreCase("eevee")){
                evolucion3 = registro.getString();
                evolucion3 = Utils.limpiarString(evolucion3);

                tipo1 = registro.getString();
                tipo1 = Utils.limpiarString(tipo1);

                tipo2 = registro.getString();
                tipo2 = Utils.limpiarString(tipo2);
                // Se crea un nuevo pokemon y se agregar al ArrayList y la lista de nexo Doble
                Basico pokemon = new Basico(idInt,nombre,etapa,tipo1,tipo2,evolucion1,evolucion2,evolucion3);
                listaArray.add(pokemon);
                lista.insertarAlFinallast(pokemon);
            }else if (etapa.equalsIgnoreCase("basico")){
                tipo1 = registro.getString();
                tipo2 = registro.getString();
                // CASO: El pokemon no tiene evoluciones y se desfasan las variables
                if (tipo1 == null){
                    // Se crea un nuevo pokemon y se agregar al ArrayList y la lista de nexo Doble
                    Basico pokemon = new Basico(idInt,nombre,etapa,tipo1,tipo2,null,null,null);
                    listaArray.add(pokemon);
                    lista.insertarAlFinallast(pokemon);
                    continue;
                }
                tipo1 = Utils.limpiarString(tipo1);
                // CASO: El pokemon tiene 1 evolucion
                if (tipo2 == null){
                    // Se crea un nuevo pokemon y se agregar al ArrayList y la lista de nexo Doble
                    Basico pokemon = new Basico(idInt,nombre,etapa,tipo1,tipo2,evolucion1,null,null);
                    listaArray.add(pokemon);
                    lista.insertarAlFinallast(pokemon);
                    continue;
                }

                // CASO: El pokemon tiene 2 evoluciones
                tipo2 = Utils.limpiarString(tipo2);
                // Se crea un nuevo pokemon y se agregar al ArrayList y la lista de nexo Doble
                Basico pokemon = new Basico(idInt,nombre,etapa,tipo1,tipo2,evolucion1,evolucion2,null);
                listaArray.add(pokemon);
                lista.insertarAlFinallast(pokemon);
            }else if (etapa.equalsIgnoreCase("Primera Evolucion")){
                tipo1 = registro.getString();
                tipo1 = Utils.limpiarString(tipo1);

                tipo2 = registro.getString();
                // CASO: El pokemon no tiene siguiente evolucion
                if (tipo2 == null){
                    // Se crea un nuevo pokemon y se agregar al ArrayList y la lista de nexo Doble
                    PrimerEvolucion pokemon = new PrimerEvolucion(idInt,nombre,etapa,tipo1,tipo2,evolucion1,evolucion2);
                    listaArray.add(pokemon);
                    lista.insertarAlFinallast(pokemon);
                    continue;
                }
                tipo2 = Utils.limpiarString(tipo2);
                // Se crea un nuevo pokemon y se agregar al ArrayList y la lista de nexo Doble
                PrimerEvolucion pokemon = new PrimerEvolucion(idInt,nombre,etapa,tipo1,tipo2,evolucion1,evolucion2);
                listaArray.add(pokemon);
                lista.insertarAlFinallast(pokemon);
            }else if (etapa.equalsIgnoreCase("Segunda Evolucion")){
                tipo1 = registro.getString();
                tipo1 = Utils.limpiarString(tipo1);

                tipo2 = registro.getString();
                tipo2 = Utils.limpiarString(tipo2);

                // Se crea un nuevo pokemon y se agregar al ArrayList y la lista de nexo Doble
                SegundaEvolucion pokemon = new SegundaEvolucion(idInt,nombre,etapa,tipo1,tipo2,evolucion1,evolucion2);
                listaArray.add(pokemon);
                lista.insertarAlFinallast(pokemon);
            }
        }
        archivoEntrada.close();

    }

    /**
     * Subprograma encargado de ordenar un arraylist de manera alfabetica, almacenandolo en una linkedList
     * @param lista a ordenar
     * @return LinkedList ordenada
     */
    public static LinkedList<pokemon> ordenarLista(ArrayList<pokemon> lista){
        Collections.sort(lista, new Comparator<pokemon>() {
            public int compare(pokemon p1, pokemon p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });

        LinkedList<pokemon> listaLinked = new LinkedList<>();
        listaLinked.clear();
        Iterator<pokemon> iterator = lista.iterator();
        while (iterator.hasNext()) {
            pokemon pokemon = iterator.next();
            listaLinked.add(pokemon);
        }
        return listaLinked;
    }

    /**
     * Subprograma encargado de ordenar los id que se encuentran en un ArrayList de manera creciente, almacenandolo en una linkedList
     * @param lista a ordenar
     * @return LinkedList ordenada
     */
    public static LinkedList<pokemon> ordenarListaIdCreciente(ArrayList<pokemon> lista) {
        Collections.sort(lista, new Comparator<pokemon>() {
            public int compare(pokemon p1, pokemon p2) {
                return Integer.compare(p1.getId(), p2.getId());
            }
        });

        LinkedList<pokemon> listaLinked = new LinkedList<>();
        Iterator<pokemon> iterator = lista.iterator();
        listaLinked.clear();
        while (iterator.hasNext()) {
            pokemon pokemon = iterator.next();
            listaLinked.add(pokemon);
        }
        return listaLinked;
    }

    /**
     * Subprograma encargado de ordenar los id que se encuentran en un ArrayList de manera decreciente, almacenandolo en una linkedList
     * @param lista a ordenar
     * @return LinkedList ordenada
     */
    public static LinkedList<pokemon> ordenarListaIdDecreciente(ArrayList<pokemon> lista) {
        Collections.sort(lista, new Comparator<pokemon>() {
            public int compare(pokemon p1, pokemon p2) {
                    return Integer.compare(p2.getId(), p1.getId());
            }
        });

        LinkedList<pokemon> listaLinked = new LinkedList<>();
        Iterator<pokemon> iterator = lista.iterator();
        listaLinked.clear();
        while (iterator.hasNext()) {
            pokemon pokemon = iterator.next();
            listaLinked.add(pokemon);
        }
        return listaLinked;
    }

    /**
     * Se ordena la ArrayList alfabeticamente y se almacena en una LinkedList para luego desplegarlos en pantalla
     */
    @Override
    public void desplegarAlfabeticamente(){
        listaLinked = ordenarLista(listaArray);
        //Se busca el pokemon en la lista
        for (pokemon aux : listaLinked) {
            StdOut.println("[" + aux.getId() + "] " + aux.getNombre());
        }
    }

    /**
     * Se ordena la ArrayList en base a las IDS de los pokemon de manera creciente y se almacena en una LinkedList para luego desplegarlos en pantalla
     */
    @Override
    public void desplegarPorID(){
        listaLinked = ordenarListaIdCreciente(listaArray);
        //Se busca el pokemon en la lista
        for (pokemon aux : listaLinked) {
            StdOut.println("[" + aux.getId() + "] " + aux.getNombre());
        }
    }

    /**
     * Se ordena la ArrayList en base a las IDS de los pokemon de manera decreciente y se almacena en una LinkedList para luego desplegarlos en pantalla
     */
    @Override
    public void desplegarPokemonPrimerEvolucion(){
        listaLinked = ordenarListaIdDecreciente(listaArray);
        //Se busca el pokemon en la lista
        for (pokemon aux : listaArray) {
            if (aux.getEtapa().equalsIgnoreCase("Primera Evolucion")){
                StdOut.println("[" + aux.getId() + "] " + aux.getNombre());
            }
        }
    }

    /**
     * Menu encargado de realizar la busqueda de un pokemon ingresando su nombre o su id, hasta que se quiera dejar de buscar
     */
    @Override
    public void busquedaPersonalizada(){
        boolean salir = false;
        String opcionBusqueda = null;
        while (!salir){
            StdOut.println("----[Busqueda personalizada]----");
            StdOut.println("[1] Buscar por nombre");
            StdOut.println("[2] Buscar por id");
            StdOut.println("[3] Dejar de buscar");
            opcionBusqueda = StdIn.readString();
            String busqueda = null;
            pokemon p = null;
            boolean continuar = false;
            switch (opcionBusqueda){
                case "1":
                    StdOut.println("Ingrese el nombre del pokemón a buscar:");
                    busqueda = StdIn.readString();
                    p = lista.buscarNombre(busqueda);
                    // Se verifica la etapa de pokemon y se revisa si tiene evoluciones
                    if (p instanceof Basico){
                        if (((Basico) p).getPrimerEvolucion() != null || ((Basico) p).getSegundaEvolucion() != null || ((Basico) p).getTercerEvolucion() != null){
                            while (!continuar){
                                StdOut.println("¿Desea obtener detalles sobre una evolución?");
                                StdOut.println("[1] Primer Evolucion");
                                StdOut.println("[2] Segunda Evolucion");
                                StdOut.println("[3] Tercer Evolucion");
                                StdOut.println("[4] Salir");
                                String input = StdIn.readString();
                                switch (input){
                                    case "1":
                                        if (((Basico) p).getPrimerEvolucion() == null){
                                            StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                            return;
                                        }
                                        lista.buscarNombre(((Basico) p).getPrimerEvolucion());
                                        break;
                                    case "2":
                                        if (((Basico) p).getSegundaEvolucion() == null){
                                            StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                            return;
                                        }
                                        lista.buscarNombre(((Basico) p).getSegundaEvolucion());
                                        break;
                                    case "3":
                                        if (((Basico) p).getTercerEvolucion() == null){
                                            StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                            return;
                                        }
                                        lista.buscarNombre(((Basico) p).getTercerEvolucion());
                                        break;
                                    case "4":
                                        continuar = true;
                                        break;
                                    default:
                                        StdOut.println("Ingreso una opción invalida!");
                                }
                            }
                        }
                    } else if (p instanceof PrimerEvolucion) {
                        while (!continuar){
                            StdOut.println("¿Desea obtener detalles sobre una evolución?");
                            StdOut.println("[1] Anterior Evolucion");
                            StdOut.println("[2] Siguiente Evolucion");
                            StdOut.println("[3] Salir");
                            String input = StdIn.readString();
                            switch (input){
                                case "1":
                                    if (((PrimerEvolucion) p).getEvolucionAnterior() == null){
                                        StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                        return;
                                    }
                                    lista.buscarNombre(((PrimerEvolucion) p).getEvolucionAnterior());
                                    break;
                                case "2":
                                    if (((PrimerEvolucion) p).getEvolucionSiguiente() == null){
                                        StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                        return;
                                    }
                                    lista.buscarNombre(((PrimerEvolucion) p).getEvolucionSiguiente());
                                    break;
                                case "3":
                                    continuar = true;
                                    break;
                                default:
                                    StdOut.println("Ingreso una opción invalida!");
                            }
                        }
                    } else if (p instanceof SegundaEvolucion) {
                        while (!continuar){
                            StdOut.println("¿Desea obtener detalles sobre una evolución?");
                            StdOut.println("[1] Etapa Base");
                            StdOut.println("[2] Primer Evolucion");
                            StdOut.println("[3] Salir");
                            String input = StdIn.readString();
                            switch (input){
                                case "1":
                                    if (((SegundaEvolucion) p).getEvolucionBasica() == null){
                                        StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                        return;
                                    }
                                    lista.buscarNombre(((SegundaEvolucion) p).getEvolucionBasica());
                                    break;
                                case "2":
                                    if (((SegundaEvolucion) p).getEvolucionAnterior() == null){
                                        StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                        return;
                                    }
                                    lista.buscarNombre(((SegundaEvolucion) p).getEvolucionAnterior());
                                    break;
                                case "3":
                                    continuar = true;
                                    break;
                                default:
                                    StdOut.println("Ingreso una opción invalida!");
                            }
                        }
                    }
                    break;
                case "2":
                    StdOut.println("Ingrese el id del pokemón a buscar:");
                    busqueda = StdIn.readString();
                    int busquedaFinal = Utils.toInteger(busqueda);
                    p = lista.buscarId(busquedaFinal);
                    // Se verifica la etapa de pokemon y se revisa si tiene evoluciones
                    if (p instanceof Basico){
                        if (((Basico) p).getPrimerEvolucion() != null || ((Basico) p).getSegundaEvolucion() != null || ((Basico) p).getTercerEvolucion() != null){
                            while (!continuar){
                                StdOut.println("¿Desea obtener detalles sobre una evolución?");
                                StdOut.println("[1] Primer Evolucion");
                                StdOut.println("[2] Segunda Evolucion");
                                StdOut.println("[3] Tercer Evolucion");
                                StdOut.println("[4] Salir");
                                String input = StdIn.readString();
                                switch (input){
                                    case "1":
                                        if (((Basico) p).getPrimerEvolucion() == null){
                                            StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                            return;
                                        }
                                        lista.buscarNombre(((Basico) p).getPrimerEvolucion());
                                        break;
                                    case "2":
                                        if (((Basico) p).getSegundaEvolucion() == null){
                                            StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                            return;
                                        }
                                        lista.buscarNombre(((Basico) p).getSegundaEvolucion());
                                        break;
                                    case "3":
                                        if (((Basico) p).getTercerEvolucion() == null){
                                            StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                            return;
                                        }
                                        lista.buscarNombre(((Basico) p).getTercerEvolucion());
                                        break;
                                    case "4":
                                        continuar = true;
                                        break;
                                    default:
                                        StdOut.println("Ingreso una opción invalida!");
                                }
                            }
                        }
                    } else if (p instanceof PrimerEvolucion) {
                        while (!continuar){
                            StdOut.println("¿Desea obtener detalles sobre una evolución?");
                            StdOut.println("[1] Anterior Evolucion");
                            StdOut.println("[2] Siguiente Evolucion");
                            StdOut.println("[3] Salir");
                            String input = StdIn.readString();
                            switch (input){
                                case "1":
                                    if (((PrimerEvolucion) p).getEvolucionAnterior() == null){
                                        StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                        return;
                                    }
                                    lista.buscarNombre(((PrimerEvolucion) p).getEvolucionAnterior());
                                    break;
                                case "2":
                                    if (((PrimerEvolucion) p).getEvolucionSiguiente() == null){
                                        StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                        return;
                                    }
                                    lista.buscarNombre(((PrimerEvolucion) p).getEvolucionSiguiente());
                                    break;
                                case "3":
                                    continuar = true;
                                    break;
                                default:
                                    StdOut.println("Ingreso una opción invalida!");
                            }
                        }
                    } else if (p instanceof SegundaEvolucion) {
                        while (!continuar){
                            StdOut.println("¿Desea obtener detalles sobre una evolución?");
                            StdOut.println("[1] Etapa Base");
                            StdOut.println("[2] Primer Evolucion");
                            StdOut.println("[3] Salir");
                            String input = StdIn.readString();
                            switch (input){
                                case "1":
                                    if (((SegundaEvolucion) p).getEvolucionBasica() == null){
                                        StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                        return;
                                    }
                                    lista.buscarNombre(((SegundaEvolucion) p).getEvolucionBasica());
                                    break;
                                case "2":
                                    if (((SegundaEvolucion) p).getEvolucionAnterior() == null){
                                        StdOut.println("El pokemon indicado no cuenta con la evolucion indicada!");
                                        return;
                                    }
                                    lista.buscarNombre(((SegundaEvolucion) p).getEvolucionAnterior());
                                    break;
                                case "3":
                                    continuar = true;
                                    break;
                                default:
                                    StdOut.println("Ingreso una opción invalida!");
                            }
                        }
                    }
                    break;
                case "3":
                    salir = true;
                    break;
                default:
                    StdOut.println("Ingreso una opción invalida!");
            }
        }
    }

    /**
     * Menú usado para buscar un tipo de pokemon en especifico, en caso de que uno de los 2 tipos de un pokemón coincida, este pokemón se desplegara en pantalla
     */
    @Override
    public void busquedaPokemonTipo(){
        StdOut.println("----[Busqueda por tipo de pokemon]----");
        StdOut.println("Ingrese el tipo de pokemon que desea buscar:");
        String opcionBusqueda = StdIn.readString();
        //Se busca el pokemon en la lista
        for (pokemon aux : listaArray) {
            if (aux.getTipo1().equalsIgnoreCase(opcionBusqueda) || aux.getTipo2() != null && aux.getTipo2().equalsIgnoreCase(opcionBusqueda)){
                StdOut.println("[" + aux.getId() + "] " + aux.getNombre() + " - " + aux.getTipo1());

                if (aux.getTipo2() != null){
                    StdOut.print(" & " + aux.getTipo2());
                }

            }
        }

    }

}
