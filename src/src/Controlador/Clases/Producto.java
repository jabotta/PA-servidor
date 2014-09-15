package Controlador.Clases;

import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Producto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer id;
    @Column(name="ID_ESPECIFICO")
    private String idEspecifico;
    
    @ManyToOne
    @JoinColumn(name="ESPECIFICACION")
    private EspecificacionProducto especificacionProducto;

    public Producto() {
    }

    public Producto(Integer id, EspecificacionProducto especificacionProducto) {
        this.id = id;
        this.idEspecifico = null;
        this.especificacionProducto = especificacionProducto;
    }
    
    public Producto(Integer id, String idEspecifico, EspecificacionProducto especificacionProducto) {
        this.id = id;
        this.idEspecifico = idEspecifico;
        this.especificacionProducto = especificacionProducto;
    }
    
    public Producto(DataProducto dp) {
        this.id = dp.getId();
        this.idEspecifico = dp.getIdEspecifico();
        this.especificacionProducto = dp.getObjectEspecificacionProducto();
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getIdEspecifico() {
        return idEspecifico;
    }
    
    public void setId(String id) {
        this.idEspecifico = id;
    }
    
    public EspecificacionProducto getEspecificacionProducto() {
        return especificacionProducto;
    }
    
    public DataEspecificacionProducto getDataEspecificacionProducto() {
        return new DataEspecificacionProducto(especificacionProducto,true);
    }
    
    public void setEspecificacionProducto(EspecificacionProducto especificacionProducto) {
        this.especificacionProducto = especificacionProducto;
    }
    
    @Override
    public String toString() {
        return this.getId() + "  --  " + this.getEspecificacionProducto();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        return (this.id != null || other.id == null) && (this.id == null || this.id.equals(other.id));
    }
    
}
