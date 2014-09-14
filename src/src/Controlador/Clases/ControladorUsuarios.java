package Controlador.Clases;

import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class ControladorUsuarios implements IControladorUsuarios {

    private Integer id;
    private Usuario nuevoUsuario;
    private Cliente clienteElegido;
    private Proveedor proveedorElegido;
    private String Errors;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

//    - prvLst : Set<Proveedor> 
    @Override
    public void ingresarDatosCliente(DataCliente cliente) {
        nuevoUsuario = new Cliente(cliente);
    }

    @Override
    public void ingresarDatosProveedor(DataProveedor proveedor) {
        nuevoUsuario = new Proveedor(proveedor);
    }

    @Override
    public Boolean validarDatosUsuario() {
        Errors = "";
       
        Pattern p = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
        Boolean invalidaEmail = !p.matcher(nuevoUsuario.getEmail()).matches();
        if(invalidaEmail){
        
            Errors = "El formato de email es incorrecto";
            return true;
        }      
        for (Entry<String, Usuario> iter : ManejadorUsuarios.getInstance().obtenerUsuarios().entrySet()) {
            Boolean validateEmail = iter.getValue().getEmail().equals(nuevoUsuario.getEmail());
            Boolean valdiateNickname = iter.getValue().getNickname().equals(nuevoUsuario.getNickname());
            if (valdiateNickname) {
                Errors = "El usuario con este Nickname ya existe";
            }
            if (validateEmail) {
                String emailMsg = "El usuario con este Email ya existe";
                Errors += (valdiateNickname) ? "," + emailMsg : emailMsg;
            }
            if (valdiateNickname || validateEmail) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void guardarUsuario() {
        ManejadorUsuarios.getInstance().agregarUsuario(nuevoUsuario);
        System.out.println("Nuevo Usuario " + nuevoUsuario);
    }

    //@Override
//    public void cancelar(){
//        
//    }
    @Override
    public ArrayList<DataCliente> listarClientes() {
        ArrayList<DataCliente> dataCliente = new ArrayList<>();
        ManejadorUsuarios.getInstance().obtenerClientes().entrySet().stream().map((cliente) -> cliente.getValue()).forEach((valor) -> {
            dataCliente.add(new DataCliente(valor));
        });
        return dataCliente;
    }

    @Override
    public void elegirCliente(String nickname) {
        clienteElegido = ManejadorUsuarios.getInstance().getCliente(nickname);
    }

    @Override
    public DataCliente mostrarDatosCliente() {
        DataCliente dataCliente = new DataCliente(clienteElegido);
        return dataCliente;
    }

    @Override
    public ArrayList<DataOrdenCompra> listarOrdenesCliente() {
        ArrayList<DataOrdenCompra> dataOrdenCompra = new ArrayList<>();
        ManejadorOrdenes.getInstance().obtenerOrdenes().entrySet().stream().map((orden) -> orden.getValue()).forEach((valor) -> {
            if (valor.getCliente() == clienteElegido) {
                dataOrdenCompra.add(new DataOrdenCompra(valor));
            }
        });
        return dataOrdenCompra;
    }

    @Override
    public ArrayList<DataProveedor> listarProveedores() {
        ArrayList<DataProveedor> dataProveedor = new ArrayList<>();
        ManejadorUsuarios.getInstance().obtenerProveedores().entrySet().stream().map((proovedor) -> proovedor.getValue()).forEach((valor) -> {
            dataProveedor.add(new DataProveedor(valor));
        });
        return dataProveedor;
    }

    @Override
    public void elegirProveedor(String nickname) {
        proveedorElegido = ManejadorUsuarios.getInstance().getProveedor(nickname);
    }

    @Override
    public DataProveedor mostrarDatosProveedor() {
        DataProveedor dataProveedor = new DataProveedor(proveedorElegido);
        return dataProveedor;
    }

    public String getErrors() {
        return this.Errors;
    }
}
