import services.Sistema;
import services.SistemaImpl;
import ucn.*;

import java.io.IOException;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {

        SistemaImpl sistema = new SistemaImpl();
        String opcion = null;

        while (!Objects.equals(opcion, "6")){

            StdOut.println("----[POKEDEX]----");
            StdOut.println("[1] Desplegar pokemons por su Id");
            StdOut.println("[2] Desplegar pokemons alfabeticamente");
            StdOut.println("[3] Desplegar pokemons de cierto tipo");
            StdOut.println("[4] Desplegar pokemon de primera evolucion");
            StdOut.println("[5] Buscar Personalizada");
            StdOut.println("[6] Salir");

            opcion = StdIn.readLine();

            switch (opcion){
                case "1" -> sistema.desplegarPorID();
                case "2" -> sistema.desplegarAlfabeticamente();
                case "3" -> sistema.busquedaPokemonTipo();
                case "4" -> sistema.desplegarPokemonPrimerEvolucion();
                case "5" -> sistema.busquedaPersonalizada();
                case "6" -> StdOut.println("Apagando Pokedex!");
                default -> StdOut.println("Ha ingresado una opción invalida, pruebe nuevamente!");
            }
        }
    }

}