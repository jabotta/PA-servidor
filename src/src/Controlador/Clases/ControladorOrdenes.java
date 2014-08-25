package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProducto;
import java.util.ArrayList;


public class ControladorOrdenes implements IControladorOrdenes{
    
    private Cliente clienteElegido;
    private Categoria categoriaElegida;
    private EspecificacionProducto espProdElegido;
    private Producto productoElegido;
    private OrdenCompra nuevaOrden;
    private OrdenCompra ordenElegida;
    public Integer id;
    
    @Override
    public Integer getId(){
        return this.id;
    }
    
    public DataCliente listarClientes(){
        return null;
    }
    
    public void elegirCliente(String nickname){
        
    }
    
    public ArrayList<DataCategoria> listarCategorias(){
        return null;
    }
    
    public void elegirCategoria(String categoria){
        
    }
    
    public ArrayList<DataEspecificacionProducto> listarEspecificacionProductos(){
        return null;
    }
    
    public void elegirEspecificacionProducto(String nroRef){
        
    }
    
//    public void elegirMetodoDeSeleccion(String metodo){
//        
//    }
    
    public ArrayList<DataProducto> listarProductos(){
        return null;
    }
    
    public void elegirProducto(Integer id){
        
    }
    
    public void generarItemOrden(){
        
    }
    
    public void guardarOrden(){
        
    }
    
//    public void imprimirDatosOrden(){
//        
//    }
    
    public ArrayList<DataOrdenCompra> listarOrdenes(){
        return null;
    }
    
    public void elegirOrden(Integer nroOrden){
        
    }
    
    public Boolean confirmarEliminacion(){
        return true;
    }
    
    public void borrarOrdenCompra(){
        
    }
    
    public DataOrdenCompra mostrarDetalles(){
        return null;
    }
    
}
