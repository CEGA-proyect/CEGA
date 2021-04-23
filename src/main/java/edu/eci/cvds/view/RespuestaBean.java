package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Respuesta;
import edu.eci.cvds.samples.services.ServicioRespuesta;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import java.time.LocalDate;
import java.util.Map;

@ManagedBean(name = "RespuestaBean")
@SessionScoped
public class RespuestaBean extends BasePageBean {
    @Inject
    ServicioRespuesta servicioRespuesta;

    @Inject
    private OfertaBean ofertaBean;

    @Inject
    private NecesidadBean necesidadBean;


    private int id;
    private String nombre;
    private LocalDate fechaDeCreacion;
    private int tipo_id;
    private String tipo = "";
    private String comentario;
    private String message = "";
    Map<String,Integer> listado = null;


    public void crearRespuesta() throws SolidaridadEscuelaException {
        try {
            fechaDeCreacion = LocalDate.now();
            Respuesta respuesta = new Respuesta(nombre,comentario,fechaDeCreacion,tipo,tipo_id);
            servicioRespuesta.crearRespuesta(respuesta);
            message = "respuesta creada";
        } catch (Exception e) {
            message = "Error al crear la Oferta";
            throw new SolidaridadEscuelaException(e.getMessage());
        }
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



    public Map<String, Integer> getListado() throws SolidaridadEscuelaException {
        System.out.println(tipo);
        if(tipo == "Oferta") {
            listado =  ofertaBean.getOfertas();
        }if(tipo == "Necesidad"){
            listado =  necesidadBean.getNecesidades();
        }
        return listado;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setTipo(String tipo) {

        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo_id(int tipo_id) {
        this.tipo_id = tipo_id;
    }

    public int getTipo_id() {
        return tipo_id;
    }

}

