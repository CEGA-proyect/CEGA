package edu.eci.cvds.samples.entities;

import java.time.LocalDate;

public class Categoria {
    private int id ;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private String estado;
    private String valida;
    private LocalDate fechaDeModificacion; 
    public Categoria(){
        super();
    }

     public Categoria(String nombre, String descripcion , LocalDate fechaDeCreacion,LocalDate fechaDeModificacion , String estado, String valida){
        this.nombre = nombre; 
        this.descripcion = descripcion; 
        this.fechaDeCreacion = fechaDeCreacion; 
        this.estado = estado; 
        this.fechaDeModificacion = fechaDeCreacion;
        this.valida = valida;
     }

     public void setDescripcion(String descripcion) {
         this.descripcion = descripcion;
     }
     public String getDescripcion() {
         return descripcion;
     }
     public void setEstado(String estado) {
         this.estado = estado;
     }
     public String getEstado() {
         return estado;
     }
     public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
         this.fechaDeCreacion = fechaDeCreacion;
     }
     public LocalDate getFechaDeCreacion() {
         return fechaDeCreacion;
     }
     public void setFechaDeModificacion(LocalDate fechaDeModificacion) {
         this.fechaDeModificacion = fechaDeModificacion;
     }
     public LocalDate getFechaDeModificacion() {
         return fechaDeModificacion;
     }
     public void setNombre(String nombre) {
         this.nombre = nombre;
     }
     public String getNombre() {
         return nombre;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValida() {
        return valida;
    }

    public void setValida(String valida) {
        this.valida = valida;
    }

}
