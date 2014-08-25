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
    
    @Override
    public void setId(Integer id){
        this.id = id;
    }
    
    @Override
    public ArrayList<DataCliente> listarClientes(){
        ArrayList<DataCliente> dataCliente = new ArrayList<>();
        ManejadorUsuarios.getInstance().obtenerUsuarios().entrySet().stream().map((cliente) -> cliente.getValue()).forEach((valor) -> {
            if(valor instanceof Cliente){
                dataCliente.add(new DataCliente(valor));
            }
        });
        System.out.print(dataCliente);
        return dataCliente;
    }
    
    @Override
    public void elegirCliente(String nickname){
        clienteElegido = (Cliente) ManejadorUsuarios.getInstance().obtenerUsuarios().get(nickname);
    }
    
    @Override
    public ArrayList<DataCategoria> listarCategorias(){
        return null;
    }
    
    @Override
    public void elegirCategoria(String categoria){
        
    }
    
    @Override
    public ArrayList<DataEspecificacionProducto> listarEspecificacionProductos(){
        return null;
    }
    
    @Override
    public void elegirEspecificacionProducto(String nroRef){
        
    }
    //@Override
//    public void elegirMetodoDeSeleccion(String metodo){
//        
//    }
    
    @Override
    public ArrayList<DataProducto> listarProductos(){
        return null;
    }
    
    @Override
    public void elegirProducto(Integer id){
        
    }
    
    @Override
    public void generarItemOrden(){
        
    }
    
    @Override
    public void guardarOrden(){
        
    }
    
    //@Override
//    public void imprimirDatosOrden(){
//        
//    }
    
    @Override
    public ArrayList<DataOrdenCompra> listarOrdenes(){
        return null;
    }
    
    @Override
    public void elegirOrden(Integer nroOrden){
        
    }
    
    @Override
    public Boolean confirmarEliminacion(){
        return true;
    }
    
    @Override
    public void borrarOrdenCompra(){
        
    }
    
    @Override
    public DataOrdenCompra mostrarDetalles(){
        return null;
    }
    
}
