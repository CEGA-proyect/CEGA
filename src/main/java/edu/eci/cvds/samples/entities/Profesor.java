package edu.eci.cvds.samples.entities;

public class Profesor extends Usuario {
    
    private static final long serialVersionUID = -7989772938202547082L;

    Profesor(String contraseña,String usuario,String estado,String correo,String tipoDeIdentificacion,int identificacion,String nombre){
        super(contraseña, usuario, estado, correo, tipoDeIdentificacion, identificacion, nombre,"user"); 
    }
}
