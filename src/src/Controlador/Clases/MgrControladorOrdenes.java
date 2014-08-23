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
public class MgrControladorOrdenes {
    private static MgrControladorOrdenes instance = null;
    public static MgrControladorOrdenes getInstance(){
        
        if(MgrControladorOrdenes.instance == null){
            
            MgrControladorOrdenes.instance = new MgrControladorOrdenes();
        }
        return MgrControladorOrdenes.instance;
    }
    
    private MgrControladorOrdenes(){
    
    }
}
