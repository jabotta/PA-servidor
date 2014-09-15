/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rodro
 */
@Entity
@Table(catalog = "PROG1", schema = "PUBLIC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByNickname", query = "SELECT c FROM Cliente c WHERE c.nickname = :nickname")})
public class Cliente2 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private String nickname;
    @JoinColumn(name = "NICKNAME", referencedColumnName = "NICKNAME", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario2 usuario;

    public Cliente2() {
    }

    public Cliente2(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Usuario2 getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario2 usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente2)) {
            return false;
        }
        Cliente2 other = (Cliente2) object;
        if ((this.nickname == null && other.nickname != null) || (this.nickname != null && !this.nickname.equals(other.nickname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Cliente[ nickname=" + nickname + " ]";
    }
    
}
