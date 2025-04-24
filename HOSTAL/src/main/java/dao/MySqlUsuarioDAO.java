package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.SqlDBConn;

public class MySqlUsuarioDAO implements UsuarioDAO{
	@Override
	public UsuarioDTO IniciarSesion(String xlogin) {
		UsuarioDTO em=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select * from usuarios where username=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, xlogin);
			rs=pstm.executeQuery();
			if(rs.next()) {
				em=new UsuarioDTO();
				em.setCodigo(rs.getInt(1));
				em.setLogin(rs.getString(2));
				em.setPassword(rs.getString(3));
				em.setNombres(rs.getString(4));
				em.setEmail(rs.getString(5));
				em.setRol(rs.getString(6));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
				
			}catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return em;
	}

}
