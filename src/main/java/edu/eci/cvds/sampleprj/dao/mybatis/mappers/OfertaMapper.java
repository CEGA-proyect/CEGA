package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Oferta;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OfertaMapper {
    void crearOferta(@Param("oferta") Oferta o);
    List<Oferta> consultarNombresOfertas();
}
