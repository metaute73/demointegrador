package com.egg;
import com.egg.servicios.AutorServicio;

public class Application {

    public static void main(String[] args) {
        AutorServicio miautor = new AutorServicio();
        miautor.crearAutor("Daniel", true);
        miautor.buscarAutorPorNombre("Daniel");
    }
}
