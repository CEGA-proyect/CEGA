package edu.eci.cvds.samples.services;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface ServicioNecesidad {
    void crearNecesidad(Necesidad c) throws SolidaridadEscuelaException;
    void actualizarEstadoNecesidad(int id , String estado) throws  SolidaridadEscuelaException;
    List<Necesidad> consultarNombresNecesidad() throws SolidaridadEscuelaException;
    List<Necesidad> consultarNombresNecesidadGeneral() throws SolidaridadEscuelaException;
    int consultarNumeroNecesidadesUsuario(String usuario_id ) throws SolidaridadEscuelaException;
}
