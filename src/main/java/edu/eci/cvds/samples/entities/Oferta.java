package edu.eci.cvds.samples.entities;

import java.time.LocalDate;

public class Oferta {
    private int categoria_id;
    private  String nombre;
    private  String descripcion;
    private LocalDate fechadecreacion;
    private LocalDate fechademodificacion;
    private String estado;
    private int id;
    private String usuario_id;


    public Oferta(){
        super() ;
    }

    public Oferta(String nombre, String descripcion,LocalDate fechadecreacion, LocalDate fechademodificacion , String estado, int categoria_id, String usuario_id){

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechadecreacion = fechadecreacion;
        this.fechademodificacion = fechademodificacion;
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

    public LocalDate getFechadecreacion() {
        return fechadecreacion;
    }

    public void setFechadecreacion(LocalDate fechadecreacion) {
        this.fechadecreacion = fechadecreacion;
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

    public LocalDate getFechademodificacion() {
        return fechademodificacion;
    }

    public void setFechademodificacion(LocalDate fechademodificacion) {
        this.fechademodificacion = fechademodificacion;
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
