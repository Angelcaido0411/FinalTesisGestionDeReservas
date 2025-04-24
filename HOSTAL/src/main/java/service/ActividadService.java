package service;

import java.util.List;

import beans.ActividadDTO;
import dao.DAOFactory;
import interfaces.ActividadDAO;

public class ActividadService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	ActividadDAO objAct=fabrica.getActividad();

	public List<ActividadDTO> listaActividad(){
		return objAct.listarActividad();
	}
	public ActividadDTO buscarActividad(int cod) {
		return objAct.buscarActividad(cod);
	}
	public int registrarActividad(ActividadDTO obj) {
		return objAct.registrarActividad(obj);
	}
	public int actualizarActividad(ActividadDTO obj) {
		return objAct.actualizarActividad(obj);
	}
	public int eliminarActividad(int cod) {
		return objAct.eliminarActividad(cod);
	}
	public List<ActividadDTO> buscaActividad(String des){
		return objAct.buscarActividad(des);
	}
}
