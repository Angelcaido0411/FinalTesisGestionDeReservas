package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import beans.AuditoriaDTO;
import interfaces.AuditoriaDAO;
import utils.SqlDBConn;

public class MySqlAuditoriaDAO implements AuditoriaDAO{

	@Override
	public void registraSesionLogin(AuditoriaDTO audi) {
		// TODO Auto-generated method stub
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			String sql="insert into tb_auditoria values(null,?,?,null,?,null)";
			System.out.println("llego");
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, audi.getCodigoempleado());
			pstm.setString(2, audi.getFechaLogin());
			pstm.setString(3, audi.getUsuario());

			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void registraSesionLogout(AuditoriaDTO audi) {
		// TODO Auto-generated method stub
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			String sql="update tb_auditoria set fechalogout=?,tiempo=? where cod_emp=? and fechalogin=? ";
			System.out.println("llego");
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, audi.getFechaLogout());
			pstm.setString(2, audi.getTiempo());
			pstm.setInt(3, audi.getCodigoempleado());
			pstm.setString(4, audi.getFechaLogin());

			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
