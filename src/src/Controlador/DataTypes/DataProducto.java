package Controlador.DataTypes;

import Controlador.Clases.Producto;

public class DataProducto {
    
    private Integer id;
    private DataEspecificacionProducto especificacionProducto;
    
    public DataProducto(Producto p) {
        
    }
    
    public DataProducto(Integer id, DataEspecificacionProducto especificacionProducto) {
        this.id = id;
        this.especificacionProducto = especificacionProducto;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public DataEspecificacionProducto getEspecificacionProducto() {
        return especificacionProducto;
    }
    
    public void setEspecificacionProducto(DataEspecificacionProducto especificacionProducto) {
        this.especificacionProducto = especificacionProducto;
    }
    
}
