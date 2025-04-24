package service;

import dao.DAOFactory;
import interfaces.MiembroDAO;

import java.util.List;

import beans.MiembrosDTO;

public class MiembroService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	MiembroDAO objMie=fabrica.getMiembros();

	public List<MiembrosDTO> listaMiembro(){
		return objMie.listarMiembro();
	}
	public MiembrosDTO buscarMiembro(int cod) {
		return objMie.buscarMiembro(cod);
	}
	public int registrarMiembro(MiembrosDTO obj) {
		return objMie.registrarMiembro(obj);
	}
	public int actualizarMiembro(MiembrosDTO obj) {
		return objMie.actualizarMiembro(obj);
	}
	public int eliminarMiembro(int cod) {
		return objMie.eliminarMiembro(cod);
	}
	public List<MiembrosDTO> buscaMiembro(String des){
		return objMie.buscarMiembro(des);
	}
}
