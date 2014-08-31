/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Clases.IControladorProductos;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author rodro
 */
public class RegistrarProducto extends javax.swing.JInternalFrame {
    
    
    RegistrarProducto(IControladorProductos controlarProducto) {

        setBounds(50, 50, 700, 400);

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
        form.setLocation(0, 10);
        add(form); 
        add(sdi);
        SpringUtilities.makeGrid(this.getContentPane(),1,2,0,0,6,6);
    }
 
    
 

}
