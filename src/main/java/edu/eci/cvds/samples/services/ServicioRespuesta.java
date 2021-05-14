package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Respuesta;

import java.util.List;

public interface ServicioRespuesta {
    void crearRespuesta(Respuesta r) throws  SolidaridadEscuelaException;
    List<Respuesta> consultarRespuestas() throws SolidaridadEscuelaException;
}
