package Controlador.Clases;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ManejadorOrdenes {
    
    private static ManejadorOrdenes instance = null;
    Map<Integer,OrdenCompra> ordenes = new HashMap();
    
    EntityManagerFactory EntityManagerFactory = Persistence.createEntityManagerFactory("ProgramacionAppPU");
    EntityManager entityManager = EntityManagerFactory.createEntityManager();
    
    public static ManejadorOrdenes getInstance(){
        if(ManejadorOrdenes.instance == null){
            ManejadorOrdenes.instance = new ManejadorOrdenes();
        }
        return ManejadorOrdenes.instance;
    }
    
    private ManejadorOrdenes(){
    
    }
    
    public void agregarOrden(OrdenCompra orden){
        ordenes.put(orden.getNroOrden(), orden);
        
        //guardo la orden en bd
        entityManager.getTransaction().begin();
        entityManager.persist(orden);
        entityManager.getTransaction().commit();
    }
    
    public Map<Integer,OrdenCompra> obtenerOrdenes(){
        //obtengo todas las ordenes de la bd
        Query query = entityManager.createQuery("SELECT o FROM OrdenCompra o", OrdenCompra.class);
        
        //las guardo en la colecion
        List<OrdenCompra> listOrdenes = query.getResultList();
        listOrdenes.stream().forEach((ord) -> {
            ordenes.put(ord.getNroOrden(), ord);
        });
        return ordenes;
    }
    
    public OrdenCompra getOrden(Integer nroOrden){
        return this.obtenerOrdenes().get(nroOrden);
    }
    
    public void eliminarOrden(Integer nroOrden){
        this.obtenerOrdenes().remove(nroOrden);
    }
    
}
