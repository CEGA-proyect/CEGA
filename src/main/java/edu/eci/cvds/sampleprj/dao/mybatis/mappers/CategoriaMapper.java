package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Categoria;
import java.util.List;

public interface CategoriaMapper {
    void crearCategoria(@Param("categoria") Categoria c);
    void actualizarDescripcionCategoria(@Param("id") int id, @Param("descripcion") String descripcion);
    void actualizarEstadoCategoria(@Param("id") int id, @Param("estado") String estado);
    void actualizarNombreCategoria(@Param("id") int id, @Param("nombre") String nombre);
    List<Categoria> consultarNombresCategorias();
    String consultarCategoriaPorId(@Param("id") int id);
    List<Categoria> consultarNombresCategoriasGeneral();

}
