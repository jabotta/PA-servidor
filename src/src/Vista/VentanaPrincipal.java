package Vista;

import Controlador.Clases.Categoria;
import Controlador.Clases.Cliente;
import Controlador.Clases.EspecificacionProducto;
import Controlador.Clases.Fabrica;
import Controlador.Clases.IControladorOrdenes;
import Controlador.Clases.IControladorProductos;
import Controlador.Clases.IControladorUsuarios;
import static Controlador.Clases.Main.controlarOrden;
import static Controlador.Clases.Main.controlarProducto;
import static Controlador.Clases.Main.controlarUsuario;
import static Controlador.Clases.Main.idOrdenesControlador;
import static Controlador.Clases.Main.idProductosControlador;
import static Controlador.Clases.Main.idUsuariosControlador;
import Controlador.Clases.ManejadorCategorias;
import Controlador.Clases.ManejadorEspProductos;
import Controlador.Clases.ManejadorUsuarios;
import Controlador.Clases.Producto;
import Controlador.Clases.Proveedor;
import Controlador.Clases.Utils;
import Controlador.DataTypes.DataOrdenCompra;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
//import org.netbeans.lib.awtextra.AbsoluteLayout;

public class VentanaPrincipal extends javax.swing.JFrame {

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem altaCategoriaOpt;
    private javax.swing.JMenuItem cancelarOrdOpt;
    private javax.swing.JMenu casosUsoMenu;
    private javax.swing.JMenuItem crearOrdenOpt;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem modDatosProdOpt;
    private javax.swing.JMenu ordenMenu;
    private javax.swing.JMenu productoMenu;
    private javax.swing.JMenuItem registrarProdOpt;
    private javax.swing.JMenuItem registrarUsrOpt;
    public javax.swing.JMenu userMenu;
    private javax.swing.JMenuItem verInfoClienteOpt;
    private javax.swing.JMenuItem verInfoOrdenOpt;
    private javax.swing.JMenuItem verInfoProdOpt;
    private javax.swing.JMenuItem verInfoProvOpt;
    private JDesktopPane desktopPane;
    private GroupLayout layout;
    private JInternalFrame registrarUsuarioVentana;
    private JInternalFrame registrarCategoriaVentana;
    private JInternalFrame cancelarOrdenVentana;
    private JInternalFrame verOrdenVentana;
    // End of variables declaration

    public static Integer idUsuariosControlador;
    public static Integer idProductosControlador;
    public static Integer idOrdenesControlador;
    public static IControladorUsuarios controlarUsuario;
    public static IControladorProductos controlarProducto;
    public static IControladorOrdenes controlarOrden;
    private JInternalFrame registrarProductoVentana;
    private JInternalFrame verInfoClienteVentana;
    private JInternalFrame verInfoProveedorVentana;

    /**
     * Creates new form MainWindow
     */
    public VentanaPrincipal() {
        initComponents();

        idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
        idProductosControlador = Fabrica.getInstance().getControladorProductos(null).getId();
        idOrdenesControlador = Fabrica.getInstance().getControladorOrdenes(null).getId();
        controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        controlarOrden = Fabrica.getInstance().getControladorOrdenes(idOrdenesControlador);
    }

    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();

        casosUsoMenu = new javax.swing.JMenu();

        //menu sobre colaboraciones
        userMenu = new javax.swing.JMenu();
        ordenMenu = new javax.swing.JMenu();
        productoMenu = new javax.swing.JMenu();

        //Opciones sobre Usuarios
        registrarUsrOpt = new javax.swing.JMenuItem();
        verInfoClienteOpt = new javax.swing.JMenuItem();
        verInfoProvOpt = new javax.swing.JMenuItem();

        //Opciones sobre Productos
        altaCategoriaOpt = new javax.swing.JMenuItem();
        registrarProdOpt = new javax.swing.JMenuItem();
        verInfoProdOpt = new javax.swing.JMenuItem();
        modDatosProdOpt = new javax.swing.JMenuItem();

        //Opciones sobre Ordenes de compra
        crearOrdenOpt = new javax.swing.JMenuItem();
        cancelarOrdOpt = new javax.swing.JMenuItem();
        verInfoOrdenOpt = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        casosUsoMenu.setText("Casos de Uso");

        userMenu.setText("Usuarios");

