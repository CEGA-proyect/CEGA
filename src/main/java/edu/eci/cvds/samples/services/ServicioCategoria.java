package edu.eci.cvds.samples.services;
import java.util.List;
import edu.eci.cvds.samples.entities.Categoria;

public interface ServicioCategoria {
    void crearCategoria(Categoria c) throws SolidaridadEscuelaException;
    void actualizarDescripcionCategoria(int id, String descripcion)throws SolidaridadEscuelaException;
    void actualizarEstadoCategoria( int id, String estado )throws SolidaridadEscuelaException;
    void actualizarNombreCategoria( int id, String nombre )throws SolidaridadEscuelaException;
    void actualizarValidezCategoria( int id, String valida )throws SolidaridadEscuelaException;
    List<Categoria> consultarNombresCategorias() throws SolidaridadEscuelaException;
    String consultarCategoriaPorId(int id ) throws SolidaridadEscuelaException;
    List<Categoria> consultarNombresCategoriasGeneral() throws SolidaridadEscuelaException;
    String validarCategoriaPorId(int id) throws SolidaridadEscuelaException;
}
