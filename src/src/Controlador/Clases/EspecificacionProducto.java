package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;

public class EspecificacionProducto {
    
    private String nroReferencia;
    private String nombre;
    private String descripcion;
    private ArrayList<String> especificacion;
    private Float precio;
    private Proveedor proveedor;
    private ArrayList<String> imagenes;
    private ArrayList<Categoria> categorias;
    
    public EspecificacionProducto(String nroReferencia, String nombre, String descripcion, ArrayList<String> especificacion, Float precio, Proveedor proveedor, ArrayList<Categoria> categorias) {
        this.nroReferencia = nroReferencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.especificacion = especificacion;
        this.precio = precio;
        this.proveedor = proveedor;
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

    public ArrayList<String> getEspecificacion() {
        return especificacion;
    }

    public void setEspecificacion(ArrayList<String> especificacion) {
        this.especificacion = especificacion;
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
    
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    
    public ArrayList<DataCategoria> getDataCategorias() {
        ArrayList<DataCategoria> dataCategorias = new ArrayList<>();
        categorias.stream().forEach((categoria) -> {
            dataCategorias.add(new DataCategoria(categoria));
        });
        return dataCategorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    @Override
    public String toString() {
        return this.getNroReferencia() + "  --  " + this.getNombre();
    }
    
}
