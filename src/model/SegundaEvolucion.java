package model;

public class SegundaEvolucion extends pokemon{
    private String evolucionBasica;
    private String evolucionAnterior;

    public SegundaEvolucion(int id, String nombre, String etapa, String tipo1, String tipo2, String evolucionAnterior,String evolucionBasica) {
        super(id, nombre, etapa, tipo1, tipo2);
        this.evolucionBasica = evolucionBasica;
        this.evolucionAnterior = evolucionAnterior;
    }

    public String getEvolucionBasica() {
        return evolucionBasica;
    }

    public String getEvolucionAnterior() {
        return evolucionAnterior;
    }
}
