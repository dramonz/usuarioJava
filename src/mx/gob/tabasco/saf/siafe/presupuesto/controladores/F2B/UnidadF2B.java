package mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B;

public class UnidadF2B {

	private Long cve_unidad;
	private Long id;
	private String codigo;
	private String nombre;

	public UnidadF2B() {

	}

	public UnidadF2B(Long cve_unidad, Long id, String codigo, String nombre) {
		this.cve_unidad = cve_unidad;
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;

	}

	public Long getCve_unidad() {
		return cve_unidad;
	}

	public void setCve_unidad(Long cve_unidad) {
		this.cve_unidad = cve_unidad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
