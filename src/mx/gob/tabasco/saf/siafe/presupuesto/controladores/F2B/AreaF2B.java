package mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B;

public class AreaF2B {

	private Long cve;
	private String nombreArea;

	public AreaF2B(Long cve, String nombreArea) {
		this.cve = cve;
		this.nombreArea = nombreArea;
	}

	public AreaF2B() {
	}

	public Long getCve() {
		return cve;
	}

	public void setCve(Long cve) {
		this.cve = cve;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

}
