package com.egg.servicios;
import com.egg.persistencia.AutorDAO;
import com.egg.entidades.Autor;
public class AutorServicio {

    private final AutorDAO daoAutor;

    public AutorServicio() {
        this.daoAutor = new AutorDAO();
    }

    public void crearAutor(String nombre, Boolean alta) {

        try {
            Autor nuevoAutor = new Autor();

            nuevoAutor.setNombre(nombre);
            nuevoAutor.setAlta(alta);
            daoAutor.guardarAutor(nuevoAutor);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el nuevo autor de manera correcta");
        }

    }
    public void eliminarAutor(Integer id){
        try{
            if (id == null){
                throw new Exception();
            }
            daoAutor.eliminarAutor(id);
        }catch(Exception e){
            System.out.println("El id del autor no puede ser vacío");
        }
    }
    public void buscarAutorPorNombre(String nombre){
        try{
            if (nombre == null){
                throw new Exception();
            }
            System.out.println(daoAutor.buscarAutorPorNombre(nombre).toString());
        }catch(Exception e){
            System.out.println("El autor no puede ser vacío");
        }
    }
    public Autor buscarAutor(Integer id){
        return daoAutor.buscarAutor(id);
    }
    
}
