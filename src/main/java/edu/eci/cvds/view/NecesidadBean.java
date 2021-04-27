package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Necesidad;
import edu.eci.cvds.samples.services.ServicioCategoria;
import edu.eci.cvds.samples.services.ServicioNecesidad;
import edu.eci.cvds.samples.services.ServicioUsuario;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import edu.eci.cvds.shiro.Logger;
import org.apache.poi.hssf.record.chart.ChartRecord;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFChart;
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
        for (Necesidad n : nece) {
            necesidades.put(n.getNombre(), n.getId());
        }
        return necesidades;
    }

    public void crearExel() throws SolidaridadEscuelaException {
        //crear columnas
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet();
        List<Necesidad> nece = servicioNecesidad.consultarNombresNecesidadGeneral();
        HSSFRow id = hoja.createRow(0);
        HSSFRow categoria = hoja.createRow(1);
        HSSFRow nombre = hoja.createRow(2);
        HSSFRow descripcion = hoja.createRow(3);
        HSSFRow fechadecreacion = hoja.createRow(4);
        HSSFRow estado = hoja.createRow(5);
        HSSFRow fechademodificacion = hoja.createRow(6);
        HSSFRow nombreusuario = hoja.createRow(7);


        for (int i = 0; i <= nece.size(); i++) {
            //crear celdas
            HSSFCell celdaid = id.createCell((short) i);
            HSSFCell celdacategoria = categoria.createCell((short) i);
            HSSFCell celdanombre = nombre.createCell((short) i);
            HSSFCell celdadescripcion = descripcion.createCell((short) i);
            HSSFCell celdafechadecreacion = fechadecreacion.createCell((short) i);
            HSSFCell celdaestado = estado.createCell((short) i);
            HSSFCell celdafechademodificacion = fechademodificacion.createCell((short) i);
            HSSFCell celdanombreusuario = nombreusuario.createCell((short) i);
            if (i == 0) {
                HSSFRichTextString textoid = new HSSFRichTextString("ID : ");
                celdaid.setCellValue(textoid);
                HSSFRichTextString textocategoria = new HSSFRichTextString("CATEGOERIA");
                celdacategoria.setCellValue(textocategoria);
                HSSFRichTextString textodescripcion = new HSSFRichTextString("DESCRIPCION");
                celdadescripcion.setCellValue(textodescripcion);
                HSSFRichTextString textonombre = new HSSFRichTextString("NOMBRE");
                celdanombre.setCellValue(textonombre);
                HSSFRichTextString textofechadecreacion = new HSSFRichTextString("FECHA DE CREACION");
                celdafechadecreacion.setCellValue(textofechadecreacion);
                HSSFRichTextString textoestado = new HSSFRichTextString("ESTADO");
                celdaestado.setCellValue(textoestado);
                HSSFRichTextString textofechademodificacion = new HSSFRichTextString("FECHA DE MODIFICACION");
                celdafechademodificacion.setCellValue(textofechademodificacion);
                HSSFRichTextString textonombreusuario = new HSSFRichTextString("NOMBRE DE USUARIO");
                celdanombreusuario.setCellValue(textonombreusuario);
            } else {
                //llenar celdas
                HSSFRichTextString textoid = new HSSFRichTextString(String.valueOf(nece.get(i - 1).getId()));
                celdaid.setCellValue(textoid);

                HSSFRichTextString textocategoria = new HSSFRichTextString(servicioCategoria.consultarCategoriaPorId(nece.get(i - 1).getCategoria_id()));
                celdacategoria.setCellValue(textocategoria);
                HSSFRichTextString textodescripcion = new HSSFRichTextString(nece.get(i - 1).getDescripcion());
                celdadescripcion.setCellValue(textodescripcion);
                HSSFRichTextString textonombre = new HSSFRichTextString(nece.get(i - 1).getNombre());
                celdanombre.setCellValue(textonombre);
                HSSFRichTextString textofechadecreacion = new HSSFRichTextString(nece.get(i - 1).getFechadecreacion().toString());
                celdafechadecreacion.setCellValue(textofechadecreacion);
                HSSFRichTextString textoestado = new HSSFRichTextString(nece.get(i - 1).getEstado());
                celdaestado.setCellValue(textoestado);
                HSSFRichTextString textofechademodificacion = new HSSFRichTextString(nece.get(i - 1).getFechademodificacion().toString());
                celdafechademodificacion.setCellValue(textofechademodificacion);
                HSSFRichTextString textonombreusuario = new HSSFRichTextString(servicioUsuario.consultarNombreUsuarioPorCorreo(nece.get(i - 1).getUsuario_id()));
                celdanombreusuario.setCellValue(textonombreusuario);
            }
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

