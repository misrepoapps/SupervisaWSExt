package bancomext.api.supervisa.controller.service;

import bancomext.api.supervisa.controller.model.RequestUser;
import bancomext.api.supervisa.controller.model.UsuarioCliente;

public interface LoginService {
	
	public UsuarioCliente consultarClienteAsociado(RequestUser login);

}
