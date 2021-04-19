package edu.eci.cvds.samples.entities;

public class Egresado extends Usuario {
    private static final long serialVersionUID = -7126912460769107835L;

    Egresado(String contraseña,String usuario,String estado,String correo,String tipoDeIdentificacion,int identificacion,String nombre){
        super(contraseña, usuario, estado, correo, tipoDeIdentificacion, identificacion, nombre,"user"); 
    }
}
