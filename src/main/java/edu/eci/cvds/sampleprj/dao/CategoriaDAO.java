package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.Categoria;
import java.util.List;

public interface CategoriaDAO {
    void crearCategoria(Categoria c) throws PersistenceException;
    void actualizarDescripcionCategoria(String nombre, String descripcion) throws PersistenceException; 
    void actualizarEstadoCategoria( String nombre, String estado )throws PersistenceException; 
    void actualizarNombreCategoria( String nombre, String nombreNuevo )throws PersistenceException;
    Integer consultarIdcategoriaPorNombre(String nombre) throws PersistenceException;
    List<Categoria> consultarNombresCategorias() throws PersistenceException;

}
