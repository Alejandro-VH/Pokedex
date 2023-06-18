package model;

import ucn.StdOut;

public class listaPokemon {
    private NodoDoble first;
    private NodoDoble last;

    public listaPokemon(){
        this.first = null;
        this.last = null;
    }

    /**
     * Se agrega un objeto (pokemon) al final de la lista
     * @param pokemon
     */
    public void insertarAlFinallast(pokemon pokemon){
        NodoDoble nuevoNodo = new NodoDoble(pokemon);
        if(this.last==null){
            this.first = nuevoNodo;
            this.last = nuevoNodo;
        }
        this.last.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(this.last);
        this.last = nuevoNodo;
    }

    /**
     * Subprograma usado para buscar un pokemon en base a un nombre ingresado
     * @param nombre a buscar
     * @return pokemon en caso de que exista
     */
    public pokemon buscarNombre(String nombre){
        for (NodoDoble aux = this.first; aux.getSiguiente() != null; aux = aux.getSiguiente()) {
            if (nombre.equalsIgnoreCase(aux.getPokemon().getNombre())){
                StdOut.println("--[" + aux.getPokemon().getNombre() +"]--");
                StdOut.println("Id: " + aux.getPokemon().getId());
                StdOut.println("Nombre: " + aux.getPokemon().getNombre());
                StdOut.println("Etapa: " + aux.getPokemon().getEtapa());
                if (aux.getPokemon() instanceof Basico){
                    StdOut.println("1era evolucion: " + ((Basico) aux.getPokemon()).getPrimerEvolucion());
                    StdOut.println("2da evolucion: " + ((Basico) aux.getPokemon()).getSegundaEvolucion());
                    if (((Basico) aux.getPokemon()).getTercerEvolucion() != null){
                        StdOut.println("3er evolucion: " + ((Basico) aux.getPokemon()).getTercerEvolucion());
                    }
                } else if (aux.getPokemon() instanceof PrimerEvolucion) {
                    StdOut.println("Anterior evolucion: " + ((PrimerEvolucion) aux.getPokemon()).getEvolucionAnterior());
                    StdOut.println("Siguiente evolucion: " + ((PrimerEvolucion) aux.getPokemon()).getEvolucionSiguiente());
                } else if (aux.getPokemon() instanceof SegundaEvolucion) {
                    StdOut.println("Evolucion anterior: " + ((SegundaEvolucion) aux.getPokemon()).getEvolucionAnterior());
                    StdOut.println("Evolucion base: " + ((SegundaEvolucion) aux.getPokemon()).getEvolucionBasica());
                }
                StdOut.println("Tipo 1: " + aux.getPokemon().getTipo1());
                if (aux.getPokemon().getTipo2() != null){
                    StdOut.println("Tipo 2: " + aux.getPokemon().getTipo2());
                }
                return aux.getPokemon();
            }
        }
        StdOut.println("No se ha encontrado un pokemon con la nombre: " + nombre);
        return null;
    }

    /**
     * Subprograma usado para buscar un pokemon en base a un ID (Entero) ingresado
     * @param id a buscar
     * @return pokemon en caso de que exista
     */
    public pokemon buscarId(int id){
        for (NodoDoble aux = this.first; aux.getSiguiente() != null; aux = aux.getSiguiente()) {
            if (id == aux.getPokemon().getId()){
                StdOut.println("--[" + aux.getPokemon().getNombre() +"]--");
                StdOut.println("Id: " + aux.getPokemon().getId());
                StdOut.println("Nombre: " + aux.getPokemon().getNombre());
                StdOut.println("Etapa: " + aux.getPokemon().getEtapa());
                if (aux.getPokemon() instanceof Basico){
                    StdOut.println("1era evolucion: " + ((Basico) aux.getPokemon()).getPrimerEvolucion());
                    StdOut.println("2da evolucion: " + ((Basico) aux.getPokemon()).getSegundaEvolucion());
                    if (((Basico) aux.getPokemon()).getTercerEvolucion() != null){
                        StdOut.println("3er evolucion:" + ((Basico) aux.getPokemon()).getTercerEvolucion());
                    }
                } else if (aux.getPokemon() instanceof PrimerEvolucion) {
                    StdOut.println("Anterior evolucion: " + ((PrimerEvolucion) aux.getPokemon()).getEvolucionAnterior());
                    StdOut.println("Siguiente evolucion: " + ((PrimerEvolucion) aux.getPokemon()).getEvolucionSiguiente());
                } else if (aux.getPokemon() instanceof SegundaEvolucion) {
                    StdOut.println("Evolucion anterior: " + ((SegundaEvolucion) aux.getPokemon()).getEvolucionAnterior());
                    StdOut.println("Evolucion base: " + ((SegundaEvolucion) aux.getPokemon()).getEvolucionBasica());
                }
                StdOut.println("Tipo 1: " + aux.getPokemon().getTipo1());
                if (aux.getPokemon().getTipo2() != null){
                    StdOut.println("Tipo 2: " + aux.getPokemon().getTipo2());
                }
                return aux.getPokemon();
            }
        }
        StdOut.println("No se ha encontrado un pokemon con la id: " + id);
        return null;
    }
}
