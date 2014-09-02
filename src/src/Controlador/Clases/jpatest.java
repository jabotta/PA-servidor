/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Clases;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author darius
 */
public class jpatest {

    private static final String PERSISTENCE_UNIT_NAME = "ProgramacionAppPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT u FROM Usuario u");
        List<Usuario> userList = q.getResultList();
        for (Usuario user : userList) {
            System.out.println(user);
        }
    }

}
