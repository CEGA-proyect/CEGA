package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.NecesidadDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.services.ServicioNecesidad;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

import java.util.List;

public class ServicioNecesidadImpl implements ServicioNecesidad{

    @Inject 
    private NecesidadDAO necesidadDAO;

    @Override
    public void crearNecesidad(Necesidad n) throws SolidaridadEscuelaException {
        try {
            necesidadDAO.crearNecesidad(n);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }



    public List<Necesidad> consultarNombresNecesidad() throws SolidaridadEscuelaException {
        try {
            return necesidadDAO.consultarNombresNecesidad();
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());

        }
    }

    @Override
    public void actualizarEstadoNecesidad(int id , String estado) throws SolidaridadEscuelaException{
        try{
            necesidadDAO.actualizarEstadoNecesidad(id,estado);
        }catch(Exception e){
            throw new SolidaridadEscuelaException(e.toString());
        }

    }
    @Override
    public int consultarNumeroNecesidadesUsuario(String usuario_id) throws SolidaridadEscuelaException{
        try{
            return necesidadDAO.consultarNumeroNecesidadesUsuario(usuario_id);
        }catch(Exception e){
            throw new SolidaridadEscuelaException(e.toString());
        }
    }


}
