package Controlador.DataTypes;

import Controlador.Clases.Usuario;
import java.util.Date;

public class DataCliente extends DataUsuario{

    public DataCliente(Usuario u) {
        super(u.getNickname(), u.getNombre(), u.getApellido(), u.getEmail(), u.getFechaNacimiento());
    }

    public DataCliente(String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
    }
    
    @Override
    public String toString() {
        return this.getNickname() + "  --  " + this.getNombre() + "  --  " + this.getApellido();
    }
    
}
