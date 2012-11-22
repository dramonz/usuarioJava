package mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B;

public class ModuloF2B {
	
	private Long cve;
	private String nombre;
	private String descripcion;
	
	
	public ModuloF2B() {
	}


	public ModuloF2B(Long cve, String nombre, String descripcion) {
		this.cve = cve;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public Long getCve() {
		return cve;
	}


	public void setCve(Long cve) {
		this.cve = cve;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
