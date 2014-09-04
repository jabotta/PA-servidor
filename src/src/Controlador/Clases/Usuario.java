package Controlador.Clases;

import Controlador.DataTypes.DataUsuario;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private Calendar fechaNacimiento;
    private String imagen;

    public Usuario() {
    }
    
    public Usuario(String nickname, String nombre, String apellido, String email, Calendar fechaNacimiento) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Usuario(DataUsuario du) {
        this.nickname = du.getNickname();
        this.nombre = du.getNombre();
        this.apellido = du.getApellido();
        this.email = du.getEmail();
        this.fechaNacimiento = du.getFechaNacimiento();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public boolean validarDatosUsuario(){
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nickname != null ? nickname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        return (this.nickname != null || other.nickname == null) && (this.nickname == null || this.nickname.equals(other.nickname));
    }
    
}
