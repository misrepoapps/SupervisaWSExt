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
import bancomext.api.supervisa.controller.model.Cliente;
import bancomext.api.supervisa.controller.util.Constantes;
import bancomext.api.supervisa.controller.util.Log;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private Log logger;

	@Override
	public Cliente buscarClientexClave(long clave) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		String URL = Constantes.URL_API_RESOURCES + "/cliente/"+clave;
		logger.info("Conectando a: "+URL);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<Cliente> response = restTemplate.exchange(URL,
				HttpMethod.GET, request, Cliente.class);
		
		logger.debug("Response cliente: "+response.getBody());
		logger.info("Response cliente: "+response.getStatusCode());
		
		return response.getBody();
	}

}
