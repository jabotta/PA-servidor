package Controlador.Clases;

import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;

public interface IControladorUsuarios {
    
    public Integer getId();
    public void setId(Integer id);
    public void ingresarDatosCliente(DataCliente cliente);
    public void ingresarDatosProveedor(DataProveedor proveedor);
    public Boolean validarDatosUsuario();
    public void guardarUsuario();
//    public void cancelar();
//    public DataTablaUsuario mostrarTablaCliente();
    public void elegirCliente(String nickname);
    public DataCliente mostrarDatosCliente();
    public ArrayList<DataOrdenCompra> listarOrdenes();
    public ArrayList<DataProveedor> listarProveedores();
    public void elegirProveedor(String nickname);
    public DataProveedor mostrarDatosProveedor();
    
}
