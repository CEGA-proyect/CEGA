package edu.eci.cvds.samples.services;

public class SolidaridadEscuelaException extends Exception{
    private static final long serialVersionUID = -2990163185438398102L;

    public SolidaridadEscuelaException(String message, Exception e) {
        super(message,e);
    }

    public SolidaridadEscuelaException(String message){
        super(message);
    }
    
}
