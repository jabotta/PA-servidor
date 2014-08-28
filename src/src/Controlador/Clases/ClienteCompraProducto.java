package Controlador.Clases;

import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataProducto;

public class ClienteCompraProducto {
    
    private Cliente cliente;
    private Producto producto;
    private Float precio;
    
    public ClienteCompraProducto(Cliente cliente, Producto producto, Float precio) {
        this.cliente = cliente;
        this.producto = producto;
        this.precio = precio;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public DataCliente getDataCliente() {
        return new DataCliente(cliente);
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public DataProducto getDataProducto() {
        return new DataProducto(producto);
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    
    public OrdenCompra obtenerOrdenCompra(){
        return null;
    }
    
    @Override
    public String toString() {
        return this.getCliente() + "  --  " + this.getProducto() + "  --  " + this.getPrecio() ;
    }
    
}
