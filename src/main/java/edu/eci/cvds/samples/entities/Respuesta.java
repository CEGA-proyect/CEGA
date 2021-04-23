package edu.eci.cvds.samples.entities;

import java.time.LocalDate;

public class Respuesta {
    private int id;
    private String nombre;
    private LocalDate fechaDeCreacion;
    private int tipo_id;
    private String tipo;
    private String comentario;

    public Respuesta(){
        super();
    }

    public Respuesta(String nombre,String comentario , LocalDate fechaDeCreacion, String tipo , int tipo_id){
        this.nombre = nombre;
        this.fechaDeCreacion = fechaDeCreacion;
        this.tipo = tipo;
        this.tipo_id = tipo_id;
        this.comentario = comentario;

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

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public int getTipo_id() {
        return tipo_id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}
