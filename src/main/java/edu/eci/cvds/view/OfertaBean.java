package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.ServicioOferta;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import edu.eci.cvds.shiro.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "OfertaBean")
@SessionScoped
public class OfertaBean extends BasePageBean{
    @Inject
    private ServicioOferta servicioOferta;
    @Inject
    private Logger logger;

    private int categoria_id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private LocalDate fechaDeModificacion;
    private String estado;
    private int id;
    private String message = "";
    private Map<String,Integer> ofertas;
    private List<Oferta> ofertasObjeto ;
    private String usuario_id = "1000950506";
    private int maximoOfertas = 4;

    public OfertaBean() throws SolidaridadEscuelaException {
    }


    public void crearOferta() throws SolidaridadEscuelaException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
        usuario_id = (String) httpSession.getAttribute("email");
        if(servicioOferta.consultarNumeroOfertasUsuario(usuario_id) < maximoOfertas ) {
            try {
                fechaDeCreacion = LocalDate.now();
                estado = "activo";
                fechaDeModificacion = LocalDate.now();
                Oferta oferta = new Oferta(nombre, descripcion, fechaDeCreacion, fechaDeModificacion, estado, categoria_id, usuario_id);
                servicioOferta.crearOferta(oferta);
                message = "Oferta creada";
            } catch (Exception e) {
                message = "Error al crear la Oferta";
                throw new SolidaridadEscuelaException(e.getMessage());
            }
        }else{
            message = "Numero de ofertas creadas exedido";
            System.out.println(message);
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

    public void actulizarEstadoOferta() throws SolidaridadEscuelaException {
        servicioOferta.actualizarEstadoOferta(id,estado);
    }
    public Map<String,Integer> getOfertas() throws  SolidaridadEscuelaException{
        ofertas = new HashMap<String,Integer>();
        List<Oferta> ofe = servicioOferta.consultarNombresOfertas();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
        String temp  = (String) httpSession.getAttribute("email");
        for (Oferta o: ofe) {
            if(logger.isAdmin()) {
                ofertas.put(o.getNombre(), o.getId());
            }
            else{
                if(temp.equals(o.getUsuario_id())){
                    ofertas.put(o.getNombre(), o.getId());
                }
            }
        }
        return ofertas;
    }

    public List<Oferta> getOfertasObjeto() throws SolidaridadEscuelaException{
        return servicioOferta.consultarNombresOfertasGeneral();
    }

    public String consultarNombreOfertaPorId(int num) throws SolidaridadEscuelaException{
        return servicioOferta.consultarNombreOfertaPorId(num);
    }
    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());

        for (Row row : sheet) {
            for (Cell cell : row) {
                cell.setCellValue(cell.getStringCellValue().toUpperCase());
                cell.setCellStyle(style);
            }
        }
    }



}
