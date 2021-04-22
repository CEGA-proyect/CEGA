package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.OfertaDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.OfertaMapper;
import edu.eci.cvds.samples.entities.Oferta;

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


}
