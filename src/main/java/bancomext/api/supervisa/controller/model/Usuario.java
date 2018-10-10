package bancomext.api.supervisa.controller.model;

import org.springframework.stereotype.Component;

@Component
public class Usuario {

	private int id_usuario;
	private String cl_tipo_usuario;
	private String cl_usuario;
	private String nb_usuario;
	private long no_empleado;
	private String nb_corto_usuario;
	private String email;
	private String email2;
	private long es_baja;

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCl_tipo_usuario() {
		return cl_tipo_usuario;
	}

	public void setCl_tipo_usuario(String cl_tipo_usuario) {
		this.cl_tipo_usuario = cl_tipo_usuario;
	}

	public String getCl_usuario() {
		return cl_usuario;
	}

	public void setCl_usuario(String cl_usuario) {
		this.cl_usuario = cl_usuario;
	}

	public String getNb_usuario() {
		return nb_usuario;
	}

	public void setNb_usuario(String nb_usuario) {
		this.nb_usuario = nb_usuario;
	}

	public long getNo_empleado() {
		return no_empleado;
	}

	public void setNo_empleado(long no_empleado) {
		this.no_empleado = no_empleado;
	}

	public String getNb_corto_usuario() {
		return nb_corto_usuario;
	}

	public void setNb_corto_usuario(String nb_corto_usuario) {
		this.nb_corto_usuario = nb_corto_usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public long getEs_baja() {
		return es_baja;
	}

	public void setEs_baja(long es_baja) {
		this.es_baja = es_baja;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", cl_tipo_usuario=" + cl_tipo_usuario + ", cl_usuario="
				+ cl_usuario + ", nb_usuario=" + nb_usuario + ", no_empleado=" + no_empleado + ", nb_corto_usuario="
				+ nb_corto_usuario + ", email=" + email + ", email2=" + email2 + ", es_baja=" + es_baja + "]";
	}

}
