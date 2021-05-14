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
    @Override
    public List<Oferta> consultarNombresOfertas() throws SolidaridadEscuelaException{
        try {
            return ofertaDAO.consultarNombresOfertas();
        }catch(Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }

    @Override
    public void actualizarEstadoOferta(int id, String estado) throws SolidaridadEscuelaException {
        try{
            ofertaDAO.actualizarEstadoOferta(id,estado);
        }catch(Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }
    @Override
    public int consultarNumeroOfertasUsuario(String usuario_id) throws SolidaridadEscuelaException{
        try{
            return ofertaDAO.consultarNumeroOfertasUsuario(usuario_id);
        }catch (Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }

    public List<Oferta> consultarNombresOfertasGeneral() throws SolidaridadEscuelaException{
        try{
            return ofertaDAO.consultarNombresOfertasGeneral();
        }catch (Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());

        }
    }

    public String consultarNombreOfertaPorId(int num) throws SolidaridadEscuelaException{
        try{
            return ofertaDAO.consultarNombreOfertaPorId(num);
        }catch (Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());

        }
    }



}


