package interfaces;

import java.util.List;

import beans.NecesidadesDTO;

public interface NecesidadDAO {
	public NecesidadesDTO buscarNecesidad(int cod);
	public List<NecesidadesDTO> buscarNecesidad(String nom);
	public List<NecesidadesDTO> listarNecesidad();
	public int registrarNecesidad(NecesidadesDTO obj);
	public int actualizarNecesidad(NecesidadesDTO obj);
	public int eliminarNecesidad(int cod);
}
