package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.ServicioOferta;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import edu.eci.cvds.shiro.Logger;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "OfertaBean")
@SessionScoped
public class OfertaBean extends BasePageBean{
    @Inject
    private ServicioOferta servicioOferta;

    private int categoria_id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private LocalDate fechaDeModificacion;
    private String estado;
    private int id;
    private String message = "";
    private Map<String,Integer> ofertas;

    public void crearOferta() throws SolidaridadEscuelaException {
        try {
            fechaDeCreacion = LocalDate.now();
            estado = "activo";
            fechaDeModificacion = LocalDate.now();
            Oferta oferta = new Oferta(nombre,descripcion,fechaDeCreacion,fechaDeModificacion,estado,categoria_id);
            servicioOferta.crearOferta(oferta);
            message = "Oferta creada";
        } catch (Exception e) {
            message = "Error al crear la Oferta";
            throw new SolidaridadEscuelaException(e.getMessage());
        }

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {

        this.categoria_id = categoria_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Oferta> consultarNombresOfertas() throws SolidaridadEscuelaException {
        return servicioOferta.consultarNombresOfertas();
    }
    public Map<String,Integer> getOfertas() throws  SolidaridadEscuelaException{
        ofertas = new HashMap<String,Integer>();
        List<Oferta> ofe = servicioOferta.consultarNombresOfertas();
        for (Oferta o: ofe) {
            ofertas.put(o.getNombre(),o.getId());
        }
        return ofertas;
    }
}
