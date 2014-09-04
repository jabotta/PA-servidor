package Controlador.DataTypes;

import Controlador.Clases.Cliente;
import java.util.Calendar;

public class DataCliente extends DataUsuario{

    public DataCliente(Cliente c) {
        super(c.getNickname(), c.getNombre(), c.getApellido(), c.getEmail(), c.getFechaNacimiento());
        this.setImagen(c.getImagen());
    }

    public DataCliente(String nickname, String nombre, String apellido, String email, Calendar fechaNacimiento) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
    }
    
    @Override
    public String toString() {
        return this.getNickname() + "  --  " + this.getNombre() + "  --  " + this.getApellido();
    }
    
}
