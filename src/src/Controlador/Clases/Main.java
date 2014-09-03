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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Writer writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            String s = writer.toString();
            System.out.println(s);
        }

        controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        controlarOrden = Fabrica.getInstance().getControladorOrdenes(idOrdenesControlador);

        Proveedor p1 = new Proveedor("Tim1", "Tim", "Cook", "tim.cook@apple.com", new Date(1960, 11, 1), "Apple", " http://www.apple.com");
        Proveedor p2 = new Proveedor("Eddy", "Eduardo", "Cue", "eddy.cue@samsung.com", new Date(1965, 9, 2), "Samsung", "http://www.samsung.com");
        Proveedor p3 = new Proveedor("CraigX", "Craig", "Federighi", "craig.feder@sony.com", new Date(1970, 5, 4), "Sony", "http://us.playstation.com");
        Proveedor p4 = new Proveedor("Johnny", "Jonathan", "Ive", "johnny.ive@outlook.com", new Date(1967, 2, 12), "Microsoft", "http://www.xbox.com");
        Proveedor p5 = new Proveedor("OpenPeter", "Peter", "Oppenhemier", "peter.open@htc.com", new Date(1963, 8, 5), "HTC", "http://www.htc.com");

        Cliente c1 = new Cliente("Dan", "Daniel", "Riccio", "dan.riccio@gmail.com", new Date(1963, 7, 5));
        Cliente c2 = new Cliente("Phill", "Philip", "Schiller", "phil.schiller@gmail.com", new Date(1961, 10, 7));
        Cliente c3 = new Cliente("BruceS", "Bruce", "Sewell", "bruce.sewell@gmail.com", new Date(1959, 12, 3));
        Cliente c4 = new Cliente("JeffW", "Jeff", "Wiliams", "jeff.williams@gmail.com", new Date(1964, 11, 27));

        p1.setImagenes("/home/tecnoinf/Escritorio/imag/cook.jpg");
        p2.setImagenes("/home/tecnoinf/Escritorio/imag/cue.jpg");
        p3.setImagenes("/home/tecnoinf/Escritorio/imag/federighi.jpg");
        p4.setImagenes("/home/tecnoinf/Escritorio/imag/ive.jpg");
        c2.setImagenes("/home/tecnoinf/Escritorio/imag/schiller.jpg");

        ManejadorUsuarios.getInstance().agregarUsuario(p1);
        ManejadorUsuarios.getInstance().agregarUsuario(p2);
        ManejadorUsuarios.getInstance().agregarUsuario(p3);
        ManejadorUsuarios.getInstance().agregarUsuario(p4);
        ManejadorUsuarios.getInstance().agregarUsuario(p5);

        ManejadorUsuarios.getInstance().agregarUsuario(c1);
        ManejadorUsuarios.getInstance().agregarUsuario(c2);
        ManejadorUsuarios.getInstance().agregarUsuario(c3);
        ManejadorUsuarios.getInstance().agregarUsuario(c4);

        /*Categorias*/
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Celulares", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Sistemas Operativos", ManejadorCategorias.getInstance().getCategoria("Celulares")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("iOS", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Android", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Windows Phone", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Symbian", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Blackberry OS", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Equipos", ManejadorCategorias.getInstance().getCategoria("Celulares")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("iPhone", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Nexus", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Samsung", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Galaxy S3", ManejadorCategorias.getInstance().getCategoria("Samsung")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Galaxy S4", ManejadorCategorias.getInstance().getCategoria("Samsung")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Galaxy Ace", ManejadorCategorias.getInstance().getCategoria("Samsung")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Blackberry", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Nokia", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Accesorios", ManejadorCategorias.getInstance().getCategoria("Celulares")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Protectores", ManejadorCategorias.getInstance().getCategoria("Accesorios")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Baterías", ManejadorCategorias.getInstance().getCategoria("Accesorios")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Apple", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Videojuegos", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Playstation", ManejadorCategorias.getInstance().getCategoria("Videojuegos")));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Xbox", ManejadorCategorias.getInstance().getCategoria("Videojuegos")));
        /**
         * productos*
         */
        
        Map<String,String> esp3= Collections.synchronizedMap(new HashMap());
    Map<Integer, Producto> prod3 = Collections.synchronizedMap(new HashMap());
    Map<String, Categoria> cat1 = Collections.synchronizedMap(new HashMap());

    cat1.put (

    "iPhone",ManejadorCategorias.getInstance().getCategoria("iPhone"));
	cat1.put (

    "iOS",ManejadorCategorias.getInstance().getCategoria("iOS"));
	cat1.put ("Apple",ManejadorCategorias.getInstance().getCategoria("Apple"));
        
        EspecificacionProducto pr1 = new EspecificacionProducto("IPH5", "iPhone 5", "El último celular de Apple", esp3, (float) 199.0, p1, cat1, prod3); 
