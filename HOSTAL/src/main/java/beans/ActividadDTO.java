package beans;

import java.sql.Date;

public class ActividadDTO {
	private int codigo;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private int codEquipo;
	private String nomEquipo;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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
