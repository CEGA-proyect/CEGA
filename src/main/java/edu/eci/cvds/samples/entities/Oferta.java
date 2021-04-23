package edu.eci.cvds.samples.entities;

import java.time.LocalDate;

public class Oferta {
    private int categoria_id;
    private  String nombre;
    private  String descripcion;
    private LocalDate fechaDeCreacion;
    private LocalDate fechaDeModificacion;
    private String estado;
    private int id;
    private String usuario_id;


    public Oferta(){
        super() ;
    }

    public Oferta(String nombre, String descripcion,LocalDate fechaDeCreacion, LocalDate fechaDeModificacion , String estado, int categoria_id, String usuario_id){

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.estado = estado;
        this.categoria_id = categoria_id;
        this.usuario_id = usuario_id ;


    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
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
