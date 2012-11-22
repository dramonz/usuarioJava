package mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B;

public class PuestoF2B {

	private Long cve;
	private String nombrePuesto;

	public PuestoF2B() {

	}

	public PuestoF2B(Long cve, String nombrePuesto) {
		super();
		this.cve = cve;
		this.setNombrePuesto(nombrePuesto);
	}

	public void setCve(Long cve) {
		this.cve = cve;
	}

	public Long getCve() {
		return cve;
	}

	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

	public String getNombrePuesto() {
		return nombrePuesto;
	}

}
