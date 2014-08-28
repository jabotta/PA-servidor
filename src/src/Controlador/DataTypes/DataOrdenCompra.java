package Controlador.DataTypes;

import Controlador.Clases.OrdenCompra;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class DataOrdenCompra {
    
    private Integer nroOrden;
    private Date fecha;
    private Float precioTotal;
    private ArrayList<DataClienteCompraProducto> clienteCompraProducto;
    
    public DataOrdenCompra(OrdenCompra oc) {
        this.nroOrden = oc.getNroOrden();
        this.fecha = oc.getFecha();
        this.clienteCompraProducto = oc.getDataClienteCompraProducto();
    }
    
    public DataOrdenCompra(Integer nroOrden, Date fecha, ArrayList<DataClienteCompraProducto> clienteCompraProducto) {
        this.nroOrden = nroOrden;
        this.fecha = fecha;
        this.clienteCompraProducto = clienteCompraProducto;
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
    
    public ArrayList<DataClienteCompraProducto> getClienteCompraProducto() {
        return clienteCompraProducto;
    }

    public void setClienteCompraProducto(ArrayList<DataClienteCompraProducto> clienteCompraProducto) {
        this.clienteCompraProducto = clienteCompraProducto;
    }
    
    public Float getPrecioTotal() {
        return precioTotal;
    }
    
    @Override
    public String toString() {
        return this.getNroOrden() + "  --  " + this.getFecha() + "  --  " + this.getClienteCompraProducto() ;
    }
    
}
