package edu.eci.cvds.guice;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.mybatis.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.impl.*;
import edu.eci.cvds.shiro.Logger;
import edu.eci.cvds.shiro.LoggerShiroImplementation;
import edu.eci.cvds.view.BasePageBean;
import edu.eci.cvds.view.LoginBean;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                //dao
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(CategoriaDAO.class).to(MyBatisCategoriaDAO.class);
                bind(NecesidadDAO.class).to(MyBatisNecesidadDAO.class);
                bind(OfertaDAO.class).to(MyBatisOfertaDAO.class);
                bind(RespuestaDAO.class).to(MyBatisRespuestaDAO.class);
                //logger
                bind(BasePageBean.class).to(LoginBean.class);
                bind(Logger.class).to(LoggerShiroImplementation.class);
                //services 
                bind(ServicioUsuario.class).to(ServicioUsuarioImpl.class);
                bind(ServicioCategoria.class).to(ServicioCategoriaImpl.class);
                bind(ServicioNecesidad.class).to(ServicioNecesidadImpl.class);
                bind(ServicioOferta.class).to(ServicioOfertaImpl.class);
                bind(ServicioRespuesta.class).to(ServicioRespuestaImpl.class);
                
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
        

    }

    
}
