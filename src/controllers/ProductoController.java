package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import models.Producto;

public class ProductoController {
    public TreeSet<Producto> ordenarProducto(List<Producto> productos) {
        TreeSet<Producto> productosUnicos = new TreeSet<>(new Comparator<Producto>() {
            @Override
            public int compare(Producto p1, Producto p2) {
                int comparacionNombre = p1.getNombre().compareTo(p2.getNombre());
                if (comparacionNombre != 0) {
                    return comparacionNombre;
                }
                return p1.getCodigo().compareTo(p2.getCodigo());
            }
        });
        
        Set<String> codigosVistos = new HashSet<>();
        for (Producto p : productos) {
            if (!codigosVistos.contains(p.getCodigo())) {
                productosUnicos.add(p);
                codigosVistos.add(p.getCodigo());
            }
        }
        return productosUnicos;
    }

    public Map<String, List<Producto>> clasificarPorUnicidad(Set<Producto> productos) {
        Map<String, List<Producto>> clasificacion = new LinkedHashMap<>();
        clasificacion.put("A", new LinkedList<>());
        clasificacion.put("B", new LinkedList<>());
        clasificacion.put("C", new LinkedList<>());
        clasificacion.put("D", new LinkedList<>());
        clasificacion.put("E", new LinkedList<>());

        for (Producto p : productos) {
            double porcentaje = p.getPorcentajeCaracteresUnicos();
            String categoria = obtenerCategoria(porcentaje);
            clasificacion.get(categoria).add(p);
        }
        return clasificacion;
    }

    private String obtenerCategoria(double porcentaje) {
        if (porcentaje >= 90) return "A";
        if (porcentaje >= 70) return "B";
        if (porcentaje >= 50) return "C";
        if (porcentaje >= 30) return "D";
        return "E";
    }

    public List<Producto> obtenerDestacados(List<Producto> productos) {
        List<Producto> destacados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getCatidadPreciosRepetidos() > 1) {
                destacados.add(p);
            }
        }
        destacados.sort(Comparator.comparing(Producto::getNombre));
        return destacados;
    }

    public Producto buscarPorNombre(List<Producto> lista, String nombre) {
        lista.sort(Comparator.comparing(Producto::getNombre));
        int left = 0;
        int right = lista.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparacion = lista.get(mid).getNombre().compareTo(nombre);
            
            if (comparacion == 0) {
                return lista.get(mid);
            } else if (comparacion < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
    
}
