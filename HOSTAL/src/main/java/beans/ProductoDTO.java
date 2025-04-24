package beans;

public class ProductoDTO {

	private int codigo;
	private String descripcion;
	private double precio;
	private int stock;
	private int codMarca;
	private String nomMarca;
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCodMarca() {
		return codMarca;
	}
	public void setCodMarca(int codMarca) {
		this.codMarca = codMarca;
	}
	public String getNomMarca() {
		return nomMarca;
	}
	public void setNomMarca(String nomMarca) {
		this.nomMarca = nomMarca;
	}
	
	
}
