/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Clases.IControladorOrdenes;
import Controlador.Clases.ManejadorOrdenes;
import Controlador.DataTypes.DataOrdenCompra;
import static Vista.VentanaPrincipal.controlarProducto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.function.Predicate;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.TableModel;

/**
 *
 * @author rodro
 */
public class GenerarOrdenDeCompra extends JInternalFrame {

    private final IControladorOrdenes controlarOrden;
    private final ElegirCategoriaComponente treePane;
    private final JPanel listaProductosPanel;
    private final JPanel offsetleft;
    private final JPanel buttonContainer;
    private final JButton saveButton;
    private final JButton cancelarButton;
    private final JPanel InfoPanel;
    private final JPanel thirdPanel;
    private JDialog dialog;
    private int index;
    private Formulario form;
    private JTable carrito;
    private Item currentItem;
    private ArrayList<Item> carritoArray;
    private int indCompra;
    private final JPanel buttonContainerNorth;
    private JTable listarClientes;

    GenerarOrdenDeCompra(IControladorOrdenes controlarOrden) {
        this.controlarOrden = controlarOrden;
        setBounds(50, 50, 1000, 500);
        setVisible(true);
        setLayout(new SpringLayout());

        setTitle("Crear Orden");

        carritoArray = new ArrayList<GenerarOrdenDeCompra.Item>();

        JButton elegirCategoria = new JButton("Elegir Categorias");
        elegirCategoria.setSize(100, 40);
        elegirCategoria.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                openDialog();
            }
        });
       JButton elegirCliente = new JButton("Elegir Cliente");
        elegirCliente.setSize(100, 40);
        elegirCliente.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                listarYElegirCliente();
            }
        });
        treePane = new ElegirCategoriaComponente(controlarProducto, true);
        listaProductosPanel = new JPanel();
        listaProductosPanel.setLayout(new GridLayout(1, 0));
        buttonContainerNorth = new JPanel(new FlowLayout());
        buttonContainerNorth.setSize(400, 500);
        buttonContainerNorth.setVisible(true);
        buttonContainerNorth.add(elegirCategoria);
        buttonContainerNorth.add(elegirCliente);
        
        offsetleft = new JPanel();
        offsetleft.setLayout(new BorderLayout());
        offsetleft.setSize(400, 500);
        offsetleft.setVisible(true);
        offsetleft.setLocation(0, 10);
        offsetleft.add(buttonContainerNorth, BorderLayout.NORTH);
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
                ordenar();
            }
        });
        setTitle("Generar orden de compra");

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
    private void listarYElegirCliente(){
        dialog = new JDialog();
        dialog.setTitle("Elegir Cliente");

        JButton aceptarButton = new JButton("Listo!!");
        aceptarButton.setSize(80, 30);
        aceptarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
                elegirCliente();
            }
        });
        Object[][] rowData = new Object[controlarOrden.listarClientes().size()][2];
        index = 0;
        controlarOrden.listarClientes().stream().forEach((cliente) -> {
             Object[] obj={cliente.getNickname(),cliente.getEmail()};
             rowData[index] = obj;
             index++;        
        });
        String[] columnNames={"Nickname","Email"};
        listarClientes = new JTable(rowData, columnNames);
        listarClientes.setPreferredScrollableViewportSize(new Dimension(440, 100));
        listarClientes.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(listarClientes);
        JPanel clientesPane = new JPanel();
        clientesPane.add(scrollPane);
        clientesPane.revalidate();
        clientesPane.repaint();
        clientesPane.setSize(400, 400);
        dialog.getContentPane().setSize(440, 400);
        dialog.getContentPane().add(clientesPane, BorderLayout.CENTER);
        dialog.getContentPane().add(aceptarButton, BorderLayout.SOUTH);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(new Dimension(500, 400));
        dialog.setLocationRelativeTo(this);
        dialog.setModal(true);
        dialog.setVisible(true);
    }
    private void elegirCliente(){
        TableModel model = listarClientes.getModel();
        int row = listarClientes.getSelectedRow();
        String Nickname = (String) model.getValueAt(row, 0);
        String Email = (String) model.getValueAt(row, 1);
        System.out.print(Nickname);
        controlarOrden.elegirCliente(Nickname); 
    }
    private void cancel() {
        dispose();
    }

    private void ordenar() {
        Integer id= controlarOrden.getNextId();
        DataOrdenCompra dataOrden = new DataOrdenCompra(id);
        controlarOrden.guardarOrden(dataOrden);
        
        System.out.println(ManejadorOrdenes.getInstance().obtenerOrdenes().get(id)+" orden");
        JOptionPane.showMessageDialog(this, "Su Orden se ha creado correctamente", "Validacion", JOptionPane.INFORMATION_MESSAGE);

        dispose();
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
            Object[] obj = {c.getNroReferencia(), c.getNombre(),c.getStock()};

            rowData[index] = obj;
            index++;
        });
        String[] columnNames = {"NroRef", "Nombre","Stock"};

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
        String nombre = (String) model.getValueAt(row, 1);
        Integer cantidad = (Integer) model.getValueAt(row, 2);
        currentItem = new Item(nroRef, nombre, cantidad);
