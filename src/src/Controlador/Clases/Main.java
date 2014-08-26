package Controlador.Clases;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    
    public static Integer idUsuariosControlador;
    public static Integer idProductosControlador;
    public static Integer idOrdenesControlador;
    public static IControladorOrdenes controlarOrden;
    
    public static void main(String args[]) {
//        Map<Integer,String> s = Collections.synchronizedMap(new HashMap());
//        s.put(1, "s");
//        s.put(1, "t");
//        s.put(2, "s");
//        s.put(3, "s");
//        System.out.println(s);
        try {
            idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
            idProductosControlador = Fabrica.getInstance().getControladorProductos(null).getId();
            idOrdenesControlador = Fabrica.getInstance().getControladorOrdenes(null).getId();
        } catch (Exception e) {
            Writer writer = new StringWriter(); PrintWriter printWriter = new PrintWriter(writer); e.printStackTrace(printWriter); String s = writer.toString();
            System.out.println(s);
        }
        
        
        controlarOrden = Fabrica.getInstance().getControladorOrdenes(idOrdenesControlador);
//        casoDeUso1();
//        casoDeUso3();
        casoDeUso4(controlarOrden);
    }
    
//    public static void casoDeUso1(){
//        System.out.println("**************************** Registrar Usuario ****************************");
//        
//        String tipoUsuario;
//        Scanner eTipoUsuario = new Scanner (System.in); 
//        tipoUsuario = eTipoUsuario.nextLine ();
//        
//        switch (tipoUsuario) {
//            case "c":
//                Map<String,Cliente> clientes = Collections.synchronizedMap(new HashMap());
//                clientes.put("abotta", new Cliente("abotta", "Andres", "Botta", "abotta@mail.com", new Date(1987, 02, 22)));
//                clientes.entrySet().stream().map((cliente) -> cliente.getValue()).forEach((valor) -> {
//                    System.out.println(valor);
//                }); 
//            break;
//            case "p":
//                Map<String,Proveedor> proveedores = Collections.synchronizedMap(new HashMap());
//                proveedores.put("prov1", new Proveedor("prov1", "Proveedor 1", "", "prov1@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
//                proveedores.entrySet().stream().map((proveedor) -> proveedor.getValue()).forEach((valor) -> {
//                    System.out.println(valor);
//                }); 
//            break;
//        }
//    }
//    
//    public static void casoDeUso3(){
//        System.out.println("**************************** Alta de categoría ****************************");
//        
//        Map<String,Categoria> categorias = Collections.synchronizedMap(new HashMap());
//        categorias.put("cat1", new Categoria("cat1", null));
//        
//        categorias.entrySet().stream().map((categoria) -> categoria.getValue()).forEach((valor) -> {
//            System.out.println(valor);
//        });
//    }
    
    public static void casoDeUso4(IControladorOrdenes controlarOrden){
//        System.out.println("*************************** Clientes ***************************");
        ManejadorUsuarios.getInstance().agregarUsuario("abotta", new Cliente("abotta", "Andres", "Botta", "abotta@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario("dlevy", new Cliente("dlevy", "Dario", "Levy", "dlevy@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario("rrossi", new Cliente("rrossi", "Rodrigo", "Rossi", "rrossi@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario("ldeniz", new Cliente("ldeniz", "Leroy", "Deniz", "ldeniz@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario("mbergalli", new Cliente("mbergalli", "Mauro", "Bergalli", "mbergalli@mail.com", new Date(1987, 02, 22)));

//        ManejadorUsuarios.getInstance().obtenerUsuarios().entrySet().stream().map((cliente) -> cliente.getValue()).forEach((valor) -> {
//            System.out.println(valor);
//        });
        
//        System.out.println("************************** Proveedores **************************");
        ManejadorUsuarios.getInstance().agregarUsuario("prov1", new Proveedor("prov1", "Proveedor 1", "", "prov1@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        ManejadorUsuarios.getInstance().agregarUsuario("prov2", new Proveedor("prov2", "Proveedor 2", "", "prov2@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        ManejadorUsuarios.getInstance().agregarUsuario("prov3", new Proveedor("prov3", "Proveedor 3", "", "prov3@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        
//        ManejadorUsuarios.getInstance().obtenerUsuarios().entrySet().stream().map((proveedor) -> proveedor.getValue()).forEach((valor) -> {
//            System.out.println(valor);
//        });
        
//        System.out.println("************************** Categorias **************************");
        ManejadorCategorias.getInstance().agregarCategoria("cat1", new Categoria("cat1", null));
        ManejadorCategorias.getInstance().agregarCategoria("cat2", new Categoria("cat2", null));
        ManejadorCategorias.getInstance().agregarCategoria("cat3", new Categoria("cat3", null));
        ManejadorCategorias.getInstance().agregarCategoria("cat4", new Categoria("cat4", null));
        ManejadorCategorias.getInstance().agregarCategoria("cat5", new Categoria("cat5", null));
        
//        ManejadorCategorias.getInstance().obtenerCategorias().entrySet().stream().map((categoria) -> categoria.getValue()).forEach((valor) -> {
//            System.out.println(valor);
//        });
        
//        System.out.println("******************* Especificacion Productos *******************");
        ArrayList<Categoria> cat1 = new ArrayList<>();
        cat1.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat1"));
        cat1.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat5"));
        ArrayList<String> esp1 = new ArrayList<>();
        esp1.add("Espacificacion 1");
        esp1.add("Espacificacion 2");
        Proveedor prov1 = (Proveedor) ManejadorUsuarios.getInstance().obtenerUsuarios().get("prov1");
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto("a1", new EspecificacionProducto("a1", "Iphone", "Lindo y de alta gama", esp1, (float) 10.5, prov1, cat1));
                
        ArrayList<Categoria> cat2 = new ArrayList<>();
        cat2.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat1"));
        cat2.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat3"));
        ArrayList<String> esp2 = new ArrayList<>();
        esp2.add("Espacificacion 1");
        Proveedor prov2 = (Proveedor) ManejadorUsuarios.getInstance().obtenerUsuarios().get("prov2");
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto("a2", new EspecificacionProducto("a2", "Samsung Galaxy", "Lindo, grande y de alta gama", esp2, (float) 8.5, prov2, cat2));
        
        ArrayList<Categoria> cat3 = new ArrayList<>();
        cat3.add(ManejadorCategorias.getInstance().obtenerCategorias().get("cat4"));
        ArrayList<String> esp3 = new ArrayList<>();
        esp3.add("Espacificacion 1");
        Proveedor prov3 = (Proveedor) ManejadorUsuarios.getInstance().obtenerUsuarios().get("prov3");
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto("a3", new EspecificacionProducto("a3", "Sony Vaio", "Buena pc", esp3, (float) 15.5, prov3, cat3));

//        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().entrySet().stream().map((espProducto) -> espProducto.getValue()).forEach((valor) -> {
//            System.out.println(valor);
//        });
        
//        System.out.println("************************** Productos **************************");
        ManejadorProductos.getInstance().agregarProducto(1, new Producto(1, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        ManejadorProductos.getInstance().agregarProducto(2, new Producto(2, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        ManejadorProductos.getInstance().agregarProducto(3, new Producto(3, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        ManejadorProductos.getInstance().agregarProducto(4, new Producto(4, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2")));
        ManejadorProductos.getInstance().agregarProducto(5, new Producto(5, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2")));
        ManejadorProductos.getInstance().agregarProducto(6, new Producto(6, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a3")));
        
//        ManejadorProductos.getInstance().obtenerProductos().entrySet().stream().map((producto) -> producto.getValue()).forEach((valor) -> {
//            System.out.println(valor);
//        });
        
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
        
        //HAY Q VER ESTO SI SE AGREGA DE A UNO LOS PRODUCTOS O SE AGREGAN TODOS JUNTOS PQ CAMBIARIA EL
        //GENERAR ITEM ORDEN. HABLARLO CON ANDRES Q ENTIENDE
        //Especificacion Producto seleccionado
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(3);
        //Generar item Orden
        controlarOrden.generarItemOrden();
        //HASTA ACA VA LA CONSULTA
        
        //Guardar Orden
        controlarOrden.guardarOrden();
        
        System.out.println("Orden de Compra: ");
        System.out.println(ManejadorOrdenes.getInstance().obtenerOrdenes().get(1));
    }
    
}
