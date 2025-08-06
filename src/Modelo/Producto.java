package Modelo;

import java.util.List;


public class Producto {
  private String nombre;
  private String codigos;
  private  List<Double> precios;
  
  public Producto(String nombre, String codigos, List<Double> precios) {
    this.nombre = nombre;
    this.precios = precios;
    this.codigos = codigos;
  }
  
  public int porcentajeCaracteresUnicos() {
 
    
  }
  public int catidadPreciosRepetidos(){
      
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public List<Double> getPrecios() {
    return precios;
  }

  public void setPrecios(List<Double> precios) {
    this.precios = precios;
  }

  public String getCodigos() {
    return codigos;
  }

  public void setCodigos(String codigos) {
    this.codigos = codigos;
  }

  @Override
  public String toString() {
    return "Producto [nombre=" + nombre + ", precios=" + precios + ", codigos=" + codigos + "]";
  }
  
  
}
  
    

   
