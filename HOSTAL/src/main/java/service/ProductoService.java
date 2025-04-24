package service;

import dao.DAOFactory;
import interfaces.ProductoDAO;

import java.util.List;

import beans.ProductoDTO;
public class ProductoService {
DAOFactory fabrica=DAOFactory.getDAOFactory(1);
ProductoDAO objPro=fabrica.getProduto();

public List<ProductoDTO> listaProducto(){
	return objPro.listarProducto();
}
public ProductoDTO buscarProducto(int cod) {
	return objPro.buscarProducto(cod);
}
public int registrarProducto(ProductoDTO obj) {
	return objPro.registrarProducto(obj);
}
public int actualizarProducto(ProductoDTO obj) {
	return objPro.actualizarProducto(obj);
}
public int eliminarProducto(int cod) {
	return objPro.eliminarProducto(cod);
}
public List<ProductoDTO> buscaProducto(String des){
	return objPro.buscarProducto(des);
}
}
