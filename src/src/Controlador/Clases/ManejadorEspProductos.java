package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ManejadorEspProductos {
    
    private static ManejadorEspProductos instance = null;
    Map<String,EspecificacionProducto> especificacionProductos = Collections.synchronizedMap(new HashMap());
    
    public static ManejadorEspProductos getInstance(){
        if(ManejadorEspProductos.instance == null){
            
            ManejadorEspProductos.instance = new ManejadorEspProductos();
        }
        return ManejadorEspProductos.instance;
    }
    
    private ManejadorEspProductos(){
    
    }
    
    public void agregarEspecificacionProducto(String key, EspecificacionProducto especificacionProducto){
        especificacionProductos.put(key, especificacionProducto);
    }
    
    public Map<String,EspecificacionProducto> obtenerEspecificacionProductos(){
        return especificacionProductos;
    }
    
}
