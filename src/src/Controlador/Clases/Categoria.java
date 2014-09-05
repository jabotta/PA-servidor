package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Categoria {
    
    private String nombre;
    private Categoria padre;
    private Map<String,EspecificacionProducto> listaProductos;

    public Categoria(String nombre, Categoria padre) {
        this.nombre = nombre;
        this.padre = padre;
        this.listaProductos = Collections.synchronizedMap(new HashMap<String,EspecificacionProducto>());
    }
    
    public Categoria(String nombre, Categoria padre, Map<String,EspecificacionProducto> productos) {
        this.nombre = nombre;
        this.padre = padre;
        this.listaProductos = productos;
    }
    
    public Categoria(DataCategoria dc) {
        this.nombre = dc.getNombre();
        this.padre = null;
        this.listaProductos = Collections.synchronizedMap(new HashMap<String,EspecificacionProducto>());
        dc.getListaProductos().entrySet().forEach((producto) -> {
           listaProductos.put(producto.getKey(),new EspecificacionProducto(producto.getValue(),new Proveedor(producto.getValue().getProveedor())));
        });
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Categoria getPadre() {
        return padre;
    }
    
    public DataCategoria getDataPadre() {
        return new DataCategoria(padre,false);
    }
    
    public void setPadre(Categoria padre) {
        this.padre = padre;
    }
    
    public Map<String,EspecificacionProducto> getListaProductos() {
        return this.listaProductos;
    }
    
    public void setListaProductos(Map<String,EspecificacionProducto> productos) {
        this.listaProductos = productos;
    }
    
    public void agregarProducto(EspecificacionProducto producto){
        this.listaProductos.put(producto.getNroReferencia(),producto);
    }
    
    @Override
    public String toString() {
        return this.getNombre() + "  --  " + this.getPadre();
    }

    public boolean tienePadre() { 
        return this.padre != null;
    }
    
}
