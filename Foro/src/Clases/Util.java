package Clases;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class Util {
    public static String ObtenerFecha(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        
        return dateFormat.format(date);
    }

    public static String ObtenerHora(){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        return dateFormat.format(date);
    }

    public static String QuitaEspacios(String texto){
        String textoNuevo="";
        int aux = texto.length();

        for(int i=0;i<aux;i++){
            textoNuevo += texto.substring(i, i+1).equals(" ") ? "_" : texto.substring(i, i+1);
        }

        return textoNuevo;
    }
}