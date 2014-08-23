package Controlador.Clases;

public class Categoria {
    
    private String nombre;
    private Categoria padre;

    public Categoria(String nombre, Categoria padre) {
        this.nombre = nombre;
        this.padre = padre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Categoria getPadre() {
        return padre;
    }
    
    public void setPadre(Categoria padre) {
        this.padre = padre;
    }
    
}
