package bancomext.api.supervisa.controller.model;

public class RequestLogin {

	/*
	 * private String usuario; private String password;
	 */
	private String token;
	private int device;

	/*
	 * public String getUsuario() { return usuario; }
	 * 
	 * public void setUsuario(String usuario) { this.usuario = usuario; }
	 * 
	 * public String getPassword() { return password; }
	 * 
	 * public void setPassword(String password) { this.password = password; }
	 */

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
		return "RequestLogin [token=" + token + ", device=" + device + "]";
	}

}
