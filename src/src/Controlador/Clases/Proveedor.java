package Controlador.Clases;

import Controlador.DataTypes.DataProveedor;
import java.util.Date;

public class Proveedor extends Usuario{
    
    private String nombreCompania;
    private String linkSitio;

    public Proveedor(String nickname, String nombre, String apellido, String email, Date fechaNacimiento, String nombreCompania, String linkSitio) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
        this.nombreCompania = nombreCompania;
        this.linkSitio = linkSitio; 
    }
    
    public Proveedor(DataProveedor dp) {
        super(dp.getNickname(), dp.getNombre(), dp.getApellido(), dp.getEmail(), dp.getFechaNacimiento());
        this.nombreCompania = dp.getNombreCompania();
        this.linkSitio = dp.getLinkSitio();
        this.setImagenes(dp.getImagenes());
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
        return this.getNickname() + "  --  " + this.getNombre() + "  --  " + this.getApellido()+" -- "+this.getImagenes();
    }
    
}
