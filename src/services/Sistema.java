package services;

public interface Sistema {
    /**
     * Realiza la busqueda de un pokemon en especifico usando los parametros deseados (nombre o id) y luego los despliega en la consola
     */
    void busquedaPersonalizada();

    /**
     * Realiza la busqueda de un pokemon en base el tipo de pokemon indicado y despliega en la consola cualquier pokemon que al menos coincida uno de esos 2 tipos
     */
    void busquedaPokemonTipo();

    /**
     * Despliega en pantalla a todos los pokemon que se encuentren en su primera evolucion
     */
    void desplegarPokemonPrimerEvolucion();
    /**
     * Despliega en pantalla a todos los pokemon ordenados por su id, de manera creciente
     */
    void desplegarPorID();
    /**
     * Despliega en pantalla a todos los pokemon ordenados de manera alfabetica
     */
    void desplegarAlfabeticamente();
}
