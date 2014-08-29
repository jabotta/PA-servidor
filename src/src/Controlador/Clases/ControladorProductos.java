package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Objects.isNull;

public class ControladorProductos implements IControladorProductos{
    
    private Integer id;
    private EspecificacionProducto espProductoModificada;
    private Proveedor proveedorElegido;
    private EspecificacionProducto espProdElegido;
    private Map<String,String> especificaciones = Collections.synchronizedMap(new HashMap());
    private EspecificacionProducto nuevoEspProducto;
    private Categoria nuevaCategoria;
    private Categoria categoriaElegida;
    private ArrayList<Categoria> categoriasElegidas = new ArrayList<Categoria>();
    private ArrayList<String> imagenes = new ArrayList<String>();
    private Map<Integer,Producto> productosAAgregar = Collections.synchronizedMap(new HashMap());
    
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
        nuevoEspProducto = new EspecificacionProducto(espProducto,proveedorElegido);
        System.out.println("Nuevo Producto " + nuevoEspProducto);
    }
    
    @Override
    public Boolean elegirTipoProducto(){
        return true;
    }
    
    @Override
    public void agregarMultiplesProductosAutogenerados(Integer cantidad){
        for(Integer i=0;i<cantidad;i++){
            productosAAgregar.put(i, new Producto(i, nuevoEspProducto));
        }
    }
    
    @Override
    public void ingresarDatosUnidad(DataProducto producto){
        productosAAgregar.put(producto.getId(), new Producto(producto));
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
    public void agregarCategoriaAEspecificacion(String categoria){
        categoriasElegidas.add(ManejadorCategorias.getInstance().getCategoria(categoria));
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
    public Boolean controlarErrores(){
        if(!isNull(ManejadorEspProductos.getInstance().getEspecificacionProducto(nuevoEspProducto.getNroReferencia()))){
            return false;
        }        
        for(Entry<String,EspecificacionProducto> iter : ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().entrySet()){
            if(iter.getValue().getNombre().equals(nuevoEspProducto.getNombre())){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void guardarProducto(){
        nuevoEspProducto.setCategorias(categoriasElegidas);
        nuevoEspProducto.setEspecificacion(especificaciones);
        nuevoEspProducto.setImagenes(imagenes);
        nuevoEspProducto.setListaProductos(productosAAgregar);
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(nuevoEspProducto);
    }
    
    @Override
    public void ingresarDatosCategoria(DataCategoria categoria){
        nuevaCategoria = new Categoria(categoria);
        if(!isNull(categoria.getPadre())){
            asociarCategoriaPadre(categoria.getPadre());
        }
    }
    
    //@Override
//    public Boolean tienePadre(){
//        return true;
//    }
    
    @Override
    public void asociarCategoriaPadre(DataCategoria padre){
        Categoria catPadre = ManejadorCategorias.getInstance().getCategoria(padre.getNombre());
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
        imagenes.add(rutaImagen);
    }
    
    @Override
    public void agregarCategoria(DataCategoria categoria){
        
    }
    
    @Override
    public Boolean validarInfo(){
        return true;
    }
    
    @Override
    public void ingresarEspecificacion(String clave, String desc){
        especificaciones.put(clave, desc);
    }
    
    
}
