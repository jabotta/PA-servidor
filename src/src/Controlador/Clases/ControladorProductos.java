package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import static java.util.Objects.isNull;

public class ControladorProductos implements IControladorProductos{
    
    private Integer id;
    private EspecificacionProducto espProductoModificada;
    private Proveedor proveedorElegido;
    private EspecificacionProducto espProdElegido;
    private Map<String,String> especificaciones = new HashMap();
    private EspecificacionProducto nuevoEspProducto;
    private Categoria nuevaCategoria;
    private Categoria categoriaElegida;
    private Map<String,Categoria> categoriasElegidas = new HashMap();
    private List<String> imagenes = new ArrayList<>();
    private List<Producto> productosAAgregar = new ArrayList();
    
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
    public List<DataProveedor> listarProveedores(){
        List<DataProveedor> dataProveedor = new ArrayList<>();
        ManejadorUsuarios.getInstance().obtenerProveedores().entrySet().stream().map((cliente) -> cliente.getValue()).forEach((valor) -> {
            dataProveedor.add(new DataProveedor(valor));
        });
        return dataProveedor;
    }
    
    @Override
    public void elegirProveedor(String nickname){
        proveedorElegido = ManejadorUsuarios.getInstance().getProveedor(nickname);
 
    }
    
    @Override
    public void ingresarDatosProductos(DataEspecificacionProducto espProducto){
        nuevoEspProducto = new EspecificacionProducto(espProducto,proveedorElegido);
    }
    
    @Override
    public Boolean elegirTipoProducto(){
        return true;
    }
    
    @Override
    public void agregarMultiplesProductosAutogenerados(Integer cantidad){
        int newId = ManejadorProductos.getInstance().obtenerProductos().keySet().size();
        for(Integer i = 0; i < cantidad; i++){
            productosAAgregar.add(new Producto(newId, nuevoEspProducto));
            newId++;
        }
    }
    
    @Override
    public void ingresarDatosUnidad(DataProducto producto){
        productosAAgregar.add(new Producto(producto));
    }
    
    @Override
    public List<DataCategoria> listarCategorias(){
        List<DataCategoria> dataCategoria = new ArrayList<>();
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
    public List<DataCategoria> listarCategoriasAModificar(){
        List<DataCategoria> dataCategoria = new ArrayList<>();
        espProductoModificada.getCategorias().entrySet().stream().map((categoria) -> categoria.getValue()).forEach((valor) -> {
            categoriasElegidas.put(valor.getNombre(),valor);
            dataCategoria.add(new DataCategoria(valor,true));
        });
        return dataCategoria;
    }
    
    @Override
    public void agregarCategoriaAEspecificacion(String categoria){
        categoriasElegidas.put(categoria,ManejadorCategorias.getInstance().getCategoria(categoria));
    }
    
    @Override
    public void borrarCategoriaAEspecificacion(String categoria){
        categoriasElegidas.remove(categoria);
    }
                
    @Override
    public List<DataEspecificacionProducto> listarProductosCategoria(){
        List<DataEspecificacionProducto> result = new ArrayList<>();
        categoriaElegida.getListaProductos().entrySet().stream().map((espProd) -> espProd.getValue()).forEach((valor) -> {
            result.add(new DataEspecificacionProducto(valor,true));
        });
        return result;
    }
    
    @Override
    public DataEspecificacionProducto mostrarDatosProducto(String numRef){
        EspecificacionProducto productoElegido = ManejadorEspProductos.getInstance().getEspecificacionProducto(numRef);
        DataEspecificacionProducto dataProducto = new DataEspecificacionProducto(productoElegido,true);
        return dataProducto;
    }
    
    @Override
    public void listarImagenesDisco(){
        
    }
    
    @Override
    public List<String> listarImagenesAModificar(){
        imagenes = espProductoModificada.getImagenes();
        return imagenes;
    }
    
    @Override
    public Boolean controlarErrores(){
        if(!isNull(ManejadorEspProductos.getInstance().getEspecificacionProducto(nuevoEspProducto.getNroReferencia()))){
            return false;
        }    
        if(categoriasElegidas.isEmpty())
            return false;
        for(Entry<String,EspecificacionProducto> iter : ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().entrySet()){
            if(iter.getValue().getNombre().equals(nuevoEspProducto.getNombre())){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void guardarProducto(){
        
        System.err.println("prod ");
        nuevoEspProducto.setCategorias(categoriasElegidas);
        nuevoEspProducto.setEspecificacion(especificaciones);
        System.err.println("prod "+productosAAgregar);
        nuevoEspProducto.setImagenes(imagenes);
        nuevoEspProducto.setListaProductos(productosAAgregar);
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(nuevoEspProducto);

        especificaciones = new HashMap();
        imagenes = new ArrayList<>();
        productosAAgregar = new ArrayList();
    }
    
    @Override
    public DataCategoria elegirCategoriaPadre(String categoria){
        return new DataCategoria(ManejadorCategorias.getInstance().getCategoria(categoria), true);
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
    }
    @Override 
    public Boolean categoryAlreadyExist(String categoria){
        return  ManejadorCategorias.getInstance().getCategoria(categoria) != null;
    
    }
    @Override
    public void guardarCategoria(){   
        ManejadorCategorias.getInstance().agregarCategoria(nuevaCategoria);
    }
    
    @Override
    public void elegirEspProducto(String numRef){
        espProdElegido = ManejadorEspProductos.getInstance().getEspecificacionProducto(numRef);
    }
    
    @Override
    public DataProducto mostrarInformacionProducto(){
        return null;
    }
    
    /*@Override
    public ArrayList<DataEspecificacionProducto> listarEspecificacionProductos(){
        ArrayList<DataEspecificacionProducto> result = new ArrayList<DataEspecificacionProducto>();
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().entrySet().stream().map((espProd) -> espProd.getValue()).forEach((valor) -> {
            result.add(new DataEspecificacionProducto(valor));
        });
        return result;
    }*/
    
    @Override
    public void modificarDatosEspecificacionProducto(DataEspecificacionProducto espProducto){
        espProductoModificada = new EspecificacionProducto(espProducto,ManejadorUsuarios.getInstance().getProveedor(espProducto.getProveedor().getNickname()));
    }
    
    @Override
    public void agregarImagen(String rutaImagen){
        imagenes.add(rutaImagen);
    }
    
    @Override
    public void borrarImagen(String rutaImagen){
        imagenes.remove(rutaImagen);
    }
    
    @Override
    public void agregarCategoria(DataCategoria categoria){
        
    }
    
    @Override
    public Boolean validarInfo(){   
        if(categoriasElegidas.isEmpty())
            return false;
        for(Entry<String,EspecificacionProducto> iter : ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().entrySet()){
            if(!iter.getValue().getNroReferencia().equals(espProductoModificada.getNroReferencia()) && iter.getValue().getNombre().equals(nuevoEspProducto.getNombre())){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void ingresarEspecificacion(String clave, String desc){
        especificaciones.put(clave, desc);
    }
    
    @Override
    public void guardarEspProductoModificado(){
        espProductoModificada.setCategorias(categoriasElegidas);
        espProductoModificada.setEspecificacion(especificaciones);
        espProductoModificada.setImagenes(imagenes);
        espProductoModificada.setListaProductos(productosAAgregar);
        ManejadorEspProductos.getInstance().obtenerEspecificacionProductos().remove(espProductoModificada.getNroReferencia());
        ManejadorEspProductos.getInstance().agregarEspecificacionProducto(espProductoModificada);
    }
}
