package Controlador.Clases;

import Controlador.DataTypes.DataCliente;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Cliente extends Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @PrimaryKeyJoinColumn(name = "NICKNAME")
    @OneToOne
    private Usuario usuario;
    
    public Cliente() {
    }
    
    public Cliente(String nickname, String nombre, String apellido, String email, Calendar fechaNacimiento) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
    }
    
    public Cliente(DataCliente dc) {
        super(dc.getNickname(), dc.getNombre(), dc.getApellido(), dc.getEmail(), dc.getFechaNacimiento());
        this.setImagen(dc.getImagen());
        
    }
    
    public ClienteCompraProducto obtenerClienteCompraProducto() {
        return null;
    }
    
    @Override
    public String toString() {
        return this.getNickname() + "  --  " + this.getNombre() + "  --  " + this.getApellido() + " -- " + this.getImagen();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getNickname() != null ? getNickname().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        return (this.getNickname() != null || other.getNickname() == null) && (this.getNickname() == null || this.getNickname().equals(other.getNickname()));
    }
    
}
