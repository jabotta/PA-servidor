package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ManejadorOrdenes {
    
    private static ManejadorOrdenes instance = null;
    Map<Integer,OrdenCompra> ordenes = Collections.synchronizedMap(new HashMap());
    
    public static ManejadorOrdenes getInstance(){
        if(ManejadorOrdenes.instance == null){
            ManejadorOrdenes.instance = new ManejadorOrdenes();
        }
        return ManejadorOrdenes.instance;
    }
    
    private ManejadorOrdenes(){
    
    }
    
    public void agregarOrden(OrdenCompra orden){
        ordenes.put(orden.getNroOrden(), orden);
    }
    
    public Map<Integer,OrdenCompra> obtenerOrdenes(){
        return ordenes;
    }
    
    public void eliminarOrden(OrdenCompra orden){
        
    }
    
}
