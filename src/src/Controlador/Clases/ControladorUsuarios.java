package Controlador.Clases;

import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;

public class ControladorUsuarios implements IControladorUsuarios{
    private Integer id;
    private Usuario nuevoUsuario;
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
    public void ingresarDatosCliente(DataCliente cliente){
        nuevoUsuario = new Cliente(cliente);
    }
    
    @Override
    public void ingresarDatosProveedor(DataProveedor proveedor){
        nuevoUsuario = new Proveedor(proveedor);
    }
    
    @Override
    public Boolean validarDatosUsuario(){
        return ManejadorUsuarios.getInstance().obtenerUsuarios().containsKey(nuevoUsuario.getNickname());
    }
    
    @Override
    public void guardarUsuario(){
        ManejadorUsuarios.getInstance().agregarUsuario(nuevoUsuario);
        System.out.println("Nuevo Usuario " + nuevoUsuario);
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
