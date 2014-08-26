package Controlador.Clases;

import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProveedor;
import Controlador.DataTypes.DataUsuario;
import java.util.ArrayList;

public class ControladorUsuarios implements IControladorUsuarios{
    private Integer id;
    private Cliente clienteElegido;
    private Proveedor proveedorElegido;
    
    @Override
    public Integer getId(){
        return this.id;
    }
    
    @Override
    public void setId(Integer id){
        this.id = id;
    }
    
//    - prvLst : Set<Proveedor> 
    
    @Override
    public void ingresarDatos(DataUsuario usuario){
        
    }
    
    @Override
    public void validarDatosUsuario(){
        
    }
    
    @Override
    public void guardarUsuario(){
        
    }
    
    //@Override
//    public void cancelar(){
//        
//    }
    
    //@Override
//    public DataTablaUsuario mostrarTablaCliente(){
//        return null;
//    }
    
    @Override
    public void elegirCliente(String nickname){
        
    }
    
    @Override
    public DataCliente mostrarDatosCliente(){
        return null;
    }
    
    @Override
    public ArrayList<DataOrdenCompra> listarOrdenes(){
        return null;
    }
    
    @Override
    public ArrayList<DataProveedor> listarProveedores(){
        return null;
    }
    
    @Override
    public void elegirProveedor(String nickname){
        
    }
    
    @Override
    public DataProveedor mostrarDatosProveedor(){
        return null;
    }
        
}
