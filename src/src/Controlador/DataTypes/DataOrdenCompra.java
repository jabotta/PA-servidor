package Controlador.DataTypes;

import Controlador.Clases.OrdenCompra;
import java.util.ArrayList;
import java.util.Date;

public class DataOrdenCompra {
    
    private Integer nroOrden;
    private Date fecha;
    private Float precioTotal;
    private ArrayList<DataClienteCompraProducto> clienteCompraProducto;
    
    public DataOrdenCompra(OrdenCompra oc) {
        this.nroOrden = oc.getNroOrden();
        this.fecha = oc.getFecha();
        this.precioTotal = oc.getPrecioTotal();
        this.clienteCompraProducto = oc.getDataClienteCompraProducto();
    }
    
    public DataOrdenCompra(Integer nroOrden) {
        this.nroOrden = nroOrden;
        this.fecha = new Date();
        this.precioTotal = 0.0f;
    }
    
    public DataOrdenCompra(Integer nroOrden, Date fecha, Float precioTotal, ArrayList<DataClienteCompraProducto> clienteCompraProducto) {
        this.nroOrden = nroOrden;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.clienteCompraProducto = clienteCompraProducto;
    }
    
    public DataOrdenCompra(Integer nroOrden, ArrayList<DataClienteCompraProducto> clienteCompraProducto) {
        this.nroOrden = nroOrden;
        this.fecha = new Date();
        this.precioTotal = 0.0f;
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
    
    public void setPrecioTotal(Float pt) {
        this.precioTotal = pt;
    }
    
    @Override
    public String toString() {
        return this.getNroOrden() + "  --  " + this.getFecha() + "  --  " + this.getClienteCompraProducto() ;
    }
    
}
