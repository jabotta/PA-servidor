package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProveedor;
import Controlador.DataTypes.DataUsuario;
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

        ArrayList<Categoria> cat1 = new ArrayList<>();
        cat1.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat1"));
        cat1.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat5"));
        Map<String,String> esp1 = Collections.synchronizedMap(new HashMap());
        esp1.put("Esp1","Espacificacion 1");
        esp1.put("Esp1","Espacificacion 2");
        Proveedor prov1 = (Proveedor) ManejadorUsuarios.getInstance().obtenerUsuarios().get("prov1");
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(new EspecificacionProducto("a1", "Iphone", "Lindo y de alta gama", esp1, (float) 10.5, prov1, cat1));
                
        ArrayList<Categoria> cat2 = new ArrayList<>();
        cat2.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat1"));
        cat2.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat3"));
        Map<String,String> esp2 = Collections.synchronizedMap(new HashMap());
        esp2.put("Esp1","Espacificacion 1");
        Proveedor prov2 = (Proveedor) ManejadorUsuarios.getInstance().obtenerUsuarios().get("prov2");
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(new EspecificacionProducto("a2", "Samsung Galaxy", "Lindo, grande y de alta gama", esp2, (float) 8.5, prov2, cat2));
        
        ArrayList<Categoria> cat3 = new ArrayList<>();
        cat3.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat4"));
        Map<String,String> esp3 = Collections.synchronizedMap(new HashMap());
        esp3.put("Esp1","Espacificacion 1");
        Proveedor prov3 = (Proveedor) ManejadorUsuarios.getInstance().obtenerUsuarios().get("prov3");
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(new EspecificacionProducto("a3", "Sony Vaio", "Buena pc", esp3, (float) 15.5, prov3, cat3));

        ManejadorProductos.getInstance().agregarProducto(new Producto(1, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(2, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(3, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(4, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(5, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(6, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a3")));
           
        controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        controlarOrden = Fabrica.getInstance().getControladorOrdenes(idOrdenesControlador);
        
//        casoDeUso1(controlarUsuario);
//        casoDeUso2(controlarProducto);
//        casoDeUso3(controlarProducto);
//        casoDeUso4(controlarOrden);
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
        DataEspecificacionProducto espProducto = new DataEspecificacionProducto("prod1", "Producto a", "descripcion 1", Collections.synchronizedMap(new HashMap()), (float)12.0,controlarProducto.listarProveedores().get(0), new ArrayList<String>(), new ArrayList<DataCategoria>());
        controlarProducto.ingresarDatosProductos(espProducto);
    }
    
    public static void casoDeUso3(IControladorProductos controlarProducto){
        System.out.println("**************************** Alta de categoría ****************************");
        
        String tienePadre;
        Scanner eTienePadre = new Scanner (System.in);
        System.out.println("tiene padre? (s o n)");
        tienePadre = eTienePadre.nextLine();
        
        DataCategoria categoria = new DataCategoria("cat6", null);
        controlarProducto.ingresarDatosCategoria(categoria);
        
        switch (tienePadre) {
            case "s":
                DataCategoria categoriaPadre = new DataCategoria(ManejadorCategorias.getInstance().obtenerCategorias().get("cat4"));
                controlarProducto.asociarCategoriaPadre(categoriaPadre);
            break;
        }
        
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
        controlarOrden.listarProductos().stream().forEach((producto) -> {
            System.out.println(producto);
        });
        
        //Especificacion Producto seleccionado
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(3);
        
        //Generar item Orden
        controlarOrden.generarItemOrden();
        
        //Guardar Orden
        controlarOrden.guardarOrden();
        
        System.out.println("Orden de Compra: ");
        System.out.println(ManejadorOrdenes.getInstance().obtenerOrdenes().get(1));
    }

    
}
