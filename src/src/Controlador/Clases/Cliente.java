package Controlador.Clases;

import java.util.Date;

public class Cliente extends Usuario{
    
    public Cliente(String nombreCompania, String linkSitio, String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
    }
    
}
