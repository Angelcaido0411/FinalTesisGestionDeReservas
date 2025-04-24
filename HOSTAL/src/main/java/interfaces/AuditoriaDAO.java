package interfaces;

import beans.AuditoriaDTO;

public interface AuditoriaDAO {

	public void registraSesionLogin(AuditoriaDTO audi);
	public void registraSesionLogout(AuditoriaDTO audi);
}
