package interfaces;

import java.util.List;

import beans.SuministroDTO;

public interface SuministroDAO {
	public SuministroDTO buscarSuministro(int cod);
	public List<SuministroDTO> buscarSuministro(String nom);
	public List<SuministroDTO> listarSuministro();
	public int registrarSuministro(SuministroDTO obj);
	public int actualizarSuministro(SuministroDTO obj);
	public int eliminarSuministro(int cod);
}
