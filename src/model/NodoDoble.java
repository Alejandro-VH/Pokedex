package model;

public class NodoDoble {
    private pokemon pokemon;
    private NodoDoble anterior;
    private NodoDoble siguiente;

    public NodoDoble(pokemon pokemon) {
        this.pokemon = pokemon;
        this.siguiente = null;
        this.anterior = null;
    }

    public pokemon getPokemon() {
        return pokemon;
    }

    public void setDato(pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}
