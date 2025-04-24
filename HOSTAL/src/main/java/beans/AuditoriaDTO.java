package beans;

public class AuditoriaDTO {

	private int idAuditoria;
	private int codigoempleado;
	private String fechaLogin;
	private String fechaLogout;
	private String usuario;
	private String tiempo;
	public int getIdAuditoria() {
		return idAuditoria;
	}
	public void setIdAuditoria(int idAuditoria) {
		this.idAuditoria = idAuditoria;
	}
	public int getCodigoempleado() {
		return codigoempleado;
	}
	public void setCodigoempleado(int codigoempleado) {
		this.codigoempleado = codigoempleado;
	}
	public String getFechaLogin() {
		return fechaLogin;
	}
	public void setFechaLogin(String fechaLogin) {
		this.fechaLogin = fechaLogin;
	}
	public String getFechaLogout() {
		return fechaLogout;
	}
	public void setFechaLogout(String fechaLogout) {
		this.fechaLogout = fechaLogout;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public AuditoriaDTO(int idAuditoria, int codigoempleado, String fechaLogin, String fechaLogout, String usuario,
			String tiempo) {
		super();
		this.idAuditoria = idAuditoria;
		this.codigoempleado = codigoempleado;
		this.fechaLogin = fechaLogin;
		this.fechaLogout = fechaLogout;
		this.usuario = usuario;
		this.tiempo = tiempo;
	}
	
}
