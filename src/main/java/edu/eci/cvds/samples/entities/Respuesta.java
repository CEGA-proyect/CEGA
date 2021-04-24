package edu.eci.cvds.samples.entities;

import java.time.LocalDate;

public class Respuesta {
    private int id;
    private String nombre;
    private LocalDate fechaDeCreacion;
    private Integer necesidad_id;
    private Integer oferta_id;
    private String comentario;
    private String usuario_id;

    public Respuesta(){
        super();
    }

    public Respuesta(String nombre,String comentario , LocalDate fechaDeCreacion, Integer necesidad_id, Integer oferta_id, String usuario_id){
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
        this.oferta_id = oferta_id;
        this.necesidad_id = necesidad_id;
        this.comentario = comentario;
        this.usuario_id = usuario_id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }
    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public String getUsuario_id() {
        return usuario_id;
    }
    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }
    public Integer getOferta_id() {
        return oferta_id;
    }
    public void setOferta_id(Integer oferta_id) {
        this.oferta_id = oferta_id;
    }
    public Integer getNecesidad_id() {
        return necesidad_id;
    }
    public void setNecesidad_id(Integer necesidad_id) {
        this.necesidad_id = necesidad_id;
    }
}
