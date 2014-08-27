package Controlador.DataTypes;

import Controlador.Clases.Producto;

public class DataProducto {
    
    private Integer id;
    private DataEspecificacionProducto especificacionProducto;
    
    public DataProducto(Producto p) {
        this.id = p.getId();
        this.especificacionProducto = p.getDataEspecificacionProducto();
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
    
    @Override
    public String toString() {
        return this.getId() + "  --  " + this.getEspecificacionProducto();
    }
    
}
