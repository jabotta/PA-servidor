/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.Clases;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 *
 * @author rodro
 */
public class Categoria {
    private String nombre;
    private Bool tieneProductos;

    public Categoria(String nombre, Bool tieneProductos) {
        this.nombre = nombre;
        this.tieneProductos = tieneProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public Bool getTieneProductos() {
        return tieneProductos;
    }
    
}
