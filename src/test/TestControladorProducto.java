/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.Clases.Fabrica;
import Controlador.Clases.IControladorProductos;
import Controlador.Clases.IControladorUsuarios;
import Controlador.Clases.ManejadorCategorias;
import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import static java.util.Objects.isNull;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author mauro
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
    
    @Test
    public void TestRegistrarProducto () {
        
        Integer idProductosControlador = Fabrica.getInstance().getControladorProductos(null).getId();
        IControladorProductos controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        Integer idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
        IControladorUsuarios controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        
        DataProveedor proveedor1 = new DataProveedor ("pperez", "Pedro", "Perez", "perez@gmail.com", new Date(1990, 03, 02), "Pcel", "www.pcel.com");
        controlarUsuario.ingresarDatosProveedor(proveedor1);
        controlarUsuario.guardarUsuario();      
        DataEspecificacionProducto espProducto = new DataEspecificacionProducto("nroref1", "prod1", "nuevo", Collections.synchronizedMap(new HashMap()), (float)2500.0, proveedor1, new ArrayList<String>(), new ArrayList<DataCategoria>(),Collections.synchronizedMap(new HashMap())); 
        
        //Crear producto id=1 y especificacion espProducto
        DataProducto producto1 = new DataProducto ( 1 , "idSpec",  espProducto );
        
        controlarProducto.ingresarDatosProductos(espProducto);
        controlarProducto.elegirProveedor("pperez");
        controlarProducto.ingresarEspecificacion("estado", "nuevo");
        controlarProducto.ingresarEspecificacion("color", "gris");
        controlarProducto.ingresarEspecificacion("altura", "1 metro");
        DataCategoria categoria = new DataCategoria("cat1", null);
        controlarProducto.ingresarDatosCategoria(categoria); 
        controlarProducto.guardarCategoria();       
        controlarProducto.agregarCategoriaAEspecificacion("cat1");
        controlarProducto.agregarImagen("img1");
        controlarProducto.ingresarDatosUnidad(producto1);
        if(controlarProducto.controlarErrores())
            controlarProducto.guardarProducto();
        
        assertTrue (!isNull(controlarProducto.getId()));
        assertTrue (!isNull(controlarProducto.controlarErrores()));
        assertTrue (!isNull(controlarProducto.elegirTipoProducto()));
        
    }
     
    
}
