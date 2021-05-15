
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
import edu.eci.cvds.samples.services.ServicioNecesidad;
import edu.eci.cvds.samples.services.ServicioOferta;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import edu.eci.cvds.shiro.Logger;
import edu.eci.cvds.samples.services.ServicioCategoria;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name = "CategoriaBean")
@SessionScoped
public class CategoriaBean extends BasePageBean {

    private static final long serialVersionUID = -1015621969065584379L;

    @Inject
    private ServicioCategoria servicioCategoria;
    @Inject
    private ServicioOferta servicioOferta;
    @Inject
    private ServicioNecesidad servicioNecesidad;
    @Inject
    private Logger logger;

    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaDeCreacion ;
    private String estado;
    private LocalDate fechaDeModificacion;
    private String message = "";
    private String valida;
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
            Categoria categoria = new Categoria(nombre,descripcion,fechaDeCreacion,fechaDeModificacion,estado,valida);
            servicioCategoria.crearCategoria(categoria);
            message = "Categoria creada ";
        } catch (SolidaridadEscuelaException e) {
            message = "Error al crear la categoria";
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }

    public List<Categoria> consultarNombresCategorias() throws SolidaridadEscuelaException{
        return servicioCategoria.consultarNombresCategorias();
    }
    public List<Categoria> consultarNombresCategoriasGeneral() throws SolidaridadEscuelaException{
        return servicioCategoria.consultarNombresCategoriasGeneral();
    }

    public void actualizarDescripcionCategoria()throws SolidaridadEscuelaException{

        servicioCategoria.actualizarDescripcionCategoria(id,descripcion);
    }
    public void actualizarEstadoCategoria()throws SolidaridadEscuelaException{

        servicioCategoria.actualizarEstadoCategoria( id,estado);
    }

    public void actualizarNombreCategoria()throws SolidaridadEscuelaException{
        System.out.println("Entro");
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
    public void eliminarCategoria(int categoria) throws SolidaridadEscuelaException {
        servicioCategoria.actualizarEstadoCategoria( categoria,"Inactiva");
    }
    public String consultarCategoriaPorId(int num) throws SolidaridadEscuelaException{
        return servicioCategoria.consultarCategoriaPorId(num);
    }

    public String getValida() {
        return valida;
    }

    public void setValida(String valida) {
        this.valida = valida;
    }

    public PieChartModel generarEstadisticaSolicitud() throws SolidaridadEscuelaException {
        PieChartModel model = new PieChartModel();
        List<Oferta> ofe = servicioOferta.consultarNombresOfertasGeneral();
        List<Necesidad> nece = servicioNecesidad.consultarNombresNecesidadGeneral();
        List<Categoria> cate = servicioCategoria.consultarNombresCategoriasGeneral();
        List<Integer> contadores = new ArrayList<Integer>();
        for(int i = 0 ; i < cate.size(); i++){
            contadores.add(0);
        }
        for(Oferta o : ofe){
            for(int i = 0 ; i < cate.size(); i++){
                if(o.getCategoria_id() == cate.get(i).getId()){
                    contadores.set(i,contadores.get(i)+1);
                }
            }
        }
        for(Necesidad n : nece){
            for(int i = 0 ; i < cate.size(); i++){
                if(n.getCategoria_id() == cate.get(i).getId()){
                    contadores.set(i,contadores.get(i)+1);
                }
            }
        }
        for(int i = 0 ; i < cate.size(); i++) {
            if(contadores.get(i) != 0) {
                model.set(cate.get(i).getNombre(), contadores.get(i));
            }
        }
        model.setTitle("Categorias Mas Solicitadas");
        model.setShowDataLabels(true);
        model.setDataLabelFormatString("%dK");
        model.setLegendPosition("e");
        model.setShowDatatip(true);
        model.setShowDataLabels(true);
        model.setDataFormat("value");
        model.setDataLabelFormatString("%d");
        return model;
    }

    public int ofertasAsociadasCategoria(int id) throws SolidaridadEscuelaException {
        int num  = 0;
        List<Oferta> ofe = servicioOferta.consultarNombresOfertasGeneral();
        for(Oferta o : ofe){
            if(o.getCategoria_id() == id){
                num++;
            }

        }
        return num;
    }
    public int necesidadesAsociadasCategoria(int id) throws SolidaridadEscuelaException {
        int num  = 0;
        List<Necesidad> nece = servicioNecesidad.consultarNombresNecesidadGeneral();
        for(Necesidad n : nece){
            if(n.getCategoria_id() == id){
                num++;
            }
        }
        return num;
    }

    public int totalAsociadasCategoria(int id) throws SolidaridadEscuelaException {
        return necesidadesAsociadasCategoria(id) + ofertasAsociadasCategoria(id);
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

        for(int i = 0 ; i<= 10 ; i++ ){
            sheet.autoSizeColumn(i);
        }
    }




}