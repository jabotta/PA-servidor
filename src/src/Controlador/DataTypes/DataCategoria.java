package Controlador.DataTypes;

import Controlador.Clases.Categoria;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DataCategoria {
    
    private String nombre;
    private DataCategoria padre;
    private Map<String,DataEspecificacionProducto> listaProductos;
    
    public DataCategoria(Categoria c, boolean conProductos) {
        this.nombre = c.getNombre();
        if(c.getPadre() == null){
            this.padre = null;
        }else{
            this.padre = c.getDataPadre();
        }
        this.listaProductos = Collections.synchronizedMap(new HashMap<String,DataEspecificacionProducto>());
        if(conProductos)
            c.getListaProductos().entrySet().forEach((producto) -> {
               this.listaProductos.put(producto.getKey(),new DataEspecificacionProducto(producto.getValue(),true));
            });
    }
       
    public DataCategoria(String nombre, DataCategoria padre) {
        this.nombre = nombre;
        this.padre = padre;
        this.listaProductos = Collections.synchronizedMap(new HashMap<String,DataEspecificacionProducto>());
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public DataCategoria getPadre() {
        return padre;
    }
    
    public void setPadre(DataCategoria padre) {
        this.padre = padre;
    }
    
    public Map<String,DataEspecificacionProducto> getListaProductos() {
        return this.listaProductos;
    }
    
    public void setListaProductos(Map<String,DataEspecificacionProducto> productos) {
        this.listaProductos = productos;
    }
    
    @Override
    public String toString() {
        return this.getNombre() + "  --  " + this.getPadre();
    }

    public boolean tienePadre() {
        return this.padre != null;
     }
    
}
