package Controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import Modelo.Producto;

public class ProductoController {
  public void ordenarProducto(List<Producto> codigo){
    TreeSet<Producto> ordenar = new TreeSet<>();
    codigo.containsAll(ordenar);
    ordenar.comparator(Producto > codigo);
    
    
                                           

    



  }
  public void clasificarPorUnidad(Set<Producto> nombre ){

  }
  public void ordenarDestacados(List<Producto> precio){

  }
  public void buscarPorNombre(List<Producto> lista, String nombre){

  }
  
}
