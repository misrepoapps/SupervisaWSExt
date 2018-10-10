/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancomext.api.supervisa.controller.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.util.Properties;
import java.util.logging.Level;

import bancomext.api.supervisa.controller.config.Bancomext;


/**
 *
 * @author javier
 */
public class Utilerias {
    
    //loading
    
    public Utilerias(){
    }

    public static String obtenerPropiedadDesdeRecurso(String recurso, String propiedad) {
        String str = null;
        if (obtenerPropiedadesDesdeRecurso(recurso) != null) {
            str = obtenerPropiedadesDesdeRecurso(recurso).getProperty(propiedad);
        }
        return str;
    }

    public static Properties obtenerPropiedadesDesdeRecurso(String recurso) {
        Properties properties = null;
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(recurso);
            if (is == null) {
                throw new NullPointerException(recurso + " (No se puede encontrar el recurso especificado)");
            }
            properties = obtenerPropiedadesDesdeInputStream(is);
        } catch (Exception e) {
            //Bancomext.logueoError(Constantes.MODULO, e);
        } catch (Error err) {
            //Bancomext.logueo(Constantes.MODULO, err.getClass().getName() + ", " + err.getLocalizedMessage(), Level.SEVERE);
        }
        return properties;
    }

    public static Properties obtenerPropiedadesDesdeArchivo(File file) {
        Properties properties = null;
        try {

            properties = obtenerPropiedadesDesdeInputStream(new FileInputStream(file));

        } catch (Exception e) {
            //Bancomext.logueo(Constantes.MODULO, "Ocurrio un error al obtener las propiedades del archivo " + file, Level.SEVERE);
            //Bancomext.logueoError(Constantes.MODULO, e);
        } catch (Error err) {
            //Bancomext.logueo(Constantes.MODULO, "Ocurrio un error al obtener las propiedades del archivo " + file, Level.SEVERE);
            //Bancomext.logueoError(Constantes.MODULO, err);
        }
        return properties;
    }

    public static Properties obtenerPropiedadesDesdeInputStream(InputStream is)
            throws IOException {
        Properties props = new Properties();
        props.load(is);
        is.close();
        return props;
    }

    public static String _obtenerIPEquipo() {
        String ip = "";
        try {
            ip = Inet4Address.getLocalHost().getHostAddress();
        } catch (Exception e) {
            //Bancomext.logueo(Constantes.MODULO, "Ocurrio una excepción al tratar de obtener la ip del equipo: " + e.getClass().getName() + ", " + e.getLocalizedMessage(), Level.SEVERE);
            e.printStackTrace();
        } catch (Error err) {
            //Bancomext.logueo(Constantes.MODULO, "Ocurrio un error al tratar de obtener la ip del equipo: " + err.getClass().getName() + ", " + err.getLocalizedMessage(), Level.SEVERE);
            err.printStackTrace();
        }
        return ip;
    }

    public static String _obtenerNombreEquipo() {
        String nombre = "";
        try {
            nombre = Inet4Address.getLocalHost().getCanonicalHostName();
            System.out.println("ip: " + nombre);
        } catch (Exception e) {
            //Bancomext.logueo(Constantes.MODULO, "Ocurrio una excepcion al tratar de obtener la ip del equipo: " + e.getClass().getName() + ", " + e.getLocalizedMessage(), Level.SEVERE);
            e.printStackTrace();
        } catch (Error err) {
            //Bancomext.logueo(Constantes.MODULO, "Ocurrio un error al tratar de obtener la ip del equipo: " + err.getClass().getName() + ", " + err.getLocalizedMessage(), Level.SEVERE);
            err.printStackTrace();
        }
        return nombre;
    }


}
