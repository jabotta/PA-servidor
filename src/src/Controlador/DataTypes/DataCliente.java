package Controlador.DataTypes;

import Controlador.Clases.Cliente;
import java.util.Date;

public class DataCliente extends DataUsuario{

    public DataCliente(Cliente c) {
        super(c.getNickname(), c.getNombre(), c.getApellido(), c.getEmail(), c.getFechaNacimiento());
    }

    public DataCliente(String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
    }
    
    @Override
    public String toString() {
        return this.getNickname() + "  --  " + this.getNombre() + "  --  " + this.getApellido();
    }
    
}
