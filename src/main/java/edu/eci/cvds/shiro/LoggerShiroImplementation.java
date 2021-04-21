package edu.eci.cvds.shiro;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.subject.Subject;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;
public class LoggerShiroImplementation implements Logger {
    @Override
    public void login(String email, String password, boolean remember) throws SolidaridadEscuelaException{
        try {
           
            Subject subject = SecurityUtils.getSubject();
            //new Sha512Hash(password).toHex()
            UsernamePasswordToken token = new UsernamePasswordToken(email,password);
            //subject.getSession().setAttribute("correo", email);
            subject.login(token);
            System.out.println("-----entro------");
        } catch (UnknownAccountException e) {
            throw new SolidaridadEscuelaException("El usuario no esta registrado ", e);
        } catch (IncorrectCredentialsException e){
            throw new SolidaridadEscuelaException("Contraseña incorrecta", e);
        }
    }
    @Override
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    @Override
    public boolean isAdmin() {
        return SecurityUtils.getSubject().hasRole("admin");
    }

    @Override
    public boolean isUser() {
        return SecurityUtils.getSubject().hasRole("user");
    }

    @Override
    public boolean isStudent() {
        return SecurityUtils.getSubject().hasRole("student");
    }
    
}
