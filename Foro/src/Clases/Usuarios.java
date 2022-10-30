package Clases;

import java.io.BufferedReader;
import java.io.IOException;

public class Usuarios extends Archivo {
    public String nombreUsuario;
    public String password;
    public boolean registrado;
    private String carpeta = "\\C:\\Foro";
    private String archivo = "\\usuarios.txt";

    public Usuarios(){
        this.nombreUsuario = "";
        this.password = "";
    }

    public Usuarios(String nombreUsuario, String password){
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public void GetNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }

    public void GetPassword(String password){
        this.password = password;
    }

    public String SetNombreUsuario() {
        return this.nombreUsuario;
    }

    public String SetPassword() {
        return this.password;
    }

    public Boolean ExisteUsuario(String nombreUsuario){
        BufferedReader br = null;
        boolean ret = false;
        String linea = "", user = "";

        try{
            br = this.Obtener(this.carpeta + this.archivo);

            while(((linea = br.readLine()) != null) && !ret){
                user = linea.split("\t")[0];

                if(nombreUsuario.equals(user)){
                    ret = true;
                }
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

        return ret;
    }

    public Boolean EsUsuario(String nombreUsuario, String password) {
        BufferedReader br = null;
        boolean ret = false;
        String linea = "", user = "", pass = "";

        try{
            br = this.Obtener(this.carpeta + this.archivo);

            while((linea = br.readLine()) != null){
                if(!linea.equals("\t")){
                    user = linea.split("\t")[0];
                    pass = linea.split("\t")[1];
                }

                if(nombreUsuario.equals(user) && password.equals(pass)){
                    ret = true;
                }
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

        return ret;
    }

    public Boolean RegistraUsuario(String nombreUsuario, String password) {
        boolean ret = false,existeCarp=false,existeArch=false;
        String texto = nombreUsuario + "\t" + password + "\t" + Util.ObtenerFecha();

        try {
            if(!this.ExisteCarpeta(this.carpeta)){
                existeCarp = this.CrearCarpeta(this.carpeta);
            }else{
                existeCarp = true;
            }

            if(!this.ExisteArchivo(this.carpeta + this.archivo)){
                existeArch = this.CrearArchivo(this.carpeta, this.archivo);
            }else{
                existeArch = true;
            }

            if(existeCarp && existeArch){
                ret = this.Escribir(this.carpeta + this.archivo, texto);
            }else{
                ret = false;
            }
        } catch (Exception e) {
        }

        return ret;
    }
}