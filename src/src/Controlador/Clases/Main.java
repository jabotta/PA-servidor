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
        
        Utils.generarDatosDePrueba();
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
        DataEspecificacionProducto espProducto = new DataEspecificacionProducto("prod1", "Producto a", "descripcion 1", Collections.synchronizedMap(new HashMap()), (float)12.0,controlarProducto.listarProveedores().get(0), new ArrayList<String>(), new ArrayList<DataCategoria>(),Collections.synchronizedMap(new HashMap()));
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
        controlarOrden.listarProductos().stream().forEach((producto) -> {
            System.out.println(producto);
        });
        
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
