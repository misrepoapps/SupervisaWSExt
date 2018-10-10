package bancomext.api.supervisa.controller.util;

import bancomext.api.supervisa.controller.config.Bancomext;

public class Constantes {


	// Paquetes a escanear dentro del proyecto
	public static final String COMPONENT_SCAN = "bancomext.api.supervisa.controller, bancomext.api.supervisa.cron";

	/* --- Configuración Security/Oauth --- */
	
	public static Modulo MODULO;
    public static String pathConfiguracion;

    public Constantes(String _path) {
        pathConfiguracion = _path;
    }

    public static enum FORMATO_FECHA {
        DD_MM_YYYY, YYYY_MM_DD, DD_MM_YYYY_HH24_MI_SS, YYYY_MM_DD_HH24_MI_SS;
    }

    public static enum ACCION {
        FUERA_DE_LINEA, COMPROBAR_TRANSACCION, SOPORTE_TECNICO, DESCONOCIDO;
    }

	// ###### Credenciales Basic Authentication #####

	public static final String AUTHENTICACION_SAFE_CLIENT = "my-trusted-client";
	public static final String AUTHENTICACION_SAFE_PASSWORD = "my-trusted-password";

	public static final String URL_AUTH_TOKEN = "/oauth/token";
	public static final String URL_AUTH_DENIED = "/access_denied";

	public static final String ROL_ADMIN = "ADMIN";
	public static final String ROL_USER = "USER";

	public static final String ROL_ADMIN_NAME = "gonet";
	public static final String ROL_ADMIN_PASSWORD = "gonet_pwd";

	public static final String ROL_USER_NAME = "leo";
	public static final String ROL_USER_PASSWORD = "abc123";

	public static final int ACCESS_TOKEN_VALIDITY_SECONDS = 120;
	public static final int ACCESS_REFRESH_TOKEN_VALIDITY_SECONDS = 3600;

	// ####### URL de los recursos #######
	
	//login
	//public static final String URL_API_LOGIN = "http://192.168.10.21:7001/DemoSadidBancomext/APIv0.0.1";

	//local tomcat
	//public static final String URL_API_RESOURCES = "http://localhost:8080/APIResourcesSupervisa/v0.0.0";

	// Local weblogic
	//public static final String URL_API_RESOURCES = "http://10.19.5.201:6020/APIResourcesSupervisa";
	public static final String URL_API_RESOURCES = Bancomext.obtenerParametro(Modulo.SUPERVISA_CONTROLLER, "url.recursos");
	
	// desarrollo  weblogic
	//public static final String URL_API_RESOURCES = "http://192.168.10.21:7001/APIResourcesSupervisa/v0.0.0";

	// Desarrollo
	//public static final String URL_API_RESOURCES = "http://172.20.10.9:7001/APIResourcesSupervisa/v0.0.0";

}
