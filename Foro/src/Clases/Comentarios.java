package Clases;

import java.io.BufferedReader;
import java.io.IOException;

public class Comentarios extends Archivo {
    private String nombreTema="",usuario="",usuarioCreador="",fechaCreacion="",archivo="";
    private int cantComentarios=0;

    public Comentarios(String tema, String usuario,String usuarioCreador,String fecha, String archivo, int comentarios){
        this.nombreTema = tema;
        this.usuario = usuario;
        this.usuarioCreador = usuarioCreador;
        this.fechaCreacion = fecha;
        this.archivo = archivo;
        this.cantComentarios = comentarios;
    }

    public String[][] Ver(){
        String[][] lista = new String[10][4];
        String linea="";
        int cont=0,i=0;
        BufferedReader br = null;

        try{
            br = this.Obtener(this.carpetaTemas+this.archivo);

            while((linea = br.readLine()) != null){
                i = 0;

                for(String ln : linea.split("\t")){
                    lista[cont][i] = ln;
                    i++;
                }

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

    public Boolean Crear(String comentario){
        boolean ret = false,existeArch=false;
        String texto = this.usuario + "\t" + Util.ObtenerFecha() + "\t" + Util.ObtenerHora() + "\t" + comentario;

        try{

            if(!this.ExisteArchivo(this.carpetaTemas+this.archivo)){
                existeArch = this.CrearArchivo(this.carpetaTemas, this.archivo);
            }else{
                existeArch = true;
            }

            if(existeArch){
                ret = this.Escribir(this.carpetaTemas + this.archivo, texto);
            }else{
                ret = false;
            }
        }catch (Exception e){
        }

        return ret;
    }
}