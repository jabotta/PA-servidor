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
public class MgrControladorProductos {
    private static MgrControladorProductos instance = null; 
    private Map<Integer,ControladorProductos> controladorColection;
    
    public static MgrControladorProductos getInstance(){
        
        if(MgrControladorProductos.instance == null){
            
            MgrControladorProductos.instance = new MgrControladorProductos();
            MgrControladorProductos.instance.controladorColection =Collections.synchronizedMap(new HashMap());
           
        }
        return MgrControladorProductos.instance;
    }
    
    private MgrControladorProductos(){
    
    }
     public ControladorProductos getController(Integer idController) {
       
        if(controladorColection.containsKey(idController)){
        
            return controladorColection.get(idController);
        }else{
            ControladorProductos newController =  new ControladorProductos();
            controladorColection.put(idController, newController);
            return newController;
        }
    }
    public Integer getSiguienteKey(){
        return controladorColection.keySet().size();
    }
}
