package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ManejadorUsuarios {
    
    private static ManejadorUsuarios instance = null;
    Map<String,Usuario> usuarios = Collections.synchronizedMap(new HashMap<String,Usuario>());
    
    public static ManejadorUsuarios getInstance(){
        if(ManejadorUsuarios.instance == null){
            ManejadorUsuarios.instance = new ManejadorUsuarios();
        }
        return ManejadorUsuarios.instance;
    }
    
    private ManejadorUsuarios(){
    
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.put(usuario.getNickname(), usuario);
    }
    
    public Map<String,Usuario> obtenerUsuarios(){
        return usuarios;
    }
    
    public Map<String,Cliente> obtenerClientes(){
        Map<String,Cliente> result = Collections.synchronizedMap(new HashMap<String,Cliente>());
        usuarios.keySet().stream().forEach((u) -> {
            if(usuarios.get(u) instanceof Cliente){
                result.put(u,(Cliente) usuarios.get(u));
            }
        });
        return result;
    }
    
    public Map<String,Proveedor> obtenerProveedores(){
        Map<String,Proveedor> result = Collections.synchronizedMap(new HashMap<String,Proveedor>());
        usuarios.keySet().stream().forEach((u) -> {
            if(usuarios.get(u) instanceof Proveedor){
                result.put(u,(Proveedor) usuarios.get(u));
            }
        });
        return result;
    }
    
    public Cliente getCliente(String nickname){
        return this.obtenerClientes().get(nickname);
    }
    
    public Proveedor getProveedor(String nickname){
        return this.obtenerProveedores().get(nickname);
    }
    
}
