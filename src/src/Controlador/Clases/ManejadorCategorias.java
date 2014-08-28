package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ManejadorCategorias {
    
    private static ManejadorCategorias instance = null;
    Map<String,Categoria> categorias = Collections.synchronizedMap(new HashMap());
    
    public static ManejadorCategorias getInstance(){
        if(ManejadorCategorias.instance == null){
            
            ManejadorCategorias.instance = new ManejadorCategorias();
        }
        return ManejadorCategorias.instance;
    }
    
    private ManejadorCategorias(){
    
    }
    
    public void agregarCategoria(Categoria categoria){
        categorias.put(categoria.getNombre(), categoria);
    }
    
    public Map<String,Categoria> obtenerCategorias(){
        return categorias;
    }
    
    public Categoria getCategoria(String nombre){
        return this.obtenerCategorias().get(nombre);
    }
    
}
