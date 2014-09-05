package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataOrdenCompra;
import java.util.ArrayList;
import java.util.Iterator;


public class ControladorOrdenes implements IControladorOrdenes{
    
    private Integer id;
    private Cliente clienteElegido;
    private Categoria categoriaElegida;
    private EspecificacionProducto espProdElegido;
    private ArrayList<Producto> productosElegidos = new ArrayList<>();
    private ArrayList<ClienteCompraProducto> cliComProds = new ArrayList<>();
//    private OrdenCompra nuevaOrden;
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
        ManejadorUsuarios.getInstance().obtenerClientes().entrySet().stream().map((cliente) -> cliente.getValue()).forEach((valor) -> {
            dataCliente.add(new DataCliente(valor));
        });
        return dataCliente;
    }
    
    @Override
    public void elegirCliente(String nickname){
        clienteElegido = ManejadorUsuarios.getInstance().getCliente(nickname);
    }
    
    @Override
    public ArrayList<DataCategoria> listarCategorias(){
        ArrayList<DataCategoria> dataCategoria = new ArrayList<>();
        ManejadorCategorias.getInstance().obtenerCategorias().entrySet().stream().map((categoria) -> categoria.getValue()).forEach((valor) -> {
            dataCategoria.add(new DataCategoria(valor,true));
        });
        return dataCategoria;
    }
    
    @Override
    public void elegirCategoria(String categoria){
        categoriaElegida = ManejadorCategorias.getInstance().getCategoria(categoria);
    }
    
    @Override
    public ArrayList<DataEspecificacionProducto> listarEspecificacionProductos(){
        ArrayList<DataEspecificacionProducto> dataEspecificacionProducto = new ArrayList<>();
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().entrySet().stream().map((espProducto) -> espProducto.getValue()).forEach((valor) -> {
            if(valor.getCategorias().containsValue(categoriaElegida)){
                dataEspecificacionProducto.add(new DataEspecificacionProducto(valor,true));
            }
        });
        return dataEspecificacionProducto;
    }
    
    @Override
    public void elegirEspecificacionProducto(String nroRef){
        espProdElegido = ManejadorEspProductos.getInstance().getEspecificacionProducto(nroRef);
    }
    
    @Override
    public void removerEspecificacionProducto(String nroRef){
            espProdElegido = null;
    }
    //@Override
//    public void elegirMetodoDeSeleccion(String metodo){
//        
//    }
    
    @Override
    public ArrayList<DataEspecificacionProducto> listarProductosEnOrden(){
        ArrayList<DataEspecificacionProducto> dataProductos = new ArrayList<>();
        ordenElegida.getDataClienteCompraProducto().stream().forEach((clienteproducto) -> {
            DataEspecificacionProducto aux = clienteproducto.getProducto().getEspecificacionProducto();
            aux.setPrecio(clienteproducto.getPrecio()); //precio al momento de realizar la compra
            dataProductos.add(clienteproducto.getProducto().getEspecificacionProducto());
        });
        return dataProductos;
    }
    
    @Override
    public void elegirProducto(Integer id){
        productosElegidos.add(espProdElegido.getListaProductos().get(id));
    }
    @Override
    public void elegirCantidadProducto(Integer cantidad){
         System.out.println(cantidad+" cantidad<<<<");
        Iterator<Producto> it =  espProdElegido.getListaProductos().values().iterator();
        int indice = 0;
        while(it.hasNext() && indice<cantidad){
            productosElegidos.add((Producto) it.next());
            indice++;
        }
    }
    @Override
    public void generarItemOrden(){
        productosElegidos.stream().forEach((productoElegido) -> {
            
            cliComProds.add(new ClienteCompraProducto(clienteElegido, productoElegido, espProdElegido.getPrecio()));
        });
        productosElegidos = new ArrayList<>();
    }
    
    @Override
    public void guardarOrden(DataOrdenCompra dataOrden){
        OrdenCompra orden = new OrdenCompra(dataOrden);
        ArrayList<ClienteCompraProducto> cliComProd = new ArrayList<>();
        
        Float tempSumTotal = 0.0f; 
        for(ClienteCompraProducto cliProd : cliComProds){
            
            cliComProd.add(cliProd);
            tempSumTotal += cliProd.getPrecio();
        }
        
        System.out.println(cliComProds+" >clicom");
        orden.setPrecioTotal(tempSumTotal);
        orden.setClienteCompraProducto(cliComProd);
        ManejadorOrdenes.getInstance().agregarOrden(orden);
        cliComProds = new ArrayList<>();
    }
    
    //@Override
//    public void imprimirDatosOrden(){
//        
//    }
    @Override
    public Integer getNextId(){
        return ManejadorOrdenes.getInstance().obtenerOrdenes().keySet().size();
    }
    @Override
    public ArrayList<DataOrdenCompra> listarOrdenes(){
        ArrayList<DataOrdenCompra> dataOrdenCompra = new ArrayList<>();
        ManejadorOrdenes.getInstance().obtenerOrdenes().entrySet().stream().map((orden) -> orden.getValue()).forEach((valor) -> {
            dataOrdenCompra.add(new DataOrdenCompra(valor));
        });
        return dataOrdenCompra;
    }
    
    @Override
    public void elegirOrden(Integer nroOrden){
        ordenElegida = ManejadorOrdenes.getInstance().getOrden(nroOrden);
    }
    
//    @Override
//    public Boolean confirmarEliminacion(){
//        return true;
//    }
    
    @Override
    public void borrarOrdenCompra(){
        ManejadorOrdenes.getInstance().eliminarOrden(ordenElegida.getNroOrden());
        System.out.println("Borrar orden: " + ordenElegida);
    }
    
    @Override
    public DataOrdenCompra mostrarDatosOrden(){
        DataOrdenCompra dataOrden = new DataOrdenCompra(ordenElegida);
        return dataOrden;
    }

   
}
