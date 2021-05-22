package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.CategoriaDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

import java.util.List;

public class MyBatisCategoriaDAO implements CategoriaDAO {
    @Inject
    private CategoriaMapper categoriaMapper; 

    @Override
    public void crearCategoria(Categoria c) throws PersistenceException {
        try{
            categoriaMapper.crearCategoria(c); 
        }catch(Exception e){
            throw new PersistenceException(e.getMessage()); 
        }
        
    }

    @Override
    public void actualizarDescripcionCategoria(int id, String descripcion) throws PersistenceException{
        try{
            categoriaMapper.actualizarDescripcionCategoria(id, descripcion);;
        }catch(Exception e){
            throw new PersistenceException("Error al actualizar al descripcion de la categoria"); 
        }
        
    }

    @Override
    public void actualizarEstadoCategoria(int id, String estado) throws PersistenceException {
        try{
            categoriaMapper.actualizarEstadoCategoria(id, estado);;
        }catch(Exception e){
            throw new PersistenceException(e.getMessage());
        }
        
    }

    @Override
    public void actualizarNombreCategoria(int id, String nombreNuevo)throws PersistenceException {
        try{
            categoriaMapper.actualizarNombreCategoria(id, nombreNuevo);;
        }catch(Exception e){
            throw new PersistenceException("Error al actualizar el nombre de la categoria");
        }
        
    }



    @Override
    public List<Categoria> consultarNombresCategorias() throws PersistenceException {
        try {
            return categoriaMapper.consultarNombresCategorias() ;
        } catch (Exception e) {
            throw new PersistenceException(e.toString());
        }
    }
    @Override
    public String consultarCategoriaPorId(int id) throws PersistenceException{
        try{
            return categoriaMapper.consultarCategoriaPorId(id);
        }catch(Exception e ){
            throw  new PersistenceException(e.toString());
        }
    }
    @Override
    public List<Categoria> consultarNombresCategoriasGeneral() throws PersistenceException{
        try {
            return categoriaMapper.consultarNombresCategoriasGeneral() ;
        } catch (Exception e) {
            throw new PersistenceException(e.toString());
        }
    }
    @Override
    public String validarCategoriaPorId(int id) throws PersistenceException{
        try{
            return categoriaMapper.validarCategoriaPorId(id);
        }catch (Exception e) {
            throw new PersistenceException(e.toString());
        }
    }
    @Override
    public void actualizarValidezCategoria( int id, String valida )throws PersistenceException{
        try{
            categoriaMapper.actualizarValidezCategoria(id, valida);;
        }catch(Exception e){
            throw new PersistenceException(e.getMessage());
        }
    }

}
