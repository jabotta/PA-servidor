package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ManejadorEspProductos {
    
    private static ManejadorEspProductos instance = null;
    Map<String,EspecificacionProducto> especificacionProductos = new HashMap();
    
    EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("ProgramacionAppPU");
    EntityManager entityManager = EntityManagerFactory.createEntityManager();
    
    public static ManejadorEspProductos getInstance(){
        if(ManejadorEspProductos.instance == null){
            
            ManejadorEspProductos.instance = new ManejadorEspProductos();
        }
        return ManejadorEspProductos.instance;
    }
    
    private ManejadorEspProductos(){
    
    }
    
    public void agregarEspecificacionProducto(EspecificacionProducto especificacionProducto){
        especificacionProductos.put(especificacionProducto.getNroReferencia(), especificacionProducto);
        especificacionProducto.getCategorias().stream().forEach((valor) -> {
            ManejadorCategorias.getInstance().getCategoria(valor.getNombre()).agregarProducto(especificacionProducto);
        });

        //guardo la especificacion de producto en bd
        entityManager.getTransaction().begin();
        entityManager.persist(especificacionProducto);
        entityManager.getTransaction().commit();
    }
    
    public Map<String,EspecificacionProducto> obtenerEspecificacionProductos(){
        //obtengo todas las categorias de la bd
        Query query = entityManager.createQuery("SELECT e FROM EspecificacionProducto e", EspecificacionProducto.class);
        
        //las guardo en la colecion
        List<EspecificacionProducto> listUsuarios = query.getResultList();
        listUsuarios.stream().forEach((esp) -> {
            especificacionProductos.put(esp.getNroReferencia(), esp);
        });
        return especificacionProductos;
    }
    
    public void modificarProducto(EspecificacionProducto especificacionProducto){
        if(entityManager.find(EspecificacionProducto.class, especificacionProducto.getNroReferencia()) == null){
           throw new IllegalArgumentException("Unknown Employee id");
       }

       entityManager.merge(especificacionProducto);
    }
    
    public EspecificacionProducto getEspecificacionProducto(String nroRef){
        return this.obtenerEspecificacionProductos().get(nroRef);
    }
    
}
