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
public class DataCliente extends DataUsuario{

    public DataCliente(Usuario u) {
        super(u);
    }

    public DataCliente(String nickname, String nombre, String apellido, String email, Date fecha_nacimiento) {
        super(nickname, nombre, apellido, email, fecha_nacimiento);
    }
    
}
