package edu.eci.cvds.view;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>(); 

   
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
            categorias.add(categoria); 
        } catch (Exception e) {
            message = "Error al crear la categoria";
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }

    void actualizarDescripcionCategoria(String nombre, String descripcion)throws SolidaridadEscuelaException{
        boolean nombreInvalido = true; 
        for(Categoria c : categorias){
            if(c.getNombre() == nombre){
                c.setFechaDeModificacion(LocalDate.now());
                c.setDescripcion(descripcion);
                nombreInvalido = true; 
            }
        }
        if (nombreInvalido) {
            message = "el nombre de la categoria no existe";
            throw new SolidaridadEscuelaException("el nombre de la categoria no existe");  
        }
    }
    void actualizarEstadoCategoria( String nombre, String estado )throws SolidaridadEscuelaException{
        boolean nombreInvalido = true; 
        for(Categoria c : categorias){
            if(c.getNombre() == nombre){
                c.setFechaDeModificacion(LocalDate.now());
                c.setEstado(estado);
                nombreInvalido = false; 
            }
        }
        if (nombreInvalido) {
            message = "el nombre de la categoria no existe";
            throw new SolidaridadEscuelaException("el nombre de la categoria no existe");  
        }
    } 

    void actualizarNombreCategoria( String nombre, String nombreNuevo )throws SolidaridadEscuelaException{
        boolean nombreInvalido = true , nombreRepetido = false ; 
        for(Categoria c : categorias){
            if(c.getNombre() == nombre){
                for(Categoria f : categorias){
                    if(f.getNombre() == nombreNuevo && f.getNombre() != c.getNombre() ){
                        nombreRepetido = true ;  
                    }
                }
                if(!nombreRepetido){
                    c.setDescripcion(descripcion);
                    nombreInvalido = false; 
                }
            }
        }
        if (nombreInvalido) {
            message = "el nombre de la categoria no existe";
            throw new SolidaridadEscuelaException("el nombre de la categoria no existe");  
        }
    }

    public String generarId(){
        String cadena; 
        int num = categorias.size(); 

        if(num > 9999){
            cadena = Integer.toString(num); 
        }
        else if(num > 999){
            cadena = "0" + Integer.toString(num); 
        }
        else if(num > 99){
            cadena = "00" + Integer.toString(num); 
        }
        else {
            cadena = "000" + Integer.toString(num); 
        } 
        return cadena; 
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

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
}