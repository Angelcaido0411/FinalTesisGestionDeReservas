package interfaces;

import java.util.List;

import beans.MiembrosDTO;

public interface MiembroDAO {
	public MiembrosDTO buscarMiembro(int cod);
	public List<MiembrosDTO> buscarMiembro(String des);
	public List<MiembrosDTO> listarMiembro();
	public int registrarMiembro(MiembrosDTO obj);
	public int actualizarMiembro(MiembrosDTO obj);
	public int eliminarMiembro(int cod);
}
