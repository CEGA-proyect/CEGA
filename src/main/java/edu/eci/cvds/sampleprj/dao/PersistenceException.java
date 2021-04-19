package edu.eci.cvds.sampleprj.dao;

public class PersistenceException extends Exception{
    private static final long serialVersionUID = 1L;
    public PersistenceException(String mensaje, Exception e) {
        super(mensaje,e);
    }
    public PersistenceException(String mensaje){
        super(mensaje);
    }
}