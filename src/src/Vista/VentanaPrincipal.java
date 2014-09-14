package Vista;

import Controlador.Clases.Fabrica;
import Controlador.Clases.IControladorOrdenes;
import Controlador.Clases.IControladorProductos;
import Controlador.Clases.IControladorUsuarios;
import Controlador.Clases.Utils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    private JMenuItem cargarDatosDePrueba;

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
        cargarDatosDePrueba = new javax.swing.JMenuItem();
        cargarDatosDePrueba.setText("Cargar datos de Prueba");
        cargarDatosDePrueba.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loadTestData();
            }

        });

        menuBar.add(cargarDatosDePrueba);
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

        desktopPane.add(registrarUsuarioVentana);

    }

    private void registrarProdOptActionPerformed(java.awt.event.ActionEvent evt) {
        registrarProductoVentana = new RegistrarProducto(controlarProducto);

        desktopPane.add(registrarProductoVentana);
    }

    private void loadTestData() {
        cargarDatosDePrueba.setEnabled(false);
        Utils.generarDatosDePrueba();
        JOptionPane.showMessageDialog(this, "Se cargaron los datos de prueba", "Datos de Prueba", JOptionPane.INFORMATION_MESSAGE);
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
        verOrdenVentana = new VerInformacionOrden(controlarOrden,false);
        desktopPane.add(verOrdenVentana);
    }

    private void cancelarOrdenOptActionPerformed(java.awt.event.ActionEvent evt) {
        cancelarOrdenVentana  = new VerInformacionOrden(controlarOrden,true);

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

    }

}
