package Controlador.DataTypes;

import Controlador.Clases.Categoria;

public class DataCategoria {
    
    private String nombre;
    private DataCategoria padre;

    public DataCategoria(Categoria c) {
       
    }
    
    public DataCategoria(String nombre, DataCategoria padre) {
        this.nombre = nombre;
        this.padre = padre;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public DataCategoria getPadre() {
        return padre;
    }
    
    public void setPadre(DataCategoria padre) {
        this.padre = padre;
    }
    
}
