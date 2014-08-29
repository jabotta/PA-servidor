package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;
import java.util.Map;

public interface IControladorProductos {
    
    public Integer getId();
    public void setId(Integer id);
    public ArrayList<DataProveedor> listarProveedores();    
    public void elegirProveedor(String nickname);
    public void ingresarDatosProductos(DataEspecificacionProducto espProducto);
    public Boolean elegirTipoProducto();
    public void agregarMultiplesProductosAutogenerados(Integer cantidad);
    public void ingresarDatosUnidad(DataProducto producto);
    public ArrayList<DataCategoria> listarCategorias();
    public void elegirCategoria(String categoria);
    public ArrayList<DataEspecificacionProducto> listarProductosCategoria();
    public DataProducto mostrarDatosProducto(Integer id);
    public void listarImagenesDisco();
    public Boolean controlarErrores();
    public void guardarProducto();
    public DataCategoria elegirCategoriaPadre(String categoria);
    public void ingresarDatosCategoria(DataCategoria categoria);
//    public Boolean tienePadre();
    public void asociarCategoriaPadre(DataCategoria padre);
    public void guardarCategoria();
    public void elegirEspProducto(String numRef);
    public DataProducto mostrarInformacionProducto();
    //public ArrayList<DataEspecificacionProducto> listarEspecificacionProductos();
    public void modificarDatosEspecificacionProducto(DataEspecificacionProducto espProducto);
    public void agregarImagen(String rutaImagen);
    public void agregarCategoria(DataCategoria categoria);
    public Boolean validarInfo();
    public void ingresarEspecificacion(String clave, String desc);
    public void agregarCategoriaAEspecificacion(String categoria);
    
}
