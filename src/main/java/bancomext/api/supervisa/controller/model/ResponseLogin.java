package bancomext.api.supervisa.controller.model;

import java.util.Arrays;

public class ResponseLogin {

	private int codigoError;
	private String mensaje;
	private String correoContacto;
	private String razonSocial;
	private int maxDias;
	private String promotor;
	private RequisitoCliente[] requisitos;

	public int getCodigoError() {
		return codigoError;
	}

	public void setCodigoError(int codigoError) {
		this.codigoError = codigoError;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public RequisitoCliente[] getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(RequisitoCliente[] requisitos) {
		this.requisitos = requisitos;
	}

	public int getMaxDias() {
		return maxDias;
	}

	public void setMaxDias(int maxDias) {
		this.maxDias = maxDias;
	}

	public String getCorreoContacto() {
		return correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getPromotor() {
		return promotor;
	}

	public void setPromotor(String promotor) {
		this.promotor = promotor;
	}

	@Override
	public String toString() {
		return "ResponseLogin [codigoError=" + codigoError + ", mensaje=" + mensaje + ", correoContacto="
				+ correoContacto + ", razonSocial=" + razonSocial + ", maxDias=" + maxDias + ", requisitos="
				+ ", promotor=" + promotor
				+ ((requisitos)==null?"0":requisitos.length) + "]";
	}
	
	/*public String toString2() {
		return "ResponseLogin [codigoError=" + codigoError + ", mensaje=" + mensaje + ", correoContacto="
				+ correoContacto + ", razonSocial=" + razonSocial + ", maxDias=" + maxDias + ", requisitos=0"
				+ "]";
	}*/

}
