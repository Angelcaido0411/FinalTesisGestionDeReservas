package interfaces;


import java.util.List;

import beans.DetalleBoletaDTO;
import beans.BoletaDTO;

public interface BoletaDAO {
	public int registraBoleta(BoletaDTO boleta, List<DetalleBoletaDTO> lstDetalle);
}
