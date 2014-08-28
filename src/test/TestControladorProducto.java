/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.Clases.Fabrica;
import Controlador.Clases.IControladorProductos;
import static Controlador.Clases.Main.controlarProducto;
import static Controlador.Clases.Main.idProductosControlador;
import Controlador.Clases.ManejadorCategorias;
import Controlador.DataTypes.DataCategoria;
import static java.util.Objects.isNull;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author tecnoinf
 */
public class TestControladorProducto {
    
    @Test
    public void AltaDeCategoriaTest () {
        Integer idProductosControlador = Fabrica.getInstance().getControladorProductos(null).getId();
        IControladorProductos controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        
        //Crear categoria sin padre
        DataCategoria categoria = new DataCategoria("cat1", null);
        controlarProducto.ingresarDatosCategoria(categoria);
        
        controlarProducto.guardarCategoria();
        assertTrue(!isNull(ManejadorCategorias.getInstance().obtenerCategorias().get("cat1")));
        
        //Crear con padre cat1
        DataCategoria categoria2 = new DataCategoria("cat2", categoria);
        controlarProducto.ingresarDatosCategoria(categoria2);
        
        controlarProducto.guardarCategoria();
        
        assertTrue(!isNull(ManejadorCategorias.getInstance().obtenerCategorias().get("cat2")));
        assertEquals(ManejadorCategorias.getInstance().obtenerCategorias().get("cat2").getPadre().getNombre(),"cat1");
        
        //agrego otro padre por las dudas
        DataCategoria categoria3 = new DataCategoria("cat3", categoria2);
        controlarProducto.ingresarDatosCategoria(categoria3);
        
        controlarProducto.guardarCategoria();
        
        assertTrue(!isNull(ManejadorCategorias.getInstance().obtenerCategorias().get("cat3")));
        assertEquals(ManejadorCategorias.getInstance().obtenerCategorias().get("cat3").getPadre().getNombre(),"cat2");
        
    }
     
    
}
