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
import Controlador.Clases.ManejadorUsuarios;
import Controlador.Clases.OrdenCompra;
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
        
        //leer datos de nueva especificacion de autogenerados
        controlarProducto.elegirProveedor("nmar");
        DataProveedor proveedor1 = new DataProveedor(ManejadorUsuarios.getInstance().getProveedor("nmar"));
        DataEspecificacionProducto espProducto1 = new DataEspecificacionProducto("prod1", "Producto 1", "descripcion 1", Collections.synchronizedMap(new HashMap()), (float)23.5, proveedor1, new ArrayList<>(), new ArrayList<>(),Collections.synchronizedMap(new HashMap()));
        controlarProducto.ingresarDatosProductos(espProducto1);
        controlarProducto.ingresarEspecificacion("Color", "Verde");
        controlarProducto.ingresarEspecificacion("Peso", "1kg");
        controlarProducto.ingresarEspecificacion("Altura", "20cm");
        controlarProducto.agregarMultiplesProductosAutogenerados(3);
        controlarProducto.agregarCategoriaAEspecificacion("cat2");
        controlarProducto.agregarImagen("peteco");
        controlarProducto.guardarProducto();
        
        //leer datos de nueva especificacion de IngresarDatosUnidad
        controlarProducto.elegirProveedor("jrod");
        DataProveedor proveedor2 = new DataProveedor(ManejadorUsuarios.getInstance().getProveedor("jrod"));
        DataEspecificacionProducto espProducto2 = new DataEspecificacionProducto("prod2", "Producto 2", "descripcion 2", Collections.synchronizedMap(new HashMap()), (float)12.0, proveedor2, new ArrayList<>(), new ArrayList<>(),Collections.synchronizedMap(new HashMap()));
        controlarProducto.ingresarDatosProductos(espProducto2);
        controlarProducto.ingresarEspecificacion("Color", "Verde");
        controlarProducto.ingresarEspecificacion("Peso", "1kg");
        controlarProducto.ingresarDatosUnidad(new DataProducto(11, "idesp1", espProducto2));
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
        
        //Producto seleccionado
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(2);
        
        //Generar item Orden
        controlarOrden.generarItemOrden();
        
        //Guardar Orden
        DataOrdenCompra dataOrden1 = new DataOrdenCompra(1);
        controlarOrden.guardarOrden(dataOrden1);
        
        //Producto seleccionado
        controlarOrden.elegirProducto(11);
        
        //Generar item Orden
        controlarOrden.generarItemOrden();
        
        //Guardar Orden
        DataOrdenCompra dataOrden2 = new DataOrdenCompra(2);
        controlarOrden.guardarOrden(dataOrden2);
        
        //Listar clientes
        Map<Integer, OrdenCompra> ord = ManejadorOrdenes.getInstance().obtenerOrdenes();
        assertTrue (!isNull (ord.get(1)));
        assertTrue (!isNull (ord.get(2)));
     }
}
