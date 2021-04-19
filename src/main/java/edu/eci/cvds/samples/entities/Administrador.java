package edu.eci.cvds.samples.entities;

public class Administrador extends Usuario {
    private static final long serialVersionUID = -7867483224996617685L;

    Administrador(String contraseña,String usuario,String estado,String correo,String tipoDeIdentificacion,int identificacion,String nombre){
        super(contraseña, usuario, estado, correo, tipoDeIdentificacion, identificacion, nombre,"admin"); 
    }
}
