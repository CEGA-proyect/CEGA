package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadMapper {
    void crearNecesidad(@Param("necesidad") Necesidad n);
    List<Necesidad> consultarNombresNecesidad();
    List<Necesidad> consultarNombresNecesidadGeneral();
    void actualizarEstadoNecesidad(@Param("id") int id, @Param("estado") String estado );
    int consultarNumeroNecesidadesUsuario(@Param("usuario_id") String usuario_id);
    String consultarNombreNecesidadPorId(@Param("id") int num);
}