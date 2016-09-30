/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Cliente;

/**
 *
 * @author Mauro
 */
public class dao {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("proyectoLavadoPU");
    private EntityManager em;
    
    public boolean insert(Cliente c ){
        try{
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(c);
            
            em.getTransaction().commit();
            em.close();
            return true;
        }catch(Exception e){
            return false;
        }
            
        
    }
    
    
    public Cliente login(String user,String pass){
        
        Cliente c = null;
        try {
            em = emf.createEntityManager();
        em.getTransaction().begin();
        Query q = em.createQuery("select c from Cliente c where c.usuario=:user and c.password=:pass");
        q.setParameter("user",user);
        q.setParameter("pass", pass);
        c = (Cliente) q.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return c;
        } catch (Exception e) {
            return c;
        }
        
    }
    
    
    
}
