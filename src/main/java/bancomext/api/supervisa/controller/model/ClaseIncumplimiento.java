package bancomext.api.supervisa.controller.model;

import org.springframework.stereotype.Component;

@Component
public class ClaseIncumplimiento{

	
	private int idClaseIncumplimiento;
	private String clClaseIncumplimiento;
	private String nbClaseIncumplimiento;
	private TipoIncumplimiento tipoIncumplimiento;

	public int getIdClaseIncumplimiento() {
		return idClaseIncumplimiento;
	}

	public void setIdClaseIncumplimiento(int idClaseIncumplimiento) {
		this.idClaseIncumplimiento = idClaseIncumplimiento;
	}

	public String getClClaseIncumplimiento() {
		return clClaseIncumplimiento;
	}

	public void setClClaseIncumplimiento(String clClaseIncumplimiento) {
		this.clClaseIncumplimiento = clClaseIncumplimiento;
	}

	public String getNbClaseIncumplimiento() {
		return nbClaseIncumplimiento;
	}

	public void setNbClaseIncumplimiento(String nbClaseIncumplimiento) {
		this.nbClaseIncumplimiento = nbClaseIncumplimiento;
	}

	public TipoIncumplimiento getTipoIncumplimiento() {
		return tipoIncumplimiento;
	}

	public void setTipoIncumplimiento(TipoIncumplimiento tipoIncumplimiento) {
		this.tipoIncumplimiento = tipoIncumplimiento;
	}

	@Override
	public String toString() {
		return "ClaseIncumplimiento [idClaseIncumplimiento=" + idClaseIncumplimiento + ", clClaseIncumplimiento="
				+ clClaseIncumplimiento + ", nbClaseIncumplimiento=" + nbClaseIncumplimiento + ", tipoIncumplimiento="
				+ tipoIncumplimiento + "]";
	}

}
