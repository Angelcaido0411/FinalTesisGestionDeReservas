package interfaces;

import java.util.List;

import beans.EquipoDTO;

public interface EquipoDAO {
	public EquipoDTO buscarEquipo(int cod);
	public List<EquipoDTO> buscarEquipo(String des);
	public List<EquipoDTO> listarEquipo();
	public int registrarEquipo(EquipoDTO obj);
	public int actualizarEquipo(EquipoDTO obj);
	public int eliminarEquipo(int cod);
}
