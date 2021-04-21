package edu.eci.cvds.view;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.services.ServicioCategoria;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import edu.eci.cvds.shiro.Logger;
import edu.eci.cvds.samples.services.ServicioNecesidad;

@ManagedBean(name = "NecesidadBean")
@SessionScoped
public class NecesidadBean extends BasePageBean {

    private static final long serialVersionUID = -1015621969065584379L;

    @Inject
    private ServicioNecesidad servicioNecesidad;
    @Inject
    private ServicioCategoria serviciocategoria;
    @Inject
    private Logger logger;  
    
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion ;
    private String estado; 
    private LocalDate fechaDeModificacion; 
    private String urgencia; 

    private String message = "";
    private int categoria_id;

    public void comeBack() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if(logger.isAdmin()){
            facesContext.getExternalContext().redirect("../admin.xhtml");
        }
        if(logger.isStudent()){
            facesContext.getExternalContext().redirect("../Student.xhtml");
        }
        if(logger.isUser()){
            facesContext.getExternalContext().redirect("../user.xhtml");
        }
    }
    public void crearNecesidad() throws SolidaridadEscuelaException{
        try {
            fechaDeCreacion = LocalDate.now(); 
            estado = "activo"; 
            fechaDeModificacion = LocalDate.now();
            Necesidad necesidad = new Necesidad(nombre,descripcion,fechaDeCreacion,fechaDeModificacion,estado,urgencia,categoria_id);
            servicioNecesidad.crearNecesidad(necesidad);
            message = "Necesidad creada";
        } catch (Exception e) {
            message = "Error al crear la Necesidad";
            throw new SolidaridadEscuelaException(e.getMessage());
        }
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

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
}