        registrarUsrOpt.setText("Registrar Usuario");
        registrarUsrOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarUsrOptActionPerformed(evt);
            }
        });
        userMenu.add(registrarUsrOpt);

        verInfoClienteOpt.setText("Ver Informacion Cliente");
        verInfoClienteOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInfoClienteOptActionPerformed(evt);
            }
        });
        userMenu.add(verInfoClienteOpt);

        verInfoProvOpt.setText("Ver Informacion de Proveedor");
        verInfoProvOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInfoProvOptActionPerformed(evt);
            }
        });
        userMenu.add(verInfoProvOpt);

        casosUsoMenu.add(userMenu);

        productoMenu.setText("Productos");

        altaCategoriaOpt.setText("Alta Categoria");
        altaCategoriaOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaCategoriaOptActionPerformed(evt);
            }
        });
        productoMenu.add(altaCategoriaOpt);

        registrarProdOpt.setText("Registrar Producto");
        registrarProdOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarProdOptActionPerformed(evt);
            }
        });
        productoMenu.add(registrarProdOpt);

        verInfoProdOpt.setText("Ver informacion de Producto");
        verInfoProdOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInfoProdOptActionPerformed(evt);
            }
        });
        productoMenu.add(verInfoProdOpt);

        modDatosProdOpt.setText("Modificar datos de producto");
        modDatosProdOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modDatosProdOptActionPerformed(evt);
            }

        });
        productoMenu.add(modDatosProdOpt);

        casosUsoMenu.add(productoMenu);

        ordenMenu.setText("Ordenes");

        crearOrdenOpt.setText("Crear orden de compra");
        crearOrdenOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearOrdenOptActionPerformed(evt);
            }
        });
        ordenMenu.add(crearOrdenOpt);

        cancelarOrdOpt.setText("Cancelar orden de compra");
        cancelarOrdOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarOrdenOptActionPerformed(evt);
            }
        });
        ordenMenu.add(cancelarOrdOpt);

        verInfoOrdenOpt.setText("Ver información de orden de compra");
        verInfoOrdenOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInfoOrdenOptActionPerformed(evt);
            }
        });
        ordenMenu.add(verInfoOrdenOpt);

        casosUsoMenu.add(ordenMenu);

        menuBar.add(casosUsoMenu);

        setJMenuBar(menuBar);

        layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        setBounds(100, 100, 700, 1000);
        desktopPane.setBounds(100, 100, 700, 1000);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        pack();
    }

    private void registrarUsrOptActionPerformed(java.awt.event.ActionEvent evt) {
        registrarUsuarioVentana = new RegistrarUsuarioForm(controlarUsuario);

        javax.swing.GroupLayout registrarUsuariosLayout = new javax.swing.GroupLayout(registrarUsuarioVentana.getContentPane());
        registrarUsuarioVentana.getContentPane().setLayout(registrarUsuariosLayout);

        registrarUsuariosLayout.setHorizontalGroup(
                registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(registrarUsuariosLayout.createSequentialGroup())
        );

        registrarUsuariosLayout.setVerticalGroup(
                registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING));

        desktopPane.add(registrarUsuarioVentana);

    }

    private void registrarProdOptActionPerformed(java.awt.event.ActionEvent evt) {
        registrarProductoVentana = new RegistrarProducto(controlarProducto);

        desktopPane.add(registrarProductoVentana);
    }

    private void altaCategoriaOptActionPerformed(java.awt.event.ActionEvent evt) {
        registrarCategoriaVentana = new RegistrarCategoriaForm(controlarProducto);

        javax.swing.GroupLayout registrarUsuariosLayout = new javax.swing.GroupLayout(registrarCategoriaVentana.getContentPane());
        registrarCategoriaVentana.getContentPane().setLayout(registrarUsuariosLayout);

        registrarUsuariosLayout.setHorizontalGroup(
                registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(registrarUsuariosLayout.createSequentialGroup())
        );

        registrarUsuariosLayout.setVerticalGroup(
                registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING));

        desktopPane.add(registrarCategoriaVentana);

    }

    private void crearOrdenOptActionPerformed(java.awt.event.ActionEvent evt) {
        GenerarOrdenDeCompra codec = new GenerarOrdenDeCompra(controlarOrden);
        desktopPane.add(codec);
    }

    private void verInfoOrdenOptActionPerformed(java.awt.event.ActionEvent evt) {
        verOrdenVentana = new VerInformacionOrden(controlarOrden);

        javax.swing.GroupLayout registrarUsuariosLayout = new javax.swing.GroupLayout(verOrdenVentana.getContentPane());
        verOrdenVentana.getContentPane().setLayout(registrarUsuariosLayout);

        registrarUsuariosLayout.setHorizontalGroup(
                registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(registrarUsuariosLayout.createSequentialGroup())
        );

        registrarUsuariosLayout.setVerticalGroup(
                registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING));

        desktopPane.add(verOrdenVentana);
    }

    private void cancelarOrdenOptActionPerformed(java.awt.event.ActionEvent evt) {
        cancelarOrdenVentana = new CancelarOrdenDeCompra(controlarOrden);

        javax.swing.GroupLayout registrarUsuariosLayout = new javax.swing.GroupLayout(cancelarOrdenVentana.getContentPane());
        cancelarOrdenVentana.getContentPane().setLayout(registrarUsuariosLayout);

        registrarUsuariosLayout.setHorizontalGroup(
                registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(registrarUsuariosLayout.createSequentialGroup())
        );

        registrarUsuariosLayout.setVerticalGroup(
                registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING));

        desktopPane.add(cancelarOrdenVentana);
    }

    private void verInfoClienteOptActionPerformed(java.awt.event.ActionEvent evt) {
        verInfoClienteVentana = new VerInformacionClienteForm(controlarUsuario);

        javax.swing.GroupLayout verUsuariosLayout = new javax.swing.GroupLayout(verInfoClienteVentana.getContentPane());
        verInfoClienteVentana.getContentPane().setLayout(verUsuariosLayout);

        verUsuariosLayout.setHorizontalGroup(
                verUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(verUsuariosLayout.createSequentialGroup())
        );

        verUsuariosLayout.setVerticalGroup(
                verUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING));

        desktopPane.add(verInfoClienteVentana);
    }

    private void verInfoProvOptActionPerformed(java.awt.event.ActionEvent evt) {
        verInfoProveedorVentana = new VerInformacionProveedorForm(controlarUsuario);

        javax.swing.GroupLayout verUsuariosLayout = new javax.swing.GroupLayout(verInfoProveedorVentana.getContentPane());
        verInfoProveedorVentana.getContentPane().setLayout(verUsuariosLayout);

        verUsuariosLayout.setHorizontalGroup(
                verUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(verUsuariosLayout.createSequentialGroup())
        );

        verUsuariosLayout.setVerticalGroup(
                verUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING));

        desktopPane.add(verInfoProveedorVentana);
    }

    private void modDatosProdOptActionPerformed(ActionEvent evt) {
        ModificarInformacionProducto vinfo = new ModificarInformacionProducto(controlarProducto);
        desktopPane.add(vinfo);
    }

    private void verInfoProdOptActionPerformed(java.awt.event.ActionEvent evt) {
        VerInfoProductos vinfo = new VerInfoProductos(controlarProducto);
        desktopPane.add(vinfo);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
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

        Map<String, String> esp3 = Collections.synchronizedMap(new HashMap());
        Map<Integer, Producto> prod3 = Collections.synchronizedMap(new HashMap());
        Map<String, Categoria> cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put(
                "iPhone", ManejadorCategorias.getInstance().getCategoria("iPhone"));
        cat1.put(
                "iOS", ManejadorCategorias.getInstance().getCategoria("iOS"));
        cat1.put("Apple", ManejadorCategorias.getInstance().getCategoria("Apple"));

        EspecificacionProducto pr1 = new EspecificacionProducto("IPH5", "iPhone 5", "El último celular de Apple", esp3, (float) 199.0, p1, cat1, prod3);
        controlarProducto.elegirEspProducto(
                "IPH5");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put(
                "iPhone", ManejadorCategorias.getInstance().getCategoria("iPhone"));
        cat1.put(
                "iOS", ManejadorCategorias.getInstance().getCategoria("iOS"));
        cat1.put(
                "Apple", ManejadorCategorias.getInstance().getCategoria("Apple"));
        EspecificacionProducto pr2 = new EspecificacionProducto("IPH4", "iPhone 4S", "El siguiente celular al iPhone 4", esp3, (float) 99.0, p1, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "IPH4");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put(
                "Android", ManejadorCategorias.getInstance().getCategoria("Android"));
        cat1.put(
                "Nexus", ManejadorCategorias.getInstance().getCategoria("Nexus"));

        EspecificacionProducto pr3 = new EspecificacionProducto("NEX4", "Nexus4", "El celular de Google", esp3, (float) 299.0, p2, cat1, prod3);
        controlarProducto.elegirEspProducto(
                "NEX4");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put(
                "Android", ManejadorCategorias.getInstance().getCategoria("Android"));
        cat1.put(
                "Galaxy S3", ManejadorCategorias.getInstance().getCategoria("Galaxy S3"));
        EspecificacionProducto pr4 = new EspecificacionProducto("GA3", "Samsung Galaxy S3", "La versión S3 de la línea Samsung Galaxy", esp3, (float) 415.0, p2, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "GA3");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put(
                "Android", ManejadorCategorias.getInstance().getCategoria("Android"));
        cat1.put(
                "Galaxy S4", ManejadorCategorias.getInstance().getCategoria("Galaxy S4"));
        EspecificacionProducto pr5 = new EspecificacionProducto("GA4", "Samsung Galaxy S4", "La versión S4 de la línea Samsung Galaxy", esp3, (float) 839.99, p2, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "GA4");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put(
                "Android", ManejadorCategorias.getInstance().getCategoria("Android"));
        cat1.put(
                "Galaxy Ace", ManejadorCategorias.getInstance().getCategoria("Galaxy Ace"));
        EspecificacionProducto pr6 = new EspecificacionProducto("AS5", "Galaxy Ace S5830", "La versión Ace de la línea Samsung Galaxy", esp3, (float) 237.0, p2, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "AS5");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put(
                "Protectores", ManejadorCategorias.getInstance().getCategoria("Protectores"));
        EspecificacionProducto pr7 = new EspecificacionProducto("PCG", "Protector de cuero para Galaxy", "Asombroso protector de cuero para Samsung Galaxy I900", esp3, (float) 3.5, p2, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "PCG");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put(
                "Protectores", ManejadorCategorias.getInstance().getCategoria("Protectores"));
        EspecificacionProducto pr8 = new EspecificacionProducto("PMH", "Protector de aluminio para HTC", "El mejor protector de aluminio para HTC Desire HD", esp3, (float) 3.4, p5, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "PMH");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put("Apple", ManejadorCategorias.getInstance().getCategoria("Apple"));
        cat1.put("iOS", ManejadorCategorias.getInstance().getCategoria("iOS"));
        EspecificacionProducto pr9 = new EspecificacionProducto("IRD", "iPad Retina Display", "La última tableta de Apple con pantalla Retina", esp3, (float) 499.0, p1, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "IRD");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put("Apple", ManejadorCategorias.getInstance().getCategoria("Apple"));
        cat1.put("iOS", ManejadorCategorias.getInstance().getCategoria("iOS"));
        EspecificacionProducto pr10 = new EspecificacionProducto("IM", "iPad Mini", "La primera tableta chica de Apple", esp3, (float) 329.0, p1, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "IM");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put("Xbox", ManejadorCategorias.getInstance().getCategoria("Xbox"));
        EspecificacionProducto pr11 = new EspecificacionProducto("RIX", "Receptor inalámbrico para Xbox", "Receptor inalámbrico de color negro para controles de Xbox 360", esp3, (float) 10.99, p4, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "RIX");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put("Xbox", ManejadorCategorias.getInstance().getCategoria("Xbox"));
        EspecificacionProducto pr12 = new EspecificacionProducto("CIX", "Control inalámbrico para Xbox", "Control inalámbrico de 2.4 GHz para Xbox 360 ", esp3, (float) 27.27, p4, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "CIX");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put("Playstation", ManejadorCategorias.getInstance().getCategoria("Playstation"));
        EspecificacionProducto pr13 = new EspecificacionProdºucto("CHP", "Cable HDMI para PS3", "Es un cable HDMI para PS3", esp3, (float) 7.99, p3, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "CHP");
        controlarProducto.lis
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        cat1 = Collections.synchronizedMap(new HashMap());

        cat1.put("Playstation", ManejadorCategorias.getInstance().getCategoria("Playstation"));
        EspecificacionProducto pr14 = new EspecificacionProducto("CP3", "Control para PS3", "Control inalámbrico Dualshock 3 de color azul para Playstation 3", esp3, (float) 30.8, p3, cat1, prod3);

        controlarProducto.elegirEspProducto(
                "CP3");
        controlarProducto.agregarMultiplesProductosAutogenerados(10);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr1);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr2);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr3);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr4);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr5);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr6);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr7);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr8);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr9);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr10);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr11);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr12);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr13);
        ManejadorEspProductos.getInstance()
                .agregarEspecificacionProducto(pr14);

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

}
