/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.Clases.Fabrica;
import Controlador.Clases.IControladorOrdenes;
import Controlador.Clases.IControladorProductos;
import Controlador.Clases.IControladorUsuarios;
import Controlador.Clases.ManejadorOrdenes;
import Controlador.Clases.ManejadorProductos;
import Controlador.Clases.ManejadorUsuarios;
import Controlador.Clases.OrdenCompra;
import Controlador.Clases.Producto;
import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.isNull;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author darius
 */
public class TestControladorOrdenes {


    
    @Test
    public void GenerarOrdenTest() {
        Integer idOrdenesControlador = Fabrica.getInstance().getControladorOrdenes(null).getId();
        IControladorOrdenes controlarOrden = Fabrica.getInstance().getControladorOrdenes(idOrdenesControlador);
        Integer idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
        IControladorUsuarios controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        Integer idProductosControlador = Fabrica.getInstance().getControladorProductos(null).getId();
        IControladorProductos controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        
        controlarUsuario.ingresarDatosProveedor(new DataProveedor("jrod", "Juan", "Rodriguez", "jrod@gmail.com", new Date(1990, 07, 21),"Juegos", "www.juegos.com"));
        controlarUsuario.guardarUsuario();
        controlarUsuario.ingresarDatosProveedor(new DataProveedor("nmar", "Natalia", "Mar", "nmar@gmail.com", new Date(1994, 03, 05), "Newpc", "www.newpc.com"));
        controlarUsuario.guardarUsuario();
        controlarUsuario.ingresarDatosProveedor(new DataProveedor("sdum", "Sergio", "Dumas", "sdum@gmail.com", new Date(1981, 02, 12),"Insumos", "www.insumos.com"));
        controlarUsuario.guardarUsuario();
             
        controlarUsuario.ingresarDatosCliente(new DataCliente("piedra", "Pedro", "Picapiedra", "ppiedra@gmail.com", new Date(1995, 01, 01)));
        controlarUsuario.guardarUsuario();        
        controlarUsuario.ingresarDatosCliente(new DataCliente("pmar", "Pablo", "Marmol", "pmarmol@gmail.com", new Date(1990, 03, 05)));
        controlarUsuario.guardarUsuario();
        controlarUsuario.ingresarDatosCliente(new DataCliente("loco", "Pajaro", "Loco", "ploco@gmail.com", new Date(1989, 05, 12)));
        controlarUsuario.guardarUsuario(); 
        
        DataCategoria cat1 = new DataCategoria("cat1", null);
        controlarProducto.ingresarDatosCategoria(cat1);
        controlarProducto.guardarCategoria();
        DataCategoria cat2 = new DataCategoria("cat2", null);
        controlarProducto.ingresarDatosCategoria(cat2);
        controlarProducto.guardarCategoria();
        DataCategoria cat3 = new DataCategoria("cat3", null);
        controlarProducto.ingresarDatosCategoria(cat3);
        controlarProducto.guardarCategoria();
        DataCategoria cat4 = new DataCategoria("cat4", null);
        controlarProducto.ingresarDatosCategoria(cat4);
        controlarProducto.guardarCategoria();
        DataCategoria cat5 = new DataCategoria("cat5", null);
        controlarProducto.ingresarDatosCategoria(cat5);
        controlarProducto.guardarCategoria();
        
        //leer datos de nueva especificacion de IngresarDatosUnidad
        controlarProducto.elegirProveedor("jrod");
        DataProveedor proveedor = new DataProveedor(ManejadorUsuarios.getInstance().getProveedor("jrod"));
        DataEspecificacionProducto espProducto = new DataEspecificacionProducto("prod1", "Producto 1", "descripcion 1", Collections.synchronizedMap(new HashMap()), (float)12.0, proveedor, new ArrayList<>(), new ArrayList<>(),Collections.synchronizedMap(new HashMap()));
        controlarProducto.ingresarDatosProductos(espProducto);
        controlarProducto.ingresarEspecificacion("Color", "Verde");
        controlarProducto.ingresarEspecificacion("Peso", "1kg");
        DataProducto prodUnidad = new DataProducto(11, "idesp1", espProducto);
        controlarProducto.ingresarDatosUnidad(prodUnidad);
        controlarProducto.agregarCategoriaAEspecificacion("cat1");
        controlarProducto.agregarImagen("peteco");
        controlarProducto.guardarProducto();
        
        System.out.println("**************************** Generar orden de compra ****************************");
        
        //Cliente Seleccionado
        controlarOrden.elegirCliente("piedra");
        //Categoria Seleccionado
        controlarOrden.elegirCategoria("cat1");
        //Especificacion Producto seleccionado
        controlarOrden.elegirEspecificacionProducto("prod1");
        //Producto seleccionado1
        controlarOrden.elegirProducto(11);
        //Generar item Orden1
        controlarOrden.generarItemOrden();
        //Guardar Orden1
        DataOrdenCompra dataOrden1 = new DataOrdenCompra(1);
        controlarOrden.guardarOrden(dataOrden1);
        
        //Listar clientes
        Map<Integer, OrdenCompra> ord = ManejadorOrdenes.getInstance().obtenerOrdenes();
        System.out.println(ord.get(1).getClienteCompraProducto().get(0).getProducto());
        System.out.println(prodUnidad);
        assertTrue (!isNull (ord.get(1)));
        assertEquals ((long) ord.get(1).getNroOrden(), (long) 1);
//        assertEquals ((double) ord.get(2).getPrecioTotal(), (double) 12.0);
        //prod
        assertEquals (ord.get(1).getClienteCompraProducto().get(0).getProducto().getId(), new Producto(prodUnidad).getId());
        
     }
}
