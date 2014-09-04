package Controlador.Clases;

import Controlador.DataTypes.DataProveedor;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Proveedor extends Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nombreCompania;
    private String linkSitio;
    @JoinColumn(name = "NICKNAME")
    @OneToOne
    private Usuario usuario;
    
    public Proveedor() {
    }

    public Proveedor(String nickname, String nombre, String apellido, String email, Calendar fechaNacimiento, String nombreCompania, String linkSitio) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
        this.nombreCompania = nombreCompania;
        this.linkSitio = linkSitio; 
    }
    
    public Proveedor(DataProveedor dp) {
        super(dp.getNickname(), dp.getNombre(), dp.getApellido(), dp.getEmail(), dp.getFechaNacimiento());
        this.nombreCompania = dp.getNombreCompania();
        this.linkSitio = dp.getLinkSitio();
        this.setImagen(dp.getImagen());
    }
    
    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getLinkSitio() {
        return linkSitio;
    }

    public void setLinkSitio(String linkSitio) {
        this.linkSitio = linkSitio;
    }
    
    public DataProveedor obtenerDataProovedor(){
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
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        return (this.getNickname() != null || other.getNickname() == null) && (this.getNickname() == null || this.getNickname().equals(other.getNickname()));
    }
    
}
