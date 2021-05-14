package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Respuesta;

import java.util.List;

public interface RespuestaDAO {
    void crearRespuesta(Respuesta r) throws PersistenceException;
    List<Respuesta> consultarRespuestas() throws PersistenceException;
}
