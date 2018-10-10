package bancomext.api.supervisa.controller.model;

import org.springframework.stereotype.Component;

@Component
public class UsuarioCliente {

	private long idUsuario;
	private String nbUsuario;
	private String email;
	private String celular;
	private int es_baja;
	private Cliente cliente;
	private String device_token;
	private int device;
	private String nombre;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNbUsuario() {
		return nbUsuario;
	}

	public void setNbUsuario(String nbUsuario) {
		this.nbUsuario = nbUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public int getEs_baja() {
		return es_baja;
	}

	public void setEs_baja(int es_baja) {
		this.es_baja = es_baja;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDevice_token() {
		return device_token;
	}

	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	public int getDevice() {
		return device;
	}

	public void setDevice(int device) {
		this.device = device;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "UsuarioCliente [idUsuario=" + idUsuario + ", nbUsuario=" + nbUsuario + ", email=" + email + ", celular="
				+ celular + ", es_baja=" + es_baja + ", cliente=" + cliente + ", device_token=" + device_token
				+ ", device=" + device + ", nombre=" + nombre + "]";
	}

}
