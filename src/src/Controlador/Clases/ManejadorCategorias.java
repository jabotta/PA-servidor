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
public class ManejadorCategorias {
    
    private static ManejadorCategorias instance = null;
    public static ManejadorCategorias getInstance(){
        
        if(ManejadorCategorias.instance == null){
            
            ManejadorCategorias.instance = new ManejadorCategorias();
        }
        return ManejadorCategorias.instance;
    }
    
    private ManejadorCategorias(){
    
    }
}
