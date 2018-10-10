package bancomext.api.supervisa.controller.model;

import org.springframework.stereotype.Component;

@Component
public class Requisito {

	private int idRequisito;
	private TipoRequisito tipoRequisito;
	private String clRequisito;
	private String nbRequisito;
	private int no_orden;
	private int ponderacion;

	public int getIdRequisito() {
		return idRequisito;
	}

	public void setIdRequisito(int idRequisito) {
		this.idRequisito = idRequisito;
	}

	public TipoRequisito getTipoRequisito() {
		return tipoRequisito;
	}

	public void setTipoRequisito(TipoRequisito tipoRequisito) {
		this.tipoRequisito = tipoRequisito;
	}

	public String getClRequisito() {
		return clRequisito;
	}

	public void setClRequisito(String clRequisito) {
		this.clRequisito = clRequisito;
	}

	public String getNbRequisito() {
		return nbRequisito;
	}

	public void setNbRequisito(String nbRequisito) {
		this.nbRequisito = nbRequisito;
	}

	public int getNo_orden() {
		return no_orden;
	}

	public void setNo_orden(int no_orden) {
		this.no_orden = no_orden;
	}

	public int getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(int ponderacion) {
		this.ponderacion = ponderacion;
	}

	@Override
	public String toString() {
		return "Requisito [idRequisito=" + idRequisito + ", tipoRequisito=" + tipoRequisito.toString()
				+ ", clRequisito=" + clRequisito + ", nbRequisito=" + nbRequisito + ", no_orden=" + no_orden
				+ ", ponderacion=" + ponderacion + "]";
	}

}
