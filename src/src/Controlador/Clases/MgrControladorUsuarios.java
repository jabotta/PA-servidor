/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rodro
 */
public class MgrControladorUsuarios {
    private static MgrControladorUsuarios instance = null; 
    private Map<Integer,ControladorUsuarios> controladorColection;
    
    public static MgrControladorUsuarios getInstance(){
        
        if(MgrControladorUsuarios.instance == null){
            
            MgrControladorUsuarios.instance = new MgrControladorUsuarios();
            MgrControladorUsuarios.instance.controladorColection =Collections.synchronizedMap(new HashMap());
           
        }
        return MgrControladorUsuarios.instance;
    }
    
    private MgrControladorUsuarios(){
    
    }
     public ControladorUsuarios getController(Integer idController) {
       
        if(controladorColection.containsKey(idController)){
        
            return controladorColection.get(idController);
        }else{
            ControladorUsuarios newController =  new ControladorUsuarios();
            controladorColection.put(idController, newController);
            return newController;
        }
    }
    public Integer getSiguienteKey(){
        return controladorColection.keySet().size();
    }
}
