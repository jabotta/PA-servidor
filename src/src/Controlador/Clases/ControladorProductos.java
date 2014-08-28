package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;
import java.util.Map;

public class ControladorProductos implements IControladorProductos{
    
    private Integer id;
    private EspecificacionProducto espProductoModificada;
    private Proveedor proveedorElegido;
    private EspecificacionProducto espProdElegido;
    private Map<String,String> especificaciones;
    private EspecificacionProducto nuevoProducto;
    private Categoria nuevaCategoria;
    private Categoria categoriaElegida;
    
    //    - prvLst Set<Proveedor>
//    - espLst : map<string,string>
//    - prdList : Productos
//    - lstCategorias  : Set<Categoria>
    
    @Override
    public Integer getId(){
        return this.id;
    }
    
    @Override
    public void setId(Integer id){
        this.id = id;
    }
    
    @Override
    public ArrayList<DataProveedor> listarProveedores(){
        ArrayList<DataProveedor> dataProveedor = new ArrayList<>();
        ManejadorUsuarios.getInstance().obtenerProveedores().entrySet().stream().map((cliente) -> cliente.getValue()).forEach((valor) -> {
            dataProveedor.add(new DataProveedor(valor));
        });
        return dataProveedor;
    }
    
    @Override
    public void elegirProveedor(String nickname){
        proveedorElegido = ManejadorUsuarios.getInstance().getProveedor(nickname);
        System.out.println("ProveedorElegido " + proveedorElegido);
    }
    
    @Override
    public void ingresarDatosProductos(DataEspecificacionProducto espProducto){
        nuevoProducto = new EspecificacionProducto(espProducto,proveedorElegido);
        System.out.println("Nuevo Producto " + nuevoProducto);
    }
    
    @Override
    public Boolean elegirTipoProducto(){
        return true;
    }
    
    @Override
    public void agregarMultiplesProductosAutogenerados(Integer cantidad){
        
    }
    
    @Override
    public void ingresarDatosUnidad(DataProducto producto){
        
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
        categoriaElegida = ManejadorCategorias.getInstance().getCategoria(categoria);
    }
    
    @Override
    public ArrayList<DataProducto> listarProductosCategoria(){
        ArrayList<DataProducto> dataProducto = new ArrayList<>();
        ManejadorProductos.getInstance().obtenerProductos().entrySet().stream().map((producto) -> producto.getValue()).forEach((valor) -> {
            if(valor.getCategorias().contains(categoriaElegida.getNombre())){
                dataProducto.add(new DataProducto(valor));
            }
        });
        return dataProducto;
    }
    
    @Override
    public DataProducto mostrarDatosProducto(Integer id){
        Producto productoElegido = ManejadorProductos.getInstance().getProducto(id);
        DataProducto dataProducto = new DataProducto(productoElegido);
        return dataProducto;
    }
    
    @Override
    public void listarImagenesDisco(){
        
    }
    
    @Override
    public void elegirImagen(String rutaImagen){
        
    }
    
    @Override
    public Boolean controlarErrores(){
        return true;
    }
    
    @Override
    public void guardarProducto(){
        
    }
    
    @Override
    public void ingresarDatosCategoria(DataCategoria categoria){
        nuevaCategoria = new Categoria(categoria);
    }
    
    //@Override
//    public Boolean tienePadre(){
//        return true;
//    }
    
    @Override
    public void asociarCategoriaPadre(DataCategoria padre){
        Categoria catPadre = new Categoria(padre);
        nuevaCategoria.setPadre(catPadre);
        System.out.println("asociarCategoriaPadre " + nuevaCategoria);
    }
    
    @Override
    public void guardarCategoria(){
        ManejadorCategorias.getInstance().agregarCategoria(nuevaCategoria);
        System.out.println("NuevaCategoria " + nuevaCategoria);
    }
    
    @Override
    public void elegirProducto(Integer id){
        
    }
    
    @Override
    public DataProducto mostrarInformacionProducto(){
        return null;
    }
    
    @Override
    public DataEspecificacionProducto listarEspecificacionProductos(){
        return null;
    }
    
    @Override
    public void modificarDatosEspecificacionProducto(DataEspecificacionProducto espProducto){
        
    }
    
    @Override
    public void agregarImagen(String rutaImagen){
        
    }
    
    @Override
    public void agregarCategoria(DataCategoria categoria){
        
    }
    
    @Override
    public Boolean validarInfo(){
        return true;
    }
    
}
