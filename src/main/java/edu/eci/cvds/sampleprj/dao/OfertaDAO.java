package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Oferta;

import java.util.List;

public interface OfertaDAO {
    void crearOferta(Oferta o) throws PersistenceException;
    List<Oferta> consultarNombresOfertas() throws PersistenceException;
}
