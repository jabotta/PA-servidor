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
public class ManejadorEspProductos {
    
    private static ManejadorEspProductos instance = null;
    public static ManejadorEspProductos getInstance(){
        
        if(ManejadorEspProductos.instance == null){
            
            ManejadorEspProductos.instance = new ManejadorEspProductos();
        }
        return ManejadorEspProductos.instance;
    }
    
    private ManejadorEspProductos(){
    
    }
    
}
