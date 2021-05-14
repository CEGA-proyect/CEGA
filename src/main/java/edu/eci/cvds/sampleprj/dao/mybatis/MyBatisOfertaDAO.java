package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.OfertaDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.OfertaMapper;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

import java.util.List;

public class MyBatisOfertaDAO implements OfertaDAO {
    @Inject
    private OfertaMapper ofertaMapper ;

    @Override
    public void crearOferta(Oferta oferta) throws PersistenceException {
        try {
            ofertaMapper.crearOferta(oferta) ;
        } catch (Exception e) {
            throw new PersistenceException(e.toString());
        }
    }

    @Override
    public List<Oferta> consultarNombresOfertas() throws PersistenceException{
        try{
            return ofertaMapper.consultarNombresOfertas();

        }catch(Exception e){
            throw new PersistenceException(e.toString());
        }
    }

    @Override
    public void actualizarEstadoOferta(int id , String estado) throws PersistenceException {
        try{
            ofertaMapper.actualizarEstadoOferta(id,estado);
        }catch (Exception e){
            throw  new PersistenceException(e.toString());
        }

    }
    @Override

    public int consultarNumeroOfertasUsuario(String usuario_id) throws PersistenceException{
        try{
            return ofertaMapper.consultarNumeroOfertasUsuario(usuario_id);
        }catch (Exception e){
            throw new PersistenceException(e.toString());
        }
    }
    @Override
    public List<Oferta> consultarNombresOfertasGeneral() throws PersistenceException {
        try{
            return ofertaMapper.consultarNombresOfertasGeneral();
        }catch (Exception e){
            throw new PersistenceException(e.getMessage());

        }
    }
    @Override
    public String consultarNombreOfertaPorId(int num) throws PersistenceException{
        try{
            return ofertaMapper.consultarNombreOfertaPorId(num);
        }catch (Exception e){
            throw new PersistenceException(e.getMessage());

        }
    }


}
