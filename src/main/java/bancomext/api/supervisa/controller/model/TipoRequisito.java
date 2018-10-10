package bancomext.api.supervisa.controller.model;

import org.springframework.stereotype.Component;

@Component
public class TipoRequisito {

	private int idTipoRequisito;
	private String clTipoRequisito;
	private String nbTipoRequisito;
	private ClaseIncumplimiento claseIncumplimiento;

	public int getIdTipoRequisito() {
		return idTipoRequisito;
	}

	public void setIdTipoRequisito(int idTipoRequisito) {
		this.idTipoRequisito = idTipoRequisito;
	}

	public String getClTipoRequisito() {
		return clTipoRequisito;
	}

	public void setClTipoRequisito(String clTipoRequisito) {
		this.clTipoRequisito = clTipoRequisito;
	}

	public String getNbTipoRequisito() {
		return nbTipoRequisito;
	}

	public void setNbTipoRequisito(String nbTipoRequisito) {
		this.nbTipoRequisito = nbTipoRequisito;
	}

	public ClaseIncumplimiento getClaseIncumplimiento() {
		return claseIncumplimiento;
	}

	public void setClaseIncumplimiento(ClaseIncumplimiento claseIncumplimiento) {
		this.claseIncumplimiento = claseIncumplimiento;
	}

	@Override
	public String toString() {
		return "TipoRequisito [idTipoRequisito=" + idTipoRequisito + ", clTipoRequisito=" + clTipoRequisito
				+ ", nbTipoRequisito=" + nbTipoRequisito + ", claseIncumplimiento=" + claseIncumplimiento + "]";
	}

}
