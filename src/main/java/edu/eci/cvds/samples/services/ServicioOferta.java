package edu.eci.cvds.samples.services;


import edu.eci.cvds.samples.entities.Oferta;

import java.util.List;

public interface ServicioOferta {
    void crearOferta(Oferta o) throws SolidaridadEscuelaException;
    List<Oferta> consultarNombresOfertas() throws SolidaridadEscuelaException;
    List<Oferta> consultarNombresOfertasGeneral() throws SolidaridadEscuelaException;
    void actualizarEstadoOferta(int id, String estado) throws SolidaridadEscuelaException;
    int consultarNumeroOfertasUsuario(String usuario_id) throws  SolidaridadEscuelaException;
    String consultarNombreOfertaPorId(int num) throws SolidaridadEscuelaException;

}
