package beans;

public class MiembrosDTO {
	private int codigo;
	private String nombre;
	private String rol;
	private int codEquipo;
	private String nomEquipo;
	
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public int getCodEquipo() {
		return codEquipo;
	}
	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}
	public String getNomEquipo() {
		return nomEquipo;
	}
	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}
}
