package dao;

import interfaces.ActividadDAO;
import interfaces.AuditoriaDAO;
import interfaces.BeneficiarioDAO;
import interfaces.BoletaDAO;
import interfaces.ClienteDAO;
import interfaces.ComboDAO;
import interfaces.EmpleadoDAO;
import interfaces.EquipoDAO;
import interfaces.LogisticaDAO;
import interfaces.ProductoDAO;
import interfaces.SuministroDAO;
import interfaces.UsuarioDAO;
import interfaces.MiembroDAO;
import interfaces.NecesidadDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public ProductoDAO getProduto() {
		// TODO Auto-generated method stub
		return new MySqlProductoDAO();
	}

	@Override
	public EmpleadoDAO getEmpleado() {
		// TODO Auto-generated method stub
		return new MySqlEmpleadoDAO();
	}

	@Override
	public ComboDAO getCombo() {
		// TODO Auto-generated method stub
		return new MySqlComboDAO();
	}

	@Override
	public ClienteDAO getCliente() {
		// TODO Auto-generated method stub
		return new MySqlClienteDAO();
	}

	@Override
	public BoletaDAO getBoleta() {
		// TODO Auto-generated method stub
		return new MySqlBoletaDAO();
	}

	@Override
	public AuditoriaDAO getAuditoria() {
		// TODO Auto-generated method stub
		return new MySqlAuditoriaDAO();
	}

	@Override
	public UsuarioDAO getUsuario() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public SuministroDAO getSuministro() {
		// TODO Auto-generated method stub
		return new MySqlSuministroDAO();
	}

	@Override
	public MiembroDAO getMiembros() {
		// TODO Auto-generated method stub
		return new MySqlMiembroDAO();
	}

	@Override
	public EquipoDAO getEquipo() {
		// TODO Auto-generated method stub
		return new MySqlEquipoDAO();
	}

	@Override
	public ActividadDAO getActividad() {
		// TODO Auto-generated method stub
		return new MySqlActividadDAO();
	}

	@Override
	public LogisticaDAO getLogistica() {
		// TODO Auto-generated method stub
		return new MySqlLogisticaDAO();
	}

	@Override
	public NecesidadDAO getNecesidad() {
		// TODO Auto-generated method stub
		return new MySqlNecesidadDAO();
	}

	@Override
	public BeneficiarioDAO getBeneficiario() {
		// TODO Auto-generated method stub
		return new MySqlBeneficiarioDAO();
	}

}
