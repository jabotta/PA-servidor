/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Clases.Categoria;
import Controlador.Clases.Cliente;
import Controlador.Clases.EspecificacionProducto;
import Controlador.Clases.IControladorOrdenes;
import Controlador.Clases.ManejadorCategorias;
import Controlador.Clases.ManejadorEspProductos;
import Controlador.Clases.ManejadorOrdenes;
import Controlador.Clases.ManejadorProductos;
import Controlador.Clases.ManejadorUsuarios;
import Controlador.Clases.Producto;
import Controlador.Clases.Proveedor;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataOrdenCompra;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
public class CancelarOrdenDeCompra extends JInternalFrame{
    
    private final IControladorOrdenes controlarOrden;
    private final JPanel contenedor ;
    private final JList ordenList;
    private final JLabel nroRef;
    private final JLabel fechaVenta;
    private final JLabel precioTotal;
    private final JLabel cliente;
    private final JLabel productos;
    private final JTextField precioTotalText;
    private final JTextField nroRefText;
    private final JTextField clienteText;
    private JList productosList;
    private final JCalendar fechaVentaText;
    private final JButton borrarBtn;
    private final JButton cancelarBtn;
    private final JDayChooser as;
    
    public CancelarOrdenDeCompra(IControladorOrdenes ICO){
        controlarOrden = ICO;
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("abotta", "Andres", "Botta", "abotta@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("dlevy", "Dario", "Levy", "dlevy@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("rrossi", "Rodrigo", "Rossi", "rrossi@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("ldeniz", "Leroy", "Deniz", "ldeniz@mail.com", new Date(1987, 02, 22)));
        ManejadorUsuarios.getInstance().agregarUsuario(new Cliente("mbergalli", "Mauro", "Bergalli", "mbergalli@mail.com", new Date(1987, 02, 22)));

        ManejadorUsuarios.getInstance().agregarUsuario(new Proveedor("prov1", "Proveedor 1", "", "prov1@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        ManejadorUsuarios.getInstance().agregarUsuario(new Proveedor("prov2", "Proveedor 2", "", "prov2@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));
        ManejadorUsuarios.getInstance().agregarUsuario(new Proveedor("prov3", "Proveedor 3", "", "prov3@mail.com", new Date(1987, 02, 22), "apple", "www.apple.com"));

        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat1", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat2", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat3", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat4", null));
        ManejadorCategorias.getInstance().agregarCategoria(new Categoria("cat5", null));

        Map<String,Categoria> cat1 = Collections.synchronizedMap(new HashMap());
        cat1.put("cat1",ManejadorCategorias.getInstance().getCategoria("cat1"));
        cat1.put("cat5",ManejadorCategorias.getInstance().getCategoria("cat5"));
        Map<String,String> esp1 = Collections.synchronizedMap(new HashMap());
        esp1.put("Esp1","Espacificacion 1");
        esp1.put("Esp1","Espacificacion 2");
        Proveedor prov1 = ManejadorUsuarios.getInstance().getProveedor("prov1");
        Map<Integer,Producto> prod1 = Collections.synchronizedMap(new HashMap());
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(new EspecificacionProducto("a1", "Iphone", "Lindo y de alta gama", esp1, (float) 10.5, prov1, cat1,prod1));
        
        prod1.put(0,new Producto(0, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        prod1.put(1,new Producto(1, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1")));
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a1").setListaProductos(prod1);
        
        Map<String,Categoria> cat2 = Collections.synchronizedMap(new HashMap());
        cat2.put("cat1",ManejadorCategorias.getInstance().getCategoria("cat1"));
        cat2.put("cat3",ManejadorCategorias.getInstance().getCategoria("cat3"));
        Map<String,String> esp2 = Collections.synchronizedMap(new HashMap());
        esp2.put("Esp1","Espacificacion 1");
        Proveedor prov2 = ManejadorUsuarios.getInstance().getProveedor("prov2");
        Map<Integer,Producto> prod2 = Collections.synchronizedMap(new HashMap());
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(new EspecificacionProducto("a2", "Samsung Galaxy", "Lindo, grande y de alta gama", esp2, (float) 8.5, prov2, cat2,prod2));
        prod2.put(2,new Producto(2, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2")));
        prod2.put(3,new Producto(3, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2")));
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a2").setListaProductos(prod2);
        
        Map<String,Categoria> cat3 = Collections.synchronizedMap(new HashMap());
        cat3.put("cat4",ManejadorCategorias.getInstance().getCategoria("cat4"));
        Map<String,String> esp3 = Collections.synchronizedMap(new HashMap());
        esp3.put("Esp1","Espacificacion 1");
        Proveedor prov3 = ManejadorUsuarios.getInstance().getProveedor("prov3");
        Map<Integer,Producto> prod3 = Collections.synchronizedMap(new HashMap());
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(new EspecificacionProducto("a3", "Sony Vaio", "Buena pc", esp3, (float) 15.5, prov3, cat3,prod3));
        prod3.put(2,new Producto(4, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a3")));
        prod3.put(3,new Producto(5, ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a3")));
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get("a3").setListaProductos(prod3);
        
        ManejadorProductos.getInstance().agregarProducto(new Producto(1, ManejadorEspProductos.getInstance().getEspecificacionProducto("a1")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(2, ManejadorEspProductos.getInstance().getEspecificacionProducto("a1")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(3, ManejadorEspProductos.getInstance().getEspecificacionProducto("a1")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(4, ManejadorEspProductos.getInstance().getEspecificacionProducto("a2")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(5, ManejadorEspProductos.getInstance().getEspecificacionProducto("a2")));
        ManejadorProductos.getInstance().agregarProducto(new Producto(6, ManejadorEspProductos.getInstance().getEspecificacionProducto("a3")));
        System.out.println("**************************** Generar orden de compra ****************************");
        
        //Listar clientes
        controlarOrden.listarClientes().stream().forEach((cliente) -> {
            System.out.println(cliente);
        });

        //Cliente Seleccionado
        controlarOrden.elegirCliente("abotta");
        
        //Listar categorias
        controlarOrden.listarCategorias().stream().forEach((categoria) -> {
            System.out.println(categoria);
        });
        
        //Categoria Seleccionado
        controlarOrden.elegirCategoria("cat1");
        
        //Listar especificaciones de categoria seleccionada
        controlarOrden.listarEspecificacionProductos().stream().forEach((espProducto) -> {
            System.out.println(espProducto);
        });
        
        //Especificacion Producto seleccionado
        controlarOrden.elegirEspecificacionProducto("a1");
        
        //Listar productos de la especificacion seleccionada

        
        //Producto seleccionado
        controlarOrden.elegirProducto(1);
        controlarOrden.elegirProducto(3);
        
        //Generar item Orden
        controlarOrden.generarItemOrden();
        
        //Guardar Orden
        DataOrdenCompra dataOrden = new DataOrdenCompra(1);
        controlarOrden.guardarOrden(dataOrden);
        
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

        DefaultListModel tes = new DefaultListModel();
        ArrayList<DataOrdenCompra> ordenes = controlarOrden.listarOrdenes();
        ordenes.stream().forEach((orden) -> {
            tes.addElement(orden);
        });
        ordenList = new JList(tes);
        ordenList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        ordenList.setBounds(0, 50, 200, 300);
        ordenList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent evt){
                if(evt.getValueIsAdjusting())
                    return;
                DataOrdenCompra aux = (DataOrdenCompra)ordenList.getSelectedValue();
                controlarOrden.elegirOrden(aux.getNroOrden());
                nroRefText.setText(String.valueOf(aux.getNroOrden()));
                fechaVentaText.setDate(aux.getFecha());
                precioTotalText.setText(String.valueOf(aux.getPrecioTotal()));
                clienteText.setText(aux.getClienteCompraProducto().get(0).getCliente().getNickname());
                DefaultListModel tes2 = new DefaultListModel();
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
        
        productosList = new JList(new DefaultListModel());
        productosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        productosList.setBounds(220, 240, 450, 80);
        contenedor.add(productosList);
        
        borrarBtn = new JButton("Eliminar");
        cancelarBtn = new JButton("Cancelar");
        
        borrarBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 guardarCategoria(e);
            }
        });
        
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 cancelar(e);
            }
        });
        
        borrarBtn.setBounds(250, 330, 100, 40);
        cancelarBtn.setBounds(370, 330, 100, 40);
        contenedor.add(borrarBtn);
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
