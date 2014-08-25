package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ManejadorUsuarios {
    
    private static ManejadorUsuarios instance = null;
    Map<String,Usuario> usuarios = Collections.synchronizedMap(new HashMap());
    
    public static ManejadorUsuarios getInstance(){
        if(ManejadorUsuarios.instance == null){
            ManejadorUsuarios.instance = new ManejadorUsuarios();
        }
        return ManejadorUsuarios.instance;
    }
    
    private ManejadorUsuarios(){
    
    }
    
    public void agregarUsuario(String key, Usuario usuario){
        usuarios.put(key, usuario);
    }
    
    public Map<String,Usuario> obtenerUsuarios(){
        return usuarios;
    }
    
}
