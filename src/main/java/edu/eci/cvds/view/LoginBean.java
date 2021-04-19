package edu.eci.cvds.view;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.google.inject.Inject;

import edu.eci.cvds.samples.services.ServicioUsuario;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
import edu.eci.cvds.shiro.Logger;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends BasePageBean{

    private static final long serialVersionUID = 1L;
    @Inject 
    private Logger logger;

    private String email;
    private String password;
    private Boolean remember;
    private String message;

    public void login() throws IOException, SolidaridadEscuelaException{
        boolean isLogger = logger.isLogged();
        try {
            if(!isLogger){
                message = "Login Correcto";
                logger.login(email, password, false);
                redireccionamiento();
            } else{
                sesionActiva();
            }
        } catch (Exception e) {
            message = "Credenciales incorrectas";
            throw new SolidaridadEscuelaException("Credenciales incorrectas");
        }
    }

    public void redireccionamiento() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        message = "Login correcto";
        if(logger.isAdmin()){
            
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("email", email);
            facesContext.getExternalContext().redirect("../admin.xhtml");
        }
        if(logger.isStudent()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("email", email);
            facesContext.getExternalContext().redirect("../Student.xhtml");
        }
        if(logger.isUser()){
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("email", email);
            facesContext.getExternalContext().redirect("../user.xhtml");
        }
    }

    public void sesionActiva() throws IOException{
        this.message = "El nombre de ususario ya existe ";
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }


    public void logout() throws IOException{
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("../Login.xhtml");
        logger.logout();
    }

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

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public boolean getRemember(){
        return remember;
    }

    public void setRemember(boolean remember){
        this.remember = remember;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, "message"));
    }

}
