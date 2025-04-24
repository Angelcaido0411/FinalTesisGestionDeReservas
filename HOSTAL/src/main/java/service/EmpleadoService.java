package service;

import beans.EmpleadoDTO;
import dao.DAOFactory;
import interfaces.EmpleadoDAO;

public class EmpleadoService {
DAOFactory fabrica=DAOFactory.getDAOFactory(1);
EmpleadoDAO objEmpDAO=fabrica.getEmpleado();
public EmpleadoDTO IniciarSesion(String login) {
	return objEmpDAO.IniciarSesion(login);
}
}
