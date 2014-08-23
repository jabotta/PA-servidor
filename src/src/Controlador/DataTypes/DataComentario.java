package Controlador.DataTypes;

import Controlador.Clases.Comentario;

public class DataComentario {
    
    private DataCliente cliente;
    private DataEspecificacionProducto especificacionProducto;
    private String comentario;
    
    public DataComentario(Comentario c) {
        
    }
    
    public DataComentario(DataCliente cliente, DataEspecificacionProducto especificacionProducto, String comentario) {
        this.cliente = cliente;
        this.especificacionProducto = especificacionProducto;
        this.comentario = comentario;
    }

    public DataCliente getCliente() {
        return cliente;
    }
    
    public void setCliente(DataCliente cliente) {
        this.cliente = cliente;
    }
    
    public DataEspecificacionProducto getEspecificacionProducto() {
        return especificacionProducto;
    }

    public void setEspecificacionProducto(DataEspecificacionProducto especificacionProducto) {
        this.especificacionProducto = especificacionProducto;
    }
    
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
