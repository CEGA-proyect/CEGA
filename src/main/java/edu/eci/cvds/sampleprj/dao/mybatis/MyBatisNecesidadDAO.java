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
    @Override
    public List<Necesidad> consultarNombresNecesidad() throws PersistenceException{
        try{
            return necesidadMapper.consultarNombresNecesidad();
        }catch(Exception e){
            throw new PersistenceException(e.toString());
        }
    }
    @Override
    public List<Necesidad> consultarNombresNecesidadGeneral() throws PersistenceException{
        try{
            return necesidadMapper.consultarNombresNecesidadGeneral();
        }catch(Exception e){
            throw new PersistenceException(e.toString());
        }
    }
    @Override
    public void actualizarEstadoNecesidad(int id , String estado) throws PersistenceException{
        try{
            necesidadMapper.actualizarEstadoNecesidad(id,estado);
        }catch(Exception e){
            throw new PersistenceException(e.toString());
        }
    }
    @Override
    public int consultarNumeroNecesidadesUsuario(String usuario_id) throws PersistenceException{
        try{
            return necesidadMapper.consultarNumeroNecesidadesUsuario(usuario_id);
        }catch (Exception e){
            throw new PersistenceException(e.toString());
        }
    }



}