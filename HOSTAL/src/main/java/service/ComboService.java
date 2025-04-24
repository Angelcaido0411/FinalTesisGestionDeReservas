package service;

import dao.DAOFactory;
import interfaces.ComboDAO;

import java.util.ArrayList;

import beans.ComboDTO;

public class ComboService {

	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	ComboDAO obj=fabrica.getCombo();
	public ArrayList<ComboDTO> listar(String sql) throws Exception{
		return obj.lista(sql);
	}
}
