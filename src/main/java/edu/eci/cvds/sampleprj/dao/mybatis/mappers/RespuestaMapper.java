package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Respuesta;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RespuestaMapper {
    void crearRespuesta(@Param("respuesta") Respuesta r);
    List<Respuesta> consultarRespuestas();
}
