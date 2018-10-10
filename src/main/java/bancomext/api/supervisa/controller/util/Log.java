package bancomext.api.supervisa.controller.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({ "file:${user.home}/config_supervisa/supervisa_controller.properties" })
public class Log {

	private static final Logger logger = Logger.getLogger(Log.class.getName());
	public static String version = "1.0.0";
	public static String fechaVersion = "22/05/2018";

	public Log() {
        
		boolean esDebug = false;
        if("${log.debug}".equals("1")) {
        	esDebug = true;
        }

 
        if(esDebug) {
        	logger.setLevel(Level.ALL);
        	info("Log level appSupervisa > DEBUG");
        }else {
        	logger.setLevel(Level.INFO);
        	info("Log level appSupervisa > INFO ");
        }
        
        info("Version appSupervisa: "+version);
        info("Fecha: "+fechaVersion);

	}

	public void info(String _log) {
		logger.info(_log);
	}

	public void debug(String _log) {
		logger.finer(_log);
	}
	
	public void warning(String _log) {
		logger.warning(_log);
	}
	
	public void error(String _log) {
		logger.log(Level.SEVERE, _log);
	}

}
