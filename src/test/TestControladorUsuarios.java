/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controlador.Clases.Cliente;
import Controlador.Clases.Fabrica;
import Controlador.Clases.IControladorUsuarios;
import Controlador.Clases.ManejadorUsuarios;
import Controlador.Clases.Proveedor;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataProveedor;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import static java.util.Objects.isNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author mauro
 */
public class TestControladorUsuarios {

    
    @Test
    public void AltadeUsuarioTest () {

        //agrego un usuario cliente
        Integer idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
        IControladorUsuarios controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        
        Calendar cal = Calendar.getInstance();
        cal.set(1960, 11, 1);
        DataCliente cliente1 = new DataCliente("dduck", "Daffy", "Duck", "dduck@gmail.com", cal);
        controlarUsuario.ingresarDatosCliente(cliente1);

        
        controlarUsuario.guardarUsuario();
        
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getNickname(), "dduck");
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getEmail(), "dduck@gmail.com");        
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getNombre(), "Daffy");
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getApellido(), "Duck");
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getFechaNacimiento(), new Date(1995, 01, 01));
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").validarDatosUsuario(), true);
        

        //agrego un usuario proveedor
        DataProveedor proveedor1 = new DataProveedor ("pperez", "Pedro", "Perez", "perez@gmail.com", cal, "Pcel", "www.pcel.com");
        controlarUsuario.ingresarDatosProveedor(proveedor1);
        controlarUsuario.guardarUsuario();        
        
        assertEquals (ManejadorUsuarios.getInstance().getProveedor("pperez").getNickname(), "pperez");
        assertEquals (ManejadorUsuarios.getInstance().getProveedor("pperez").getEmail(), "perez@gmail.com");
        assertEquals (ManejadorUsuarios.getInstance().getProveedor("pperez").getNombre(), "Pedro");
        assertEquals (ManejadorUsuarios.getInstance().getProveedor("pperez").getApellido(), "Perez");
        assertEquals (ManejadorUsuarios.getInstance().getProveedor("pperez").getFechaNacimiento(), cal);
        assertEquals (ManejadorUsuarios.getInstance().getProveedor("pperez").getNombreCompania(), "Pcel");
        assertEquals (ManejadorUsuarios.getInstance().getProveedor("pperez").getLinkSitio(), "www.pcel.com");
        assertEquals (ManejadorUsuarios.getInstance().getProveedor("pperez").validarDatosUsuario(), true);        

        
        //probar fotos cuando se pueda
        
        //crear usuario con nickname repetido
        DataCliente cliente2 = new DataCliente("dduck", "Darwin", "Duck", "darwinduck@gmail.com", cal);
        controlarUsuario.ingresarDatosCliente(cliente2);
        controlarUsuario.guardarUsuario();        
        
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").validarDatosUsuario(), true);        
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getNickname(), "dduck");
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getEmail(), "darwinduck@gmail.com");        
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getNombre(), "Darwin");
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getApellido(), "Duck");
        assertEquals (ManejadorUsuarios.getInstance().getCliente("dduck").getFechaNacimiento(), cal);
        

        
        
        //crear usuario con email repetido
        
        DataCliente cliente3 = new DataCliente("darwind", "Darwin", "Duck", "dduck@gmail.com", cal);
        controlarUsuario.ingresarDatosCliente(cliente3);
        controlarUsuario.guardarUsuario();        
        
        assertEquals (ManejadorUsuarios.getInstance().getCliente("darwind").validarDatosUsuario(), true);         
        assertEquals (ManejadorUsuarios.getInstance().getCliente("darwind").getNickname(), "darwind");
        assertEquals (ManejadorUsuarios.getInstance().getCliente("darwind").getEmail(), "dduck@gmail.com");        
        assertEquals (ManejadorUsuarios.getInstance().getCliente("darwind").getNombre(), "Darwin");
        assertEquals (ManejadorUsuarios.getInstance().getCliente("darwind").getApellido(), "Duck");
        assertEquals (ManejadorUsuarios.getInstance().getCliente("darwind").getFechaNacimiento(), new Date(1997, 03, 12));        

    }  
    
    @Test
    public void TestVerInformacionCliente () {
    
        //cargar clientes
        Integer idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
        IControladorUsuarios controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador); 
        
        Calendar cal = Calendar.getInstance();
        cal.set(1960, 11, 1);
        DataCliente cliente1 = new DataCliente("piedra", "Pedro", "Picapiedra", "ppiedra@gmail.com", cal);
        DataCliente cliente2 = new DataCliente("pmar", "Pablo", "Marmol", "pmarmol@gmail.com", cal);        
        DataCliente cliente3 = new DataCliente("loco", "Pajaro", "Loco", "ploco@gmail.com", cal);        
        controlarUsuario.ingresarDatosCliente(cliente1);
        controlarUsuario.guardarUsuario();        
        controlarUsuario.ingresarDatosCliente(cliente2);
        controlarUsuario.guardarUsuario();
        controlarUsuario.ingresarDatosCliente(cliente3);
        controlarUsuario.guardarUsuario();                
        

        //Listar clientes
        Map<String, Cliente> clie = ManejadorUsuarios.getInstance().obtenerClientes();
        assertTrue (!isNull (clie.get("piedra")));
        assertTrue (!isNull (clie.get("pmar")));
        assertTrue (!isNull (clie.get("loco")));
                
    }
    
    @Test
    public void TestVerInformacionProveedor () {
    
        //cargar clientes
        Integer idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
        IControladorUsuarios controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        
        Calendar cal = Calendar.getInstance();
        cal.set(1960, 11, 1);
        DataProveedor proveed1 = new DataProveedor("jrod", "Juan", "Rodriguez", "jrod@gmail.com", cal,"Juegos", "www.juegos.com");
        DataProveedor proveed2 = new DataProveedor("nmar", "Natalia", "Mar", "nmar@gmail.com", cal, "Newpc", "www.newpc.com");        
        DataProveedor proveed3 = new DataProveedor("sdum", "Sergio", "Dumas", "sdum@gmail.com", cal,"Insumos", "www.insumos.com"); 
        controlarUsuario.ingresarDatosProveedor(proveed1);
        controlarUsuario.guardarUsuario();
        controlarUsuario.ingresarDatosProveedor(proveed2);
        controlarUsuario.guardarUsuario();
        controlarUsuario.ingresarDatosProveedor(proveed3);
        controlarUsuario.guardarUsuario();
        

        Map<String, Proveedor> prov = ManejadorUsuarios.getInstance().obtenerProveedores();
        assertTrue (!isNull (prov.get("jrod")));
        assertTrue (!isNull (prov.get("nmar")));
        assertTrue (!isNull (prov.get("sdum")));
        
    }
}
