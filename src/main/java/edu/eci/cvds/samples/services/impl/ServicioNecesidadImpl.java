package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.NecesidadDAO;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.services.ServicioNecesidad;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

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
    
}
