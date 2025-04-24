package service;

import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;

public class UsuarioService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	UsuarioDAO objUsuDAO=fabrica.getUsuario();
	public UsuarioDTO IniciarSesion(String login) {
		return objUsuDAO.IniciarSesion(login);
	}
}
