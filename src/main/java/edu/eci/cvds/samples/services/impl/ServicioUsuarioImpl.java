package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import edu.eci.cvds.samples.services.ServicioUsuario;
public class ServicioUsuarioImpl implements ServicioUsuario {
    @Inject
    private UsuarioDAO usuarioDAO;

    @Override
    public Usuario consultarIdUsuarioPorCorreo(String correo) throws SolidaridadEscuelaException {
        try {
            return usuarioDAO.consultarIdPorCorreo(correo);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException("Error al consultar usuario con correo "+correo);
        }
    }

}
