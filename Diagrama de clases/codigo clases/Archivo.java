package Clases;

import java.io.FileReader;
import String;
import java.io.File;
import Integer;
import Boolean;

public abstract class Archivo {

  protected File AbrirArchivo(String ruta) {
  return null;
  }

  protected Boolean CrearArchivo() {
  return null;
  }

  protected Boolean Escribir(String ruta) {
  return null;
  }

  protected Boolean Escribir(String ruta, Integer linea) {
  return null;
  }

  protected FileReader Obtener(String ruta) {
  return null;
  }

  protected FileReader Obtener(String ruta, Integer lineaDesde, Integer hasta) {
  return null;
  }

}