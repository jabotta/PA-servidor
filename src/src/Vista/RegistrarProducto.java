/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Clases.IControladorProductos;
import Controlador.Clases.Utils;
import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author rodro
 */
public class RegistrarProducto extends javax.swing.JInternalFrame {

    private JDialog dialog;
    private ElegirCategoriaComponente treePane;
    private final Formulario form;
    private final IControladorProductos controlarProducto;
    private final SelectorDeImagenes sdi;

    RegistrarProducto(IControladorProductos controlarProducto) {

        this.controlarProducto = controlarProducto;
     
        setBounds(50, 50, 800, 500);
        setVisible(true);
        setLayout(new SpringLayout());

        setTitle("Registrar Producto");
 
        form = new Formulario();

        form.addField("Titulo", "text");
        form.addField("NroRef", "text");
        form.addField("Descripcion", "text");
        form.addField("Especificaciones", "textarea");
        form.addField("Precio", "text");
        form.addField("Stock", "text");
        form.addField("Proveedor", "combo", controlarProducto.listarProveedores().toArray(),null);


        treePane = new ElegirCategoriaComponente(controlarProducto, false);
        sdi = new SelectorDeImagenes();
        sdi.setLocation(700, 10);


        JButton elegirCategoria = new JButton("Elegir Categorias");
        elegirCategoria.setSize(100, 40);
        elegirCategoria.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog();
            }
        });
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setSize(200, 200);
        buttonsPanel.setVisible(true);
        JButton salvar = new JButton("Guardar");
        salvar.setSize(80, 30);
        salvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                validar();
            }
        });
        JButton cancelar = new JButton("Cancelar");
        cancelar.setSize(80, 30);
        cancelar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        buttonsPanel.add(salvar);
        buttonsPanel.add(cancelar);

        JPanel offsetleft = new JPanel();
        offsetleft.setLayout(new BorderLayout());
        offsetleft.setSize(400, 500);
        offsetleft.setVisible(true);
        offsetleft.setLocation(0, 10);
        offsetleft.add(buttonsPanel, BorderLayout.SOUTH);
        offsetleft.add(form, BorderLayout.CENTER);
        offsetleft.add(elegirCategoria, BorderLayout.NORTH);

        add(offsetleft);
        add(sdi);

        SpringUtilities.makeGrid(this.getContentPane(), 1, 2, 0, 0, 6, 6);

    }

    private void cancelar() {
        this.dispose();

    }

    private void validar() {
        String titulo = ((JTextField) form.getComponentByName("Titulo")).getText();
        String NroRef = ((JTextField) form.getComponentByName("NroRef")).getText();
        String descripcion = ((JTextField) form.getComponentByName("Descripcion")).getText();
        String especificaciones = ((JTextArea) form.getComponentByName("Especificaciones")).getText();
        String precio = ((JTextField) form.getComponentByName("Precio")).getText();
        String Stock = ((JTextField) form.getComponentByName("Stock")).getText();
        DataProveedor Proveedor = (DataProveedor) ((JComboBox) form.getComponentByName("Proveedor")).getSelectedItem();
        HashSet<String> categorias = treePane.getSelectedCategories();
        HashSet<String> imagenes = this.sdi.getListaDeImagenes();
        Float precioReal = null;
        Integer stockReal = null;
        try {
            stockReal = Integer.parseInt(Stock);
            precioReal = Float.parseFloat(precio);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio y Stock deben ser un numero valido", "Validacion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Utils.formatString(titulo).isEmpty() || Utils.formatString(NroRef).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Titulo,NroRef,Proveedor son requeridos", "Validacion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (categorias.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe elegir una Categoria para el producto", "Validacion", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (Proveedor == null) {
            JOptionPane.showMessageDialog(this, "Debe elegir una Proveedor para el producto", "Validacion", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DataEspecificacionProducto espProducto = new DataEspecificacionProducto(NroRef, titulo, descripcion, new HashMap(), precioReal, Proveedor, new ArrayList<String>(), new ArrayList<DataCategoria>(), new ArrayList());
        controlarProducto.elegirProveedor(Proveedor.getNickname());
        controlarProducto.ingresarDatosProductos(espProducto);
        
        for(String iter : especificaciones.split("\n")){
            String[] iter2 = iter.split(":");
            if (iter2.length != 2) {
                JOptionPane.showMessageDialog(this, "Las especificaciones deben ingresarse con el formato 'Tipo: Description'", "Validacion", JOptionPane.ERROR_MESSAGE);
                return;
            }
            controlarProducto.ingresarEspecificacion(iter2[0], iter2[1].trim());
        }
       

        controlarProducto.agregarMultiplesProductosAutogenerados(stockReal);

        categorias.forEach((cat) -> {
            controlarProducto.agregarCategoriaAEspecificacion(cat);
        });
        imagenes.forEach((img) -> { 
            controlarProducto.agregarImagen(img);
        });
        if (controlarProducto.controlarErrores()) {
            try {
                controlarProducto.guardarProducto();
                JOptionPane.showMessageDialog(this, "Su Producto se ha creado correctamente", "Validacion", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Sus datos no son correctos, Verifique", "Validacion", JOptionPane.ERROR_MESSAGE);

            }
        }else{
           
            JOptionPane.showMessageDialog(this, "Sus datos no son correctos, Verifique", "Validacion", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void openDialog() {
        dialog = new JDialog();
        dialog.setTitle("Elegir Categoria");

        JButton aceptarButton = new JButton("Listo!!");
        aceptarButton.setSize(80, 30);
        aceptarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.getContentPane().setSize(400, 400);
        dialog.getContentPane().add(treePane, BorderLayout.CENTER);
        dialog.getContentPane().add(aceptarButton, BorderLayout.SOUTH);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(new Dimension(400, 400));
        dialog.setLocationRelativeTo(this);
        dialog.setModal(true);
        dialog.setVisible(true);

    }

}
