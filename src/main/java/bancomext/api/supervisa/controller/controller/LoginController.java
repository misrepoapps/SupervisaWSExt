package bancomext.api.supervisa.controller.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import bancomext.api.supervisa.controller.model.Cliente;
import bancomext.api.supervisa.controller.model.Parametro;
import bancomext.api.supervisa.controller.model.RequestLogin;
import bancomext.api.supervisa.controller.model.RequestUser;
import bancomext.api.supervisa.controller.model.RequisitoCliente;
import bancomext.api.supervisa.controller.model.ResponseLogin;
import bancomext.api.supervisa.controller.model.Usuario;
import bancomext.api.supervisa.controller.model.UsuarioCliente;
import bancomext.api.supervisa.controller.service.ClienteService;
import bancomext.api.supervisa.controller.service.LoginService;
import bancomext.api.supervisa.controller.service.ParametroService;
import bancomext.api.supervisa.controller.service.RequisitoClienteService;
import bancomext.api.supervisa.controller.service.UsuarioService;
import bancomext.api.supervisa.controller.util.Log;

@RestController
@RequestMapping//(value = "/login")
public class LoginController {
	
	@Autowired
	private Log logger;

	@Autowired
	private RequisitoClienteService requisitoService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ParametroService parametroService;
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseLogin> getRequisitosCliente(@RequestBody RequestLogin login,
			HttpServletRequest _request, HttpServletResponse _response) {
		
		logger.info("peticion en LoginController con usuario: "+_request.getRemoteUser());

		logger.info("Request Login COntroller: " + login.toString());

		//System.out.println("Servlet response: " + _response.toString());
		
		ResponseLogin response = new ResponseLogin();
		
		String cabeceroUsuario = null;
		
		// PASO 1 -> Validar al usuario contenido en cabecero
		if (_request.getRemoteUser()!=null) {
			cabeceroUsuario = _request.getRemoteUser();
			//System.out.println("usuario en header: " + cabeceroUsuario);

			// Paso 2 -> Buscar el cliente asociado al usuario en SISC
			RequestUser requestUser = new RequestUser();
			requestUser.setDevice(login.getDevice());
			requestUser.setToken(login.getToken());
			requestUser.setUsuario(cabeceroUsuario);
			UsuarioCliente usuario = loginService.consultarClienteAsociado(requestUser);
			if (usuario != null) {

				// Paso 3 -> obtener parametro de dias
				Parametro param = null;
				long maxDias = 0;
				try {
					param = parametroService.getParametroDias();
					maxDias = param.getValor_parametro();
				}catch(Exception e) {
					maxDias = 3;
				}

				// Paso 4 -> CON EL ID DE CLIENTE DE CISC BUSCAR SUS REQUISITOS

				List<RequisitoCliente> requisitoscliente = requisitoService
						.consultarRequisitosPorCliente(usuario.getCliente().getIdCliente());

				if (requisitoscliente == null) {
					response.setCodigoError(1);
					response.setMensaje("No se encontraron requisitos contractuales asociados al cliente");
					//response.setCorreoContacto("asesoria@bancomext.gob.mx");
					response.setRequisitos(null);
					response.setMaxDias((int)maxDias);
					response.setRazonSocial("prueba");
					
					//en caso de no haber requisitos consultar razon social del cliente
					
					Cliente cliente = clienteService.buscarClientexClave(usuario.getCliente().getClCliente());
					if(cliente!=null) {
						response.setRazonSocial(cliente.getRazonSocial());
					}
					
					// Paso 4 -> obtener correo de promotor
					Usuario promotor = null;
					String correo = "";
					try {
						promotor = usuarioService.findById(cliente.getId_promotor2());
						if(promotor.getEmail2()!=null) {
							correo = promotor.getEmail();
						}else {
							correo = "asesoria@bancomext.gob.mx";
						}
					}catch(Exception e) {
						correo = "asesoria@bancomext.gob.mx";
					}
					response.setCorreoContacto(correo);
					try {
						response.setPromotor(promotor.getNb_usuario());
					}catch(Exception e) {
						response.setPromotor(null);
					}
					
					//System.out.println("Respuesta exitosa sin requisitos: ");
				} else {
					response.setCodigoError(0);
					response.setMensaje("Consulta exitosa.");
					//response.setCorreoContacto("asesoria@bancomext.gob.mx");
					response.setRequisitos(requisitoscliente.toArray(new RequisitoCliente[0]));
					response.setMaxDias((int)maxDias);
					response.setRazonSocial(requisitoscliente.get(0).getCliente().getRazonSocial());
					
					// Paso 4 -> obtener correo de promotor
					Usuario promotor = null;
					String correo = "";
					try {
						promotor = usuarioService.findById(requisitoscliente.get(0).getCliente().getId_promotor2());
						if(promotor.getEmail()!=null) {
							correo = promotor.getEmail();
						}else {
							correo = "asesoria@bancomext.gob.mx";
						}
					}catch(Exception e) {
						correo = "asesoria@bancomext.gob.mx";
					}
					response.setCorreoContacto(correo);
					try {
						response.setPromotor(promotor.getNb_usuario());
					}catch(Exception e) {
						response.setPromotor(null);
					}

				}

			} else {
				response.setCodigoError(-1);
				response.setMensaje("Usuario no encontrado");
				response.setCorreoContacto(null);
				response.setPromotor(null);
				response.setRequisitos(null);
				response.setMaxDias(0);
				response.setRazonSocial(null);
				//System.out.println("Respuesta error: "+response.toString());
			}

		}else {
			response.setCodigoError(-1);
			response.setMensaje("Error en solicitud. ");
			response.setCorreoContacto(null);
			response.setPromotor(null);
			response.setRequisitos(null);
			response.setMaxDias(0);
			response.setRazonSocial(null);
		}

		//Bancomext.logueo(Modulo.SUPERVISA_CONTROLLER,
				//"Devolviendo respuesta: " + response.toString(), Level.WARNING);
		//if(response!=null) {
			//if(response.getRequisitos()!=null) {
				logger.debug("Response cliente: "+response.toString());
			//}else {
				//logger.debug("Response cliente: "+response.toString2());
			//}
			logger.info("Response cliente: "+response.getMensaje());
		//}
		return new ResponseEntity<ResponseLogin>(response, HttpStatus.OK);

	}

}
