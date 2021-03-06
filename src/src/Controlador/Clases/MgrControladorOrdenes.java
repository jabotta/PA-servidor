package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MgrControladorOrdenes {
    
    private static MgrControladorOrdenes instance = null;
    private Map<Integer,ControladorOrdenes> controladorColection;
    
    public static MgrControladorOrdenes getInstance(){
        if(MgrControladorOrdenes.instance == null){
            MgrControladorOrdenes.instance = new MgrControladorOrdenes();
            MgrControladorOrdenes.instance.controladorColection = new HashMap();
        }
        return MgrControladorOrdenes.instance;
    }
    
    private MgrControladorOrdenes(){
    
    }

    public ControladorOrdenes getController(Integer idController) {
        if(controladorColection.containsKey(idController)){
            return controladorColection.get(idController);
        }else{
            ControladorOrdenes newController = new ControladorOrdenes();
            newController.setId(idController);
            controladorColection.put(idController, newController);
            return newController;
        }
    }
    
    public Integer getSiguienteKey(){
        return controladorColection.keySet().size();
    }
    
}
