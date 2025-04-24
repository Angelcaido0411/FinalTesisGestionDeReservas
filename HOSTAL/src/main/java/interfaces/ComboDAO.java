package interfaces;

import java.util.ArrayList;

import beans.ComboDTO;

public interface ComboDAO {

	
	public ArrayList<ComboDTO> lista(String sql) throws Exception;
}
