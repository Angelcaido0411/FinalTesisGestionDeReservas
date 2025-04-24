package beans;

public class BeneficiarioDTO {
	private int codigo;
	private String nombre;
	private int edad;
	private String genero;
	private String ubicacion;
	private int codNecesidad;
	private String nomNecesidad;
	
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
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getCodNecesidad() {
		return codNecesidad;
	}
	public void setCodNecesidad(int codNecesidad) {
		this.codNecesidad = codNecesidad;
	}
	public String getNomNecesidad() {
		return nomNecesidad;
	}
	public void setNomNecesidad(String nomNecesidad) {
		this.nomNecesidad = nomNecesidad;
	}
	
}
