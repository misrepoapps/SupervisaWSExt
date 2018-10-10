package bancomext.api.supervisa.controller.service;

import java.util.List;

import bancomext.api.supervisa.controller.model.RequisitoCliente;

public interface RequisitoClienteService {
	
	/**
	 * Método encargado de solicitar al servidor de recurso la lista de requisitos con incumplimiento
	 * @param clienteId
	 * @return
	 */
	public List<RequisitoCliente> consultarRequisitosPorCliente(long clienteId); 

}
