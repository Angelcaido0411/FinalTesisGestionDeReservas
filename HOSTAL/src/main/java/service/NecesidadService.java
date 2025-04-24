package service;

import java.util.List;

import beans.NecesidadesDTO;
import dao.DAOFactory;
import interfaces.NecesidadDAO;

public class NecesidadService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	NecesidadDAO objNec=fabrica.getNecesidad();

	public List<NecesidadesDTO> listaNecesidad(){
		return objNec.listarNecesidad();
	}
	public NecesidadesDTO buscarNecesidad(int cod) {
		return objNec.buscarNecesidad(cod);
	}
	public int registrarNecesidad(NecesidadesDTO obj) {
		return objNec.registrarNecesidad(obj);
	}
	public int actualizarNecesidad(NecesidadesDTO obj) {
		return objNec.actualizarNecesidad(obj);
	}
	public int eliminarNecesidad(int cod) {
		return objNec.eliminarNecesidad(cod);
	}
	public List<NecesidadesDTO> buscaNecesidad(String des){
		return objNec.buscarNecesidad(des);
	}
}
