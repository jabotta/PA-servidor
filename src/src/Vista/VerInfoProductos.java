/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Clases.IControladorProductos;
import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProveedor;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.TableModel;

/**
 *
 * @author rodro
 */
public class VerInfoProductos extends JInternalFrame {

    private String nroRef;
    private JDialog dialog;
    private final ElegirCategoriaComponente treePane;
    private final JPanel InfoPanel;
    private final JPanel offsetleft;
    private final IControladorProductos controlarProducto;

    private int index;
    private final JPanel listaProductosPanel;
    private Formulario form; 
    private JButton saveButton;
    private JButton cancelarButton;
    private JPanel buttonContainer;

    /**
     * Creates new form VerInfoProductos
     */
    public VerInfoProductos(IControladorProductos controlarProducto) {

        this.controlarProducto = controlarProducto;
    

        setBounds(50, 50, 800, 700);
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
        add(offsetleft);
        add(InfoPanel);

        SpringUtilities.makeGrid(this.getContentPane(), 1, 2, 0, 0, 6, 6);

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
        
        TableModel model = listaProductos.getModel();
        int row = listaProductos.getSelectedRow();
        String nroRef = (String) model.getValueAt(row, 0);
        DataEspecificacionProducto dataProducto = controlarProducto.mostrarDatosProducto(nroRef);
        form = new Formulario(false);
        form.addField("Nombre", "text", null, dataProducto.getNombre());
        form.addField("NroRef", "text", null, dataProducto.getNroReferencia());
        form.addField("Descripcion", "text", null, dataProducto.getDescripcion());
        String especificaciones = "";
        for(String iter: dataProducto.getEspecificacion().keySet()){
            especificaciones += iter + ": "+ dataProducto.getEspecificacion().get(iter) + "\n";
        }
        form.addField("Especificaciones", "textarea", null, especificaciones);
        String categorias = "";
        for(DataCategoria iter: dataProducto.getCategorias()){
            categorias += iter.getNombre() + "\n";
        }
        form.addField("Categorias", "textarea", null, categorias);
        DataProveedor proveedor = dataProducto.getProveedor();
        form.addField("Proveedor", "text", null, proveedor.getNickname() + " " + proveedor.getNombre() + " " + proveedor.getApellido());
        form.addIMGField("Imagenes",   dataProducto.getImagenes(),false);

        InfoPanel.add(form, BorderLayout.CENTER);
        InfoPanel.revalidate();
        InfoPanel.repaint();  

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
