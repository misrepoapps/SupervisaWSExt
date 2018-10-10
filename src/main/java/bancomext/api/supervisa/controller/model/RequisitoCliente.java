package bancomext.api.supervisa.controller.model;

import org.springframework.stereotype.Component;

@Component
public class RequisitoCliente {

	private int idRequisitoCliente;
	private Cliente cliente;
	private Requisito requisito;
	private String dsRequisito;
	private String obsRequisito;
	private String feVigenciaInicio;
	private String feVigenciaFin;
	private int noOrden;
	private int seEnviaNotificacion;
	private Integer noPeriodoNotifica;
	
	public RequisitoCliente() {
		
	}	

	public int getIdRequisitoCliente() {
		return idRequisitoCliente;
	}

	public void setIdRequisitoCliente(int idRequisitoCliente) {
		this.idRequisitoCliente = idRequisitoCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Requisito getRequisito() {
		return requisito;
	}

	public void setRequisito(Requisito requisito) {
		this.requisito = requisito;
	}

	public String getDsRequisito() {
		return dsRequisito;
	}

	public void setDsRequisito(String dsRequisito) {
		this.dsRequisito = dsRequisito;
	}

	public String getObsRequisito() {
		return obsRequisito;
	}

	public void setObsRequisito(String obsRequisito) {
		this.obsRequisito = obsRequisito;
	}

	public String getFeVigenciaInicio() {
		return feVigenciaInicio;
	}

	public void setFeVigenciaInicio(String feVigenciaInicio) {
		this.feVigenciaInicio = feVigenciaInicio;
	}

	public String getFeVigenciaFin() {
		return feVigenciaFin;
	}

	public void setFeVigenciaFin(String feVigenciaFin) {
		this.feVigenciaFin = feVigenciaFin;
	}

	public int getNoOrden() {
		return noOrden;
	}

	public void setNoOrden(int noOrden) {
		this.noOrden = noOrden;
	}

	public int isSeEnviaNotificacion() {
		return seEnviaNotificacion;
	}

	public void setSeEnviaNotificacion(int seEnviaNotificacion) {
		this.seEnviaNotificacion = seEnviaNotificacion;
	}

	public Integer getNoPeriodoNotifica() {
		return noPeriodoNotifica;
	}

	public void setNoPeriodoNotifica(Integer noPeriodoNotifica) {
		this.noPeriodoNotifica = noPeriodoNotifica;
	}

	@Override
	public String toString() {
		return "RequisitoCliente [idRequisitoCliente=" + idRequisitoCliente + ", cliente=" + cliente + ", requisito="
				+ requisito + ", dsRequisito=" + dsRequisito + ", obsRequisito=" + obsRequisito + ", feVigenciaInicio="
				+ feVigenciaInicio + ", feVigenciaFin=" + feVigenciaFin + ", noOrden=" + noOrden
				+ ", seEnviaNotificacion=" + seEnviaNotificacion + ", noPeriodoNotifica=" + noPeriodoNotifica + "]";
	}

}
