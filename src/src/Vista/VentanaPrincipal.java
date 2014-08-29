package Vista;

import Controlador.Clases.Fabrica;
import Controlador.Clases.IControladorOrdenes;
import Controlador.Clases.IControladorProductos;
import Controlador.Clases.IControladorUsuarios;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
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
    private JPanel panelRegistrarUsuario;
    private JPanel panelRegistrarCategoria;
    // End of variables declaration
    
    public static Integer idUsuariosControlador;
    public static Integer idProductosControlador;
    public static Integer idOrdenesControlador;
    public static IControladorUsuarios controlarUsuario;
    public static IControladorProductos controlarProducto;
    public static IControladorOrdenes controlarOrden;
    
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
        ordenMenu.add(cancelarOrdOpt);

        verInfoOrdenOpt.setText("Ver información de orden de compra");
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
        setBounds(100, 100, 500, 900);
        pack();
    }                       

    private void registrarUsrOptActionPerformed(java.awt.event.ActionEvent evt) {                                                
        registrarUsuarioVentana = new javax.swing.JInternalFrame();
        panelRegistrarUsuario = new RegistrarUsuarioForm(controlarUsuario);
        
        javax.swing.GroupLayout registrarUsuariosLayout = new javax.swing.GroupLayout(registrarUsuarioVentana.getContentPane());
        registrarUsuarioVentana.getContentPane().setLayout(registrarUsuariosLayout);
        
        registrarUsuariosLayout.setHorizontalGroup(
            registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(registrarUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        registrarUsuariosLayout.setVerticalGroup(
            registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelRegistrarUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        desktopPane.add(registrarUsuarioVentana);
        registrarUsuarioVentana.setBounds(50, 50, 700, 400);
        registrarUsuarioVentana.setVisible(true);
    }                                               

    private void registrarProdOptActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void altaCategoriaOptActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        registrarCategoriaVentana = new javax.swing.JInternalFrame();
        panelRegistrarCategoria = new RegistrarCategoriaForm(controlarProducto);
        
        javax.swing.GroupLayout registrarUsuariosLayout = new javax.swing.GroupLayout(registrarCategoriaVentana.getContentPane());
        registrarCategoriaVentana.getContentPane().setLayout(registrarUsuariosLayout);
        
        registrarUsuariosLayout.setHorizontalGroup(
            registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(registrarUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRegistrarCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        
        registrarUsuariosLayout.setVerticalGroup(
            registrarUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelRegistrarCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        desktopPane.add(registrarCategoriaVentana);
        registrarCategoriaVentana.setBounds(50, 50, 700, 400);
        registrarCategoriaVentana.setVisible(true);
    }                                                

    private void crearOrdenOptActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void verInfoClienteOptActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void verInfoProvOptActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void verInfoProdOptActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
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