controlarProducto.elegirEspProducto (
    "IPH5");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put (

    "iPhone",ManejadorCategorias.getInstance().getCategoria("iPhone"));
	cat1.put (

    "iOS",ManejadorCategorias.getInstance().getCategoria("iOS"));
	cat1.put (
    "Apple",ManejadorCategorias.getInstance().getCategoria("Apple"));
EspecificacionProducto pr2 = new EspecificacionProducto("IPH4", "iPhone 4S", "El siguiente celular al iPhone 4", esp3, (float) 99.0, p1, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "IPH4");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put (

    "Android",ManejadorCategorias.getInstance().getCategoria("Android"));
	cat1.put (
    "Nexus",ManejadorCategorias.getInstance().getCategoria("Nexus"));

EspecificacionProducto pr3 = new EspecificacionProducto("NEX4", "Nexus4", "El celular de Google", esp3, (float) 299.0, p2, cat1, prod3);
controlarProducto.elegirEspProducto (
    "NEX4");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put (

    "Android",ManejadorCategorias.getInstance().getCategoria("Android"));
	cat1.put (
    "Galaxy S3",ManejadorCategorias.getInstance().getCategoria("Galaxy S3"));
EspecificacionProducto pr4 = new EspecificacionProducto("GA3", "Samsung Galaxy S3", "La versión S3 de la línea Samsung Galaxy", esp3, (float) 415.0, p2, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "GA3");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put (

    "Android",ManejadorCategorias.getInstance().getCategoria("Android"));
	cat1.put (
    "Galaxy S4",ManejadorCategorias.getInstance().getCategoria("Galaxy S4"));
EspecificacionProducto pr5 = new EspecificacionProducto("GA4", "Samsung Galaxy S4", "La versión S4 de la línea Samsung Galaxy", esp3, (float) 839.99, p2, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "GA4");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put (

    "Android",ManejadorCategorias.getInstance().getCategoria("Android"));
	cat1.put (
    "Galaxy Ace",ManejadorCategorias.getInstance().getCategoria("Galaxy Ace"));
EspecificacionProducto pr6 = new EspecificacionProducto("AS5", "Galaxy Ace S5830", "La versión Ace de la línea Samsung Galaxy", esp3, (float) 237.0, p2, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "AS5");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put (
    "Protectores",ManejadorCategorias.getInstance().getCategoria("Protectores"));
EspecificacionProducto pr7 = new EspecificacionProducto("PCG", "Protector de cuero para Galaxy", "Asombroso protector de cuero para Samsung Galaxy I900", esp3, (float) 3.5, p2, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "PCG");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put (
    "Protectores",ManejadorCategorias.getInstance().getCategoria("Protectores"));
EspecificacionProducto pr8 = new EspecificacionProducto("PMH", "Protector de aluminio para HTC", "El mejor protector de aluminio para HTC Desire HD", esp3, (float) 3.4, p5, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "PMH");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put ("Apple",ManejadorCategorias.getInstance

    ().getCategoria("Apple"));
	cat1.put ("iOS",ManejadorCategorias.getInstance
    ().getCategoria("iOS"));
EspecificacionProducto pr9 = new EspecificacionProducto("IRD", "iPad Retina Display", "La última tableta de Apple con pantalla Retina", esp3, (float) 499.0, p1, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "IRD");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put ("Apple",ManejadorCategorias.getInstance

    ().getCategoria("Apple"));
	cat1.put ("iOS",ManejadorCategorias.getInstance
    ().getCategoria("iOS"));
EspecificacionProducto pr10 = new EspecificacionProducto("IM", "iPad Mini", "La primera tableta chica de Apple", esp3, (float) 329.0, p1, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "IM");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put ("Xbox",ManejadorCategorias.getInstance
    ().getCategoria("Xbox"));
EspecificacionProducto pr11 = new EspecificacionProducto("RIX", "Receptor inalámbrico para Xbox", "Receptor inalámbrico de color negro para controles de Xbox 360", esp3, (float) 10.99, p4, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "RIX");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put ("Xbox",ManejadorCategorias.getInstance
    ().getCategoria("Xbox"));
EspecificacionProducto pr12 = new EspecificacionProducto("CIX", "Control inalámbrico para Xbox", "Control inalámbrico de 2.4 GHz para Xbox 360 ", esp3, (float) 27.27, p4, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "CIX");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put ("Playstation",ManejadorCategorias.getInstance
    ().getCategoria("Playstation"));
EspecificacionProducto pr13 = new EspecificacionProducto("CHP", "Cable HDMI para PS3", "Es un cable HDMI para PS3", esp3, (float) 7.99, p3, cat1, prod3);

    controlarProducto.elegirEspProducto (
    "CHP");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
