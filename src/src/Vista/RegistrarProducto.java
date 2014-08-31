/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Clases.IControladorProductos;
import Controlador.Clases.Utils;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author rodro
 */
public class RegistrarProducto extends javax.swing.JInternalFrame {
    
    
    RegistrarProducto(IControladorProductos controlarProducto) {
        
        Utils.generarDatosDePrueba();
                
        setBounds(50, 50, 800, 500); 
        setVisible(true);
        setLayout(new SpringLayout());

        setTitle("Registrar Producto");
        
        Formulario form = new Formulario();
        
        form.addField("Titulo", "text");
        form.addField("NroRef", "text");
        form.addField("Descripcion", "text");
        form.addField("Especificaciones", "textarea");
        form.addField("Precio", "text");
        form.addField("Proveedor", "combo");
        
        
        SelectorDeImagenes sdi = new SelectorDeImagenes();
        
        sdi.setLocation(700, 10);
       
      
        
        JButton elegirCategoria  = new JButton("Elegir Categorias");
        elegirCategoria.setSize(100,40);
        elegirCategoria.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog();
             }
        });
        
        JPanel offsetleft = new JPanel(); 
        offsetleft.setLayout(new BorderLayout());
        offsetleft.setSize(400, 500);
        offsetleft.setVisible(true);
        offsetleft.setLocation(0, 10);
        offsetleft.add(form,BorderLayout.CENTER);
        offsetleft.add(elegirCategoria,BorderLayout.NORTH);
        
        add(offsetleft); 
        add(sdi);
        
        
        SpringUtilities.makeGrid(this.getContentPane(),1,2,0,0,6,6);
        
    }
    private void openDialog(){
        JDialog dialog =  new JDialog();
        dialog.setTitle("Elegir Categoria");
        ElegirCategoriaComponente treePane =  new ElegirCategoriaComponente();
        dialog.getContentPane().setSize(400,400);
        dialog.getContentPane().add(treePane, BorderLayout.CENTER);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(new Dimension(400, 400));
        dialog.setLocationRelativeTo(this);
        dialog.setModal(true);
        dialog.setVisible(true);
    
    }
    
 

}
