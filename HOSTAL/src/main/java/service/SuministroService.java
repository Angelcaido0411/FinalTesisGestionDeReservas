package service;

import java.util.List;

import beans.SuministroDTO;
import dao.DAOFactory;
import interfaces.SuministroDAO;

public class SuministroService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	SuministroDAO objSum=fabrica.getSuministro();

	public List<SuministroDTO> listaSuministro(){
		return objSum.listarSuministro();
	}
	public SuministroDTO buscarSuministro(int cod) {
		return objSum.buscarSuministro(cod);
	}
	public int registrarSuministro(SuministroDTO obj) {
		return objSum.registrarSuministro(obj);
	}
	public int actualizarSuministro(SuministroDTO obj) {
		return objSum.actualizarSuministro(obj);
	}
	public int eliminarSuministro(int cod) {
		return objSum.eliminarSuministro(cod);
	}
	public List<SuministroDTO> buscaSuministro(String des){
		return objSum.buscarSuministro(des);
	}
}
