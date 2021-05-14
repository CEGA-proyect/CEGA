package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Oferta;

import java.util.List;

public interface OfertaDAO {
    void crearOferta(Oferta o) throws PersistenceException;
    List<Oferta> consultarNombresOfertas() throws PersistenceException;
    void actualizarEstadoOferta(int id, String estado) throws PersistenceException;
    int consultarNumeroOfertasUsuario(String usuario_id) throws  PersistenceException;
    List<Oferta> consultarNombresOfertasGeneral() throws PersistenceException;
    String consultarNombreOfertaPorId(int num) throws PersistenceException;

}
