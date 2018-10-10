package bancomext.api.supervisa.controller.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import bancomext.api.supervisa.controller.model.RequestUser;
import bancomext.api.supervisa.controller.model.UsuarioCliente;
import bancomext.api.supervisa.controller.util.Constantes;
import bancomext.api.supervisa.controller.util.Log;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private Log logger;

	@Override
	public UsuarioCliente consultarClienteAsociado(RequestUser login) {
				
		String URL = Constantes.URL_API_RESOURCES + "/usuariosCliente/usuario";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Object> request = new HttpEntity<Object>(login, headers);
		
		logger.info("Conectando a: "+URL);
		
		ResponseEntity<UsuarioCliente> response = restTemplate.exchange(URL,HttpMethod.POST, request, UsuarioCliente.class);
        
		logger.debug("Response login: "+response.getBody());
        logger.info("Response login: "+response.getStatusCode());
				
		return response.getBody();
	}

}
