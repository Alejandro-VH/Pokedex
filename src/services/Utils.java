package services;

import model.pokemon;

public class Utils {

    public Utils(){
        //vacio
    }

    /**
     * Subprograma dedicado a quitar los espacios al inicio y al final de un String
     * @param string a limpiar
     * @return String limpio
     */
    public static String limpiarString(String string){
        // Eliminar espacios al inicio
        while (string.startsWith(" ")) {
            string = string.substring(1);
        }

        // Eliminar espacios al final
        while (string.endsWith(" ")) {
            string = string.substring(0, string.length() - 1);
        }

        return string;
    }

    /**
     * Subprograma encargado de transformar un String a Integer
     * @param text a transformar
     * @return String transformado a Integer
     */
    public static Integer toInteger(String text){
        int resultado = 0;
        try {
            resultado = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return resultado;
    }

}
