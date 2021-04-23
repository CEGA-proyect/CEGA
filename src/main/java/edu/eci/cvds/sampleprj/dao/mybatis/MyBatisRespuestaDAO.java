package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.RespuestaDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.RespuestaMapper;
import edu.eci.cvds.samples.entities.Respuesta;

public class MyBatisRespuestaDAO implements RespuestaDAO {
    @Inject
    RespuestaMapper respuestaMapper;

    @Override
    public void crearRespuesta(Respuesta r) throws PersistenceException {
        try {
            respuestaMapper.crearRespuesta(r);
        } catch (Exception e) {
            throw new PersistenceException(e.toString());
        }
    }
}
