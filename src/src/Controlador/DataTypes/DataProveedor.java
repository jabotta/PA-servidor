package Controlador.DataTypes;

import Controlador.Clases.Proveedor;
import java.util.Date;

public class DataProveedor extends DataUsuario{
    
    private String nombreCompania;
    private String linkSitio;
    
    public DataProveedor(Proveedor p) {
        super(p.getNickname(), p.getNombre(), p.getApellido(), p.getEmail(), p.getFechaNacimiento());
        this.nombreCompania = p.getNombreCompania();
        this.linkSitio = p.getLinkSitio();
    }
    
    public DataProveedor(String nombre_compania, String link_sitio, String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
        this.nombreCompania = nombre_compania;
        this.linkSitio = link_sitio;
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
    
}
