package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Necesidad;

public interface ServicioNecesidad {
    void crearNecesidad(Necesidad c) throws SolidaridadEscuelaException; 
}
