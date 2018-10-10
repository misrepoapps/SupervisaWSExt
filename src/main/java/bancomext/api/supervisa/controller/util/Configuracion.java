/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancomext.api.supervisa.controller.util;

import java.io.File;
import java.util.Properties;
import java.util.logging.Level;

import bancomext.api.supervisa.controller.config.Bancomext;


/**
 *
 * @author javier
 */
public class Configuracion {

    private Properties configuracion = null;
    private Modulo modulo;

    public Configuracion(Modulo archivoConfiguracion) {
        this.modulo = archivoConfiguracion;
        this.configuracion = obtenerConfiguracion(archivoConfiguracion);
    }

    public Properties obtenerConfiguracion(Modulo archivoConfiguracion) {
        if (this.configuracion == null) {
            this.configuracion = Utilerias.obtenerPropiedadesDesdeArchivo(new File(Constantes.pathConfiguracion /*+ File.separator + "config"*/ + File.separator + archivoConfiguracion.toString()));
        }
        return this.configuracion;
    }

    public String obtenerParametro(String parametro) {
        if (!this.configuracion.containsKey(parametro)) {
            //Bancomext.logueo(this.modulo, "No se encontro el parametro \"" + parametro + "\" en el archivo de configuración \"" + this.modulo + "\"", Level.WARNING);
        	System.out.println("No se encontro el parametro: "+parametro);
        }
        return this.configuracion.getProperty(parametro);
    }

}
