package Controlador.DataTypes;

import Controlador.Clases.Proveedor;
import java.util.Date;

public class DataProveedor extends DataUsuario{
    
    private String nombreCompania;
    private String linkSitio;
    
    public DataProveedor(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String nombreCompania, String linkSitio) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
        this.nombreCompania = nombreCompania;
        this.linkSitio = linkSitio;
    }
    
    public DataProveedor(Proveedor p) {
        super(p.getNickname(), p.getNombre(), p.getApellido(), p.getEmail(), p.getFechaNacimiento());
        this.nombreCompania = p.getNombreCompania();
        this.linkSitio = p.getLinkSitio();
         this.setImagenes(p.getImagenes());
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
    
    @Override
    public String toString() {
        return this.getNickname() + "  --  " + this.getNombre() + "  --  " + this.getApellido();
    }
    
}
