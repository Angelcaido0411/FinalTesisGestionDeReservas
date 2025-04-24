package service;



import beans.AuditoriaDTO;
import dao.DAOFactory;
import interfaces.AuditoriaDAO;

public class AuditoriaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	AuditoriaDAO obj=fabrica.getAuditoria();
	
	public void registrarSesionLogin(AuditoriaDTO audi) {
		obj.registraSesionLogin(audi);
	}
	public void registrarSesionLogout(AuditoriaDTO audi) {
		obj.registraSesionLogout(audi);
	}

}
