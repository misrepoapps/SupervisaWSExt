package bancomext.api.supervisa.controller.model;

import org.springframework.stereotype.Component;

@Component
public class TipoIncumplimiento {

	private int idTipoIncumplimiento;
	private String clTipoIncumplimiento;
	private String nbTipoIncumplimiento;
	private int idFactorAfectacion;

	public int getIdTipoIncumplimiento() {
		return idTipoIncumplimiento;
	}

	public void setIdTipoIncumplimiento(int idTipoIncumplimiento) {
		this.idTipoIncumplimiento = idTipoIncumplimiento;
	}

	public String getClTipoIncumplimiento() {
		return clTipoIncumplimiento;
	}

	public void setClTipoIncumplimiento(String clTipoIncumplimiento) {
		this.clTipoIncumplimiento = clTipoIncumplimiento;
	}

	public String getNbTipoIncumplimiento() {
		return nbTipoIncumplimiento;
	}

	public void setNbTipoIncumplimiento(String nbTipoIncumplimiento) {
		this.nbTipoIncumplimiento = nbTipoIncumplimiento;
	}

	public int getIdFactorAfectacion() {
		return idFactorAfectacion;
	}

	public void setIdFactorAfectacion(int idFactorAfectacion) {
		this.idFactorAfectacion = idFactorAfectacion;
	}

	@Override
	public String toString() {
		return "TipoIncumplimiento [idTipoIncumplimiento=" + idTipoIncumplimiento + ", clTipoIncumplimiento="
				+ clTipoIncumplimiento + ", nbTipoIncumplimiento=" + nbTipoIncumplimiento + ", idFactorAfectacion="
				+ idFactorAfectacion + "]";
	}

}
