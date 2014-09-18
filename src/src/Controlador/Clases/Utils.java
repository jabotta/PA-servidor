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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rodro
 */
public class Utils {

    public static final void generarDatosDePrueba(){
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
        
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1960, 11, 1);
        Proveedor p1 = new Proveedor("Tim1", "Tim", "Cook", "tim.cook@apple.com", cal1, "Apple", " http://www.apple.com");
        Calendar cal2 = Calendar.getInstance();
        cal2.set(1965, 9, 2);
        Proveedor p2 = new Proveedor("Eddy", "Eduardo", "Cue", "eddy.cue@samsung.com", cal2, "Samsung", "http://www.samsung.com");
        Calendar cal3 = Calendar.getInstance();
        cal3.set(1965, 9, 2);
        Proveedor p3 = new Proveedor("CraigX", "Craig", "Federighi", "craig.feder@sony.com", cal3, "Sony", "http://us.playstation.com");
        Calendar cal4 = Calendar.getInstance();
        cal4.set(1967, 2, 12);
        Proveedor p4 = new Proveedor("Johnny", "Jonathan", "Ive", "johnny.ive@outlook.com", cal4, "Microsoft", "http://www.xbox.com");
        Calendar cal5 = Calendar.getInstance();
        cal5.set(1963, 8, 5);
        Proveedor p5 = new Proveedor("OpenPeter", "Peter", "Oppenhemier", "peter.open@htc.com", cal5, "HTC", "http://www.htc.com");
        
        Calendar cal6 = Calendar.getInstance();
        cal6.set(1963, 7, 5);
        Cliente c1 = new Cliente("Dan", "Daniel", "Riccio", "dan.riccio@gmail.com", cal6);
        Calendar cal7 = Calendar.getInstance();
        cal7.set(1961, 10, 7);
        Cliente c2 = new Cliente("Phil", "Philip", "Schiller", "phil.schiller@gmail.com", cal7);
        Calendar cal8 = Calendar.getInstance();
        cal8.set(1959, 12, 3);
        Cliente c3 = new Cliente("BruceS", "Bruce", "Sewell", "bruce.sewell@gmail.com", cal8);
        Calendar cal9 = Calendar.getInstance();
        cal9.set(1964, 11, 27);
        Cliente c4 = new Cliente("JeffW", "Jeff", "Wiliams", "jeff.williams@gmail.com", cal9);

        p1.setImagen("/home/tecnoinf/Escritorio/imag/cook.jpg");
        p2.setImagen("/home/tecnoinf/Escritorio/imag/cue.jpg");
        p3.setImagen("/home/tecnoinf/Escritorio/imag/federighi.jpg");
        p4.setImagen("/home/tecnoinf/Escritorio/imag/ive.jpg");
        c2.setImagen("/home/tecnoinf/Escritorio/imag/schiller.jpg");
        if(!ManejadorUsuarios.getInstance().obtenerClientes().containsKey(p1.getNickname()))
            ManejadorUsuarios.getInstance().agregarUsuario(p1);
        if(!ManejadorUsuarios.getInstance().obtenerClientes().containsKey(p2.getNickname()))
            ManejadorUsuarios.getInstance().agregarUsuario(p2);
        if(!ManejadorUsuarios.getInstance().obtenerClientes().containsKey(p3.getNickname()))
            ManejadorUsuarios.getInstance().agregarUsuario(p3);
        if(!ManejadorUsuarios.getInstance().obtenerClientes().containsKey(p4.getNickname()))
            ManejadorUsuarios.getInstance().agregarUsuario(p4);
        if(!ManejadorUsuarios.getInstance().obtenerClientes().containsKey(p5.getNickname()))
            ManejadorUsuarios.getInstance().agregarUsuario(p5);

        if(!ManejadorUsuarios.getInstance().obtenerClientes().containsKey(c1.getNickname()))
            ManejadorUsuarios.getInstance().agregarUsuario(c1);
        if(!ManejadorUsuarios.getInstance().obtenerClientes().containsKey(c2.getNickname()))
            ManejadorUsuarios.getInstance().agregarUsuario(c2);
        if(!ManejadorUsuarios.getInstance().obtenerClientes().containsKey(c3.getNickname()))
            ManejadorUsuarios.getInstance().agregarUsuario(c3);
        if(!ManejadorUsuarios.getInstance().obtenerClientes().containsKey(c4.getNickname()))
            ManejadorUsuarios.getInstance().agregarUsuario(c4);

