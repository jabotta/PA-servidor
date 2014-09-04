package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ManejadorCategorias {
    
    private static ManejadorCategorias instance = null;
    Map<String,Categoria> categorias = Collections.synchronizedMap(new HashMap<String, Categoria>());
    
    EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("ProgramacionAppPU");
    EntityManager entityManager = EntityManagerFactory.createEntityManager();
    
    public static ManejadorCategorias getInstance(){
        if(ManejadorCategorias.instance == null){
            ManejadorCategorias.instance = new ManejadorCategorias();
        }
        return ManejadorCategorias.instance;
    }
    
    private ManejadorCategorias(){
    
    }
    
    public void agregarCategoria(Categoria categoria){
        //la agrego a la colecion
        categorias.put(categoria.getNombre(), categoria);
        
        categoria.getListaProductos().entrySet().forEach((producto) -> {
            ManejadorEspProductos.getInstance().getEspecificacionProducto(producto.getKey()).agregarCategoria(categoria);
        });
        
        //guardo la categoria en bd
        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
    public Map<String,Categoria> obtenerCategorias(){
        //obtengo todas las categorias de la bd
        Query query = entityManager.createQuery("SELECT c FROM Categoria c", Categoria.class);
        
        //las guardo en la colecion
        List<Categoria> listCategorias = query.getResultList();
        listCategorias.stream().forEach((cat) -> {
            categorias.put(cat.getNombre(), cat);
        });
        
        return categorias;
    }
    
    public Categoria getCategoria(String nombre){
        return this.obtenerCategorias().get(nombre);
    }
    
}
