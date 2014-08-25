package Controlador.Clases;

import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProveedor;
import Controlador.DataTypes.DataUsuario;
import java.util.ArrayList;

public class ControladorUsuarios implements IControladorUsuarios{
    public Integer id;
    
    public Integer getId(){
        return this.id;
    }
    
    private Cliente clienteElegido;
    private Proveedor proveedorElegido;
//    - prvLst : Set<Proveedor> 
    
    public void ingresarDatos(DataUsuario usuario){
        
    }
    
    public void validarDatosUsuario(){
        
    }
    
    public void guardarUsuario(){
        
    }
    
//    public void cancelar(){
//        
//    }
    
//    public DataTablaUsuario mostrarTablaCliente(){
//        return null;
//    }
    
    public void elegirCliente(String nickname){
        
    }
    
    public DataCliente mostrarDatosCliente(){
        return null;
    }
    
    public ArrayList<DataOrdenCompra> listarOrdenes(){
        return null;
    }
    
    public ArrayList<DataProveedor> listarProveedores(){
        return null;
    }
    
    public void elegirProveedor(String nickname){
        
    }
    
    public DataProveedor mostrarDatosProveedor(){
        return null;
    }
        
}
