package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

import java.util.List;

public interface NecesidadDAO {
    void crearNecesidad(Necesidad n) throws PersistenceException;
    List<Necesidad> consultarNombresNecesidad() throws PersistenceException;

}
