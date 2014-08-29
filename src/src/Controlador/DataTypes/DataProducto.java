package Controlador.DataTypes;

import Controlador.Clases.EspecificacionProducto;
import Controlador.Clases.Producto;
import Controlador.Clases.Proveedor;

public class DataProducto {
    
    private Integer id;
    private String idEspecifico;
    private DataEspecificacionProducto especificacionProducto;
    
    public DataProducto(Producto p) {
        this.id = p.getId();
        this.idEspecifico = p.getIdEspecifico();
        this.especificacionProducto = p.getDataEspecificacionProducto();
    }
    
    public DataProducto(Integer id, DataEspecificacionProducto especificacionProducto) {
        this.id = id;
        this.idEspecifico = null;
        this.especificacionProducto = especificacionProducto;
    }
    
    public DataProducto(Integer id, String idEspecifico, DataEspecificacionProducto especificacionProducto) {
        this.id = id;
        this.idEspecifico = idEspecifico;
        this.especificacionProducto = especificacionProducto;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getIdEspecifico() {
        return idEspecifico;
    }
    
    public void setIdEspecifico(String id) {
        this.idEspecifico = id;
    }
    
    public DataEspecificacionProducto getEspecificacionProducto() {
        return especificacionProducto;
    }
    
    public EspecificacionProducto getObjectEspecificacionProducto() {
        Proveedor prov = new Proveedor(especificacionProducto.getProveedor());
        return new EspecificacionProducto(especificacionProducto, prov);
    }
    
    public void setEspecificacionProducto(DataEspecificacionProducto especificacionProducto) {
        this.especificacionProducto = especificacionProducto;
    }
    
    @Override
    public String toString() {
        return this.getId() + "  --  " + this.getEspecificacionProducto();
    }
    
}
