package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.Usuario;

public interface UsuarioDAO {
    Usuario consultarIdPorCorreo(String correo) throws PersistenceException;
    String consultarNombreUsuarioPorCorreo(String correo) throws PersistenceException;
}
