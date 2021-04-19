package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Usuario implements Serializable
{
    private static final long serialVersionUID = -3562557157186870879L;
    private String contraseña;
    private String user; 
    private String estado; 
    private String correo; 
    private String tipoDeIdentificacion; 
    private int identificacion; 
    private String nombre; 
    private LocalDate fechaRegistro;
    private String rol; 
    
    public Usuario(String contraseña,String user,String estado,String correo,String tipoDeIdentificacion,int identificacion,String nombre, String rol){
    	this.contraseña = contraseña; 
    	this.user = user ; 
    	this.estado = estado ; 
    	this.correo = correo; 
    	this.tipoDeIdentificacion = tipoDeIdentificacion; 
    	this.identificacion = identificacion; 
    	this.nombre = nombre;
        this.rol = rol; 
    	this.fechaRegistro = java.time.LocalDate.now();
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getContraseña() {
        return contraseña;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public int getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }
    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }
    public String getUsuario() {
        return user;
    }
    public void setUsuario(String usuario) {
        this.user = usuario;
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    
}