        /*Categorias*/
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Celulares"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Celulares", null));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Sistemas Operativos"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Sistemas Operativos", ManejadorCategorias.getInstance().getCategoria("Celulares")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("iOS"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("iOS", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Android"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Android", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Windows Phone"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Windows Phone", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Symbian"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Symbian", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Blackberry OS"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Blackberry OS", ManejadorCategorias.getInstance().getCategoria("Sistemas Operativos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Equipos"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Equipos", ManejadorCategorias.getInstance().getCategoria("Celulares")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("iPhone"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("iPhone", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Nexus"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Nexus", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Samsung"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Samsung", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Galaxy S3"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Galaxy S3", ManejadorCategorias.getInstance().getCategoria("Samsung")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Galaxy S4"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Galaxy S4", ManejadorCategorias.getInstance().getCategoria("Samsung")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Galaxy Ace"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Galaxy Ace", ManejadorCategorias.getInstance().getCategoria("Samsung")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Blackberry"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Blackberry", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Nokia"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Nokia", ManejadorCategorias.getInstance().getCategoria("Equipos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Accesorios"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Accesorios", ManejadorCategorias.getInstance().getCategoria("Celulares")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Protectores"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Protectores", ManejadorCategorias.getInstance().getCategoria("Accesorios")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Baterías"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Baterías", ManejadorCategorias.getInstance().getCategoria("Accesorios")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Apple"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Apple", null));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Videojuegos"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Videojuegos", null));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Playstation"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Playstation", ManejadorCategorias.getInstance().getCategoria("Videojuegos")));
        if(!ManejadorCategorias.getInstance().obtenerCategorias().containsKey("Xbox"))
            ManejadorCategorias.getInstance().agregarCategoria(new Categoria("Xbox", ManejadorCategorias.getInstance().getCategoria("Videojuegos")));
        /**
         * productos*
         */

        /////////////////Producto 1
        Map<String,String> esppr1= new HashMap();
        List<Producto> prodpr1 = new ArrayList();
        List<Categoria> catpr1 = new ArrayList();
        List<Producto> productospr1 = new ArrayList();
        catpr1.add (ManejadorCategorias.getInstance().getCategoria("iPhone"));
        catpr1.add (ManejadorCategorias.getInstance().getCategoria("iOS"));
        catpr1.add (ManejadorCategorias.getInstance().getCategoria("Apple"));
        EspecificacionProducto pr1 = new EspecificacionProducto("IPH5", "iPhone 5", "El último celular de Apple", esppr1, (float) 199.0, p1, catpr1, prodpr1); 
        controlarProducto.elegirEspProducto ("IPH5");
        for(Integer i = 0; i < 10; i++){
            productospr1.add(new Producto(i, pr1));
        }
        pr1.setListaProductos(productospr1);

        /////////////////Producto 2
        Map<String,String> esppr2= new HashMap();
        List<Producto> prodpr2 = new ArrayList();
        List<Categoria> catpr2 = new ArrayList();
        List<Producto> productospr2 = new ArrayList();
        esppr2.put("Capacidad", "16 GB");
        esppr2.put("Peso", "140 g");
        esppr2.put("Pantalla", "3.5”");
        esppr2.put("Versiones de Wifi", "b/g/n");
        catpr2.add(ManejadorCategorias.getInstance().getCategoria("iPhone"));
        catpr2.add(ManejadorCategorias.getInstance().getCategoria("iOS"));
        catpr2.add(ManejadorCategorias.getInstance().getCategoria("Apple"));
        EspecificacionProducto pr2 = new EspecificacionProducto("IPH4", "iPhone 4S", "El siguiente celular al iPhone 4", esppr2, (float) 99.0, p1, catpr2, prodpr2);
        controlarProducto.elegirEspProducto ("IPH4");
        productospr2 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr2.add(new Producto(i, pr2));
        }
        pr2.setListaProductos(productospr2);

        /////////////////Producto 3
        Map<String,String> esppr3= new HashMap();
        List<Producto> prodpr3 = new ArrayList();
        List<Categoria> catpr3 = new ArrayList();
        List<Producto> productospr3 = new ArrayList();
        esppr3.put("Capacidad", "8 GB");
        esppr3.put("Peso", "139 g");
        esppr3.put("Pantalla", "4.7”");
        esppr3.put("Versión de Android", "4.3");
        catpr3.add(ManejadorCategorias.getInstance().getCategoria("Android"));
        catpr3.add(ManejadorCategorias.getInstance().getCategoria("Nexus"));
        EspecificacionProducto pr3 = new EspecificacionProducto("NEX4", "Nexus4", "El celular de Google", esppr3, (float) 299.0, p2, catpr3, prodpr3);
        controlarProducto.elegirEspProducto ("NEX4");
        productospr3 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr3.add(new Producto(i, pr3));
        }
        pr3.setListaProductos(productospr3);

        /////////////////Producto 4
        Map<String,String> esppr4= new HashMap();
        List<Producto> prodpr4 = new ArrayList();
        List<Categoria> catpr4 = new ArrayList();
        List<Producto> productospr4 = new ArrayList();
        esppr4.put("Dimensiones", "136.6 x 70.6 x 8.6 mm");
        esppr4.put("Peso", "133 g");
        esppr4.put("Pantalla", "4.8”");
        esppr4.put("Versión de Android", "4.0.4");
        catpr4.add(ManejadorCategorias.getInstance().getCategoria("Android"));
        catpr4.add(ManejadorCategorias.getInstance().getCategoria("Galaxy S3"));
        EspecificacionProducto pr4 = new EspecificacionProducto("GA3", "Samsung Galaxy S3", "La versión S3 de la línea Samsung Galaxy", esppr4, (float) 415.0, p2, catpr4, prodpr4);
        controlarProducto.elegirEspProducto ("GA3");
        productospr4 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr4.add(new Producto(i, pr4));
        }
        pr4.setListaProductos(productospr4);

        /////////////////Producto 5
        Map<String,String> esppr5= new HashMap();
        List<Producto> prodpr5 = new ArrayList();
        List<Categoria> catpr5 = new ArrayList();
        List<Producto> productospr5 = new ArrayList();
        esppr5.put("Dimensiones", "136.6 x 69.8 x 7.9 mm");
        esppr5.put("Peso", "130 g");
        esppr5.put("Pantalla", "4.99”");
        esppr5.put("Versión de Android", "4.2.2");
        catpr5.add(ManejadorCategorias.getInstance().getCategoria("Android"));
        catpr5.add(ManejadorCategorias.getInstance().getCategoria("Galaxy S4"));
        EspecificacionProducto pr5 = new EspecificacionProducto("GA4", "Samsung Galaxy S4", "La versión S4 de la línea Samsung Galaxy", esppr5, (float) 839.99, p2, catpr5, prodpr5);
        controlarProducto.elegirEspProducto ("GA4");
        productospr5 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr5.add(new Producto(i, pr5));
        }
        pr5.setListaProductos(productospr5);

        /////////////////Producto 6
        Map<String,String> esppr6= new HashMap();
        List<Producto> prodpr6 = new ArrayList();
        List<Categoria> catpr6 = new ArrayList();
        List<Producto> productospr6 = new ArrayList();
        esppr6.put("Dimensiones", "112.4 x 59.9 x 11.5 mm");
        esppr6.put("Peso", "113 g");
        esppr6.put("Pantalla", ": 3.5”");
        esppr6.put("Versión de Android", "2.3");
        catpr6.add(ManejadorCategorias.getInstance().getCategoria("Android"));
        catpr6.add(ManejadorCategorias.getInstance().getCategoria("Galaxy Ace"));
        EspecificacionProducto pr6 = new EspecificacionProducto("AS5", "Galaxy Ace S5830", "La versión Ace de la línea Samsung Galaxy", esppr6, (float) 237.0, p2, catpr6, prodpr6);

        controlarProducto.elegirEspProducto ("AS5");
        productospr6 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr6.add(new Producto(i, pr6));
        }
        pr6.setListaProductos(productospr6);

        /////////////////Producto 7
        Map<String,String> esppr7= new HashMap();
        List<Producto> prodpr7 = new ArrayList();
        List<Categoria> catpr7 = new ArrayList();
        List<Producto> productospr7 = new ArrayList();
        esppr7.put("Dimensiones", "12.5 cm x 6.7 cm x 2.0 cm");
        esppr7.put("Peso", "44 g");
        catpr7.add(ManejadorCategorias.getInstance().getCategoria("Protectores"));
        EspecificacionProducto pr7 = new EspecificacionProducto("PCG", "Protector de cuero para Galaxy", "Asombroso protector de cuero para Samsung Galaxy I900", esppr7, (float) 3.5, p2, catpr7, prodpr7);
        controlarProducto.elegirEspProducto ("PCG");
        productospr7 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr7.add(new Producto(i, pr7));
        }
        pr7.setListaProductos(productospr7);

        /////////////////Producto 8
        Map<String,String> esppr8= new HashMap();
        List<Producto> prodpr8 = new ArrayList();
        List<Categoria> catpr8 = new ArrayList();
        List<Producto> productospr8 = new ArrayList();
        esppr8.put("Dimensiones", "12.4 cm x 7.0 cm x 1.3 cm");
        esppr8.put("Peso", "26 g");
        catpr8.add(ManejadorCategorias.getInstance().getCategoria("Protectores"));
        EspecificacionProducto pr8 = new EspecificacionProducto("PMH", "Protector de aluminio para HTC", "El mejor protector de aluminio para HTC Desire HD", esppr8, (float) 3.4, p5, catpr8, prodpr8);
        controlarProducto.elegirEspProducto ("PMH");
        productospr8 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr8.add(new Producto(i, pr8));
        }
        pr8.setListaProductos(productospr8);

        /////////////////Producto 9
        Map<String,String> esppr9= new HashMap();
        List<Producto> prodpr9 = new ArrayList();
        List<Categoria> catpr9 = new ArrayList();
        List<Producto> productospr9 = new ArrayList();
        esppr9.put("Capacidad", "16 GB");
        esppr9.put("Peso", "652 g");
        esppr9.put("Pantalla", "9.7”");
        esppr9.put("Procesador", "A6X");
        catpr9.add(ManejadorCategorias.getInstance().getCategoria("Apple"));
        catpr9.add(ManejadorCategorias.getInstance().getCategoria("iOS"));
        EspecificacionProducto pr9 = new EspecificacionProducto("IRD", "iPad Retina Display", "La última tableta de Apple con pantalla Retina", esppr9, (float) 499.0, p1, catpr9, prodpr9);
        controlarProducto.elegirEspProducto ("IRD");
        productospr9 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr9.add(new Producto(i, pr9));
        }
        pr9.setListaProductos(productospr9);

        /////////////////Producto 10
        Map<String,String> esppr10= new HashMap();
        List<Producto> prodpr10 = new ArrayList();
        List<Categoria> catpr10 = new ArrayList();
        List<Producto> productospr10 = new ArrayList();
        esppr10.put("Capacidad", "16 GB");
        esppr10.put("Peso", "308 g");
        esppr10.put("Pantalla", "7.9”");
        esppr10.put("Procesador", "A5");
        catpr10.add(ManejadorCategorias.getInstance().getCategoria("Apple"));
        catpr10.add(ManejadorCategorias.getInstance().getCategoria("iOS"));
        EspecificacionProducto pr10 = new EspecificacionProducto("IM", "iPad Mini", "La primera tableta chica de Apple", esppr10, (float) 329.0, p1, catpr10, prodpr10);
        controlarProducto.elegirEspProducto ("IM");
        productospr10 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr10.add(new Producto(i, pr10));
        }
        pr10.setListaProductos(productospr10);

        /////////////////Producto 11
        Map<String,String> esppr11= new HashMap();
        List<Producto> prodpr11 = new ArrayList();
        List<Categoria> catpr11 = new ArrayList();
        List<Producto> productospr11 = new ArrayList();
        esppr11.put("Dimensiones", "7.5 cm x 4.2 cm x 1.8 cm");
        esppr11.put("Peso", "111 g");
        catpr11.add(ManejadorCategorias.getInstance().getCategoria("Xbox"));
        EspecificacionProducto pr11 = new EspecificacionProducto("RIX", "Receptor inalámbrico para Xbox", "Receptor inalámbrico de color negro para controles de Xbox 360", esppr11, (float) 10.99, p4, catpr11, prodpr11);
        controlarProducto.elegirEspProducto ("RIX");
        productospr11 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr11.add(new Producto(i, pr11));
        }
        pr11.setListaProductos(productospr11);

        /////////////////Producto 12
        Map<String,String> esppr12= new HashMap();
        List<Producto> prodpr12 = new ArrayList();
        List<Categoria> catpr12 = new ArrayList();
        List<Producto> productospr12 = new ArrayList();
        esppr12.put("Garantía", "3 meses");
        esppr12.put("Dimensiones", "5.91 in x 4.33 in x 1.77 in");
        esppr12.put("Peso", "7.83 oz");
        catpr12.add(ManejadorCategorias.getInstance().getCategoria("Xbox"));
        EspecificacionProducto pr12 = new EspecificacionProducto("CIX", "Control inalámbrico para Xbox", "Control inalámbrico de 2.4 GHz para Xbox 360 ", esppr12, (float) 27.27, p4, catpr12, prodpr12);
        controlarProducto.elegirEspProducto ("CIX");
        productospr12 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr12.add(new Producto(i, pr12));
        }
        pr12.setListaProductos(productospr12);

        /////////////////Producto 13
        Map<String,String> esppr13= new HashMap();
        List<Producto> prodpr13 = new ArrayList();
        List<Categoria> catpr13 = new ArrayList();
        List<Producto> productospr13 = new ArrayList();
        esppr13.put("Dimensiones", "0 in x 0 in x 0 in");
        esppr13.put("Peso", "7.83 oz");
        catpr13.add(ManejadorCategorias.getInstance().getCategoria("Playstation"));
        EspecificacionProducto pr13 = new EspecificacionProducto("CHP", "Cable HDMI para PS3", "Es un cable HDMI para PS3", esppr13, (float) 7.99, p3, catpr13, prodpr13);
        controlarProducto.elegirEspProducto("CHP");
        productospr13 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr13.add(new Producto(i, pr13));
        }
        pr13.setListaProductos(productospr13);

        /////////////////Producto 14
        Map<String,String> esppr14 = new HashMap();
        List<Producto> prodpr14 = new ArrayList();
        List<Categoria> catpr14 = new ArrayList();
        List<Producto> productospr14 = new ArrayList();
        esppr14.put("Dimensiones", "16.0 cm x 9.5 cm x 5.0 cm");
        esppr14.put("Peso", "184 g");
        catpr14.add(ManejadorCategorias.getInstance().getCategoria("Playstation"));
        EspecificacionProducto pr14 = new EspecificacionProducto("CP3", "Control para PS3", "Control inalámbrico Dualshock 3 de color azul para Playstation 3", esppr14, (float) 30.8, p3, catpr14, prodpr14);
        controlarProducto.elegirEspProducto ("CP3");
        productospr14 = new ArrayList();
        for(Integer i = 0; i < 10; i++){
            productospr14.add(new Producto(i, pr14));
        }
        pr14.setListaProductos(productospr14);

        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr1.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr1);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr2.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr2);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr3.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr3);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr4.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr4);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr5.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr5);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr6.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr6);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr7.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr7);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr8.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr8);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr9.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr9);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr10.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr10);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr11.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr11);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr12.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr12);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr13.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr13);
        if(!ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().containsKey(pr14.getNroReferencia()))
            ManejadorEspProductos.getInstance().agregarEspecificacionProducto(pr14);

        if(ManejadorOrdenes.getInstance().obtenerOrdenes().isEmpty()){
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
            dataOrden.setFecha(getDateFromString("12/8/2013"));
            controlarOrden.guardarOrden(dataOrden);

            controlarOrden.elegirCliente("Dan");
            controlarOrden.elegirEspecificacionProducto("NEX4");
            controlarOrden.elegirProducto(1);
            controlarOrden.elegirProducto(2);
            controlarOrden.elegirProducto(3);
            controlarOrden.generarItemOrden();
            DataOrdenCompra dataOrden2 = new DataOrdenCompra(2);
            dataOrden2.setFecha(getDateFromString("19/8/2013"));
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
            dataOrden3.setFecha(getDateFromString("19/8/2013"));
            controlarOrden.guardarOrden(dataOrden3);

            controlarOrden.elegirCliente("BruceS");
            controlarOrden.elegirEspecificacionProducto("CIX");
            controlarOrden.elegirProducto(1);
            controlarOrden.elegirProducto(2);
            controlarOrden.elegirProducto(3);
            controlarOrden.elegirProducto(4);
            controlarOrden.generarItemOrden();
            DataOrdenCompra dataOrden4 = new DataOrdenCompra(4);
            dataOrden4.setFecha(getDateFromString("22/8/2013"));
            controlarOrden.guardarOrden(dataOrden4);

            controlarOrden.elegirCliente("JeffW");
            controlarOrden.elegirEspecificacionProducto("PCG");
            controlarOrden.elegirProducto(1);
            controlarOrden.generarItemOrden();
            DataOrdenCompra dataOrden5 = new DataOrdenCompra(5);
            dataOrden5.setFecha(getDateFromString("25/8/2013"));
            controlarOrden.guardarOrden(dataOrden5);
        }
    }

    public static String formatString(String s) {

        if (s != null) {

            return s.trim();
        }
        return "";
    }
    /**
     @return Regresa la fecha en formato string 
    **/
    public static String formatDate(Date s) {
        if (s != null) {
            DateFormat dateFormat = new SimpleDateFormat(Constantes.DATE_FORMAT);

            return dateFormat.format(s);
        }
        return "";
    }
    public static String formatDate(Calendar s) {
        if (s != null) {
            DateFormat dateFormat = new SimpleDateFormat(Constantes.DATE_FORMAT);

            return dateFormat.format(s);
        }
        return "";
    }
    public static Date getDateFromString(String value) {
        try {
            return new SimpleDateFormat(Constantes.DATE_FORMAT).parse(value);
        } catch (ParseException ex) {
           return null;
        }
    }
}
