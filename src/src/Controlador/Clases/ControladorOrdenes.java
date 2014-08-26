package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProducto;
import java.util.ArrayList;
import java.util.Date;


public class ControladorOrdenes implements IControladorOrdenes{
    
    private Integer id;
    private Cliente clienteElegido;
    private Categoria categoriaElegida;
    private EspecificacionProducto espProdElegido;
    private ArrayList<Producto> productosElegidos;
    private ArrayList<ClienteCompraProducto> cliComProds;
    private OrdenCompra nuevaOrden;
    private OrdenCompra ordenElegida;
    
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
        return dataCliente;
    }
    
    @Override
    public void elegirCliente(String nickname){
        clienteElegido = (Cliente) ManejadorUsuarios.getInstance().obtenerUsuarios().get(nickname);
    }
    
    @Override
    public ArrayList<DataCategoria> listarCategorias(){
        ArrayList<DataCategoria> dataCategoria = new ArrayList<>();
        ManejadorCategorias.getInstance().obtenerCategorias().entrySet().stream().map((categoria) -> categoria.getValue()).forEach((valor) -> {
            dataCategoria.add(new DataCategoria(valor));
        });
        return dataCategoria;
    }
    
    @Override
    public void elegirCategoria(String categoria){
        categoriaElegida = ManejadorCategorias.getInstance().obtenerCategorias().get(categoria);
    }
    
    @Override
    public ArrayList<DataEspecificacionProducto> listarEspecificacionProductos(){
        ArrayList<DataEspecificacionProducto> dataEspecificacionProducto = new ArrayList<>();
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().entrySet().stream().map((espProducto) -> espProducto.getValue()).forEach((valor) -> {
            if(valor.getCategorias().contains(categoriaElegida)){
                dataEspecificacionProducto.add(new DataEspecificacionProducto(valor));
            }
        });
        return dataEspecificacionProducto;
    }
    
    @Override
    public void elegirEspecificacionProducto(String nroRef){
        espProdElegido = ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().get(nroRef);
    }
    //@Override
//    public void elegirMetodoDeSeleccion(String metodo){
//        
//    }
    
    @Override
    public ArrayList<DataProducto> listarProductos(){
        ArrayList<DataProducto> dataProductos = new ArrayList<>();
        ManejadorProductos.getInstance().obtenerProductos().entrySet().stream().map((producto) -> producto.getValue()).forEach((valor) -> {
            if(valor.getEspecificacionProducto() == espProdElegido){
                dataProductos.add(new DataProducto(valor));
            }
        });
        return dataProductos;
    }
    
    @Override
    public void elegirProducto(Integer id){
        productosElegidos.add(ManejadorProductos.getInstance().obtenerProductos().get(id));
    }
    
    @Override
    public void generarItemOrden(){
        productosElegidos.stream().forEach((productoElegido) -> {
            cliComProds.add(new ClienteCompraProducto(clienteElegido, productoElegido, espProdElegido.getPrecio()));
        });
    }
    
    @Override
    public void guardarOrden(){
        ManejadorOrdenes.getInstance().agregarOrden(1, new OrdenCompra(1, new Date(), cliComProds));
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
