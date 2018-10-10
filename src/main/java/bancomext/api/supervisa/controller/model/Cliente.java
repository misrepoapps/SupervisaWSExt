package bancomext.api.supervisa.controller.model;

import org.springframework.stereotype.Component;

@Component
public class Cliente {

	private int idCliente;
	private long id_promotor2;
	private long clCliente;
	private String razonSocial;

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public long getClCliente() {
		return clCliente;
	}

	public void setClCliente(long clCliente) {
		this.clCliente = clCliente;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public long getId_promotor2() {
		return id_promotor2;
	}

	public void setId_promotor2(long id_promotor2) {
		this.id_promotor2 = id_promotor2;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", id_promotor2=" + id_promotor2 + ", clCliente=" + clCliente
				+ ", razonSocial=" + razonSocial + "]";
	}

}
