package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MgrControladorProductos {
    
    private static MgrControladorProductos instance = null; 
    private Map<Integer,ControladorProductos> controladorColection;
    
    public static MgrControladorProductos getInstance(){
        if(MgrControladorProductos.instance == null){
            MgrControladorProductos.instance = new MgrControladorProductos();
            MgrControladorProductos.instance.controladorColection = new HashMap();
        }
        return MgrControladorProductos.instance;
    }
    
    private MgrControladorProductos(){
    
    }
    
    public ControladorProductos getController(Integer idController) {
        if(controladorColection.containsKey(idController)){
            return controladorColection.get(idController);
        }else{
            ControladorProductos newController = new ControladorProductos();
            newController.setId(idController);
            controladorColection.put(idController, newController);
            return newController;
        }
    }
     
    public Integer getSiguienteKey(){
        return controladorColection.keySet().size();
    }
    
}
