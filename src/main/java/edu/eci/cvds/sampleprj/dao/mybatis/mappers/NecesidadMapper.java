package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadMapper {
    void crearNecesidad(@Param("necesidad") Necesidad n);
    List<Necesidad> consultarNombresNecesidad();
}