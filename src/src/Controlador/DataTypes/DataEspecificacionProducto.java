package Controlador.DataTypes;

import Controlador.Clases.EspecificacionProducto;
import java.util.ArrayList;
import java.util.Map;

public class DataEspecificacionProducto {
    
    private String nroReferencia;
    private String nombre;
    private String descripcion;
    private Map<String,String> especificacion;
    private Float precio;
    private DataProveedor proveedor;
    private ArrayList<String> imagenes;
    private ArrayList<DataCategoria> categorias;
    
    public DataEspecificacionProducto(EspecificacionProducto ep) {
        this.nroReferencia = ep.getNroReferencia();
        this.nombre = ep.getNombre();
        this.descripcion = ep.getDescripcion();
        this.especificacion = ep.getEspecificacion();
        this.precio = ep.getPrecio();
        this.proveedor = ep.getDataProveedor();
        this.imagenes = ep.getImagenes();
        this.categorias = ep.getDataCategorias();
    }
    
    public DataEspecificacionProducto(String nroReferencia, String nombre, String descripcion, Map<String,String> especificacion, Float precio, DataProveedor proveedor, ArrayList<String> imagenes, ArrayList<DataCategoria> categorias) {
        this.nroReferencia = nroReferencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.especificacion = especificacion;
        this.precio = precio;
        this.proveedor = proveedor;
        this.imagenes = imagenes;
        this.categorias = categorias;
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

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
    public DataProveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(DataProveedor proveedor) {
        this.proveedor = proveedor;
    }

    public ArrayList<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<String> imagenes) {
        this.imagenes = imagenes;
    }
    
    public ArrayList<DataCategoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<DataCategoria> categorias) {
        this.categorias = categorias;
    }
    
    @Override
    public String toString() {
        return this.getNroReferencia() + "  --  " + this.getNombre();
    }
    
}
