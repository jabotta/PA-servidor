package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ManejadorUsuarios {
    
    private static ManejadorUsuarios instance = null;
    Map<String,Usuario> usuarios = Collections.synchronizedMap(new HashMap());
    
    EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("ProgramacionAppPU");
    EntityManager entityManager = EntityManagerFactory.createEntityManager();
    
    public static ManejadorUsuarios getInstance(){
        if(ManejadorUsuarios.instance == null){
            ManejadorUsuarios.instance = new ManejadorUsuarios();
        }
        return ManejadorUsuarios.instance;
    }
    
    private ManejadorUsuarios(){
    
    }
    
    public void agregarUsuario(Usuario usuario){
        usuarios.put(usuario.getNickname(), usuario);
        
        //guardo la categoria en bd
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
    }
    
    public Map<String,Usuario> obtenerUsuarios(){
        //obtengo todas las categorias de la bd
        Query query = entityManager.createQuery("SELECT u FROM Usuario u");
        
        //las guardo en la colecion
        List<Usuario> listUsuarios = query.getResultList();
        listUsuarios.stream().forEach((usu) -> {
            usuarios.put(usu.getNickname(), usu);
        });
        return usuarios;
    }
    
    public Map<String,Cliente> obtenerClientes(){
        //obtengo todas las categorias de la bd
        Query query = entityManager.createQuery("SELECT c FROM Cliente c");
        
        //las guardo en la colecion
        Map<String,Cliente> clientes = Collections.synchronizedMap(new HashMap());
        List<Cliente> listClientes = query.getResultList();
        listClientes.stream().forEach((cli) -> {
            clientes.put(cli.getNickname(), cli);
        });
        return clientes;
    }
    
    public Map<String,Proveedor> obtenerProveedores(){
        //obtengo todas las categorias de la bd
        Query query = entityManager.createQuery("SELECT c FROM Proveedor c");
        
        //las guardo en la colecion
        Map<String,Proveedor> proveedores = Collections.synchronizedMap(new HashMap());
        List<Proveedor> listProveedores = query.getResultList();
        listProveedores.stream().forEach((pro) -> {
            proveedores.put(pro.getNickname(), pro);
        });
        return proveedores;
    }
    
    public Cliente getCliente(String nickname){
        return this.obtenerClientes().get(nickname);
    }
    
    public Proveedor getProveedor(String nickname){
        return this.obtenerProveedores().get(nickname);
    }
    
}
