/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.Clases;

/**
 *
 * @author rodro
 */
public class ManejadorUsuarios {
     private static ManejadorUsuarios instance = null;
    public static ManejadorUsuarios getInstance(){
        
        if(ManejadorUsuarios.instance == null){
            
            ManejadorUsuarios.instance = new ManejadorUsuarios();
        }
        return ManejadorUsuarios.instance;
    }
    
    private ManejadorUsuarios(){
    
    }
}
