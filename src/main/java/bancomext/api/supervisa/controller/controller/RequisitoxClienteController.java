/*package bancomext.api.supervisa.controller.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bancomext.api.supervisa.controller.model.RequisitoCliente;
import bancomext.api.supervisa.controller.service.RequisitoClienteService;


@RestController
@RequestMapping(value = "/requisitosCliente")
public class RequisitoxClienteController {

	@Autowired
	private RequisitoClienteService service;
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.GET, 
			produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RequisitoCliente>> getRequisitosCliente(@PathVariable("id") long id) {
		List<RequisitoCliente> requisitoscliente = service.consultarRequisitosPorCliente(id);
        if(requisitoscliente.isEmpty()){
            return new ResponseEntity<List<RequisitoCliente>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<RequisitoCliente>>(requisitoscliente, HttpStatus.OK);
    }	


}*/
