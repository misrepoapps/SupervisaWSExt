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
import bancomext.api.supervisa.controller.model.Parametro;
import bancomext.api.supervisa.controller.util.Constantes;
import bancomext.api.supervisa.controller.util.Log;

@Service("parametroService")
public class ParametroServiceImpl implements ParametroService{
	
	@Autowired
	private Log logger;

	@Override
	public Parametro getParametroDias() {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		String URL = Constantes.URL_API_RESOURCES + "/parametro/"+5;
		logger.info("Conectando a: "+URL);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<Parametro> response = restTemplate.exchange(URL,
				HttpMethod.GET, request, Parametro.class);
		logger.debug("Response parametro: "+response.getBody());
		logger.info("Response parametro: "+response.getStatusCode());
		
		return response.getBody();
	}

}