//        controlarProducto.elegirEspProducto(nroRef);
//        DataEspecificacionProducto dataProducto = controlarProducto.mostrarDatosProducto(nroRef);

        form = new Formulario(true);
        form.addField("Cantidad", "text");

        JButton agregarCarrito = new JButton("Agregar");
        agregarCarrito.setSize(100, 40);
        agregarCarrito.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                agregar();
            }
        });
        InfoPanel.add(agregarCarrito, BorderLayout.SOUTH);
        InfoPanel.add(form, BorderLayout.CENTER);
        InfoPanel.revalidate();
        InfoPanel.repaint();

        saveButton.setVisible(true);
    }

    public void cancelarLinea(MouseEvent e) {

        TableModel model = carrito.getModel();
        int col = carrito.getSelectedColumn();
        if (col == 3) {
            String ref = (String) model.getValueAt(carrito.getSelectedRow(), 0);
            Predicate<Item> pre = new Predicate<Item>() {

                @Override
                public boolean test(Item t) {
                    return t.nroRef == ref;
                }
            };
            controlarOrden.removerEspecificacionProducto(ref);
            carritoArray.removeIf(pre);
            renderCarrito();
        }
    }

    public void agregar() {

        String cantidad = ((JTextField) form.getComponentByName("Cantidad")).getText();
        Integer cantidadReal = null;

        try {
            cantidadReal = Integer.parseInt(cantidad);
            if (cantidadReal <= 0) {
                JOptionPane.showMessageDialog(this, "Cantidad debe ser un numero Entero", "Validacion", JOptionPane.ERROR_MESSAGE);

            } else if(cantidadReal > currentItem.cantidad){
                JOptionPane.showMessageDialog(this, "Cantidad debe ser menor o igual al stock del producto", "Validacion", JOptionPane.ERROR_MESSAGE);
            } else {
                currentItem.cantidad = cantidadReal;
                System.out.println(cantidadReal+" nroref "+currentItem.nroRef);
                controlarOrden.elegirEspecificacionProducto(currentItem.nroRef);
                controlarOrden.elegirCantidadProducto(currentItem.cantidad);
                controlarOrden.generarItemOrden();
                carritoArray.add(currentItem);
                renderCarrito();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantidad debe ser un numero Entero", "Validacion", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void renderCarrito() {
        thirdPanel.removeAll();

        String[] columnNames = {"NroRef", "Nombre", "Cantidad", "Cancelar"};
        Object[][] rowData = new Object[carritoArray.size()][4];
        indCompra = 0;
        carritoArray.forEach((it) -> {
            Object[] obj = {it.nroRef, it.titulo, String.valueOf(it.cantidad), "Cancelar"};
            rowData[indCompra] = obj;
            indCompra++;
        });

        carrito = new JTable(rowData, columnNames);
        carrito.setPreferredScrollableViewportSize(new Dimension(500, 100));
        carrito.setFillsViewportHeight(true);

        carrito.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cancelarLinea(e);
            }
        });

        JScrollPane scrollPane = new JScrollPane(carrito);
        thirdPanel.add(scrollPane);

        thirdPanel.revalidate();
        thirdPanel.repaint();
    }

    public class Item {

        public String nroRef;
        public String titulo;
        public Integer cantidad;

        public Item(String nroRef, String titulo, Integer cantidad) {
            this.nroRef = nroRef;
            this.titulo = titulo;
            this.cantidad = cantidad;
        }

    }
}
