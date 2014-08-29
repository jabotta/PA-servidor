package Controlador.Clases;

import Controlador.DataTypes.DataEspecificacionProducto;
import Controlador.DataTypes.DataProducto;
import java.util.ArrayList;

public class Producto {
    
    private Integer id;
    private String idEspecifico;
    private EspecificacionProducto especificacionProducto;

    public Producto(Integer id, EspecificacionProducto especificacionProducto) {
        this.id = id;
        this.idEspecifico = null;
        this.especificacionProducto = especificacionProducto;
    }
    
    public Producto(Integer id, String idEspecifico, EspecificacionProducto especificacionProducto) {
        this.id = id;
        this.idEspecifico = idEspecifico;
        this.especificacionProducto = especificacionProducto;
    }
    
    public Producto(DataProducto dp) {
        this.id = dp.getId();
        this.idEspecifico = dp.getIdEspecifico();
        this.especificacionProducto = dp.getObjectEspecificacionProducto();
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
    
    public void setId(String id) {
        this.idEspecifico = id;
    }
    
    public EspecificacionProducto getEspecificacionProducto() {
        return especificacionProducto;
    }
    
    public DataEspecificacionProducto getDataEspecificacionProducto() {
        return new DataEspecificacionProducto(especificacionProducto);
    }
    
    public void setEspecificacionProducto(EspecificacionProducto especificacionProducto) {
        this.especificacionProducto = especificacionProducto;
    }
    
    public ArrayList<String> getCategorias(){
        ArrayList<String> categorias = new ArrayList<>();
        this.getEspecificacionProducto().getCategorias().stream().forEach((cat) -> {
            categorias.add(cat.getNombre());
        });
        return categorias;
    }
    
    @Override
    public String toString() {
        return this.getId() + "  --  " + this.getEspecificacionProducto();
    }
    
}
