package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Respuesta;

public interface ServicioRespuesta {
    void crearRespuesta(Respuesta r) throws  SolidaridadEscuelaException;
}
