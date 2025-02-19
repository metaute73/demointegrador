package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Autor;
import com.egg.entidades.Libro;
import com.egg.entidades.Editorial;
import com.egg.persistencia.LibroDAO;

public class LibroServicio {
    private LibroDAO libroDAO;
    private AutorServicio autorServicio;
    private EditorialServicio editorialServicio;

    public LibroServicio() {
        this.libroDAO = new LibroDAO();
        this.autorServicio = new AutorServicio();
        this.editorialServicio = new EditorialServicio();
    }

    public void CrearLibro(String titulo, Integer anio, Integer ejemplares, Boolean alta,
            Integer autor, Integer editorial) {

        try {
            Libro miLibro = new Libro();
            miLibro.setTitulo(titulo);
            miLibro.setAnio(anio);
            miLibro.setEjemplares(ejemplares);
            miLibro.setAlta(alta);
            miLibro.setAutor(autorServicio.buscarAutor(autor));
            miLibro.setEditorial(editorialServicio.buscarEditorial(editorial));
            guardarLibro(miLibro);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el nuevo autor de manera correcta");
        }

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

    public void buscarLibroPorTitulo(String titulo) {
        try {
            if (titulo == null) {
                throw new Exception();
            }
            Libro libroB = libroDAO.buscarLibroPorTitulo(titulo);
            System.out.println(libroB);
        } catch (Exception e) {
            System.out.println("System.out.println(\"El título del libro no puede ser vacío " + e.getMessage());
        }
    }

    public void buscarLibroPorAutor(String autor) {
        List<Libro> libros = libroDAO.buscarLibroPorAutor(autor);
        try {
            if (libros.isEmpty()) {
                System.out.println("no se encontraron libros");
            } else {
                for (Libro l : libros) {
                    System.out.println(l);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void buscarLibroPorEditorial(String editorial) {
        List<Libro> libros = libroDAO.buscarLibroPorEditorial(editorial);
        try {
            if (libros.isEmpty()) {
                System.out.println("no se encontraron libros");
            } else {
                for (Libro l : libros) {
                    System.out.println(l);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
