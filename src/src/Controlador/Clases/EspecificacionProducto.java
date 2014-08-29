package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EspecificacionProducto {
    
    private String nroReferencia;
    private String nombre;
    private String descripcion;
    private Map<String,String> especificacion;
    private Float precio;
    private Proveedor proveedor;
    private ArrayList<String> imagenes;
    private Map<String,Categoria> categorias;
    private Map<Integer,Producto> listaProductos;
    
    public EspecificacionProducto(String nroReferencia, String nombre, String descripcion, Map<String,String> especificacion, Float precio, Proveedor proveedor, Map<String,Categoria> categorias,Map<Integer,Producto> listaProductos) {
        this.nroReferencia = nroReferencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.especificacion = especificacion;
        this.precio = precio;
        this.proveedor = proveedor;
        this.categorias = categorias;
        this.listaProductos = listaProductos;
    }
    
    public EspecificacionProducto(DataEspecificacionProducto espProducto, Proveedor proveedor) {
        this.nroReferencia = espProducto.getNroReferencia();
        this.nombre = espProducto.getNombre();
        this.descripcion = espProducto.getDescripcion();
        this.especificacion = espProducto.getEspecificacion();
        this.precio = espProducto.getPrecio();
        this.proveedor = proveedor;
        this.categorias = Collections.synchronizedMap(new HashMap());
        this.imagenes = new ArrayList<>();
        this.listaProductos = Collections.synchronizedMap(new HashMap());
        espProducto.getProductos().entrySet().forEach((producto) -> {
           this.listaProductos.put(producto.getKey(),new Producto(producto.getKey(),this));
        });
    }

    public String getNroReferencia() {
        return nroReferencia;
    }

    public void setNroReferencia(String nroReferencia) {
        this.nroReferencia = nroReferencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Map<String,String> getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(Map<String,String> especificacion) {
        this.especificacion = especificacion;
    }
    
    public Map<Integer,Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(Map<Integer,Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }
    
    public DataProveedor getDataProveedor() {
        return new DataProveedor(proveedor);
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public ArrayList<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<String> imagenes) {
        this.imagenes = imagenes;
    }
    
    public Map<String,Categoria> getCategorias() {
        return categorias;
    }
    
    public ArrayList<DataCategoria> getDataCategorias() {
        ArrayList<DataCategoria> dataCategorias = new ArrayList<>();
        this.getCategorias().entrySet().stream().map((categoria) -> categoria.getValue()).forEach((valor) -> {
            dataCategorias.add(new DataCategoria(valor, false));
        });
        return dataCategorias;
    }

    public void setCategorias(Map<String,Categoria> categorias) {
        this.categorias = categorias;
    }
    
    public void agregarCategoria(Categoria categoria){
        this.categorias.put(categoria.getNombre(),categoria);
    }
    
    @Override
    public String toString() {
        return this.getNroReferencia() + "  --  " + this.getNombre();
    }
    
}
