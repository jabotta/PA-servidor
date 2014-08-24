package Controlador.Clases;

public class Fabrica {
    
    private static Fabrica instance= null;
    
    private Fabrica(){
    
    }
    
    public static Fabrica getInstance(){
        if(Fabrica.instance == null){
            
            Fabrica.instance = new Fabrica();
        }
        return Fabrica.instance;
    }
    
    public static IControladorOrdenes getControladorOrdenes(Integer idController){
        if (idController == null) {
            Integer nextKey = MgrControladorOrdenes.getInstance().getSiguienteKey();
            return MgrControladorOrdenes.getInstance().getController(nextKey);
        }
        return MgrControladorOrdenes.getInstance().getController(idController);
    }
    
    public static IControladorProductos getControladorProductos(Integer idController){
        if(idController == null){
            Integer nextKey = MgrControladorProductos.getInstance().getSiguienteKey();
            return MgrControladorProductos.getInstance().getController(nextKey);
        }
        return MgrControladorProductos.getInstance().getController(idController);
    }
    
    public static IControladorUsuarios getControladorUsuarios(Integer idController){
        if(idController == null){
            Integer nextKey = MgrControladorUsuarios.getInstance().getSiguienteKey();
            return MgrControladorUsuarios.getInstance().getController(nextKey);
        }
        return MgrControladorUsuarios.getInstance().getController(idController);
    }
    
}
