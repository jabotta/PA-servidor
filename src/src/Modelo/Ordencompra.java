/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodro
 */
@Entity
@Table(catalog = "PROG1", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordencompra.findAll", query = "SELECT o FROM Ordencompra o"),
    @NamedQuery(name = "Ordencompra.findByNroOrden", query = "SELECT o FROM Ordencompra o WHERE o.nroOrden = :nroOrden"),
    @NamedQuery(name = "Ordencompra.findByFecha", query = "SELECT o FROM Ordencompra o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Ordencompra.findByPrecio", query = "SELECT o FROM Ordencompra o WHERE o.precio = :precio")})
public class Ordencompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NRO_ORDEN", nullable = false)
    private Long nroOrden;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 65535, scale = 32767)
    private BigDecimal precio;

    public Ordencompra() {
    }

    public Ordencompra(Long nroOrden) {
        this.nroOrden = nroOrden;
    }

    public Long getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(Long nroOrden) {
        this.nroOrden = nroOrden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroOrden != null ? nroOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordencompra)) {
            return false;
        }
        Ordencompra other = (Ordencompra) object;
        if ((this.nroOrden == null && other.nroOrden != null) || (this.nroOrden != null && !this.nroOrden.equals(other.nroOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Ordencompra[ nroOrden=" + nroOrden + " ]";
    }
    
}
