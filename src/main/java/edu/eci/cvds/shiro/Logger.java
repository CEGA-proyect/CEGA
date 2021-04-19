package edu.eci.cvds.shiro;

import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

public interface Logger {
    
    public void login(String email, String password, boolean remember) throws SolidaridadEscuelaException;
    public void logout();
    public boolean isLogged();
    public boolean isAdmin();
    public boolean isStudent();
    public boolean isUser();
}
