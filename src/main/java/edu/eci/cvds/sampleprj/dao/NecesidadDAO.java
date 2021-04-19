package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.Necesidad;

public interface NecesidadDAO {
    void crearNecesidad(Necesidad n) throws PersistenceException;

}
