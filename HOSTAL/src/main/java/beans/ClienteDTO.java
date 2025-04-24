package beans;

public class ClienteDTO {
private int codigo;
private String nombre,apellido,sexo;
private int dni;
private String direccion;
private int codDistrito;
private String nomDistrito;
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
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getSexo() {
	return sexo;
}
public void setSexo(String sexo) {
	this.sexo = sexo;
}
public int getDni() {
	return dni;
}
public void setDni(int dni) {
	this.dni = dni;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public int getCodDistrito() {
	return codDistrito;
}
public void setCodDistrito(int codDistrito) {
	this.codDistrito = codDistrito;
}
public String getNomDistrito() {
	return nomDistrito;
}
public void setNomDistrito(String nomDistrito) {
	this.nomDistrito = nomDistrito;
}
public ClienteDTO(int codigo, String nombre, String apellido, String sexo, int dni, String direccion,
		String nomDistrito) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.apellido = apellido;
	this.sexo = sexo;
	this.dni = dni;
	this.direccion = direccion;
	this.nomDistrito = nomDistrito;
}


}
