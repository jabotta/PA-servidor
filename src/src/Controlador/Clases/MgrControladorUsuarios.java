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
public class MgrControladorUsuarios {
    private static MgrControladorUsuarios instance = null;
    public static MgrControladorUsuarios getInstance(){
        
        if(MgrControladorUsuarios.instance == null){
            
            MgrControladorUsuarios.instance = new MgrControladorUsuarios();
        }
        return MgrControladorUsuarios.instance;
    }
    
    private MgrControladorUsuarios(){
    
    }
}
