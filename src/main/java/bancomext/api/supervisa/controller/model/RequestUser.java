package bancomext.api.supervisa.controller.model;

import org.springframework.stereotype.Component;

@Component
public class RequestUser {

	private String usuario;
	private String token;
	private int device;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getDevice() {
		return device;
	}

	public void setDevice(int device) {
		this.device = device;
	}

	@Override
	public String toString() {
		return "RequestUser [usuario=" + usuario + ", token=" + token + ", device=" + device + "]";
	}

}
