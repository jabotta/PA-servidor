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
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.TableModel;

/**
 *
 * @author rodro
 */
public class ModificarInformacionProducto extends JInternalFrame {

    private String nroRef;
    private JDialog dialog;
    private ElegirCategoriaComponente treePane;
    private final JPanel InfoPanel;
    private final JPanel offsetleft;
    private final IControladorProductos controlarProducto;

    private int index;
    private final JPanel listaProductosPanel;
    private Formulario form;
    private JButton saveButton;
    private JButton cancelarButton;
    private JPanel buttonContainer;
    private final JPanel thirdPanel;
    private SelectorDeImagenes sdi;

    /**
     * Creates new form VerInfoProductos
     */
    public ModificarInformacionProducto(IControladorProductos controlarProducto) {

        this.controlarProducto = controlarProducto;

        setBounds(00, 00, 1000, 700);
        setVisible(true);
        setLayout(new SpringLayout());

        JButton elegirCategoria = new JButton("Elegir Categorias");
        elegirCategoria.setSize(100, 40);
        elegirCategoria.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog();
            }
        });
        treePane = new ElegirCategoriaComponente(controlarProducto, true);
        listaProductosPanel = new JPanel();
        listaProductosPanel.setLayout(new GridLayout(1, 0));

        offsetleft = new JPanel();
        offsetleft.setLayout(new BorderLayout());
        offsetleft.setSize(400, 500);
        offsetleft.setVisible(true);
        offsetleft.setLocation(0, 10);
        offsetleft.add(elegirCategoria, BorderLayout.NORTH);
        offsetleft.add(listaProductosPanel, BorderLayout.CENTER);
        buttonContainer = new JPanel(new FlowLayout());
        buttonContainer.setSize(400, 500);
        buttonContainer.setVisible(true);

        saveButton = new JButton("Guardar");
        saveButton.setVisible(false);

        saveButton.setSize(100, 40);
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });
        setTitle("Modificar Informacion de Producto");

        buttonContainer.add(saveButton);
        cancelarButton = new JButton("Cancelar");
        cancelarButton.setSize(100, 40);
        cancelarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });
        buttonContainer.add(cancelarButton);
        offsetleft.add(buttonContainer, BorderLayout.SOUTH);
        InfoPanel = new JPanel();
        InfoPanel.setSize(400, 500);
        InfoPanel.setLayout(new BorderLayout());

        thirdPanel = new JPanel();
        thirdPanel.setSize(400, 500);
        thirdPanel.setLayout(new BorderLayout());

        add(offsetleft);
        add(InfoPanel);
        add(thirdPanel);

        SpringUtilities.makeGrid(this.getContentPane(), 1, 3, 0, 0, 6, 6);

    }

    private void save() {
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

        controlarProducto.modificarDatosEspecificacionProducto(espProducto);

        controlarProducto.listarCategoriasAModificar().forEach((cat) -> {

            controlarProducto.borrarCategoriaAEspecificacion(cat.getNombre());
        });
        for(String iter : especificaciones.split("\n")){
            String[] iter2 = iter.split(":");
            if (iter2.length != 2) {
                JOptionPane.showMessageDialog(this, "Las especificaciones deben ingresarse con el formato 'Tipo: Description'", "Validacion", JOptionPane.ERROR_MESSAGE);
                return;
            }
            controlarProducto.ingresarEspecificacion(iter2[0], iter2[1].trim());
        }
        controlarProducto.elegirProveedor(Proveedor.getNickname());
        controlarProducto.ingresarDatosProductos(espProducto);

        controlarProducto.agregarMultiplesProductosAutogenerados(stockReal);

        categorias.forEach((cat) -> {
            controlarProducto.agregarCategoriaAEspecificacion(cat);
        });
        imagenes.forEach((img) -> {
            controlarProducto.agregarImagen(img);
        });

        if (controlarProducto.validarInfo()) {
            try {
                controlarProducto.guardarEspProductoModificado();
                JOptionPane.showMessageDialog(this, "Su Producto se ha creado correctamente", "Validacion", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Validacion", JOptionPane.ERROR_MESSAGE);

            }
        } else {

            JOptionPane.showMessageDialog(this, "2Sus datos no son correctos, Verifique", "Validacion", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void cancel() {
        dispose();
    }

    private void listarProductos() {
        listaProductosPanel.removeAll();
        listaProductosPanel.revalidate();
        listaProductosPanel.repaint();

        if (!treePane.getSelectedCategories().isEmpty()) {
            String catName = treePane.getSelectedCategories().iterator().next();
            controlarProducto.elegirCategoria(catName);
        }
        Object[][] rowData = new Object[controlarProducto.listarProductosCategoria().size()][2];
        index = 0;

        controlarProducto.listarProductosCategoria().forEach((c) -> {
            Object[] obj = {c.getNroReferencia(), c.getNombre()};

            rowData[index] = obj;
            index++;
        });
        String[] columnNames = {"NroRef", "Nombre"};

        JTable listaProductos = new JTable(rowData, columnNames);
        listaProductos.setPreferredScrollableViewportSize(new Dimension(500, 100));
        listaProductos.setFillsViewportHeight(true);

        listaProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                printDataProducto(listaProductos);
            }
        });

        JScrollPane scrollPane = new JScrollPane(listaProductos);
        listaProductosPanel.add(scrollPane);
        listaProductosPanel.revalidate();
        listaProductosPanel.repaint();
        revalidate();
        repaint();
    }

    private void printDataProducto(JTable listaProductos) {

        InfoPanel.removeAll();
        thirdPanel.removeAll();
        TableModel model = listaProductos.getModel();
        int row = listaProductos.getSelectedRow();
        String nroRef = (String) model.getValueAt(row, 0);
        controlarProducto.elegirEspProducto(nroRef);
        DataEspecificacionProducto dataProducto = controlarProducto.mostrarDatosProducto(nroRef);
        form = new Formulario(true);
        form.addField("Titulo", "text", null, dataProducto.getNombre());
        form.addField("NroRef", "text", null, dataProducto.getNroReferencia());
        form.addField("Descripcion", "text", null, dataProducto.getDescripcion());
        
        String especificaciones = "";
        for(String iter: dataProducto.getEspecificacion().keySet()){
            especificaciones += iter + ": "+ dataProducto.getEspecificacion().get(iter) + "\n";
        }
        form.addField("Especificaciones", "textarea", null, especificaciones);
        form.addField("Precio", "text", null, String.valueOf(dataProducto.getPrecio()));
        form.addField("Stock", "text", null, String.valueOf(dataProducto.getProductos().size()));
        form.addField("Proveedor", "combo", controlarProducto.listarProveedores().toArray(), null);

        ((JComboBox) form.getComponentByName("Proveedor")).setSelectedItem(dataProducto.getProveedor());

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
        InfoPanel.add(elegirCategoria, BorderLayout.NORTH);
        InfoPanel.add(form, BorderLayout.CENTER);
        InfoPanel.revalidate();
        InfoPanel.repaint();

        thirdPanel.add(sdi);
        thirdPanel.revalidate();
        thirdPanel.repaint();
        saveButton.setVisible(true);

        sdi.load(dataProducto.getImagenes());
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
                listarProductos();
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
