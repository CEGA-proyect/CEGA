package edu.eci.cvds.samples.entities;

import java.time.LocalDate;

public class Necesidad {

    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private String estado; 
    private LocalDate fechaDeModificacion; 
    private String urgencia; 
    private int categoria ;
    private String usuario_id;
    public Necesidad(){
        super();
    }
    public Necesidad(String nombre, String descripcion , LocalDate fechaDeCreacion,LocalDate fechaDeModificacion , String estado, String urgencia, int categoria, String usuario_id){
        this.usuario_id = usuario_id;
        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.fechaDeCreacion = fechaDeCreacion; 
        this.estado = estado; 
        this.fechaDeModificacion = fechaDeModificacion;
        this.urgencia = urgencia; 
        this.categoria = categoria; 
    }    
    public int getCategoria() {
        return categoria;
    }
    public void setCategoria(int categoria) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }
}
