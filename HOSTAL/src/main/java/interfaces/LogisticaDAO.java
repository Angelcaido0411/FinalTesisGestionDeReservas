package interfaces;

import java.util.List;

import beans.LogisticaDTO;

public interface LogisticaDAO {
	public LogisticaDTO buscarLogistica(int cod);
	public List<LogisticaDTO> buscarLogistica(String des);
	public List<LogisticaDTO> listarLogistica();
	public int registrarLogistica(LogisticaDTO obj);
	public int actualizarLogistica(LogisticaDTO obj);
	public int eliminarLogistica(int cod);
}
