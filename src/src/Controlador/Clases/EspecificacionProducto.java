package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProveedor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class EspecificacionProducto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "NROREFERENCIA")
    private String nroReferencia;
    private String nombre;
    private String descripcion;
    private Float precio;
    
    @ElementCollection
    @MapKeyColumn(name="NOMBRE")
    @Column(name="VALOR")
    @CollectionTable(name="ESPECIFICACIONES", joinColumns=@JoinColumn(name="ESPPRID"))
    //@Transient
    private Map<String,String> especificacion;
    
    @ManyToOne
    @JoinColumn(name = "PROVEEDOR_ID")
    private Proveedor proveedor;

    //@Transient
    @ElementCollection
    @CollectionTable(name="IMAGENES",joinColumns=@JoinColumn(name="PARENTID"))
    @Column(name="PATH")
    private List<String> imagenes;
    
    @ManyToMany
    @JoinTable(name="CATEGORIAESPECIFICACIONPROD",
        joinColumns={@JoinColumn(name="ESP_NROREF", referencedColumnName="NROREFERENCIA")},
        inverseJoinColumns={@JoinColumn(name="CAT_NAME", referencedColumnName="NOMBRE")})
    private Map<String,Categoria> categorias;
    
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="especificacionProducto")
    @JoinColumn(name="ID")
    private List<Producto> listaProductos;

    public EspecificacionProducto() {
    }
    
    public EspecificacionProducto(String nroReferencia, String nombre, String descripcion, Map<String,String> especificacion, Float precio, Proveedor proveedor, Map<String,Categoria> categorias,List<Producto> listaProductos) {
        this.nroReferencia = nroReferencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.especificacion = especificacion;
        this.precio = precio;
        this.proveedor = proveedor;
        this.categorias = categorias;
        this.listaProductos = listaProductos;
        this.imagenes = new ArrayList();
    }
    
    public EspecificacionProducto(DataEspecificacionProducto espProducto, Proveedor proveedor) {
        this.nroReferencia = espProducto.getNroReferencia();
        this.nombre = espProducto.getNombre();
        this.descripcion = espProducto.getDescripcion();
        this.especificacion = espProducto.getEspecificacion();
        this.precio = espProducto.getPrecio();
        this.proveedor = proveedor;
        this.categorias = new HashMap();
        this.imagenes = new ArrayList();
        this.listaProductos = new ArrayList();
        /*espProducto.getProductos().entrySet().forEach((producto) -> {
           this.listaProductos.put(producto.getKey(),new Producto(producto.getKey(),this));
        });*/
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
    
    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
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

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }
    
    public Map<String,Categoria> getCategorias() {
        return categorias;
    }
    
    public List<DataCategoria> getDataCategorias() {
        List<DataCategoria> dataCategorias = new ArrayList<>();
        /*this.getCategorias().entrySet().stream().map((categoria) -> categoria.getValue()).forEach((valor) -> {
            dataCategorias.add(new DataCategoria(valor, false));
        });*/
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroReferencia != null ? nroReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EspecificacionProducto)) {
            return false;
        }
        EspecificacionProducto other = (EspecificacionProducto) object;
        return (this.nroReferencia != null || other.nroReferencia == null) && (this.nroReferencia == null || this.nroReferencia.equals(other.nroReferencia));
    }
    
}
