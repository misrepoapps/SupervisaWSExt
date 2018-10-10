/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancomext.api.supervisa.controller.util;

import java.io.File;

/**
 *
 * @author javier
 */
public enum Modulo {
    
    SUPERVISA_CONTROLLER("supervisa_controller");
    
    String strVal;

    private Modulo(String _strVal) {
        this.strVal = _strVal;
    }

    public String toString() {
        return this.strVal + ".properties";
    }

    public String obtenerCarpetaLog() {
        return this.strVal;
    }

    public String obtenerRutaMensajes() {
        System.out.println("obteniendo ruta de mensajes");
        String strPath = Constantes.pathConfiguracion;
        //String strPath = System.getProperty("user.dir");
        strPath = strPath + File.separator + "config" + File.separator + this.strVal + "Mensajes.properties";
        System.out.println("ruta de mensajes obtenida: "+strPath);
        return strPath;
    }
}
