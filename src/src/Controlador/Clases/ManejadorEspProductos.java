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
    
    public void agregarEspecificacionProducto(EspecificacionProducto especificacionProducto){
        especificacionProductos.put(especificacionProducto.getNroReferencia(), especificacionProducto);
        especificacionProducto.getCategorias().entrySet().stream().map((categoria) -> categoria.getValue()).forEach((valor) -> {    
         
            ManejadorCategorias.getInstance().getCategoria(valor.getNombre()).agregarProducto(especificacionProducto);
//            System.out.println(valor.getNombre()+" "+ManejadorCategorias.getInstance().getCategoria(valor.getNombre()).getListaProductos().size());
        });
        
    }
    
    public Map<String,EspecificacionProducto> obtenerEspecificacionProductos(){
        return especificacionProductos;
    }
    
    public EspecificacionProducto getEspecificacionProducto(String nroRef){
        return this.obtenerEspecificacionProductos().get(nroRef);
    }
    
}
