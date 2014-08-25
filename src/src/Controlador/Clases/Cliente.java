package Controlador.Clases;

import java.util.Date;

public class Cliente extends Usuario{
    
    public Cliente(String nickname, String nombre, String apellido, String email, Date fechaNacimiento) {
        super(nickname, nombre, apellido, email, fechaNacimiento);
    }
    
    public ClienteCompraProducto obtenerClienteCompraProducto() {
        return null;
    }
    
    @Override
    public String toString() {
        return this.getNickname() + "  --  " + this.getNombre() + "  --  " + this.getApellido();
    }
    
}
