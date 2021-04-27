package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;

public interface ServicioUsuario {
    Usuario consultarIdUsuarioPorCorreo(String correo) throws SolidaridadEscuelaException;
    String consultarNombreUsuarioPorCorreo(String correo) throws SolidaridadEscuelaException;
    
}
