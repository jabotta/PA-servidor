package Controlador.Clases;

import Controlador.DataTypes.DataClienteCompraProducto;
import Controlador.DataTypes.DataOrdenCompra;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class OrdenCompra {
    
    private Integer nroOrden;
    private Date fecha;
    private Float precioTotal;
    private ArrayList<ClienteCompraProducto> clienteCompraProducto;
    
    public OrdenCompra(Integer nroOrden, ArrayList<ClienteCompraProducto> clienteCompraProducto) {
        this.nroOrden = nroOrden;
        this.fecha = new Date();
        this.clienteCompraProducto = clienteCompraProducto;
    }
    
    public OrdenCompra(Integer nroOrden, Date fecha, ArrayList<ClienteCompraProducto> clienteCompraProducto) {
        this.nroOrden = nroOrden;
        this.fecha = fecha;
        this.clienteCompraProducto = clienteCompraProducto;
    }
    
    public OrdenCompra(DataOrdenCompra doc) {
        this.nroOrden = doc.getNroOrden();
        this.fecha = doc.getFecha();
    }

    public Integer getNroOrden() {
        return nroOrden;
    }
    
    public void setNroOrden(Integer nroOrden) {
        this.nroOrden = nroOrden;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public ArrayList<ClienteCompraProducto> getClienteCompraProducto() {
        return clienteCompraProducto;
    }
    
    public ArrayList<DataClienteCompraProducto> getDataClienteCompraProducto() {
        ArrayList<DataClienteCompraProducto> dataClienteCompraProducto = new ArrayList<>();
        clienteCompraProducto.stream().forEach((cliProd) -> {
            dataClienteCompraProducto.add(new DataClienteCompraProducto(cliProd));
        });
        return dataClienteCompraProducto;
    }

    public void setClienteCompraProducto(ArrayList<ClienteCompraProducto> clienteCompraProducto) {
        this.clienteCompraProducto = clienteCompraProducto;
    }
    
    public Float getPrecioTotal() {
        return precioTotal;
    }
    
    public void setPrecioTotal(Float pt) {
        this.precioTotal = pt;
    }
    
    public Cliente getCliente(){
        Iterator<ClienteCompraProducto> it = this.getClienteCompraProducto().iterator();
        while(it.hasNext()){
            ClienteCompraProducto cliProd = it.next();
            return cliProd.getCliente();
        }
        return null;
    }
    
    @Override
    public String toString() {
        return this.getNroOrden() + "  --  " + this.getFecha() + "  --  " + this.getClienteCompraProducto() ;
    }
    
}
