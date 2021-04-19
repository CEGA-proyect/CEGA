package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Categoria;

public interface ServicioCategoria {
    void crearCategoria(Categoria c) throws SolidaridadEscuelaException;
    void actualizarDescripcionCategoria(String nombre, String descripcion)throws SolidaridadEscuelaException; 
    void actualizarEstadoCategoria( String nombre, String estado )throws SolidaridadEscuelaException; 
    void actualizarNombreCategoria( String nombre, String nombreNuevo )throws SolidaridadEscuelaException; 
}
