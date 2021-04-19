package edu.eci.cvds.samples.entities;

import java.time.LocalDate;

public class Necesidad {
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private String estado; 
    private LocalDate fechaDeModificacion; 
    private String urgencia; 
    private Categoria categoria ; 

    public Necesidad(String nombre, String descripcion , LocalDate fechaDeCreacion,LocalDate fechaDeModificacion , String estado, String urgencia, Categoria categoria){

        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.fechaDeCreacion = fechaDeCreacion; 
        this.estado = estado; 
        this.fechaDeModificacion = fechaDeCreacion;
        this.urgencia = urgencia; 
        this.categoria = categoria; 
    }    
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
    public LocalDate getFechaDeModificacion() {
        return fechaDeModificacion;
    }
    public void setFechaDeModificacion(LocalDate fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUrgencia() {
        return urgencia;
    }
    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }
    

}
