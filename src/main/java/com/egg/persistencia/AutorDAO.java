package com.egg.persistencia;
import com.egg.entidades.Autor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AutorDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarAutor(Autor autor) throws Exception {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public void eliminarAutor(Integer id) throws Exception {
        Autor autor = buscarAutor(id);
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
    }

    public Autor buscarAutor(int id) {
        return em.find(Autor.class, id);
    }

    public Autor buscarAutorPorNombre(String nombre){
        String query = "SELECT a FROM Autor a  WHERE a.nombre =  :param";
        Autor author = em.createQuery(query,Autor.class).setParameter("param", nombre).getSingleResult();
        return author;
    }

}
