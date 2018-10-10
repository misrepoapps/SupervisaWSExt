package bancomext.api.supervisa.controller.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import bancomext.api.supervisa.controller.model.RequisitoCliente;
import bancomext.api.supervisa.controller.util.Constantes;
import bancomext.api.supervisa.controller.util.Log;

@Service("requisitoClienteService")
public class RequisitoClienteServiceImpl implements RequisitoClienteService {
	
	@Autowired
	private Log logger;

	@Override
	public List<RequisitoCliente> consultarRequisitosPorCliente(long clienteId) {

		// Generando cabecero
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		// Generar URL
		String URL = Constantes.URL_API_RESOURCES + "/requisitosCliente/" + clienteId;
		logger.info("Conectando a: "+URL);
		// Generando solicitud con RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<String>(headers);
				
		// Enviar peticion
		ResponseEntity<List> response = restTemplate.exchange(URL, HttpMethod.GET, request, List.class);
		
		logger.debug("Response requisitos: "+response.getBody());
		logger.info("Response requisitos: "+response.getStatusCode());
				
		// validar respuesta
		List<LinkedHashMap<String, RequisitoCliente>> usersMap = (List<LinkedHashMap<String, RequisitoCliente>>) response.getBody();

		if (usersMap != null) {
			ArrayList<RequisitoCliente> list = new ArrayList<RequisitoCliente>();

			for (LinkedHashMap<String, RequisitoCliente> map : usersMap) {

				ObjectMapper mapper = new ObjectMapper();
				RequisitoCliente req = mapper.convertValue(map, RequisitoCliente.class);
				list.add(req);
				
			}
			return list;
		} else {
			return null;
		}

	}

}
