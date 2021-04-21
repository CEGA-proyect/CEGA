package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.Categoria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoriaDAO {
    void crearCategoria(Categoria c) throws PersistenceException;
    void actualizarDescripcionCategoria(int id, String descripcion) throws PersistenceException;
    void actualizarEstadoCategoria( int id, String estado )throws PersistenceException;
    void actualizarNombreCategoria( int id, String nombre )throws PersistenceException;
    List<Categoria> consultarNombresCategorias() throws PersistenceException;

}