cat1  = Collections.synchronizedMap(new HashMap());

    cat1.put ("Playstation",ManejadorCategorias.getInstance
    ().getCategoria("Playstation"));
EspecificacionProducto pr14 = new EspecificacionProducto("CP3", "Control para PS3", "Control inalámbrico Dualshock 3 de color azul para Playstation 3", esp3, (float) 30.8, p3, cat1, prod3);

    controlarProducto.elegirEspProducto (

    "CP3");
controlarProducto.agregarMultiplesProductosAutogenerados(10);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr1);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr2);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr3);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr4);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr5);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr6);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr7);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr8);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr9);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr10);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr11);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr12);
ManejadorEspProductos.getInstance ()

    .agregarEspecificacionProducto(pr13);
ManejadorEspProductos.getInstance ()

.agregarEspecificacionProducto(pr14);

//        casoDeUso1(controlarUsuario);
//        casoDeUso2(controlarProducto);
//        casoDeUso3(controlarProducto);
//        casoDeUso4(controlarOrden);
//        casoDeUso5(controlarUsuario);
//        casoDeUso6(controlarUsuario);
//        casoDeUso7(controlarProducto);
//        casoDeUso8(controlarProducto);
//        casoDeUso9(controlarOrden);
//        casoDeUso10(controlarOrden);
    }

    public static void casoDeUso1(IControladorUsuarios controlarUsuario) {
        System.out.println("**************************** Registrar Usuario ****************************");

        String tipoUsuario;
        Scanner eTipoUsuario = new Scanner(System.in);
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

        if (controlarUsuario.validarDatosUsuario()) {
            System.out.println("Ya existe el usuario");
        } else {
            controlarUsuario.guardarUsuario();
        }
    }

    public static void casoDeUso2(IControladorProductos controlarProducto) {
        System.out.println("**************************** Registrar Producto ****************************");

        controlarProducto.listarProveedores().stream().forEach((proveedor) -> {
            System.out.println(proveedor);
        });

        String nicknameProveedor = "prov2";//leer el nickname del proveedor elegido
        controlarProducto.elegirProveedor(nicknameProveedor);

        //leer datos de nueva especificacion
        DataEspecificacionProducto espProducto = new DataEspecificacionProducto("prod1", "Producto a", "descripcion 1", Collections.synchronizedMap(new HashMap()), (float) 12.0, controlarProducto.listarProveedores().get(0), new ArrayList<>(), new ArrayList<>(), Collections.synchronizedMap(new HashMap()));
        controlarProducto.ingresarDatosProductos(espProducto);
        controlarProducto.ingresarEspecificacion("Color", "Verde");
        controlarProducto.ingresarEspecificacion("Peso", "1kg");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        controlarProducto.ingresarDatosUnidad(new DataProducto(11, "idesp1", espProducto));
        controlarProducto.listarCategorias();
        controlarProducto.agregarCategoriaAEspecificacion("cat1");
        controlarProducto.agregarImagen("peteco");
        if (controlarProducto.controlarErrores()) {
            controlarProducto.guardarProducto();
        }
    }

    public static void casoDeUso3(IControladorProductos controlarProducto) {
        System.out.println("**************************** Alta de categoría ****************************");

        DataCategoria padre = new DataCategoria(ManejadorCategorias.getInstance().getCategoria("cat1"), true);
        DataCategoria categoria = new DataCategoria("cat6", padre);
        controlarProducto.ingresarDatosCategoria(categoria);
        controlarProducto.guardarCategoria();
    }

    public static void casoDeUso4(IControladorOrdenes controlarOrden) {
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

    public static void casoDeUso5(IControladorUsuarios controlarUsuario) {
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

    public static void casoDeUso6(IControladorUsuarios controlarUsuario) {
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

    public static void casoDeUso7(IControladorProductos controlarProducto) {
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

    public static void casoDeUso8(IControladorProductos controlarProducto) {
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
        if (controlarProducto.validarInfo()) {
            controlarProducto.guardarEspProductoModificado();
        }
    }

    public static void casoDeUso9(IControladorOrdenes controlarOrden) {
        System.out.println("**************************** Cancelar Orden de Compra ****************************");

        //Listar ordenes
        controlarOrden.listarOrdenes().stream().forEach((orden) -> {
            System.out.println(orden);
        });

        //Orden Seleccionada
        controlarOrden.elegirOrden(1);

        String confirmaEliminar;
        Scanner eConfirmaEliminar = new Scanner(System.in);
        System.out.println("Eliminar? (s o n)");
        confirmaEliminar = eConfirmaEliminar.nextLine();

        switch (confirmaEliminar) {
            case "s":
                controlarOrden.borrarOrdenCompra();
                break;
        }
    }

    public static void casoDeUso10(IControladorOrdenes controlarOrden) {
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
