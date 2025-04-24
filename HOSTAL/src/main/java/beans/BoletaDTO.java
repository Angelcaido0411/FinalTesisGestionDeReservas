package beans;

import java.util.Date;

public class BoletaDTO {

	private int numBoleta,codEmpleado,codCliente;
	private Date fecha;
	private double monto;
	public int getNumBoleta() {
		return numBoleta;
	}
	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}
	public int getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(int codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public BoletaDTO(int numBoleta, int codEmpleado, int codCliente, Date fecha, double monto) {
		super();
		this.numBoleta = numBoleta;
		this.codEmpleado = codEmpleado;
		this.codCliente = codCliente;
		this.fecha = fecha;
		this.monto = monto;
	}
	public BoletaDTO() {
		super();
	}
	
	
	
}
