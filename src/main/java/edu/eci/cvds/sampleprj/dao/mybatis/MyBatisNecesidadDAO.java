package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.NecesidadDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.NecesidadMapper;
import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public class MyBatisNecesidadDAO implements NecesidadDAO {
    @Inject
    private NecesidadMapper necesidadMapper;
    @Override
    public void crearNecesidad(Necesidad necesidad) throws PersistenceException {
        try {
            necesidadMapper.crearNecesidad(necesidad) ;
        } catch (Exception e) {
            throw new PersistenceException(e.toString());
        }
    }
    public List<Necesidad> consultarNombresNecesidad() throws PersistenceException{
        try{
            return necesidadMapper.consultarNombresNecesidad();
        }catch(Exception e){
            throw new PersistenceException(e.toString());
        }
    }


}