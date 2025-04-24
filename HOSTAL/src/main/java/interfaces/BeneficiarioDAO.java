package interfaces;

import java.util.List;

import beans.BeneficiarioDTO;

public interface BeneficiarioDAO {
	public BeneficiarioDTO buscarBeneficiario(int cod);
	public List<BeneficiarioDTO> buscarBeneficiario(String des);
	public List<BeneficiarioDTO> listarBeneficiario();
	public int registrarBeneficiario(BeneficiarioDTO obj);
	public int actualizarBeneficiario(BeneficiarioDTO obj);
	public int eliminarBeneficiario(int cod);
}
