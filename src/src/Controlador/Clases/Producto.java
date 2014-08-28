package Controlador.Clases;

import Controlador.DataTypes.DataEspecificacionProducto;
import java.util.ArrayList;

public class Producto {
    
    private Integer id;
    private EspecificacionProducto especificacionProducto;

    public Producto(Integer id, EspecificacionProducto especificacionProducto) {
        this.id = id;
        this.especificacionProducto = especificacionProducto;
    }

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
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
