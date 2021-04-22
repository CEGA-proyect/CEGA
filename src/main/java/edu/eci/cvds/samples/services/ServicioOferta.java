package edu.eci.cvds.samples.services;


import edu.eci.cvds.samples.entities.Oferta;

import java.util.List;

public interface ServicioOferta {
    void crearOferta(Oferta o) throws SolidaridadEscuelaException;
    List<Oferta> consultarNombresOfertas() throws SolidaridadEscuelaException;
}
