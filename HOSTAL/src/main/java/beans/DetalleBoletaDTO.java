package beans;

public class DetalleBoletaDTO {
private int numBoleta,codProducto,canProducto;
private double precio;
public int getNumBoleta() {
	return numBoleta;
}
public void setNumBoleta(int numBoleta) {
	this.numBoleta = numBoleta;
}
public int getCodProducto() {
	return codProducto;
}
public void setCodProducto(int codProducto) {
	this.codProducto = codProducto;
}
public int getCanProducto() {
	return canProducto;
}
public void setCanProducto(int canProducto) {
	this.canProducto = canProducto;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}
public DetalleBoletaDTO(int numBoleta, int codProducto, int canProducto, double precio) {
	super();
	this.numBoleta = numBoleta;
	this.codProducto = codProducto;
	this.canProducto = canProducto;
	this.precio = precio;
}


}
