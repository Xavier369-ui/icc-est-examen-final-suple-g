package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Producto {
    private final String nombre;
    private final String codigo;
    private final List<Double> precios;

    public Producto(String nombre, String codigo, List<Double> precios) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precios = precios;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public List<Double> getPrecios() {
        return precios;
    }

    public double getPorcentajeCaracteresUnicos() {
        String nombreSinEspacios = nombre.replaceAll("\\s+", "").toLowerCase();
        Set<Character> caracteresUnicos = new HashSet<>();
        
        for (char c : nombreSinEspacios.toCharArray()) {
            caracteresUnicos.add(c);
        }
        
        return ((double) caracteresUnicos.size() * 100) / nombreSinEspacios.length();
    }

    public int getCatidadPreciosRepetidos() {
        Map<Double, Integer> frecuencia = new HashMap<>();
        for (Double precio : precios) {
            frecuencia.put(precio, frecuencia.getOrDefault(precio, 0) + 1);
        }
        
        int repetidos = 0;
        for (int count : frecuencia.values()) {
            if (count > 1) {
                repetidos += count - 1;
            }
        }
        return repetidos;
    }
    
}
