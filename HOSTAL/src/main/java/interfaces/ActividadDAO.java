package interfaces;

import java.util.List;

import beans.ActividadDTO;

public interface ActividadDAO {
	public ActividadDTO buscarActividad(int cod);
	public List<ActividadDTO> buscarActividad(String des);
	public List<ActividadDTO> listarActividad();
	public int registrarActividad(ActividadDTO obj);
	public int actualizarActividad(ActividadDTO obj);
	public int eliminarActividad(int cod);
}
