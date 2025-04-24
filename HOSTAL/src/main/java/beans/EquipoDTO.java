package beans;

public class EquipoDTO {
	private int codigo;
	private String nombre;
	private String especialidad;
	private int codOrganizacion;
	private String nomOrganizacion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public int getCodOrganizacion() {
		return codOrganizacion;
	}
	public void setCodOrganizacion(int codOrganizacion) {
		this.codOrganizacion = codOrganizacion;
	}
	public String getNomOrganizacion() {
		return nomOrganizacion;
	}
	public void setNomOrganizacion(String nomOrganizacion) {
		this.nomOrganizacion = nomOrganizacion;
	}
}
