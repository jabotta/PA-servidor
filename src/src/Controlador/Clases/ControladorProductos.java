package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;

public class ControladorProductos implements IControladorProductos{
    
    private Integer id;
    private EspecificacionProducto espProductoModificada;
    private Proveedor proveedorElegido;
    private EspecificacionProducto espProdElegido;
    private ArrayList<String> especificaciones;
    private Producto nuevoProducto;
    private Categoria nuevaCategoria;
    
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
        return null;
    }
    
    @Override
    public void elegirProveedor(String nickname){
        
    }
    
    @Override
    public void ingresarDatosProductos(DataEspecificacionProducto espProducto){
        
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
        return null;
    }
    
    @Override
    public void elegirCategoria(String categoria){
        
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
        
    }
    
    //@Override
//    public Boolean tienePadre(){
//        return true;
//    }
    
    @Override
    public void asociarCategoriaPadre(){
        
    }
    
    @Override
    public void guardarCategoria(){
        
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
