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
public class ManejadorOrdenes {
    private static ManejadorOrdenes instance = null;
    public static ManejadorOrdenes getInstance(){
        
        if(ManejadorOrdenes.instance == null){
            
            ManejadorOrdenes.instance = new ManejadorOrdenes();
        }
        return ManejadorOrdenes.instance;
    }
    
    private ManejadorOrdenes(){
    
    }
}
