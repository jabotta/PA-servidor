package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProducto;
import java.util.ArrayList;

public interface IControladorOrdenes {
    
    public Integer getId();
    public void setId(Integer id);
    public ArrayList<DataCliente> listarClientes();
    public void elegirCliente(String nickname);
    public ArrayList<DataCategoria> listarCategorias();
    public void elegirCategoria(String categoria);
    public ArrayList<DataEspecificacionProducto> listarEspecificacionProductos();
    public void elegirEspecificacionProducto(String nroRef);
//    public void elegirMetodoDeSeleccion(String metodo);
    public ArrayList<DataEspecificacionProducto> listarProductosEnOrden();
    public void elegirProducto(Integer id);
    public void elegirCantidadProducto(Integer cantidad);
    public void generarItemOrden();
    public void guardarOrden(DataOrdenCompra dataOrden);
//    public void imprimirDatosOrden();
    public ArrayList<DataOrdenCompra> listarOrdenes();
    public void elegirOrden(Integer nroOrden);
//    public Boolean confirmarEliminacion();
    public void borrarOrdenCompra();
    public DataOrdenCompra mostrarDatosOrden();

    public void removerEspecificacionProducto(String ref);
    
}
