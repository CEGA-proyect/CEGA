package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.OfertaDAO;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.ServicioOferta;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

import java.util.List;

public class ServicioOfertaImpl implements ServicioOferta{
    @Inject
    private OfertaDAO ofertaDAO;

    @Override
    public void crearOferta(Oferta o) throws SolidaridadEscuelaException{
        try {
            ofertaDAO.crearOferta(o);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }
    public List<Oferta> consultarNombresOfertas() throws SolidaridadEscuelaException{
        try {
            return ofertaDAO.consultarNombresOfertas();
        }catch(Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }


}


