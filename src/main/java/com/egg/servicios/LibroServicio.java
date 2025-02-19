package com.egg.servicios;

import com.egg.entidades.Libro;
import com.egg.persistencia.LibroDAO;

public class LibroServicio {
    private LibroDAO libroDAO;
    
    public LibroServicio() {
        this.libroDAO = new LibroDAO();
    }

    public void guardarLibro(Libro libro) {
        try {
            libroDAO.guardarLibro(libro);
            System.out.println("Libro guardado con éxito.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarLibro(Long isbn) {
        Libro libroRequerido = libroDAO.buscarLibro(isbn);
        try {
            if (libroRequerido == null) {
                throw new Exception("No se encontró el libro con ISBN " + isbn);
            }
            System.out.println(libroRequerido);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
