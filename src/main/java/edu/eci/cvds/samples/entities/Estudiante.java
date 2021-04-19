package edu.eci.cvds.samples.entities;

public class Estudiante extends Usuario {

    private static final long serialVersionUID = -3803621721172323868L;

    Estudiante(String contraseña,String usuario,String estado,String correo,String tipoDeIdentificacion,int identificacion,String nombre){
        super(contraseña, usuario, estado, correo, tipoDeIdentificacion, identificacion, nombre,"student"); 
    }
}
