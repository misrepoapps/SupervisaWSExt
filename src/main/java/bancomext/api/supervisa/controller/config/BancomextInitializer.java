/*package bancomext.api.supervisa.controller.config;

import java.io.File;
import java.util.logging.Level;

import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import bancomext.api.supervisa.controller.util.Constantes;
import bancomext.api.supervisa.controller.util.Modulo;

public class BancomextInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
    	//produccion
        String PATH = System.getProperty("user.home").concat(File.separator).concat("supervisa_controller_app"); 
        //

        Bancomext.definirPropertiesDefault(Modulo.SUPERVISA_CONTROLLER, PATH);       
        Bancomext.logueo(Modulo.SUPERVISA_CONTROLLER, "Path definido: "+PATH, Level.INFO);
        return new Class[] { BancomextConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/"+Constantes.APP_VERSION+"/*" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
    	Filter [] singleton = { new BancomextCORSFilter()};
    	return singleton;
    }
 
}*/