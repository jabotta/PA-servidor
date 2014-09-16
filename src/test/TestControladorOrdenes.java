import Controlador.Clases.Fabrica;
import Controlador.Clases.IControladorOrdenes;
import Controlador.Clases.IControladorProductos;
import Controlador.Clases.IControladorUsuarios;
import Controlador.Clases.ManejadorOrdenes;
import Controlador.Clases.ManejadorUsuarios;
import Controlador.Clases.OrdenCompra;
import Controlador.Clases.Producto;
import Controlador.DataTypes.DataCategoria;
import Controlador.DataTypes.DataCliente;
import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataOrdenCompra;
import Controlador.DataTypes.DataProducto;
import Controlador.DataTypes.DataProveedor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.isNull;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestControladorOrdenes {
    
    @Test
    public void GenerarOrdenTest() {
        Integer idOrdenesControlador = Fabrica.getInstance().getControladorOrdenes(null).getId();
        IControladorOrdenes controlarOrden = Fabrica.getInstance().getControladorOrdenes(idOrdenesControlador);
        Integer idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
        IControladorUsuarios controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        Integer idProductosControlador = Fabrica.getInstance().getControladorProductos(null).getId();
        IControladorProductos controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1960, 11, 1);
        controlarUsuario.ingresarDatosProveedor(new DataProveedor("jrod", "Juan", "Rodriguez", "jrod@gmail.com", cal1,"Juegos", "www.juegos.com"));
        controlarUsuario.guardarUsuario();
        
        Calendar cal2 = Calendar.getInstance();
        cal2.set(1960, 11, 1);
        controlarUsuario.ingresarDatosCliente(new DataCliente("piedra", "Pedro", "Picapiedra", "ppiedra@gmail.com", cal2));
        controlarUsuario.guardarUsuario();
        
        DataCategoria cat1 = new DataCategoria("cat1", null);
        controlarProducto.ingresarDatosCategoria(cat1);
        controlarProducto.guardarCategoria();
        
        //leer datos de nueva especificacion de IngresarDatosUnidad
        controlarProducto.elegirProveedor("jrod");
        DataProveedor proveedor = new DataProveedor(ManejadorUsuarios.getInstance().getProveedor("jrod"));
        DataEspecificacionProducto espProducto = new DataEspecificacionProducto("prod1", "Producto 1", "descripcion 1", new HashMap(), (float)12.0, proveedor, new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        controlarProducto.ingresarDatosProductos(espProducto);
        controlarProducto.ingresarEspecificacion("Color", "Verde");
        controlarProducto.ingresarEspecificacion("Peso", "1kg");
        DataProducto prodUnidad = new DataProducto(11, "idesp1", espProducto);
        controlarProducto.ingresarDatosUnidad(prodUnidad);
        controlarProducto.agregarCategoriaAEspecificacion("cat1");
        controlarProducto.agregarImagen("peteco");
        controlarProducto.guardarProducto();
        
        //Cliente Seleccionado
        controlarOrden.elegirCliente("piedra");
        //Categoria Seleccionado
        controlarOrden.elegirCategoria("cat1");
        //Especificacion Producto seleccionado
        controlarOrden.elegirEspecificacionProducto("prod1");
        //Producto seleccionado1
        controlarOrden.elegirProducto(11);
        //Generar item Orden1
        controlarOrden.generarItemOrden();
        //Guardar Orden1
        DataOrdenCompra dataOrden = new DataOrdenCompra(1);
        controlarOrden.guardarOrden(dataOrden);
        
        Map<Integer, OrdenCompra> ord = ManejadorOrdenes.getInstance().obtenerOrdenes();
        assertTrue (!isNull (ord.get(1)));
        assertEquals (ord.get(1).getNroOrden(), dataOrden.getNroOrden());
        //prod
        assertEquals (ord.get(1).getClienteCompraProducto().get(0).getProducto().getId(), new Producto(prodUnidad).getId());
        
     }
    
    @Test
    public void CancelarOrdenTest () {
        Integer idOrdenesControlador = Fabrica.getInstance().getControladorOrdenes(null).getId();
        IControladorOrdenes controlarOrden = Fabrica.getInstance().getControladorOrdenes(idOrdenesControlador);
        Integer idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
        IControladorUsuarios controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        Integer idProductosControlador = Fabrica.getInstance().getControladorProductos(null).getId();
        IControladorProductos controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1960, 11, 1);
        controlarUsuario.ingresarDatosProveedor(new DataProveedor("jrod", "Juan", "Rodriguez", "jrod@gmail.com", cal1,"Juegos", "www.juegos.com"));
        controlarUsuario.guardarUsuario();
        
        Calendar cal2 = Calendar.getInstance();
        cal2.set(1960, 11, 1);
        controlarUsuario.ingresarDatosCliente(new DataCliente("piedra", "Pedro", "Picapiedra", "ppiedra@gmail.com", cal2));
        controlarUsuario.guardarUsuario();
        
        DataCategoria cat1 = new DataCategoria("cat1", null);
        controlarProducto.ingresarDatosCategoria(cat1);
        controlarProducto.guardarCategoria();
        
        //leer datos de nueva especificacion de IngresarDatosUnidad
        controlarProducto.elegirProveedor("jrod");
        DataProveedor proveedor = new DataProveedor(ManejadorUsuarios.getInstance().getProveedor("jrod"));
        DataEspecificacionProducto espProducto = new DataEspecificacionProducto("prod1", "Producto 1", "descripcion 1", new HashMap(), (float)12.0, proveedor, new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        controlarProducto.ingresarDatosProductos(espProducto);
        controlarProducto.ingresarEspecificacion("Color", "Verde");
        controlarProducto.ingresarEspecificacion("Peso", "1kg");
        DataProducto prodUnidad = new DataProducto(11, "idesp1", espProducto);
        controlarProducto.ingresarDatosUnidad(prodUnidad);
        controlarProducto.agregarCategoriaAEspecificacion("cat1");
        controlarProducto.agregarImagen("peteco");
        controlarProducto.guardarProducto();
        
        //Cliente Seleccionado
        controlarOrden.elegirCliente("piedra");
        //Categoria Seleccionado
        controlarOrden.elegirCategoria("cat1");
        //Especificacion Producto seleccionado
        controlarOrden.elegirEspecificacionProducto("prod1");
        //Producto seleccionado1
        controlarOrden.elegirProducto(11);
        //Generar item Orden1
        controlarOrden.generarItemOrden();
        //Guardar Orden1
        DataOrdenCompra dataOrden = new DataOrdenCompra(1);
        controlarOrden.guardarOrden(dataOrden);
        
        controlarOrden.elegirOrden(1);
        controlarOrden.borrarOrdenCompra();
        
        Map<Integer, OrdenCompra> ord = ManejadorOrdenes.getInstance().obtenerOrdenes();
        assertTrue (isNull (ord.get(1)));
    }
    
    @Test
    public void VerInformacionOrdenTest () {
        Integer idOrdenesControlador = Fabrica.getInstance().getControladorOrdenes(null).getId();
        IControladorOrdenes controlarOrden = Fabrica.getInstance().getControladorOrdenes(idOrdenesControlador);
        Integer idUsuariosControlador = Fabrica.getInstance().getControladorUsuarios(null).getId();
        IControladorUsuarios controlarUsuario = Fabrica.getInstance().getControladorUsuarios(idUsuariosControlador);
        Integer idProductosControlador = Fabrica.getInstance().getControladorProductos(null).getId();
        IControladorProductos controlarProducto = Fabrica.getInstance().getControladorProductos(idProductosControlador);
        
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1960, 11, 1);
        controlarUsuario.ingresarDatosProveedor(new DataProveedor("jrod", "Juan", "Rodriguez", "jrod@gmail.com", cal1,"Juegos", "www.juegos.com"));
        controlarUsuario.guardarUsuario();
        
        Calendar cal2 = Calendar.getInstance();
        cal2.set(1960, 11, 1);
        controlarUsuario.ingresarDatosCliente(new DataCliente("piedra", "Pedro", "Picapiedra", "ppiedra@gmail.com", cal2));
        controlarUsuario.guardarUsuario();
        
        DataCategoria cat1 = new DataCategoria("cat1", null);
        controlarProducto.ingresarDatosCategoria(cat1);
        controlarProducto.guardarCategoria();
        
        //leer datos de nueva especificacion de IngresarDatosUnidad
        controlarProducto.elegirProveedor("jrod");
        DataProveedor proveedor = new DataProveedor(ManejadorUsuarios.getInstance().getProveedor("jrod"));
        DataEspecificacionProducto espProducto = new DataEspecificacionProducto("prod1", "Producto 1", "descripcion 1", new HashMap(), (float)12.0, proveedor, new ArrayList<>(), new ArrayList<>(),new ArrayList<>());
        controlarProducto.ingresarDatosProductos(espProducto);
        controlarProducto.ingresarEspecificacion("Color", "Verde");
        controlarProducto.ingresarEspecificacion("Peso", "1kg");
        DataProducto prodUnidad = new DataProducto(11, "idesp1", espProducto);
        controlarProducto.ingresarDatosUnidad(prodUnidad);
        controlarProducto.agregarCategoriaAEspecificacion("cat1");
        controlarProducto.agregarImagen("peteco");
        controlarProducto.guardarProducto();
        
        //Cliente Seleccionado
        controlarOrden.elegirCliente("piedra");
        //Categoria Seleccionado
        controlarOrden.elegirCategoria("cat1");
        //Especificacion Producto seleccionado
        controlarOrden.elegirEspecificacionProducto("prod1");
        //Producto seleccionado1
        controlarOrden.elegirProducto(11);
        //Generar item Orden1
        controlarOrden.generarItemOrden();
        //Guardar Orden1
        DataOrdenCompra dataOrdenCreada = new DataOrdenCompra(1);
        controlarOrden.guardarOrden(dataOrdenCreada);
        
        //Orden Seleccionada
        controlarOrden.elegirOrden(1);
        
        DataOrdenCompra dataOrden = controlarOrden.mostrarDatosOrden();
        
        assertTrue (!isNull (dataOrden));
        assertEquals (dataOrden.getNroOrden(), dataOrdenCreada.getNroOrden());
        //prod
        assertEquals (dataOrden.getClienteCompraProducto().get(0).getProducto().getId(), new Producto(prodUnidad).getId());
        
    }
}
