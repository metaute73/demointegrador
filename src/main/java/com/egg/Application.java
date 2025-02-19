package com.egg;
import com.egg.servicios.*;

public class Application {

    public static void main(String[] args) {
        /* 
        AutorServicio miautor = new AutorServicio();
        miautor.crearAutor("Daniel", true);
        miautor.buscarAutorPorNombre("Daniel");
        
        LibroServicio miLibro = new LibroServicio();
        miLibro.CrearLibro("La venganza del León", 2007, 7, false, 1, 1);
        */
        EditorialServicio miEdi = new EditorialServicio();
        miEdi.crearEditorial("Edi 1", true);
    }
}
