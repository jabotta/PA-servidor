/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador.DataTypes;

import Controlador.Clases.Categoria;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 *
 * @author rodro
 */
public class DataCategoria {
    private String nombre;
    private Bool tieneProductos;

    public DataCategoria(Categoria c) {
       
    }
    public DataCategoria(String nombre, Bool tieneProductos) {
        this.nombre = nombre;
        this.tieneProductos = tieneProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Bool getTieneProductos() {
        return tieneProductos;
    }

    public void setTieneProductos(Bool tieneProductos) {
        this.tieneProductos = tieneProductos;
    }
}
