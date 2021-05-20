package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.OfertaDAO;
import edu.eci.cvds.samples.entities.Oferta;
import edu.eci.cvds.samples.services.ServicioOferta;
import edu.eci.cvds.samples.services.SolidaridadEscuelaException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class ServicioOfertaImpl implements ServicioOferta{
    InputStream inputStream;
    @Inject
    private OfertaDAO ofertaDAO;

    @Override
    public void crearOferta(Oferta o) throws SolidaridadEscuelaException{
        try {
            ofertaDAO.crearOferta(o);
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }
    @Override
    public List<Oferta> consultarNombresOfertas() throws SolidaridadEscuelaException{
        try {
            return ofertaDAO.consultarNombresOfertas();
        }catch(Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }

    @Override
    public void actualizarEstadoOferta(int id, String estado) throws SolidaridadEscuelaException {
        try{
            ofertaDAO.actualizarEstadoOferta(id,estado);
        }catch(Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }
    @Override
    public int consultarNumeroOfertasUsuario(String usuario_id) throws SolidaridadEscuelaException{
        try{
            return ofertaDAO.consultarNumeroOfertasUsuario(usuario_id);
        }catch (Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());
        }
    }

    public List<Oferta> consultarNombresOfertasGeneral() throws SolidaridadEscuelaException{
        try{
            return ofertaDAO.consultarNombresOfertasGeneral();
        }catch (Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());

        }
    }

    public String consultarNombreOfertaPorId(int num) throws SolidaridadEscuelaException{
        try{
            return ofertaDAO.consultarNombreOfertaPorId(num);
        }catch (Exception e){
            throw new SolidaridadEscuelaException(e.getMessage());

        }
    }

    @Override
    public String ConsultarMaximoOfertasPorUsuario() throws SolidaridadEscuelaException, IOException {
        String result = "";
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new SolidaridadEscuelaException("property file '" + propFileName + "' not found in the classpath");
            }
            result = prop.getProperty("numeromax");
        } catch (Exception e) {
            throw new SolidaridadEscuelaException(e.getMessage());
        } finally {
            inputStream.close();
        }
        return result;
    }


}


