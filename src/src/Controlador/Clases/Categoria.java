package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Categoria implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "PADRE")
    private Categoria padre;
    @Transient
    private Map<String,EspecificacionProducto> listaProductos = Collections.synchronizedMap(new HashMap());;

    public Categoria() {
        
    }

    public Categoria(String nombre, Categoria padre) {
        this.nombre = nombre;
        this.padre = padre;
    }
    
    public Categoria(DataCategoria dc) {
        this.nombre = dc.getNombre();
        this.padre = null;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        return (this.nombre != null || other.nombre == null) && (this.nombre == null || this.nombre.equals(other.nombre));
    }
    
}
