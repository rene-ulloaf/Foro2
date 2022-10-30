package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public abstract class Archivo {
    protected String carpetaTemas = "\\C:\\Foro\\Temas";
    
    protected boolean ExisteCarpeta(String ruta){
        File archivo = null;
        boolean ret = false;

        try {
            archivo = new File(ruta);
            ret = archivo.isDirectory();
        } catch (Exception e) {
        }

        return ret;
    }

    protected boolean ExisteArchivo(String ruta){
        File archivo = null;
        boolean ret = false;

        try {
            archivo = new File(ruta);
            ret = archivo.exists();
        } catch (Exception e) {
        }

        return ret;
    }

    protected boolean CrearCarpeta(String ruta){
        File archivo = null;
        boolean carp = true;

        try{
            archivo = new File (ruta);
            carp = archivo.mkdir();
        }catch (Exception e){

        }

        return carp;
    }

    protected boolean CrearArchivo(String ruta){
        File archivo = null;
        boolean ret = true;

        try{
            archivo = new File(ruta);
            ret = archivo.createNewFile();
        }catch (Exception e){

        }

        return ret;
    }

    protected boolean CrearArchivo(String ruta, String nombreArchivo){
        File archivo = null;
        boolean ret = true;

        try{
            archivo = new File(ruta,nombreArchivo);
            ret = archivo.createNewFile();
        }catch (Exception e){
          
        }
        
        return ret;
    }

    protected boolean Escribir(String ruta, String texto){
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter salida = null;
        boolean ret = false;

        try{
            fw = new FileWriter(ruta, true);
            bw = new BufferedWriter(fw);
            salida = new PrintWriter(bw);

            salida.println(texto);
            ret = true;
        }catch (Exception e){
        }finally{
            salida.close();
        }

        return ret;
    }

    protected boolean Escribir(String ruta, String texto, Integer linea){
        RandomAccessFile archivo = null;
        boolean ret = false;

        try{
            archivo = new RandomAccessFile(ruta, "rw");
            archivo.seek(linea);
            archivo.writeChars(texto);

            ret = true;
        }catch (Exception e){
        }finally{
            if(archivo != null){
                try {
                    archivo.close();
                } catch (Exception e) {
                }
            }
        }

        return ret;
    }

    protected BufferedReader Obtener(String ruta){
        FileReader entrada = null;
        BufferedReader salida = null;

        try  {
            entrada = new FileReader(ruta);
            salida = new BufferedReader(entrada);
        }catch (IOException ex) {
            //System.out.println(ex);
        }finally{
            /*if(entrada!=null){
                try{
                    entrada.close();
                }catch(IOException ex){
                }
            }*/
            /*if(salida!=null){
                try{
                    salida.close();
                }catch(IOException ex){}
            }*/
        }

        return salida;
    }

    protected FileWriter Obtener(String ruta, Integer Desde, Integer hasta){
        RandomAccessFile archivo = null;
        FileWriter salida = null;
        int aux;

        try{
            archivo = new RandomAccessFile("nombre_fichero", "rw");
            archivo.seek(Desde);

            while((aux = archivo.read()) <= hasta){
                salida.write(aux);
            }
        }catch (Exception e){
        }finally{
            if(archivo != null){
                try{
                    archivo.close();
                }catch (Exception e){
                }
            }
        }

        return salida;
    }
}