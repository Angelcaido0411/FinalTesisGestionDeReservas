package service;

import java.util.List;

import beans.LogisticaDTO;
import dao.DAOFactory;
import interfaces.LogisticaDAO;

public class LogisticaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	LogisticaDAO objLog=fabrica.getLogistica();

	public List<LogisticaDTO> listaLogistica(){
		return objLog.listarLogistica();
	}
	public LogisticaDTO buscarLogistica(int cod) {
		return objLog.buscarLogistica(cod);
	}
	public int registrarLogistica(LogisticaDTO obj) {
		return objLog.registrarLogistica(obj);
	}
	public int actualizarLogistica(LogisticaDTO obj) {
		return objLog.actualizarLogistica(obj);
	}
	public int eliminarLogistica(int cod) {
		return objLog.eliminarLogistica(cod);
	}
	public List<LogisticaDTO> buscaLogistica(String des){
		return objLog.buscarLogistica(des);
	}
}
