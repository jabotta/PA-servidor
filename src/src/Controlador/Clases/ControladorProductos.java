package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;

public class ControladorProductos implements IControladorProductos{
    
    private EspecificacionProducto espProductoModificada;
    private Proveedor proveedorElegido;
    private EspecificacionProducto espProdElegido;
    private ArrayList<String> especificaciones;
    private Producto nuevoProducto;
    private Categoria nuevaCategoria;
    private Integer id;
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
    
    public ArrayList<DataProveedor> listarProveedores(){
        return null;
    }
    
    public void elegirProveedor(String nickname){
        
    }
    
    public void ingresarDatosProductos(DataEspecificacionProducto espProducto){
        
    }
    
    public Boolean elegirTipoProducto(){
        return true;
    }
    
    public void agregarMultiplesProductosAutogenerados(Integer cantidad){
        
    }
    
    public void ingresarDatosUnidad(DataProducto producto){
        
    }
    
    public ArrayList<DataCategoria> listarCategorias(){
        return null;
    }
    
    public void elegirCategoria(String categoria){
        
    }
    
    public void listarImagenesDisco(){
        
    }
    
    public void elegirImagen(String rutaImagen){
        
    }
    
    public Boolean controlarErrores(){
        return true;
    }
    
    public void guardarProducto(){
        
    }
    
    public void ingresarDatosCategoria(DataCategoria categoria){
        
    }
    
//    public Boolean tienePadre(){
//        return true;
//    }
    
    public void asociarCategoriaPadre(){
        
    }
    
    public void guardarCategoria(){
        
    }
    
    public void elegirProducto(Integer id){
        
    }
    
    public DataProducto mostrarInformacionProducto(){
        return null;
    }
    
    public DataEspecificacionProducto listarEspecificacionProductos(){
        return null;
    }
    
    public void modificarDatosEspecificacionProducto(DataEspecificacionProducto espProducto){
        
    }
    
    public void agregarImagen(String rutaImagen){
        
    }
    
    public void agregarCategoria(DataCategoria categoria){
        
    }
    
    public Boolean validarInfo(){
        return true;
    }
    
}
