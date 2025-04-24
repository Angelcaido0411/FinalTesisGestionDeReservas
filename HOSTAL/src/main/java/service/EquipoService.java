package service;

import java.util.List;

import beans.EquipoDTO;
import dao.DAOFactory;
import interfaces.EquipoDAO;

public class EquipoService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	EquipoDAO objEqu=fabrica.getEquipo();

	public List<EquipoDTO> listaEquipo(){
		return objEqu.listarEquipo();
	}
	public EquipoDTO buscarEquipo(int cod) {
		return objEqu.buscarEquipo(cod);
	}
	public int registrarEquipo(EquipoDTO obj) {
		return objEqu.registrarEquipo(obj);
	}
	public int actualizarEquipo(EquipoDTO obj) {
		return objEqu.actualizarEquipo(obj);
	}
	public int eliminarEquipo(int cod) {
		return objEqu.eliminarEquipo(cod);
	}
	public List<EquipoDTO> buscaEquipo(String des){
		return objEqu.buscarEquipo(des);
	}
}
