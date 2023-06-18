package model;

public class PrimerEvolucion extends pokemon{
    private String evolucionAnterior;
    private String evolucionSiguiente;

    public PrimerEvolucion(int id, String nombre, String etapa, String tipo1, String tipo2,String evolucionSiguiente , String evolucionAnterior) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.evolucionAnterior = evolucionAnterior;
        this.evolucionSiguiente = evolucionSiguiente;
    }

    public String getEvolucionAnterior() {
        return evolucionAnterior;
    }

    public String getEvolucionSiguiente() {
        return evolucionSiguiente;
    }
}
