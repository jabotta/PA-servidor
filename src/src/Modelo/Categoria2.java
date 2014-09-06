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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @UniqueConstraint(columnNames = {"NOMBRE"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.nombre = :nombre")})
public class Categoria2 implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    private String nombre;
    @JoinTable(name = "CATEGORIAESPECIFICACIONPROD", joinColumns = {
        @JoinColumn(name = "CAT_NAME", referencedColumnName = "NOMBRE", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "ESP_NROREF", referencedColumnName = "NROREFERENCIA", nullable = false)})
    @ManyToMany
    private Collection<Especificacionproducto2> especificacionproductoCollection;
    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "padre")
    private Collection<Categoria2> categoriaCollection;
    @JoinColumn(name = "PADRE", referencedColumnName = "NOMBRE")
    @ManyToOne
    private Categoria2 padre;

    public Categoria2() {
    }

    public Categoria2(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Categoria2> getCategoriaCollection() {
        return categoriaCollection;
    }

    public void setCategoriaCollection(Collection<Categoria2> categoriaCollection) {
        this.categoriaCollection = categoriaCollection;
    }

    public Categoria2 getPadre() {
        return padre;
    }

    public void setPadre(Categoria2 padre) {
        this.padre = padre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria2)) {
            return false;
        }
        Categoria2 other = (Categoria2) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Categoria[ nombre=" + nombre + " ]";
    }

    @XmlTransient
    public Collection<Especificacionproducto2> getEspecificacionproductoCollection() {
        return especificacionproductoCollection;
    }

    public void setEspecificacionproductoCollection(Collection<Especificacionproducto2> especificacionproductoCollection) {
        this.especificacionproductoCollection = especificacionproductoCollection;
    }

}
