/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rodro
 */
@Entity
@Table(catalog = "PROG1", schema = "PUBLIC", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NROREFERENCIA"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especificacionproducto.findAll", query = "SELECT e FROM Especificacionproducto e"),
    @NamedQuery(name = "Especificacionproducto.findByNroreferencia", query = "SELECT e FROM Especificacionproducto e WHERE e.nroreferencia = :nroreferencia"),
    @NamedQuery(name = "Especificacionproducto.findByNombre", query = "SELECT e FROM Especificacionproducto e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Especificacionproducto.findByDescripcion", query = "SELECT e FROM Especificacionproducto e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Especificacionproducto.findByPrecio", query = "SELECT e FROM Especificacionproducto e WHERE e.precio = :precio"),
    @NamedQuery(name = "Especificacionproducto.findByProveedorId", query = "SELECT e FROM Especificacionproducto e WHERE e.proveedorId = :proveedorId")})
public class Especificacionproducto2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String nroreferencia;
    @Column(length = 255)
    private String nombre;
    @Column(length = 255)
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 17, scale = 0)
    private Double precio;
    @Column(name = "PROVEEDOR_ID", length = 255)
    private String proveedorId;
    @ManyToMany(mappedBy = "especificacionproductoCollection")
    private Collection<Categoria2> categoriaCollection;

    public Especificacionproducto2() {
    }

    public Especificacionproducto2(String nroreferencia) {
        this.nroreferencia = nroreferencia;
    }

    public String getNroreferencia() {
        return nroreferencia;
    }

    public void setNroreferencia(String nroreferencia) {
        this.nroreferencia = nroreferencia;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    @XmlTransient
    public Collection<Categoria2> getCategoriaCollection() {
        return categoriaCollection;
    }

    public void setCategoriaCollection(Collection<Categoria2> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroreferencia != null ? nroreferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especificacionproducto2)) {
            return false;
        }
        Especificacionproducto2 other = (Especificacionproducto2) object;
        if ((this.nroreferencia == null && other.nroreferencia != null) || (this.nroreferencia != null && !this.nroreferencia.equals(other.nroreferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Especificacionproducto[ nroreferencia=" + nroreferencia + " ]";
    }
    
}
