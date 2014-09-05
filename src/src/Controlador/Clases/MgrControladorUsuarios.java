package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MgrControladorUsuarios {
    
    private static MgrControladorUsuarios instance = null; 
    private Map<Integer,ControladorUsuarios> controladorColection;
    
    public static MgrControladorUsuarios getInstance(){
        if(MgrControladorUsuarios.instance == null){
            MgrControladorUsuarios.instance = new MgrControladorUsuarios();
            MgrControladorUsuarios.instance.controladorColection = Collections.synchronizedMap(new HashMap<Integer,ControladorUsuarios>());
        }
        return MgrControladorUsuarios.instance;
    }
    
    private MgrControladorUsuarios(){
    
    }
    
    public ControladorUsuarios getController(Integer idController) {
        if(controladorColection.containsKey(idController)){
            return controladorColection.get(idController);
        }else{
            ControladorUsuarios newController = new ControladorUsuarios();
            newController.setId(idController);
            controladorColection.put(idController, newController);
            return newController;
        }
    }
    
    public Integer getSiguienteKey(){
        return controladorColection.keySet().size();
    }
}
