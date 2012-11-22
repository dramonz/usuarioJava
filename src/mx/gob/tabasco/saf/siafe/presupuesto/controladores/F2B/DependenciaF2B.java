package mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B;

public class DependenciaF2B {

	private Long cve;
	private String nombreDependencia;
	private Long id;
	private Long cveSector;
	
	public DependenciaF2B() {

	}

	public DependenciaF2B(Long cve, String nombreDependencia, Long id,
			Long cveSector) {
		this.cve = cve;
		this.nombreDependencia = nombreDependencia;
		this.id = id;
		this.cveSector = cveSector;
	}

	public Long getCve() {
		return cve;
	}

	public void setCve(Long cve) {
		this.cve = cve;
	}

	public String getNombreDependencia() {
		return nombreDependencia;
	}

	public void setNombreDependencia(String nombreDependencia) {
		this.nombreDependencia = nombreDependencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCveSector() {
		return cveSector;
	}

	public void setCveSector(Long cveSector) {
		this.cveSector = cveSector;
	}

	
}
