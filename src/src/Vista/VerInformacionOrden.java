/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Clases.IControladorOrdenes;
import Controlador.Clases.ManejadorOrdenes;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataOrdenCompra;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author darius
 */
public class VerInformacionOrden extends JInternalFrame{
    
    private final IControladorOrdenes controlarOrden;
    private final JPanel contenedor ;
    private final JList<String> ordenList;
    private final JLabel nroRef;
    private final JLabel fechaVenta;
    private final JLabel precioTotal;
    private final JLabel cliente;
    private final JLabel productos;
    private final JTextField precioTotalText;
    private final JTextField nroRefText;
    private final JTextField clienteText;
    private JList<String> productosList;
    private final JCalendar fechaVentaText;
    private final JButton cancelarBtn;
    private final JDayChooser as;
    
    public VerInformacionOrden(IControladorOrdenes ICO){
        controlarOrden = ICO;
        System.out.println("Orden de Compra: ");
        System.out.println(ManejadorOrdenes.getInstance().obtenerOrdenes().get(1));
        setBounds(50, 50, 700, 400);
        setVisible(true);
        setLayout(null);
        contenedor = new JPanel();
        contenedor.setLayout(null);
        contenedor.setSize(700, 400);
        contenedor.setLocation(10, 0);
        add(contenedor);
        
        JLabel elegirUsuarioLabel = new JLabel("Elegir Orden De Compra:");
        elegirUsuarioLabel.setVisible(true);
        elegirUsuarioLabel.setBounds(0, 10, 150, 20);
        contenedor.add(elegirUsuarioLabel);

        DefaultListModel<String> tes = new DefaultListModel<String>();
        ArrayList<DataOrdenCompra> ordenes = controlarOrden.listarOrdenes();
        ordenes.stream().forEach((orden) -> {
            tes.addElement(orden.getNroOrden() + " - " + orden.getClienteCompraProducto().get(0).getCliente().getNickname() + " - " + orden.getFecha().toString());
        });
        ordenList = new JList<String>(tes);
        ordenList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ordenList.setBounds(0, 50, 200, 300);
        ordenList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent evt){
                if(evt.getValueIsAdjusting())
                    return;
                DataOrdenCompra aux = new DataOrdenCompra(ManejadorOrdenes.getInstance().obtenerOrdenes().get(ordenList.getSelectedValue().split("-")[0].trim()));
                controlarOrden.elegirOrden(aux.getNroOrden());
                nroRefText.setText(String.valueOf(aux.getNroOrden()));
                fechaVentaText.setDate(aux.getFecha());
                precioTotalText.setText(String.valueOf(aux.getPrecioTotal()));
                clienteText.setText(aux.getClienteCompraProducto().get(0).getCliente().getNickname());
                DefaultListModel<String> tes2 = new DefaultListModel<String>();
                ArrayList<DataEspecificacionProducto> productosLst = controlarOrden.listarProductosEnOrden();
                
                productosLst.stream().forEach((producto) -> {
                    tes2.addElement(producto.getNroReferencia() + " - "+producto.getNombre() + " - $"+producto.getPrecio());
                });
                productosList.setModel(tes2);
            }
        });
        contenedor.add(ordenList);
        
        nroRef = new JLabel("Numero de referencia");
        nroRef.setVisible(true);
        nroRef.setBounds(220, 60, 150, 10);
        contenedor.add(nroRef);
        
        nroRefText = new JTextField();
        nroRefText.setBounds(370, 50, 300, 30);
        contenedor.add(nroRefText);
        
        fechaVenta = new JLabel("Fecha de venta");
        fechaVenta.setVisible(true);
        fechaVenta.setBounds(220, 100, 150, 10);
        contenedor.add(fechaVenta);
        as = new JDayChooser();
                
        fechaVentaText = new JCalendar();
         
        fechaVentaText.setBounds(370, 90, 300, 30);
        contenedor.add(fechaVentaText);
        
        precioTotal = new JLabel("Precio total");
        precioTotal.setVisible(true);
        precioTotal.setBounds(220, 140, 150, 10);
        contenedor.add(precioTotal);
        
        precioTotalText = new JTextField();
        precioTotalText.setBounds(370, 130, 300, 30);
        contenedor.add(precioTotalText);
        
        cliente = new JLabel("Cliente");
        cliente.setVisible(true);
        cliente.setBounds(220, 180, 150, 10);
        contenedor.add(cliente);
        
        clienteText = new JTextField();
        clienteText.setBounds(370, 170, 300, 30);
        contenedor.add(clienteText);
        
        productos = new JLabel("Productos");
        productos.setVisible(true);
        productos.setBounds(220, 220, 150, 10);
        contenedor.add(productos);
        
        productosList = new JList<String>(new DefaultListModel<String>());
        productosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productosList.setBounds(220, 240, 450, 80);
        contenedor.add(productosList);
       
        cancelarBtn = new JButton("Cancelar");
       
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 cancelar(e);
            }
        });
        
        cancelarBtn.setBounds(250, 330, 100, 40);
        contenedor.add(cancelarBtn);
        
        
    }
    
    private void guardarCategoria(ActionEvent evt) {
        Integer nroOrden = Integer.valueOf(nroRefText.getText());
        
        controlarOrden.elegirOrden(nroOrden);
        controlarOrden.borrarOrdenCompra();
        setVisible(false);
        nroRefText.setText("");
    }

    private void cancelar(ActionEvent evt) {
        setVisible(false);
        nroRefText.setText("");
        fechaVentaText.setDate(new Date());
        precioTotalText.setText("");
        clienteText.setText("");
    }
    
}
