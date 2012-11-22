package mx.gob.tabasco.saf.siafe.presupuesto.controladores.F2B;

public class EmpleadoF2B {

	private Long cve;
	private String nombre;
	private String puesto;
	private String area;
	private String correoElectronico;
	private String unidad;
	private int cveUnidad;
	private int idUnidad;
	private int cvePuesto;
	private int cveArea;
	private int activo;
	private Long cveJefe;

	public EmpleadoF2B() {

	}

	public EmpleadoF2B(Long cve, String puesto, String area, String unidad,
			String nombre, String correoElectronico, int cveUnidad,
			int idUnidad, int cveArea, int cvePuesto,Long cveJefe) {
		super();
		this.cve = cve;
		this.puesto = puesto;
		this.area = area;
		this.unidad = unidad;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.cveUnidad = cveUnidad;
		this.idUnidad = idUnidad;
		this.cveArea = cveArea;
		this.cvePuesto = cvePuesto;
		this.cveJefe = cveJefe;
	}
	
//	public EmpleadoF2B(Long cve, String puesto, String area, String unidad,
//			String nombre, String correoElectronico, int cveUnidad,
//			int idUnidad, int cveArea, int cvePuesto, Long cveJefe) {
//		super();
//		this.cve = cve;
//		this.puesto = puesto;
//		this.area = area;
//		this.unidad = unidad;
//		this.nombre = nombre;
//		this.correoElectronico = correoElectronico;
//		this.cveUnidad = cveUnidad;
//		this.idUnidad = idUnidad;
//		this.cveArea = cveArea;
//		this.cvePuesto = cvePuesto;
//		this.cveJefe = cveJefe;
//	}

	public Long getCve() {
		return cve;
	}

	public void setCve(Long cve) {
		this.cve = cve;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public int getCveUnidad() {
		return cveUnidad;
	}

	public void setCveUnidad(int cveUnidad) {
		this.cveUnidad = cveUnidad;
	}

	public int getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(int idUnidad) {
		this.idUnidad = idUnidad;
	}

	public void setCveArea(int cveArea) {
		this.cveArea = cveArea;
	}

	public int getCveArea() {
		return cveArea;
	}

	public void setCvePuesto(int cvePuesto) {
		this.cvePuesto = cvePuesto;
	}

	public int getCvePuesto() {
		return cvePuesto;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}
	public int getActivo() {
		return activo;
	}

	public Long getCveJefe() {
		return cveJefe;
	}

	public void setCveJefe(Long cveJefe) {
		this.cveJefe = cveJefe;
	} 
	 

}