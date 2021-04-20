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
    public int consultarIdcategoriaPorNombre(String nombre) throws SolidaridadEscuelaException {
        return servicioCategoria.consultarIdcategoriaPorNombre(nombre);
    }

    public List<Categoria> consultarNombresCategorias() throws SolidaridadEscuelaException{
        return servicioCategoria.consultarNombresCategorias();
    }

    public void actualizarDescripcionCategoria(String nombre, String descripcion)throws SolidaridadEscuelaException{
        System.out.print("--------entro a descripcion categoria-------------");
        servicioCategoria.actualizarDescripcionCategoria(nombre,descripcion);
    }
    public void actualizarEstadoCategoria( String nombre, String estado )throws SolidaridadEscuelaException{
        System.out.print("--------entro a estado categoria-------------");
        servicioCategoria.actualizarEstadoCategoria(nombre,estado);
    } 

    public void actualizarNombreCategoria( String nombre, String nombreNuevo )throws SolidaridadEscuelaException{

        servicioCategoria.actualizarNombreCategoria(nombre, nombreNuevo);

    }

    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        System.out.println("------------------puso descripcion" +  descripcion+ "--------------------" );
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
        System.out.println("------------------puso nombre " +  nombre + "--------------------" );
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
}