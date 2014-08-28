/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.Clases.Categoria;
import Controlador.Clases.Cliente;
import Controlador.Clases.ClienteCompraProducto;
import Controlador.Clases.ControladorOrdenes;
import Controlador.Clases.EspecificacionProducto;
import Controlador.Clases.OrdenCompra;
import Controlador.Clases.Producto;
import Controlador.Clases.Proveedor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
       // Generar environment
/*        
        Map<String,Proveedor> proveedores = Collections.synchronizedMap(new HashMap());
        System.out.println("************************** Proveedores **************************");
        proveedores.put("prov1", new Proveedor("prov1", "Proveedor 1", "", "prov1@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        proveedores.put("prov2", new Proveedor("prov2", "Proveedor 2", "", "prov2@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        proveedores.put("prov3", new Proveedor("prov3", "Proveedor 3", "", "prov3@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));

        proveedores.entrySet().stream().map((proveedor) -> proveedor.getValue()).forEach((valor) -> {
            System.out.println(valor);
        });
        
        Map<String,Categoria> categorias = Collections.synchronizedMap(new HashMap());
        System.out.println("************************** Categorias **************************");
        categorias.put("cat1", new Categoria("cat1", null));
        categorias.put("cat2", new Categoria("cat2", null));
        categorias.put("cat3", new Categoria("cat3", null));
        categorias.put("cat4", new Categoria("cat4", null));
        categorias.put("cat5", new Categoria("cat5", null));
        
        categorias.entrySet().stream().map((categoria) -> categoria.getValue()).forEach((valor) -> {
            System.out.println(valor);
        });
        
        Map<String,EspecificacionProducto> espProductos = Collections.synchronizedMap(new HashMap());
        System.out.println("******************* Especificacion Productos *******************");
        ArrayList<Categoria> cat1 = new ArrayList<>();
        cat1.add(categorias.get("cat1"));
        cat1.add(categorias.get("cat5"));
        ArrayList<String> esp1 = new ArrayList<>();
        esp1.add("Espacificacion 1");
        esp1.add("Espacificacion 2");
        espProductos.put("a1", new EspecificacionProducto("a1", "Iphone", "Lindo y de alta gama", esp1, (float) 10.5, proveedores.get("prov1"), cat1));

        ArrayList<Categoria> cat2 = new ArrayList<>();
        cat2.add(categorias.get("cat1"));
        cat2.add(categorias.get("cat3"));
        ArrayList<String> esp2 = new ArrayList<>();
        esp2.add("Espacificacion 1");
        espProductos.put("a2", new EspecificacionProducto("a2", "Samsung Galaxy", "Lindo, grande y de alta gama", esp2, (float) 8.5, proveedores.get("prov2"), cat2));
        
        ArrayList<Categoria> cat3 = new ArrayList<>();
        cat3.add(categorias.get("cat4"));
        ArrayList<String> esp3 = new ArrayList<>();
        esp3.add("Espacificacion 1");
        espProductos.put("a3", new EspecificacionProducto("a3", "Sony Vaio", "Buena pc", esp3, (float) 15.5, proveedores.get("prov3"), cat3));
        
        espProductos.entrySet().stream().map((espProducto) -> espProducto.getValue()).forEach((valor) -> {
            System.out.println(valor);
        });
        
        Map<Integer,Producto> productos = Collections.synchronizedMap(new HashMap());
        System.out.println("************************** Productos **************************");
        productos.put(1, new Producto(1, espProductos.get("a1")));
        productos.put(2, new Producto(2, espProductos.get("a1")));
        productos.put(3, new Producto(3, espProductos.get("a1")));
        productos.put(4, new Producto(4, espProductos.get("a2")));
        productos.put(5, new Producto(5, espProductos.get("a2")));
        productos.put(6, new Producto(6, espProductos.get("a3")));
        
        productos.entrySet().stream().map((producto) -> producto.getValue()).forEach((valor) -> {
            System.out.println(valor);
        });
        
        Map<String,Cliente> clientes = Collections.synchronizedMap(new HashMap());
        System.out.println("*************************** Clientes ***************************");
        clientes.put("abotta", new Cliente("abotta", "Andres", "Botta", "abotta@mail.com", new Date(1987, 02, 22)));
        clientes.put("dlevy", new Cliente("dlevy", "Dario", "Levy", "dlevy@mail.com", new Date(1987, 02, 22)));
        clientes.put("rrossi", new Cliente("rrossi", "Rodrigo", "Rossi", "rrossi@mail.com", new Date(1987, 02, 22)));
        clientes.put("ldeniz", new Cliente("ldeniz", "Leroy", "Deniz", "ldeniz@mail.com", new Date(1987, 02, 22)));
        clientes.put("mbergalli", new Cliente("mbergalli", "Mauro", "Bergalli", "mbergalli@mail.com", new Date(1987, 02, 22)));
        
        //        for(Map.Entry<String, Cliente> cliente : clientes.entrySet()){
//            System.out.println(cliente.getValue().toString());
//        }
        clientes.entrySet().stream().map((cliente) -> cliente.getValue()).forEach((valor) -> {
            System.out.println(valor);
        });
        
        System.out.println("**************************** Inicio ****************************");
        System.out.println("Cliente Seleccionado: ");
        Cliente cliSeleccionado = clientes.get("abotta");
        System.out.println(cliSeleccionado);
        
        System.out.println("Categoria seleccionada: ");
        Categoria categoriaSeleccionada = categorias.get("cat1");
        System.out.println(categoriaSeleccionada);
        
        System.out.println("Listar esp de productos de la categoria seleccionada: ");
        espProductos.entrySet().stream().map((espProducto) -> espProducto.getValue()).forEach((valor) -> {
            if(valor.getCategorias().contains(categoriaSeleccionada)){
                System.out.println(valor);
            }
        });
        
        System.out.println("Esp Producto seleccionado: ");
        EspecificacionProducto espProductoSeleccionado = espProductos.get("a1");
        System.out.println(espProductoSeleccionado);
        
        System.out.println("Listar productos de la especificacion seleccionada: ");
        productos.entrySet().stream().map((producto) -> producto.getValue()).forEach((valor) -> {
            if(valor.getEspecificacionProducto() == espProductoSeleccionado){
                System.out.println(valor);
            }
        });
        
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        productosSeleccionados.add(productos.get(1));
        productosSeleccionados.add(productos.get(3));
        
        System.out.println("Producto seleccionado: ");
        productosSeleccionados.stream().forEach((productoSeleccionado) -> {
            System.out.println(productoSeleccionado);
        });
        
        ArrayList<ClienteCompraProducto> cliComProds = new ArrayList<>();
        productosSeleccionados.stream().forEach((productoSeleccionado) -> {
            cliComProds.add(new ClienteCompraProducto(cliSeleccionado, productoSeleccionado, espProductoSeleccionado.getPrecio()));
        });
        
        System.out.println("Cliente Compra Productos seleccionado: ");
        cliComProds.stream().forEach((cliComProd) -> {
            System.out.println(cliComProd);
        });
        
        OrdenCompra ordenCompra = new OrdenCompra(1, new Date(), cliComProds);
        
        System.out.println("Orden de Compra: ");
        System.out.println(ordenCompra);
       // MyClass is tested
       ControladorOrdenes tester = new ControladorOrdenes();
       assertTrue(false);

       // Tests*/
     }
}
