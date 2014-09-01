package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    public static Integer idUsuariosControlador;
    public static Integer idProductosControlador;
    public static Integer idOrdenesControlador;
    public static IControladorUsuarios controlarUsuario;
    public static IControladorProductos controlarProducto;
    public static IControladorOrdenes controlarOrden;
    
    public static void main(String args[]) {
        
        try {
            idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
            idProductosControlador = Fabrica.getInstance().getControladorProductos(null).getId();
            idOrdenesControlador = Fabrica.getInstance().getControladorOrdenes(null).getId();
        } catch (Exception e) {
            Writer writer = new StringWriter(); PrintWriter printWriter = new PrintWriter(writer); e.printStackTrace(printWriter); String s = writer.toString();
            System.out.println(s);
        }
        
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("abotta", "Andres", "Botta", "abotta@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("dlevy", "Dario", "Levy", "dlevy@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("rrossi", "Rodrigo", "Rossi", "rrossi@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("ldeniz", "Leroy", "Deniz", "ldeniz@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("mbergalli", "Mauro", "Bergalli", "mbergalli@mail.com", new Date(1987, 02, 22)));

        ManejadorUsuarios.getInstance().agregarUsuario(new Proveedor("prov1", "Proveedor 1", "", "prov1@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        ManejadorUsuarios.getInstance().agregarUsuario(new Proveedor("prov2", "Proveedor 2", "", "prov2@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        ManejadorUsuarios.getInstance().agregarUsuario(new Proveedor("prov3", "Proveedor 3", "", "prov3@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));

        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat1", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat2", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat3", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat4", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat5", null));

        Map<String,Categoria> cat1 = Collections.synchronizedMap(new HashMap());
        cat1.put("cat1",ManejadorCategorias.getInstance().getCategoria("cat1"));
        cat1.put("cat5",ManejadorCategorias.getInstance().getCategoria("cat5"));
        Map<String,String> esp1 = Collections.synchronizedMap(new HashMap());
        esp1.put("Esp1","Espacificacion 1");
        esp1.put("Esp1","Espacificacion 2");
        Proveedor prov1 = ManejadorUsuarios.getInstance().getProveedor("prov1");
        Map<Integer,Producto> prod1 = Collections.synchronizedMap(new HashMap());
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(new EspecificacionProducto("a1", "Iphone", "Lindo y de alta gama", esp1, (float) 10.5, prov1, cat1,prod1));
        
        prod1.put(0,new Producto(0, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        prod1.put(1,new Producto(1, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1").setListaProductos(prod1);
        
        Map<String,Categoria> cat2 = Collections.synchronizedMap(new HashMap());
        cat2.put("cat1",ManejadorCategorias.getInstance().getCategoria("cat1"));
        cat2.put("cat3",ManejadorCategorias.getInstance().getCategoria("cat3"));
        Map<String,String> esp2 = Collections.synchronizedMap(new HashMap());
        esp2.put("Esp1","Espacificacion 1");
        Proveedor prov2 = ManejadorUsuarios.getInstance().getProveedor("prov2");
        Map<Integer,Producto> prod2 = Collections.synchronizedMap(new HashMap());
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(new EspecificacionProducto("a2", "Samsung Galaxy", "Lindo, grande y de alta gama", esp2, (float) 8.5, prov2, cat2,prod2));
        prod2.put(2,new Producto(2, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2")));
        prod2.put(3,new Producto(3, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2")));
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2").setListaProductos(prod2);
        
        Map<String,Categoria> cat3 = Collections.synchronizedMap(new HashMap());
        cat3.put("cat4",ManejadorCategorias.getInstance().getCategoria("cat4"));
        Map<String,String> esp3 = Collections.synchronizedMap(new HashMap());
        esp3.put("Esp1","Espacificacion 1");
        Proveedor prov3 = ManejadorUsuarios.getInstance().getProveedor("prov3");
        Map<Integer,Producto> prod3 = Collections.synchronizedMap(new HashMap());
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(new EspecificacionProducto("a3", "Sony Vaio", "Buena pc", esp3, (float) 15.5, prov3, cat3,prod3));
        prod3.put(2,new Producto(4, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a3")));
        prod3.put(3,new Producto(5, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a3")));
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a3").setListaProductos(prod3);
        
        ManejadorProductos.getInstance().agregarProducto(new Producto(1, ManejadorEspProductos.getInstance().getEspecificacionProducto("a1")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(2, ManejadorEspProductos.getInstance().getEspecificacionProducto("a1")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(3, ManejadorEspProductos.getInstance().getEspecificacionProducto("a1")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(4, ManejadorEspProductos.getInstance().getEspecificacionProducto("a2")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(5, ManejadorEspProductos.getInstance().getEspecificacionProducto("a2")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(6, ManejadorEspProductos.getInstance().getEspecificacionProducto("a3")));
           
        controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        controlarOrden = Fabrica.getInstance().getControladorOrdenes(idOrdenesControlador);
        
        casoDeUso1(controlarUsuario);
        casoDeUso2(controlarProducto);
        casoDeUso3(controlarProducto);
        casoDeUso4(controlarOrden);
        casoDeUso5(controlarUsuario);
        casoDeUso6(controlarUsuario);
        casoDeUso7(controlarProducto);
        casoDeUso8(controlarProducto);
        casoDeUso9(controlarOrden);
        casoDeUso10(controlarOrden);
    }
    
    public static void casoDeUso1(IControladorUsuarios controlarUsuario){
        System.out.println("**************************** Registrar Usuario ****************************");
        
        String tipoUsuario;
        Scanner eTipoUsuario = new Scanner (System.in); 
        tipoUsuario = eTipoUsuario.nextLine();
        
        switch (tipoUsuario) {
            case "c":                
                DataCliente cliente = new DataCliente("botta", "Jorge", "Susundey", "abotta@mail.com", new Date(1987, 02, 22));
                controlarUsuario.ingresarDatosCliente(cliente);
            break;
            case "p":
                DataProveedor proveedor = new DataProveedor("prov4", "Proveedor 4", "", "prov4@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com");
                controlarUsuario.ingresarDatosProveedor(proveedor);
            break;
        }
        
        if(controlarUsuario.validarDatosUsuario()){
            System.out.println("Ya existe el usuario");
        }else{
            controlarUsuario.guardarUsuario();
        }
    }
    
    public static void casoDeUso2(IControladorProductos controlarProducto){
        System.out.println("**************************** Registrar Producto ****************************");
        
        controlarProducto.listarProveedores().stream().forEach((proveedor) -> {
            System.out.println(proveedor);
        });
        
        String nicknameProveedor = "prov2";//leer el nickname del proveedor elegido
        controlarProducto.elegirProveedor(nicknameProveedor);
        
        //leer datos de nueva especificacion
        DataEspecificacionProducto espProducto = new DataEspecificacionProducto("prod1", "Producto a", "descripcion 1", Collections.synchronizedMap(new HashMap()), (float)12.0,null, new ArrayList<>(), new ArrayList<>(),Collections.synchronizedMap(new HashMap()));
        controlarProducto.ingresarDatosProductos(espProducto);
        controlarProducto.ingresarEspecificacion("Color", "Verde");
        controlarProducto.ingresarEspecificacion("Peso", "1kg");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        controlarProducto.ingresarDatosUnidad(new DataProducto(11,"idesp1",espProducto));
        controlarProducto.listarCategorias();
        controlarProducto.agregarCategoriaAEspecificacion("cat1");
        controlarProducto.agregarImagen("peteco");
        if(controlarProducto.controlarErrores())
            controlarProducto.guardarProducto();
    }
    
    public static void casoDeUso3(IControladorProductos controlarProducto){
        System.out.println("**************************** Alta de categoría ****************************");
        
        DataCategoria padre = new DataCategoria(ManejadorCategorias.getInstance().getCategoria("cat1"), true);
        DataCategoria categoria = new DataCategoria("cat6", padre);
        controlarProducto.ingresarDatosCategoria(categoria);
        controlarProducto.guardarCategoria();
    }
    
    public static void casoDeUso4(IControladorOrdenes controlarOrden){
        System.out.println("**************************** Generar orden de compra ****************************");
        
        //Listar clientes
        controlarOrden.listarClientes().stream().forEach((cliente) -> {
            System.out.println(cliente);
        });

        //Cliente Seleccionado
        controlarOrden.elegirCliente("abotta");
        
        //Listar categorias
        controlarOrden.listarCategorias().stream().forEach((categoria) -> {
            System.out.println(categoria);
        });
        
        //Categoria Seleccionado
        controlarOrden.elegirCategoria("cat1");
        
        //Listar especificaciones de categoria seleccionada
        controlarOrden.listarEspecificacionProductos().stream().forEach((espProducto) -> {
            System.out.println(espProducto);
        });
        
        //Especificacion Producto seleccionado
        controlarOrden.elegirEspecificacionProducto("a1");
        
        //Listar productos de la especificacion seleccionada
        /*controlarOrden.listarProductos().stream().forEach((producto) -> {
            System.out.println(producto);
        });*/
        
        //Producto seleccionado
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(3);
        
        //Generar item Orden
        controlarOrden.generarItemOrden();
        
        //Guardar Orden
        DataOrdenCompra dataOrden = new DataOrdenCompra(1);
        controlarOrden.guardarOrden(dataOrden);
        
        System.out.println("Orden de Compra: ");
        System.out.println(ManejadorOrdenes.getInstance().obtenerOrdenes().get(1));
    }
    
    public static void casoDeUso5(IControladorUsuarios controlarUsuario){
        System.out.println("**************************** Ver informacion del cliente ****************************");
        
        //Listar clientes
        controlarUsuario.listarClientes().stream().forEach((cliente) -> {
            System.out.println(cliente);
        });

        //Cliente Seleccionado
        controlarUsuario.elegirCliente("abotta");
        
        //Mostrar Datos Cliente
        DataCliente dataCliente = controlarUsuario.mostrarDatosCliente();
        System.out.println("Mostrar Datos del cliente: " + dataCliente);
        
        //Listar ordenes del cliente elegido
        controlarUsuario.listarOrdenesCliente().stream().forEach((orden) -> {
            System.out.println(orden);
        });
    }
    
    public static void casoDeUso6(IControladorUsuarios controlarUsuario){
        System.out.println("**************************** Ver informacion del proveedor ****************************");
        
        //Listar proveedores
        controlarUsuario.listarProveedores().stream().forEach((cliente) -> {
            System.out.println(cliente);
        });

        //Proveedor Seleccionado
        controlarUsuario.elegirProveedor("prov1");
        
        //Mostrar Datos Cliente
        DataProveedor dataProveedor = controlarUsuario.mostrarDatosProveedor();
        System.out.println("Mostrar Datos del proveedor: " + dataProveedor);
    }
    
    public static void casoDeUso7(IControladorProductos controlarProducto){
        System.out.println("**************************** Ver informacion del producto ****************************");
        
        //Listar categorias
        controlarProducto.listarCategorias().stream().forEach((categoria) -> {
            System.out.println(categoria);
        });
        
        //Categoria Seleccionado
        controlarProducto.elegirCategoria("cat3");
        
        //Listar productos categoria seleccionada
        controlarProducto.listarProductosCategoria().stream().forEach((producto) -> {
            System.out.println(producto);
        });
        
        //Mostrar Datos Cliente
        DataEspecificacionProducto dataProducto = controlarProducto.mostrarDatosProducto("a3");
        System.out.println("Mostrar Datos del producto: " + dataProducto);
    }
    
    public static void casoDeUso8(IControladorProductos controlarProducto){
        System.out.println("**************************** Modificar datos del Producto ****************************");
        
        //Listar categorias
        controlarProducto.listarCategorias().stream().forEach((categoria) -> {
            System.out.println(categoria);
        });
        
        //Categoria Seleccionado
        controlarProducto.elegirCategoria("cat3");
        
        //Listar productos categoria seleccionada
        controlarProducto.listarProductosCategoria().stream().forEach((producto) -> {
            System.out.println(producto);
        });
        
        controlarProducto.elegirEspProducto("a3");
        DataEspecificacionProducto dataProducto = controlarProducto.mostrarDatosProducto("a3");
        controlarProducto.modificarDatosEspecificacionProducto(dataProducto);
        
        controlarProducto.listarCategoriasAModificar();
        controlarProducto.agregarCategoriaAEspecificacion("cat5");
        controlarProducto.borrarCategoriaAEspecificacion("cat5");
        if(controlarProducto.validarInfo())
            controlarProducto.guardarEspProductoModificado();
    }
    
    public static void casoDeUso9(IControladorOrdenes controlarOrden){
        System.out.println("**************************** Cancelar Orden de Compra ****************************");
        
        //Listar ordenes
        controlarOrden.listarOrdenes().stream().forEach((orden) -> {
            System.out.println(orden);
        });
        
        //Orden Seleccionada
        controlarOrden.elegirOrden(1);
        
        String confirmaEliminar;
        Scanner eConfirmaEliminar = new Scanner (System.in);
        System.out.println("Eliminar? (s o n)");
        confirmaEliminar = eConfirmaEliminar.nextLine();
        
        switch (confirmaEliminar) {
            case "s":
                controlarOrden.borrarOrdenCompra();
            break;
        }
    }
    
    public static void casoDeUso10(IControladorOrdenes controlarOrden){
        System.out.println("**************************** Ver informacion de Orden de Compra ****************************");
        
        //Listar ordenes
        controlarOrden.listarOrdenes().stream().forEach((orden) -> {
            System.out.println(orden);
        });
        
        //Orden Seleccionada
        controlarOrden.elegirOrden(1);
        
        //Mostrar Datos Cliente
        DataOrdenCompra dataOrden = controlarOrden.mostrarDatosOrden();
        System.out.println("Mostrar Datos de la Orden: " + dataOrden);
    }
    
}
