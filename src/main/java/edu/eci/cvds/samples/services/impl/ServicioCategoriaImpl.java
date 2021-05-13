package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.CategoriaDAO;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.ServicioCategoria;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import java.util.List;

public class ServicioCategoriaImpl implements ServicioCategoria  {
    @Inject 
    private CategoriaDAO categoriaDAO;

    @Override
    public void crearCategoria(Categoria c) throws SolidaridadEscuelaException {
        try {
            // consultar por id (verification)
            categoriaDAO.crearCategoria(c);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }


    @Override
    public List<Categoria> consultarNombresCategorias() throws SolidaridadEscuelaException {
        try {
            return categoriaDAO.consultarNombresCategorias();
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.toString());
        }
    }

    @Override
    public void actualizarDescripcionCategoria(int id, String descripcion) throws SolidaridadEscuelaException{
        try {
            categoriaDAO.actualizarDescripcionCategoria(id, descripcion);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
        
    }

    @Override
    public void actualizarEstadoCategoria(int id, String estado) throws SolidaridadEscuelaException {
        try {
            categoriaDAO.actualizarEstadoCategoria(id, estado);
        } catch (Exception e) {

            throw new SolidaridadEscuelaException(e.getMessage());
        }
        
    }

    @Override
    public void actualizarNombreCategoria(int id, String nombre) throws SolidaridadEscuelaException {
        try {
            categoriaDAO.actualizarNombreCategoria(id, nombre);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
        
    }
    @Override
    public String consultarCategoriaPorId(int id) throws SolidaridadEscuelaException{
        try{
            return categoriaDAO.consultarCategoriaPorId(id);
        }catch (Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }
}
