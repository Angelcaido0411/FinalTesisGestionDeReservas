package service;

import java.util.List;

import beans.BeneficiarioDTO;
import dao.DAOFactory;
import interfaces.BeneficiarioDAO;

public class BeneficiarioService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	BeneficiarioDAO objBen=fabrica.getBeneficiario();

	public List<BeneficiarioDTO> listaBeneficiario(){
		return objBen.listarBeneficiario();
	}
	public BeneficiarioDTO buscarBeneficiario(int cod) {
		return objBen.buscarBeneficiario(cod);
	}
	public int registrarBeneficiario(BeneficiarioDTO obj) {
		return objBen.registrarBeneficiario(obj);
	}
	public int actualizarBeneficiario(BeneficiarioDTO obj) {
		return objBen.actualizarBeneficiario(obj);
	}
	public int eliminarBeneficiario(int cod) {
		return objBen.eliminarBeneficiario(cod);
	}
	public List<BeneficiarioDTO> buscaBeneficiario(String des){
		return objBen.buscarBeneficiario(des);
	}
}
