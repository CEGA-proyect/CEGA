package edu.eci.cvds.samples.services;
import java.util.List;
import edu.eci.cvds.samples.entities.Categoria;

public interface ServicioCategoria {
    void crearCategoria(Categoria c) throws SolidaridadEscuelaException;
    void actualizarDescripcionCategoria(int id, String descripcion)throws SolidaridadEscuelaException;
    void actualizarEstadoCategoria( int id, String estado )throws SolidaridadEscuelaException;
    void actualizarNombreCategoria( int id, String nombre )throws SolidaridadEscuelaException;
    List<Categoria> consultarNombresCategorias() throws SolidaridadEscuelaException;
}
