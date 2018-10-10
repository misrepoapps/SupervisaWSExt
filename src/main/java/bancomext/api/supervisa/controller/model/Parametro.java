package bancomext.api.supervisa.controller.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Parametro{

	private long id_parametro;

	private String nb_parametro;

	private long valor_parametro;

	public long getId_parametro() {
		return id_parametro;
	}

	public void setId_parametro(long id_parametro) {
		this.id_parametro = id_parametro;
	}

	public String getNb_parametro() {
		return nb_parametro;
	}

	public void setNb_parametro(String nb_parametro) {
		this.nb_parametro = nb_parametro;
	}

	public long getValor_parametro() {
		return valor_parametro;
	}

	public void setValor_parametro(long valor_parametro) {
		this.valor_parametro = valor_parametro;
	}

	@Override
	public String toString() {
		return "Parametro [id_parametro=" + id_parametro + ", nb_parametro=" + nb_parametro + ", valor_parametro="
				+ valor_parametro + "]";
	}

}
