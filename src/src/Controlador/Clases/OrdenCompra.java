package Controlador.Clases;

import Controlador.DataTypes.DataClienteCompraProducto;
import Controlador.DataTypes.DataOrdenCompra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class OrdenCompra implements Serializable {
    @Id
    @Column(name="NRO_ORDEN")
    private Integer nroOrden;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    @Column(name="PRECIO")
    private Float precioTotal;
    @OneToMany(cascade={CascadeType.PERSIST},mappedBy="Orden")
    @JoinColumn(name="ORDEN_ID")
    private List<ClienteCompraProducto> clienteCompraProducto;
    
    public OrdenCompra(Integer nroOrden, List<ClienteCompraProducto> clienteCompraProducto) {
        this.nroOrden = nroOrden;
        this.fecha = new Date();
        this.clienteCompraProducto = clienteCompraProducto;
    }
    
    public OrdenCompra(Integer nroOrden, Date fecha, List<ClienteCompraProducto> clienteCompraProducto) {
        this.nroOrden = nroOrden;
        this.fecha = fecha;
        this.clienteCompraProducto = clienteCompraProducto;
    }
    
    public OrdenCompra(DataOrdenCompra doc) {
        this.nroOrden = doc.getNroOrden();
        this.fecha = doc.getFecha();
    }
    
    public OrdenCompra() {}

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
    
    public List<ClienteCompraProducto> getClienteCompraProducto() {
        return clienteCompraProducto;
    }
    
    public List<DataClienteCompraProducto> getDataClienteCompraProducto() {
        List<DataClienteCompraProducto> dataClienteCompraProducto = new ArrayList<>();
        /*clienteCompraProducto.forEach((cliProd) -> {
            System.out.println(cliProd+"<<>>");
            dataClienteCompraProducto.add(new DataClienteCompraProducto(cliProd));
        });*/
        return dataClienteCompraProducto;
    }

    public void setClienteCompraProducto(List<ClienteCompraProducto> clienteCompraProducto) {
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
        /*while(it.hasNext()){
            ClienteCompraProducto cliProd = it.next();
            return cliProd.getCliente();
        }*/
        return null;
    }
    
    @Override
    public String toString() {
        return this.getNroOrden() + "  --  " + this.getFecha() + "  --  " + this.getClienteCompraProducto() ;
    }
    
}
