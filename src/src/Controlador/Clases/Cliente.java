package Controlador.Clases;

import Controlador.DataTypes.DataCliente;
import java.util.Date;

public class Cliente extends Usuario{
    
    public Cliente(String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
    }
    
    public Cliente(DataCliente dc) {
        super(dc.getNickname(), dc.getNombre(), dc.getApellido(), dc.getEmail(), dc.getFechaNacimiento());
        this.setImagenes(dc.getImagenes());
        
    }
    
    public ClienteCompraProducto obtenerClienteCompraProducto() {
        return null;
    }
    
    @Override
    public String toString() {
        return this.getNickname() + "  --  " + this.getNombre() + "  --  " + this.getApellido()+" -- "+this.getImagenes();
    }
    
}
