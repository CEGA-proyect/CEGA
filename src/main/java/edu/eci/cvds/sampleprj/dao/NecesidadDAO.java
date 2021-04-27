package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

import java.util.List;

public interface NecesidadDAO {
    void crearNecesidad(Necesidad n) throws PersistenceException;
    void actualizarEstadoNecesidad(int id, String estado) throws  PersistenceException;
    List<Necesidad> consultarNombresNecesidad() throws PersistenceException;
    int consultarNumeroNecesidadesUsuario(String usuario_id) throws PersistenceException;
    List<Necesidad> consultarNombresNecesidadGeneral() throws PersistenceException;


}
