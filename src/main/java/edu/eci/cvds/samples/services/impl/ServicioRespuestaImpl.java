package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.RespuestaDAO;
import edu.eci.cvds.samples.entities.Respuesta;
import edu.eci.cvds.samples.services.ServicioRespuesta;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

import java.util.List;

public class ServicioRespuestaImpl implements ServicioRespuesta {
    @Inject
    private RespuestaDAO respuestaDAO;

    @Override
    public void crearRespuesta(Respuesta r)throws SolidaridadEscuelaException{
        try{
            respuestaDAO.crearRespuesta(r);
        }catch (Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }

    @Override
    public List<Respuesta> consultarRespuestas() throws SolidaridadEscuelaException{
        try{
            return respuestaDAO.consultarRespuestas();
        }catch (Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }
}
