package edu.eci.cvds.samples.entities;

import java.time.LocalDate;

public class Necesidad {


    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechadecreacion;
    private String estado; 
    private LocalDate fechademodificacion;
    private String urgencia; 
    private int categoria_id ;
    private String usuario_id;
    public Necesidad(){
        super();
    }
    public Necesidad(String nombre, String descripcion , LocalDate fechaDeCreacion,LocalDate fechaDeModificacion , String estado, String urgencia, int categoria, String usuario_id){
        this.usuario_id = usuario_id;
        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.fechadecreacion = fechaDeCreacion;
        this.estado = estado; 
        this.fechademodificacion = fechaDeModificacion;
        this.urgencia = urgencia; 
        this.categoria_id = categoria;
    }    
    public int getCategoria_id() {
        return categoria_id;
    }
    public void setCategoria_id(int categoria) {
        this.categoria_id = categoria;
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
    public LocalDate getFechadecreacion() {
        return fechadecreacion;
    }
    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechadecreacion = fechaDeCreacion;
    }
    public LocalDate getFechademodificacion() {
        return fechademodificacion;
    }
    public void setFechademodificacion(LocalDate fechaDeModificacion) {
        this.fechademodificacion = fechaDeModificacion;
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
