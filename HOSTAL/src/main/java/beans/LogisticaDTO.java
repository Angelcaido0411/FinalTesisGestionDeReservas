package beans;

import java.sql.Date;

public class LogisticaDTO {
	private int codigo;
	private int codSuministro;
	private String nomSuministro;
	private Date fechaEnvio;
	private Date fechaEntrega;
	private int cantidad;
	private String ubicacionOrigen;
	private String ubicacionDestino;
	private String estado;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodSuministro() {
		return codSuministro;
	}
	public void setCodSuministro(int codSuministro) {
		this.codSuministro = codSuministro;
	}
	public String getNomSuministro() {
		return nomSuministro;
	}
	public void setNomSuministro(String nomSuministro) {
		this.nomSuministro = nomSuministro;
	}
	public Date getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getUbicacionOrigen() {
		return ubicacionOrigen;
	}
	public void setUbicacionOrigen(String ubicacionOrigen) {
		this.ubicacionOrigen = ubicacionOrigen;
	}
	public String getUbicacionDestino() {
		return ubicacionDestino;
	}
	public void setUbicacionDestino(String ubicacionDestino) {
		this.ubicacionDestino = ubicacionDestino;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
