package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Respuesta;

public interface RespuestaDAO {
    void crearRespuesta(Respuesta r) throws PersistenceException;
}
