package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



import beans.ClienteDTO;
import interfaces.ClienteDAO;
import utils.SqlDBConn;

public class MySqlClienteDAO implements ClienteDAO {

	@Override
	public ArrayList<ClienteDTO> buscarCliente(String ape) {
		ArrayList<ClienteDTO> data=new ArrayList<ClienteDTO>();
		ClienteDTO bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		System.out.println("xd");
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			String sql="select cod_cli,nom_cli,ape_cli,sexo_cli,dni_cli,dir_cli,nom_dis "+
			"from tb_cliente natural join tb_distrito where ape_cli like ? ";
			pstm=cn.prepareStatement(sql);
					pstm.setString(1, (ape+"%"));
					rs=pstm.executeQuery();
					while(rs.next()) {
						bean=new ClienteDTO(rs.getInt(1),rs.getString(2),rs.getString(3),
								rs.getString(4),rs.getInt(5),rs.getString(6),rs.getString(7));
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
				e2.printStackTrace();
			}
			
		}
		return data;
	}
	
	

}
