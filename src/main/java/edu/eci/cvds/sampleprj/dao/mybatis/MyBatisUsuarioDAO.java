package edu.eci.cvds.sampleprj.dao.mybatis;
import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Usuario;

public class MyBatisUsuarioDAO implements UsuarioDAO {
    @Inject
    private UsuarioMapper usuarioMapper;
    @Override
    public Usuario consultarIdPorCorreo(String correo) throws PersistenceException {
        try {
            return usuarioMapper.consultarIdPorCorreo(correo);
        } catch (Exception e) {
            throw new PersistenceException(e.toString());
        }
    }
    @Override
    public String consultarNombreUsuarioPorCorreo(String correo) throws  PersistenceException{
        try{
            return usuarioMapper.consultarNombreUsuarioPorCorreo(correo);
        }catch (Exception e){
            throw new PersistenceException(e.toString());
        }
    }
}
