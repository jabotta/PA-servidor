/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Clases;

import Controlador.DataTypes.DataOrdenCompra;
import static Vista.VentanaPrincipal.controlarOrden;
import static Vista.VentanaPrincipal.controlarProducto;
import static Vista.VentanaPrincipal.controlarUsuario;
import static Vista.VentanaPrincipal.idOrdenesControlador;
import static Vista.VentanaPrincipal.idProductosControlador;
import static Vista.VentanaPrincipal.idUsuariosControlador;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rodro
 */
public class Utils {

    public static final void generarDatosDePrueba() {
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
        Cliente c2 = new Cliente("Phil", "Philip", "Schiller", "phil.schiller@gmail.com", new Date(1961, 10, 7));
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
        Map<Integer,Producto> productosAAgregar = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 1
        cat1.put ("iPhone",ManejadorCategorias.getInstance().getCategoria("iPhone"));
        cat1.put ("iOS",ManejadorCategorias.getInstance().getCategoria("iOS"));
        cat1.put ("Apple",ManejadorCategorias.getInstance().getCategoria("Apple"));
        EspecificacionProducto pr1 = new EspecificacionProducto("IPH5", "iPhone 5", "El último celular de Apple", esp3, (float) 199.0, p1, cat1, prod3); 
        controlarProducto.elegirEspProducto ("IPH5");
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr1));
        }
        pr1.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 2
        cat1.put ("iPhone",ManejadorCategorias.getInstance().getCategoria("iPhone"));
        cat1.put ("iOS",ManejadorCategorias.getInstance().getCategoria("iOS"));
        cat1.put ("Apple",ManejadorCategorias.getInstance().getCategoria("Apple"));
        EspecificacionProducto pr2 = new EspecificacionProducto("IPH4", "iPhone 4S", "El siguiente celular al iPhone 4", esp3, (float) 99.0, p1, cat1, prod3);
        controlarProducto.elegirEspProducto ("IPH4");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr2));
        }
        pr2.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 3
        cat1.put ("Android",ManejadorCategorias.getInstance().getCategoria("Android"));
        cat1.put ("Nexus",ManejadorCategorias.getInstance().getCategoria("Nexus"));
        EspecificacionProducto pr3 = new EspecificacionProducto("NEX4", "Nexus4", "El celular de Google", esp3, (float) 299.0, p2, cat1, prod3);
        controlarProducto.elegirEspProducto ("NEX4");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr3));
        }
        pr3.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 4
        cat1.put ("Android",ManejadorCategorias.getInstance().getCategoria("Android"));
        cat1.put ("Galaxy S3",ManejadorCategorias.getInstance().getCategoria("Galaxy S3"));
        EspecificacionProducto pr4 = new EspecificacionProducto("GA3", "Samsung Galaxy S3", "La versión S3 de la línea Samsung Galaxy", esp3, (float) 415.0, p2, cat1, prod3);
        controlarProducto.elegirEspProducto ("GA3");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr4));
        }
        pr4.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 5
        cat1.put ("Android",ManejadorCategorias.getInstance().getCategoria("Android"));
        cat1.put ("Galaxy S4",ManejadorCategorias.getInstance().getCategoria("Galaxy S4"));
        EspecificacionProducto pr5 = new EspecificacionProducto("GA4", "Samsung Galaxy S4", "La versión S4 de la línea Samsung Galaxy", esp3, (float) 839.99, p2, cat1, prod3);
        controlarProducto.elegirEspProducto ("GA4");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr5));
        }
        pr5.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 6
        cat1.put ("Android",ManejadorCategorias.getInstance().getCategoria("Android"));
        cat1.put ("Galaxy Ace",ManejadorCategorias.getInstance().getCategoria("Galaxy Ace"));
        EspecificacionProducto pr6 = new EspecificacionProducto("AS5", "Galaxy Ace S5830", "La versión Ace de la línea Samsung Galaxy", esp3, (float) 237.0, p2, cat1, prod3);

        controlarProducto.elegirEspProducto ("AS5");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr6));
        }
        pr6.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 7
        cat1.put ("Protectores",ManejadorCategorias.getInstance().getCategoria("Protectores"));
        EspecificacionProducto pr7 = new EspecificacionProducto("PCG", "Protector de cuero para Galaxy", "Asombroso protector de cuero para Samsung Galaxy I900", esp3, (float) 3.5, p2, cat1, prod3);
        controlarProducto.elegirEspProducto ("PCG");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr7));
        }
        pr7.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 8
        cat1.put ("Protectores",ManejadorCategorias.getInstance().getCategoria("Protectores"));
        EspecificacionProducto pr8 = new EspecificacionProducto("PMH", "Protector de aluminio para HTC", "El mejor protector de aluminio para HTC Desire HD", esp3, (float) 3.4, p5, cat1, prod3);
        controlarProducto.elegirEspProducto ("PMH");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr8));
        }
        pr8.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 9
        cat1.put ("Apple",ManejadorCategorias.getInstance().getCategoria("Apple"));
        cat1.put ("iOS",ManejadorCategorias.getInstance().getCategoria("iOS"));
        EspecificacionProducto pr9 = new EspecificacionProducto("IRD", "iPad Retina Display", "La última tableta de Apple con pantalla Retina", esp3, (float) 499.0, p1, cat1, prod3);
        controlarProducto.elegirEspProducto ("IRD");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr9));
        }
        pr9.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 10
        cat1.put ("Apple",ManejadorCategorias.getInstance().getCategoria("Apple"));
        cat1.put ("iOS",ManejadorCategorias.getInstance().getCategoria("iOS"));
        EspecificacionProducto pr10 = new EspecificacionProducto("IM", "iPad Mini", "La primera tableta chica de Apple", esp3, (float) 329.0, p1, cat1, prod3);
        controlarProducto.elegirEspProducto ("IM");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr10));
        }
        pr10.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 11
        cat1.put ("Xbox",ManejadorCategorias.getInstance().getCategoria("Xbox"));
        EspecificacionProducto pr11 = new EspecificacionProducto("RIX", "Receptor inalámbrico para Xbox", "Receptor inalámbrico de color negro para controles de Xbox 360", esp3, (float) 10.99, p4, cat1, prod3);
        controlarProducto.elegirEspProducto ("RIX");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr11));
        }
        pr11.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 12
        cat1.put ("Xbox",ManejadorCategorias.getInstance().getCategoria("Xbox"));
        EspecificacionProducto pr12 = new EspecificacionProducto("CIX", "Control inalámbrico para Xbox", "Control inalámbrico de 2.4 GHz para Xbox 360 ", esp3, (float) 27.27, p4, cat1, prod3);

        controlarProducto.elegirEspProducto ("CIX");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr12));
        }
        pr12.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 13
        cat1.put ("Playstation",ManejadorCategorias.getInstance().getCategoria("Playstation"));
        EspecificacionProducto pr13 = new EspecificacionProducto("CHP", "Cable HDMI para PS3", "Es un cable HDMI para PS3", esp3, (float) 7.99, p3, cat1, prod3);
        controlarProducto.elegirEspProducto("CHP");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr13));
        }
        pr13.setListaProductos(productosAAgregar);
        cat1  = Collections.synchronizedMap(new HashMap());

        /////////////////Producto 1
        cat1.put ("Playstation",ManejadorCategorias.getInstance().getCategoria("Playstation"));
        EspecificacionProducto pr14 = new EspecificacionProducto("CP3", "Control para PS3", "Control inalámbrico Dualshock 3 de color azul para Playstation 3", esp3, (float) 30.8, p3, cat1, prod3);
        controlarProducto.elegirEspProducto ("CP3");
        productosAAgregar = Collections.synchronizedMap(new HashMap());
        for(Integer i = 0; i < 10; i++){
            productosAAgregar.put(i, new Producto(i, pr14));
        }
        pr14.setListaProductos(productosAAgregar);

        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr1);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr2);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr3);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr4);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr5);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr6);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr7);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr8);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr9);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr10);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr11);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr12);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr13);
        ManejadorEspProductos.getInstance ().agregarEspecificacionProducto(pr14);
        

        controlarOrden.elegirCliente("Dan");
        controlarOrden.elegirEspecificacionProducto("IPH5");
        controlarOrden.elegirProducto(1);
        controlarOrden.generarItemOrden();
        controlarOrden.elegirEspecificacionProducto("IRD");
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(2);
        controlarOrden.elegirEspecificacionProducto("IM");
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(2);
        controlarOrden.generarItemOrden();
        DataOrdenCompra dataOrden = new DataOrdenCompra(1);
        controlarOrden.guardarOrden(dataOrden);
        
        controlarOrden.elegirCliente("Dan");
        controlarOrden.elegirEspecificacionProducto("NEX4");
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(2);
        controlarOrden.elegirProducto(3);
        controlarOrden.generarItemOrden();
        DataOrdenCompra dataOrden2 = new DataOrdenCompra(2);
        controlarOrden.guardarOrden(dataOrden2);

        controlarOrden.elegirCliente("Phil");
        controlarOrden.elegirEspecificacionProducto("CHP");
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(2);
        controlarOrden.generarItemOrden();
        controlarOrden.elegirEspecificacionProducto("CP3");
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(2);
        controlarOrden.elegirProducto(3);
        controlarOrden.generarItemOrden();
        DataOrdenCompra dataOrden3 = new DataOrdenCompra(3);
        controlarOrden.guardarOrden(dataOrden3);

        controlarOrden.elegirCliente("BruceS");
        controlarOrden.elegirEspecificacionProducto("CIX");
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(2);
        controlarOrden.elegirProducto(3);
        controlarOrden.elegirProducto(4);
        controlarOrden.generarItemOrden();
        DataOrdenCompra dataOrden4 = new DataOrdenCompra(4);
        controlarOrden.guardarOrden(dataOrden4);

        controlarOrden.elegirCliente("JeffW");
        controlarOrden.elegirEspecificacionProducto("PCG");
        controlarOrden.elegirProducto(1);
        controlarOrden.generarItemOrden();
        DataOrdenCompra dataOrden5 = new DataOrdenCompra(5);
        controlarOrden.guardarOrden(dataOrden5);

    }

    public static String formatString(String s) {

        if (s != null) {

            return s.trim();
        }
        return "";
    }
    /**
     * *
     *
     * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Date
     * date = new Date();
     */
}
