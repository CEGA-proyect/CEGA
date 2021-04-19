package edu.eci.cvds.guice;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import edu.eci.cvds.sampleprj.dao.CategoriaDAO;
import edu.eci.cvds.sampleprj.dao.NecesidadDAO;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisCategoriaDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisNecesidadDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisUsuarioDAO;
import edu.eci.cvds.samples.services.ServicioCategoria;
import edu.eci.cvds.samples.services.ServicioNecesidad;
import edu.eci.cvds.samples.services.ServicioUsuario;
import edu.eci.cvds.samples.services.impl.ServicioCategoriaImpl;
import edu.eci.cvds.samples.services.impl.ServicioNecesidadImpl;
import edu.eci.cvds.samples.services.impl.ServicioUsuarioImpl;
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
                //logger
                bind(BasePageBean.class).to(LoginBean.class);
                bind(Logger.class).to(LoggerShiroImplementation.class);
                //services 
                bind(ServicioUsuario.class).to(ServicioUsuarioImpl.class);
                bind(ServicioCategoria.class).to(ServicioCategoriaImpl.class);
                bind(ServicioNecesidad.class).to(ServicioNecesidadImpl.class);
                
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
        

    }

    
}
