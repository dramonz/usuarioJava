package mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B;

public class RolF2B {
	
	private String rol;
	private String descripcion;
	private Integer activo;
	
	public RolF2B() {
	}

	public RolF2B(String rol, String descripcion, Integer activo) {
		this.rol = rol;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getActivo() {
		return this.activo;
	}
	
	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	
}
