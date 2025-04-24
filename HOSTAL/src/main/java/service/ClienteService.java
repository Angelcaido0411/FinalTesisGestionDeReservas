package service;

import dao.DAOFactory;
import interfaces.ClienteDAO;

import java.util.ArrayList;

import beans.ClienteDTO;

public class ClienteService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	ClienteDAO obj=fabrica.getCliente();
	public ArrayList<ClienteDTO>buscarCliente(String ape){
		return obj.buscarCliente(ape);
	}

}
