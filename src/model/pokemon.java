package model;

public class pokemon {
    private int id;
    private String nombre;
    private String etapa;
    private String tipo1;
    private String tipo2;

    public pokemon(int id, String nombre, String etapa, String tipo1, String tipo2) {
        this.id = id;
        this.nombre = nombre;
        this.etapa = etapa;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEtapa() {
        return etapa;
    }

    public String getTipo1() {
        return tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }
}
