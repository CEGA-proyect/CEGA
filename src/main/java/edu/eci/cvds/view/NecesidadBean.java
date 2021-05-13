package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.services.ServicioCategoria;
import edu.eci.cvds.samples.services.ServicioNecesidad;
import edu.eci.cvds.samples.services.ServicioUsuario;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import edu.eci.cvds.shiro.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.model.chart.PieChartModel;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "NecesidadBean")
@SessionScoped
public class NecesidadBean extends BasePageBean {

    private static final long serialVersionUID = -1015621969065584379L;

    @Inject
    private ServicioNecesidad servicioNecesidad;
    @Inject
    private ServicioCategoria servicioCategoria;
    @Inject
    private ServicioUsuario servicioUsuario;
    @Inject
    private Logger logger;

    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion;
    private String estado;
    private LocalDate fechaDeModificacion;
    private String urgencia;
    private String usuario_id = "";
    //private String usuario_id = loginBean.getEmail();
    private int maxNecesidades = 10;

    private String message = "";
    private int categoria_id;

    private Map<String, Integer> necesidades;
    private List<Necesidad> necesidadesObjeto;

    public void comeBack() throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (logger.isAdmin()) {
            facesContext.getExternalContext().redirect("../admin.xhtml");
        }
        if (logger.isStudent()) {
            facesContext.getExternalContext().redirect("../Student.xhtml");
        }
        if (logger.isUser()) {
            facesContext.getExternalContext().redirect("../user.xhtml");
        }
    }

    public void crearNecesidad() throws SolidaridadEscuelaException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
        usuario_id = (String) httpSession.getAttribute("email");

        if (servicioNecesidad.consultarNumeroNecesidadesUsuario(usuario_id) < maxNecesidades) {
            try {
                fechaDeCreacion = LocalDate.now();
                estado = "activo";
                fechaDeModificacion = LocalDate.now();
                Necesidad necesidad = new Necesidad(nombre, descripcion, fechaDeCreacion, fechaDeModificacion, estado, urgencia, categoria_id, usuario_id);
                servicioNecesidad.crearNecesidad(necesidad);
                message = "Necesidad creada";
            } catch (Exception e) {
                message = "Error al crear la Necesidad";
                throw new SolidaridadEscuelaException(e.getMessage());
            }
        } else {
            message = "numero de necesidades creadas excedido";
            System.out.print(message);
        }
    }

    public void actualizarEstadoNecesidad() throws SolidaridadEscuelaException {
        System.out.println(id);
        System.out.println(estado);
        servicioNecesidad.actualizarEstadoNecesidad(id, estado);
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

    public List<Necesidad> consultarNombresNecesidad() throws SolidaridadEscuelaException {
        return servicioNecesidad.consultarNombresNecesidad();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Integer> getNecesidades() throws SolidaridadEscuelaException {
        necesidades = new HashMap<String, Integer>();
        List<Necesidad> nece = servicioNecesidad.consultarNombresNecesidad();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);
        String temp  = (String) httpSession.getAttribute("email");

        for (Necesidad n : nece) {
            if(logger.isAdmin()) {
                necesidades.put(n.getNombre(), n.getId());
            }
            else if(logger.isStudent()){
                if(temp.equals(n.getUsuario_id())){
                    necesidades.put(n.getNombre(), n.getId());
                }
            }
        }
        return necesidades;
    }

    public List<Necesidad> getNecesidadesObjeto() throws SolidaridadEscuelaException{
        return servicioNecesidad.consultarNombresNecesidad();
    }

    public void crearExel() throws SolidaridadEscuelaException {
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet("Necesidades");
        List<Necesidad> nece = servicioNecesidad.consultarNombresNecesidadGeneral();
        int cont = 1 ;
        Row rowi = hoja.createRow(0);
        rowi.createCell(0).setCellValue("ID");
        rowi.createCell(1).setCellValue("CATEGORIA");
        rowi.createCell(2).setCellValue("NOMBRE");
        rowi.createCell(3).setCellValue("DESCRIPCION");
        rowi.createCell(4).setCellValue("FECHA DE CREACION");
        rowi.createCell(5).setCellValue("ESTADO");
        rowi.createCell(6).setCellValue("FECHA DE MODIFICACION");
        rowi.createCell(7).setCellValue("NOMBRE USUARIO");

        for(Necesidad n : nece ){
            Row row  = hoja.createRow(cont++);
            row.createCell(0).setCellValue(n.getId());
            row.createCell(1).setCellValue(servicioCategoria.consultarCategoriaPorId( n.getCategoria_id()));
            row.createCell(2).setCellValue(n.getNombre());
            row.createCell(3).setCellValue(n.getDescripcion());
            row.createCell(4).setCellValue( n.getFechadecreacion().toString());
            row.createCell(5).setCellValue(n.getEstado());
            row.createCell(6).setCellValue( n.getFechademodificacion().toString());
            row.createCell(7).setCellValue(servicioUsuario.consultarNombreUsuarioPorCorreo(n.getUsuario_id()));

        }
        for(int i = 0 ; i<= 7 ; i++ ){
            hoja.autoSizeColumn(i);
        }

        try {
            FileOutputStream elFichero = new FileOutputStream("ResumenNecesidades.xls");
            libro.write(elFichero);
            elFichero.close();


        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    public PieChartModel generarEstadisticaEstado() throws SolidaridadEscuelaException {
        PieChartModel model = new PieChartModel();
        int activo=0, proceso = 0 , resuelta = 0, cerrada = 0 ;

        List<Necesidad> nece = servicioNecesidad.consultarNombresNecesidadGeneral();

        for (Necesidad n : nece) {
            if (n.getEstado().equals("Activa")) {
                activo++;
            }
            else if (n.getEstado().equals("En Proceso")) {
                proceso++;
            }
            else if (n.getEstado().equals("Cerrada")) {
                cerrada++;

            }
            else if (n.getEstado().equals("Resuelta")) {
                resuelta++;


            }
        }


        model.set("Activas",activo);
        model.set("En proceso ", proceso);
        model.set("Resueltas",resuelta);
        model.set("cerradas",cerrada);
        model.setTitle("Estado Necesidades");
        model.setShowDataLabels(true);
        model.setDataLabelFormatString("%dK");
        model.setLegendPosition("e");
        model.setShowDatatip(true);
        model.setShowDataLabels(true);
        model.setDataFormat("value");
        model.setDataLabelFormatString("%d");
        return model;
    }
}

