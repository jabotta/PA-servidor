package Controlador.Clases;

public class ManejadorCategorias {
    
    private static ManejadorCategorias instance = null;
    
    public static ManejadorCategorias getInstance(){
        if(ManejadorCategorias.instance == null){
            
            ManejadorCategorias.instance = new ManejadorCategorias();
        }
        return ManejadorCategorias.instance;
    }
    
    private ManejadorCategorias(){
    
    }
    
    public void guardarCategoria(Categoria categoria){
        
    }
    
}
