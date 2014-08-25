package Controlador.Clases;

public class ManejadorOrdenes {
    private static ManejadorOrdenes instance = null;
    
    public static ManejadorOrdenes getInstance(){
        if(ManejadorOrdenes.instance == null){
            ManejadorOrdenes.instance = new ManejadorOrdenes();
        }
        return ManejadorOrdenes.instance;
    }
    
    private ManejadorOrdenes(){
    
    }
    
    public void agregarOrden(OrdenCompra orden){
        
    }
    
    public OrdenCompra obtenerOrdenes(){
        return null;
    }
    
    public void eliminarOrden(OrdenCompra orden){
        
    }
    
}
