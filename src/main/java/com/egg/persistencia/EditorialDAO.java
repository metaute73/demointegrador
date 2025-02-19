package com.egg.persistencia;

import java.util.List;

import com.egg.entidades.Editorial;
import com.egg.entidades.Libro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EditorialDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarEditorial(Editorial editorial) throws Exception {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public void eliminarEditorial(Integer id) throws Exception {
        Editorial editorial = buscarEditorial(id);
        em.getTransaction().begin();
        em.remove(editorial);
        em.getTransaction().commit();
    }

    public Editorial buscarEditorial(int id) {
        return em.find(Editorial.class, id);
    }

}
