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
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import edu.eci.cvds.shiro.Logger;
import edu.eci.cvds.samples.services.ServicioCategoria;

@ManagedBean(name = "CategoriaBean")
@SessionScoped
public class CategoriaBean extends BasePageBean {

    private static final long serialVersionUID = -1015621969065584379L;

    @Inject
    private ServicioCategoria servicioCategoria;
    @Inject
    private Logger logger;  

    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion ;
    private String estado; 
    private LocalDate fechaDeModificacion; 
    private String message = "";
    private Map<String,Integer  > categoria ;

   
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
    public void crearCategoria() throws SolidaridadEscuelaException{
        try {
            fechaDeCreacion = LocalDate.now(); 
            estado = "activo"; 
            fechaDeModificacion = LocalDate.now();
            Categoria categoria = new Categoria(nombre,descripcion,fechaDeCreacion,fechaDeModificacion,estado);
            servicioCategoria.crearCategoria(categoria);
            message = "Categoria creada ";
        } catch (Exception e) {
            message = "Error al crear la categoria";
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }

    public List<Categoria> consultarNombresCategorias() throws SolidaridadEscuelaException{
        return servicioCategoria.consultarNombresCategorias();
    }

    public void actualizarDescripcionCategoria()throws SolidaridadEscuelaException{

        servicioCategoria.actualizarDescripcionCategoria(id,descripcion);
    }
    public void actualizarEstadoCategoria()throws SolidaridadEscuelaException{

        servicioCategoria.actualizarEstadoCategoria( id,estado);
    } 

    public void actualizarNombreCategoria()throws SolidaridadEscuelaException{

        servicioCategoria.actualizarNombreCategoria(id, nombre);

    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public Map<String,Integer> getCategoria() throws  SolidaridadEscuelaException{
        categoria = new HashMap<String,Integer>();
        List<Categoria> cate = servicioCategoria.consultarNombresCategorias();
        for (Categoria c: cate) {
            categoria.put(c.getNombre(),c.getId());
        }
        return categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

}