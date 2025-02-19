package com.egg.servicios;
import com.egg.persistencia.EditorialDAO;
import com.egg.entidades.Editorial;
public class EditorialServicio {

    private final EditorialDAO daoEditorial;

    public EditorialServicio() {
        this.daoEditorial = new EditorialDAO();
    }

    public void crearEditorial(String nombre, Boolean alta) {

        try {
            Editorial nuevoEditorial = new Editorial();

            nuevoEditorial.setNombre(nombre);
            nuevoEditorial.setAlta(alta);
            daoEditorial.guardarEditorial(nuevoEditorial);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el nuevo Editorial de manera correcta");
        }

    }
    public void eliminarEditorial(Integer id){
        try{
            if (id == null){
                throw new Exception();
            }
            daoEditorial.eliminarEditorial(id);
        }catch(Exception e){
            System.out.println("El id del Editorial no puede ser vacío");
        }
    }
   
    public Editorial buscarEditorial(Integer id){
        return daoEditorial.buscarEditorial(id);
    }
    
}