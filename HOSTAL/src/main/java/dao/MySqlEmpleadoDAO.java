package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import beans.EmpleadoDTO;
import interfaces.EmpleadoDAO;
import utils.SqlDBConn;

public class MySqlEmpleadoDAO implements EmpleadoDAO{

	@Override
	public EmpleadoDTO IniciarSesion(String xlogin) {
		EmpleadoDTO em=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			String sql="select * from tb_empleado where log_emp=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, xlogin);
			rs=pstm.executeQuery();
			if(rs.next()) {
				em=new EmpleadoDTO();
				em.setCodigo(rs.getInt(1));
				em.setNombres(rs.getString(2));
				em.setApellidos(rs.getString(3));
				em.setLogin(rs.getString(4));
				em.setPassword(rs.getString(5));
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
