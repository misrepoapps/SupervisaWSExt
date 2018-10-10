/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancomext.api.supervisa.controller.config;

import java.io.File;
import java.util.Hashtable;
import java.util.Properties;
import java.util.logging.Level;

import org.apache.axis2.context.ConfigurationContext;

import bancomext.api.supervisa.controller.util.Configuracion;
import bancomext.api.supervisa.controller.util.Constantes;
//import bancomext.api.supervisa.controller.util.Logueo;
import bancomext.api.supervisa.controller.util.Modulo;
import bancomext.api.supervisa.controller.util.Utilerias;

/**
 *
 * @author javier
 */
public class Bancomext {
    
  //public static final boolean ENCRIPTADO = true;
  private static final Hashtable<Modulo, Configuracion> hashConfiguraciones = new Hashtable();
  //private static final Hashtable<Modulo, Logueo> hashLogeo = new Hashtable();
  private static final Hashtable<Modulo, Properties> hashMensajes = new Hashtable();
  private static ConfigurationContext contextoSeguro = null;
  
  static {
	  
	 // TODO Auto-generated constructor stub
	  String PATH = System.getProperty("user.home").concat(File.separator).concat("config_supervisa"); 
	  //String PATH = System.getProperty("user.home").concat(File.separator).concat("supervisa_controller_app"); 
	  Bancomext.definirPropertiesDefault(Modulo.SUPERVISA_CONTROLLER, PATH);       
      //Bancomext.logueo(Modulo.SUPERVISA_CONTROLLER, "Path definido: "+PATH, Level.INFO);
  }
  
  public static void definirPropertiesDefault(Modulo _modulo, String _path){
      Constantes.pathConfiguracion = _path;
      Constantes.MODULO = _modulo;
      //Bancomext.logueo(_modulo, "Carpeta de configuiracion definida en: "+_path, Level.INFO);
      //Bancomext.logueo(_modulo, "Modulo default definido en: "+_modulo, Level.INFO);
  }  
  
  public static Properties obtenerConfiguracion(Modulo modulo)
  {
    if (!hashConfiguraciones.containsKey(modulo)) {
      hashConfiguraciones.put(modulo, new Configuracion(modulo));
    }
    return ((Configuracion)hashConfiguraciones.get(modulo)).obtenerConfiguracion(modulo);
  }
  
  public static String obtenerParametro(Modulo modulo, String parametro)
  {
    if (!hashConfiguraciones.containsKey(modulo)) {
      hashConfiguraciones.put(modulo, new Configuracion(modulo));
    }
    return ((Configuracion)hashConfiguraciones.get(modulo)).obtenerParametro(parametro);
  }
  
  /*public static void logueo(Modulo modulo, String mensaje, Level nivel)
  {
    if (!hashLogeo.containsKey(modulo)) {
      hashLogeo.put(modulo, new Logueo(modulo));
    }
    ((Logueo)hashLogeo.get(modulo)).log(mensaje, nivel);
  }
  
  public static void logueoError(Modulo modulo, Error e)
  {
    if (!hashLogeo.containsKey(modulo)) {
      hashLogeo.put(modulo, new Logueo(modulo));
    }
    ((Logueo)hashLogeo.get(modulo)).loguearError(e);
  }
  
  public static void logueoError(Modulo modulo, Exception e)
  {
    if (!hashLogeo.containsKey(modulo)) {
      hashLogeo.put(modulo, new Logueo(modulo));
    }
    ((Logueo)hashLogeo.get(modulo)).logearExcepcion(e);
  }
  
  public static String obtenerMensaje(Modulo modulo, String idMensaje)
  {
    if (!hashMensajes.containsKey(modulo)) {
      hashMensajes.put(modulo, Utilerias.obtenerPropiedadesDesdeArchivo(new File(modulo.obtenerRutaMensajes())));
    }
    return ((Properties)hashMensajes.get(modulo)).getProperty(idMensaje);
  }*/
  
    
}
