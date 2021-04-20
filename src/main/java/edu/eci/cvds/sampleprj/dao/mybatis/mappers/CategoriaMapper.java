package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.Categoria;
import java.util.List;

public interface CategoriaMapper {
    void crearCategoria(@Param("categoria") Categoria c);

    void actualizarDescripcionCategoria(@Param("nombre") String nombre, @Param("descripcion") String descripcion);

    void actualizarEstadoCategoria(@Param("nombre") String nombre, @Param("estado") String estado);

    void actualizarNombreCategoria(@Param("nombre") String nombre, @Param("nombreNuevo") String nombreNuevo);

    int consultarIdcategoriaPorNombre(@Param("nombre") String nombre);

    List<Categoria> consultarNombresCategorias();

}
