package Clases;

import java.io.BufferedReader;
import java.io.IOException;

public class Temas extends Archivo {
    private String nombreUsuario;
    private String archivoTem = "\\temas.txt";
    private String archivoCant = "\\cant_temas.txt";
    
    public Temas(){
        this.nombreUsuario = "";
    }

    public Temas(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public void GetNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
  
    public Boolean Crear(String nombreTema) {
        boolean ret = false,existeCarp=false,existeArch=false;
        String texto = nombreTema + "\t" + this.nombreUsuario + "\t" + Util.ObtenerFecha() + "\t" + Util.QuitaEspacios("\\" +Util.ObtenerFecha() + "-" + Util.ObtenerHora() + "-" + nombreTema + ".txt");

        try {
            if(!this.ExisteCarpeta(this.carpetaTemas)){
                existeCarp = this.CrearCarpeta(this.carpetaTemas);
            }else{
                existeCarp = true;
            }

            if(!this.ExisteArchivo(this.carpetaTemas + this.archivoTem)){
                existeArch = this.CrearArchivo(this.carpetaTemas, this.archivoTem);
            }else{
                existeArch = true;
            }

            if(existeCarp && existeArch){
                ret = this.Escribir(this.carpetaTemas + this.archivoTem, texto);
                this.CrearCantidad(String.valueOf(this.ObtenerCantidad() + 1));
            }else{
                ret = false;
            }
        } catch (Exception e) {
        }

        return ret;
    }

    public Boolean CrearCantidad(String cantidad) {
        boolean ret = false,existeCarp=false,existeArch=false;

        try {
            if(!this.ExisteCarpeta(this.carpetaTemas)){
                existeCarp = this.CrearCarpeta(this.carpetaTemas);
            }else{
                existeCarp = true;
            }

            if(!this.ExisteArchivo(this.carpetaTemas + this.archivoCant)){
                existeArch = this.CrearArchivo(this.carpetaTemas, this.archivoCant);
            }else{
                existeArch = true;
            }

            if(existeCarp && existeArch){
                ret = this.Escribir(this.carpetaTemas + this.archivoCant, cantidad);
            }else{
                ret = false;
            }
        } catch (Exception e) {
        }

        return ret;
    }

    public String[][] Ver() {
        String[][] lista = new String[this.ObtenerCantidad()][6];
        String linea="";
        int cont=0,i=0;
        BufferedReader br = null;

        try{
            br = this.Obtener(this.carpetaTemas + this.archivoTem);

            while((linea = br.readLine()) != null){
                i = 0;
                lista[cont][i] = "Seleccionar";
                i = 1;
                
                for(String ln : linea.split("\t")){
                    lista[cont][i] = ln;
                    i++;
                }
                lista[cont][i] = "0";

                cont++;
            }
        }catch(Exception e) {
        }finally{
            try {
                if(br != null){
                    br.close();
                }
            } catch(IOException e){
            }
        }

        return lista;
    }

    public int ObtenerCantidad() {
        String linea = "";
        int cant = 0;
        BufferedReader br = null;

        try{
            br = this.Obtener(this.carpetaTemas + this.archivoCant);

            while((linea = br.readLine()) != null){
                cant = Integer.parseInt(linea);
            }
        }catch(Exception e) {
        }finally{
            try {
                if(br != null){
                    br.close();
                }
            } catch(IOException e){
            }
        }

        return cant;
    }
}