package Controlador.DataTypes;

import Controlador.Clases.ClienteCompraProducto;
import Controlador.Clases.OrdenCompra;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataOrdenCompra {
    
    private Integer nroOrden;
    private Date fecha;
    private Float precioTotal;
    private List<DataClienteCompraProducto> clienteCompraProducto;
    
    public DataOrdenCompra(OrdenCompra oc) {
        this.nroOrden = oc.getNroOrden();
        this.fecha = oc.getFecha();
        this.precioTotal = oc.getPrecioTotal();
        this.clienteCompraProducto = new ArrayList<DataClienteCompraProducto>();
        Iterator it = oc.getClienteCompraProducto().iterator();
        while(it.hasNext()){
            clienteCompraProducto.add(new DataClienteCompraProducto((ClienteCompraProducto)it.next()));
        }
        System.out.println("ACAAAAAAAAA"+clienteCompraProducto);
    }
    
    public DataOrdenCompra(Integer nroOrden) {
        this.nroOrden = nroOrden;
        this.fecha = new Date();
        this.precioTotal = 0.0f;
    }
    
    public DataOrdenCompra(Integer nroOrden, Date fecha, Float precioTotal, List<DataClienteCompraProducto> clienteCompraProducto) {
        this.nroOrden = nroOrden;
        this.fecha = fecha;
        this.precioTotal = precioTotal;
        this.clienteCompraProducto = clienteCompraProducto;
    }
    
    public DataOrdenCompra(Integer nroOrden, List<DataClienteCompraProducto> clienteCompraProducto) {
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
    
    public List<DataClienteCompraProducto> getClienteCompraProducto() {
        return clienteCompraProducto;
    }

    public void setClienteCompraProducto(List<DataClienteCompraProducto> clienteCompraProducto) {
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
