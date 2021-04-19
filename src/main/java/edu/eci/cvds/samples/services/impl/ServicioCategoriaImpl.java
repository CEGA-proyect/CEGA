package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.CategoriaDAO;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.ServicioCategoria;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

public class ServicioCategoriaImpl implements ServicioCategoria  {
    @Inject 
    private CategoriaDAO categoriaDAO;

    @Override
    public void crearCategoria(Categoria c) throws SolidaridadEscuelaException {
        try {
            categoriaDAO.crearCategoria(c);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }

    @Override
    public void actualizarDescripcionCategoria(String nombre, String descripcion) throws SolidaridadEscuelaException{
        try {
            categoriaDAO.actualizarDescripcionCategoria(nombre, descripcion);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException("Error actualizar la descripcion de la categoria");
        }
        
    }

    @Override
    public void actualizarEstadoCategoria(String nombre, String estado) throws SolidaridadEscuelaException {
        try {
            categoriaDAO.actualizarDescripcionCategoria(nombre, estado);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException("Error actualizar la descripcion de la categoria");
        }
        
    }

    @Override
    public void actualizarNombreCategoria(String nombre, String nombreNuevo) throws SolidaridadEscuelaException {
        try {
            categoriaDAO.actualizarDescripcionCategoria(nombre, nombreNuevo);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException("Error actualizar la descripcion de la categoria");
        }
        
    }
}
