/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package bancomext.api.supervisa.controller.util;

import java.io.File;
import java.io.FileFilter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import bancomext.api.supervisa.controller.config.Bancomext;


public class Logueo {

    private Logger log = null;
    private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss SSS");
    private FileHandler fh;
    private int diaActual;
    private String strCarpetaLog;

    public Logueo(Modulo archivoConfiguracion) {
        try {
            System.out.println("config: " + archivoConfiguracion.toString());
            this.log = Logger.getLogger(archivoConfiguracion.toString());

            File carpetaLog = new File(Constantes.pathConfiguracion + File.separator + "logs App" + File.separator + archivoConfiguracion.obtenerCarpetaLog());

            this.strCarpetaLog = carpetaLog.getAbsolutePath();
            if (!carpetaLog.exists()) {
                carpetaLog.mkdirs();
            }
            initLog();
        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getLocalizedMessage());
            ex.printStackTrace();
        } catch (Error err) {
            System.err.println(err.getClass().getName() + ": " + err.getLocalizedMessage());
            err.printStackTrace();
        }
    }

    private void initLog() {
        try {
            if (this.fh != null) {
                this.log.removeHandler(this.fh);
                this.fh.close();
                this.fh = null;
            }
            this.fh = new FileHandler(this.strCarpetaLog + File.separator + rotarLog() + ".log", true);

            this.fh.setFormatter(new Formatter() {
                public String format(LogRecord record) {
                    StackTraceElement elementoPila = Logueo.obtenerPilaLlamadas();
                    Throwable t = record.getThrown();
                    StringBuilder sb = new StringBuilder(Logueo.this.milisAFecha(record.getMillis()))
                            .append(" : ")
                            .append(record.getLevel())
                            .append(" : ")
                            .append(elementoPila.getClassName())
                            .append(" -:- ")
                            .append(elementoPila.getMethodName())
                            .append(" -:- ")
                            .append(elementoPila.getLineNumber())
                            .append(" -:- ");
                    if (t != null) {
                        sb.append(t.getClass().getCanonicalName()).append(" -.- ").append("línea ").append(elementoPila.getLineNumber()).append(" -.- ").append(t.getLocalizedMessage()).append(" -.- ").append(record.getMessage());
                    }
                    sb.append(record.getMessage());
                    sb.append("\n");

                    return sb.toString();
                }
            });
            this.log.addHandler(this.fh);

            //System.out.println("modulo en constentes: " + Constantes.MODULO.toString());

            try {
                this.log.setLevel(Level.parse(Bancomext.obtenerParametro(Constantes.MODULO, "log.nivel")));
            } catch (Exception e) {
                this.log.setLevel(Level.INFO);
            }

            this.log.config("logs en: " + this.strCarpetaLog);
            this.log.config("IP: " + Utilerias._obtenerIPEquipo() + " - " + Utilerias._obtenerNombreEquipo());
            try {
                this.log.config("nivel de log: " + Bancomext.obtenerParametro(Constantes.MODULO, "log.nivel"));
            } catch (Exception e) {
                this.log.config("nivel de log: " + "INFO");
            }
            this.log.config("versión Utilidades: " + Constantes.APP_VERSION);

            this.log.fine("Depurando logs...");

            File[] files = new File(this.strCarpetaLog).listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return (pathname.exists()) && (pathname.isFile()) && (pathname.length() == 0L);
                }
            });
            File[] arrayOfFile1;
            int j = (arrayOfFile1 = files).length;
            for (int i = 0; i < j; i++) {
                File f = arrayOfFile1[i];

                this.log.finest("Eliminando archivo de log vacío " + f.getCanonicalPath());
                try {
                    f.delete();
                } catch (Exception e) {
                    this.log.severe("Ocurrio una excepción al intentar borrar el archivo de log vacío "
                            + f.getCanonicalPath()
                            + ": "
                            + e.getClass().getCanonicalName()
                            + ", "
                            + e.getLocalizedMessage());
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getLocalizedMessage());
        } catch (Error err) {
            System.err.println(err.getClass().getName() + ": " + err.getLocalizedMessage());
        }
    }

    private String rotarLog() {
        String archivoLog = this.formatoFecha.format(Calendar.getInstance().getTime());
        archivoLog = archivoLog.substring(0, archivoLog.indexOf(" "));
        this.diaActual = Integer.parseInt(archivoLog.substring(0, 2));
        return archivoLog;
    }

    private static StackTraceElement obtenerPilaLlamadas() {
        StackTraceElement[] pila = new Throwable().getStackTrace();
        int c = 0;
        for (int i = 0; i < pila.length; i++) {
            StackTraceElement frame = pila[i];
            if (frame.getClassName().equals("java.util.logging.Logger")) {
                c++;
                if (c == 3) {
                    return pila[(i + 3)];
                }
            }
        }
        return pila[(pila.length - 2)];
    }

    private String milisAFecha(long millis) {
        return this.formatoFecha.format(new Date(millis));
    }

    public void loguearError(Error e) {
        if (this.log.isLoggable(Level.SEVERE)) {

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            this.log.log(Level.SEVERE, exceptionAsString);
        }
    }

    public void logearExcepcion(Exception e) {
        if (this.log.isLoggable(Level.SEVERE)) {

            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            this.log.log(Level.SEVERE, exceptionAsString);
        }
    }

    public void log(String mensaje, Level nivel) {
        if (this.log.isLoggable(nivel)) {
            if (this.diaActual != new Date().getDate()) {
                this.log.info("Rotando log...");
                initLog();
            }
            this.log.log(nivel, mensaje);
        }
    }
}*/
