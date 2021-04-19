package edu.eci.cvds.samples.entities;

public class Administrativo extends Usuario{
    private static final long serialVersionUID = 5356222018261227810L;

    Administrativo(String contraseña,String usuario,String estado,String correo,String tipoDeIdentificacion,int identificacion,String nombre){
        super(contraseña, usuario, estado, correo, tipoDeIdentificacion, identificacion, nombre,"user"); 
    }
}
