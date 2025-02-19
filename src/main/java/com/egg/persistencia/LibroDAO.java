package com.egg.persistencia;

import java.util.List;

import com.egg.entidades.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class LibroDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarLibro(Libro libro) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new Exception("Error saving the book", e);
        } finally {
            em.close();
        }
    }

    public void modificarLibro(Libro libro) throws Exception {
        try {
            Libro libroAntiguo = buscarLibro(libro.getIsbn());
            em.getTransaction().begin();
            libroAntiguo.setTitulo(libro.getTitulo());
            libroAntiguo.setAnio(libro.getAnio());
            libroAntiguo.setEjemplares(libro.getEjemplares());
            libroAntiguo.setAlta(libro.getAlta());
            libroAntiguo.setAutor(libro.getAutor());
            libroAntiguo.setEditorial(libro.getEditorial());
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new Exception("Error updating the book", e);
        } finally {
            em.close();
        }
    }

    public void eliminarLibro(Long isbn) throws Exception {
        try {
            Libro libro = buscarLibro(isbn);
            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            em.getTransaction().rollback();
            throw new Exception("Error deleting the book", e);
        } finally {
            em.close();
        }
    }

    public Libro buscarLibro(Long isbn) {
        try {
            return em.find(Libro.class, isbn);
        } finally {
            em.close();
        }
    }

    public Libro buscarLibroPorTitulo(String titulo){
        String query = "SELECT l FROM Libro l WHERE l.titulo = :param";
        return em.createQuery(query, Libro.class).setParameter("param", titulo).getSingleResult();
    }

    public List<Libro> buscarLibroPorEditorial(String editorial) {
        String query = "SELECT l FROM Libro l WHERE l.editorial.nombre = :nombreEditorial";
        return em.createQuery(query, Libro.class).setParameter("nombreEditorial", editorial).getResultList();
    }

    public List<Libro> buscarLibroPorAutor(String autor) {
        String query = "SELECT l FROM Libro l WHERE l.autor.nombre = :nombreAutor";
        return em.createQuery(query, Libro.class).setParameter("nombreAutor", autor).getResultList();
    }
}
