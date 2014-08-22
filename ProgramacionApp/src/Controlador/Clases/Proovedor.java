/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.Clases;

import java.util.Date;

/**
 *
 * @author rodro
 */
public class Proovedor extends Usuario{
    private String nombreCompania;
    private String linkSitio;

    public Proovedor(String nombreCompania, String linkSitio, String nickname, String nombre, String apellido, String email, Date fecha_nacimiento) {
        super(nickname, nombre, apellido, email, fecha_nacimiento);
        this.nombreCompania = nombreCompania;
        this.linkSitio = linkSitio;
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
