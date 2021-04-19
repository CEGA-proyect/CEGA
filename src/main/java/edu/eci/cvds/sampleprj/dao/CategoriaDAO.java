package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.Categoria;

public interface CategoriaDAO {
    void crearCategoria(Categoria c) throws PersistenceException;
    void actualizarDescripcionCategoria(String nombre, String descripcion) throws PersistenceException; 
    void actualizarEstadoCategoria( String nombre, String estado )throws PersistenceException; 
    void actualizarNombreCategoria( String nombre, String nombreNuevo )throws PersistenceException; 
}
