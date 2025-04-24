package service;

import java.util.List;

import beans.BoletaDTO;
import beans.DetalleBoletaDTO;
import dao.DAOFactory;
import interfaces.BoletaDAO;

public class BoletaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	BoletaDAO obj=fabrica.getBoleta();
	
	public int registrarBoleta(BoletaDTO boleta,List<DetalleBoletaDTO> lstDetalle) {
		return obj.registraBoleta(boleta, lstDetalle);
	}

}
