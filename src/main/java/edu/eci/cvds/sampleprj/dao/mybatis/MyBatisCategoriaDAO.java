package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.CategoriaDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.samples.entities.Categoria;
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
    public void actualizarDescripcionCategoria(String nombre, String descripcion) throws PersistenceException{
        try{
            categoriaMapper.actualizarDescripcionCategoria(nombre, descripcion);; 
        }catch(Exception e){
            throw new PersistenceException("Error al actualizar al descripcion de la categoria"); 
        }
        
    }

    @Override
    public void actualizarEstadoCategoria(String nombre, String estado) throws PersistenceException {
        try{
            categoriaMapper.actualizarEstadoCategoria(nombre, estado);; 
        }catch(Exception e){
            throw new PersistenceException("Error al actualizar el esado de la categoria"); 
        }
        
    }

    @Override
    public void actualizarNombreCategoria(String nombre, String nombreNuevo)throws PersistenceException {
        try{
            categoriaMapper.actualizarNombreCategoria(nombre, nombreNuevo);;
        }catch(Exception e){
            throw new PersistenceException("Error al actualizar el nombre de la categoria"); 
        }
        
    }

    @Override
    public Integer consultarIdcategoriaPorNombre(String nombre) throws PersistenceException {
        try {
            return categoriaMapper.consultarIdcategoriaPorNombre(nombre) ;
        } catch (Exception e) {
            throw new PersistenceException(e.toString());
        }
    }

    @Override
    public List<String> consultarNombresCategorias() throws PersistenceException {
        try {
            return categoriaMapper.consultarNombresCategorias() ;
        } catch (Exception e) {
            throw new PersistenceException(e.toString());
        }
    }

}
