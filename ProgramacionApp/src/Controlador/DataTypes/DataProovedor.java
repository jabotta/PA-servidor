/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.DataTypes;

import Controlador.Clases.Usuario;
import java.util.Date;

/**
 *
 * @author rodro
 */
public class DataProovedor extends DataUsuario{
    private String nombreCompania;
    private String linkSitio;

    
    
    public DataProovedor(String nombre_compania, String link_sitio, String nickname, String nombre, String apellido, String email, Date fecha_nacimiento) {
        super(nickname, nombre, apellido, email, fecha_nacimiento);
        this.nombreCompania = nombre_compania;
        this.linkSitio = link_sitio;
    }
    
    public DataProovedor(Usuario u) {
        super(u);
    }

    public String getNombre_compania() {
        return nombreCompania;
    }

    public void setNombre_compania(String nombre_compania) {
        this.nombreCompania = nombre_compania;
    }

    public String getLink_sitio() {
        return linkSitio;
    }

    public void setLink_sitio(String link_sitio) {
        this.linkSitio = link_sitio;
    }
    
}
