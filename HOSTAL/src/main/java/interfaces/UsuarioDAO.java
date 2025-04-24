package interfaces;

import beans.UsuarioDTO;

public interface UsuarioDAO {
	public UsuarioDTO IniciarSesion(String login);
}
