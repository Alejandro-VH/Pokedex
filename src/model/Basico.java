package model;

public class Basico extends pokemon{
    private String primerEvolucion;
    private String segundaEvolucion;
    private String tercerEvolucion;

    public Basico(int id, String nombre, String etapa, String tipo1, String tipo2, String primerEvolucion, String segundaEvolucion, String tercerEvolucion) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.primerEvolucion = primerEvolucion;
        this.segundaEvolucion = segundaEvolucion;
        this.tercerEvolucion = tercerEvolucion;
    }

    public String getPrimerEvolucion() {
        return primerEvolucion;
    }

    public String getSegundaEvolucion() {
        return segundaEvolucion;
    }

    public String getTercerEvolucion() {
        return tercerEvolucion;
    }
}
