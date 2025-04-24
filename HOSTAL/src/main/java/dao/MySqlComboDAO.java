package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ComboDTO;
import interfaces.ComboDAO;
import utils.SqlDBConn;

public class MySqlComboDAO implements ComboDAO{

	@Override
	public ArrayList<ComboDTO> lista(String sql) throws Exception {
		ArrayList<ComboDTO> data=new ArrayList<ComboDTO>();
		ComboDTO bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new ComboDTO(rs.getInt(1), rs.getString(2));
				data.add(bean);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		
			try {
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
	}
		return data;
	}

}
