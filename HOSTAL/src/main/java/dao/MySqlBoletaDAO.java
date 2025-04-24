package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import beans.BoletaDTO;
import beans.DetalleBoletaDTO;
import interfaces.BoletaDAO;
import utils.SqlDBConn;

public class MySqlBoletaDAO implements BoletaDAO{

	@Override
	public int registraBoleta(BoletaDTO boleta, List<DetalleBoletaDTO> lstDetalle) {
		int contador=-1;
		Connection cn=null;
		ResultSet rs=null;
		PreparedStatement pstm1=null,pstm2=null,pstm3=null;
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			
			cn.setAutoCommit(false);
			
			String sql1="select max(num_bol) from tb_boleta";
			pstm1=cn.prepareStatement(sql1);
			rs=pstm1.executeQuery();
			rs.next();
			int numBoleta=rs.getInt(1)+1;
			
			double monto=0;
			for(DetalleBoletaDTO aux: lstDetalle) {
				monto+=aux.getCanProducto()*aux.getPrecio();
			}
			String sql2="insert into tb_boleta values(?,?,?,curdate(),?)";
			pstm2=cn.prepareStatement(sql2);
			pstm2.setInt(1, numBoleta);
			pstm2.setInt(2, boleta.getCodEmpleado());
			pstm2.setInt(3, boleta.getCodCliente());
			pstm2.setDouble(4, monto);
			pstm2.executeUpdate();
			
			String sql3="insert into tb_boleta_has_producto values(?,?,?,?)";
			pstm3=cn.prepareStatement(sql3);
			for(DetalleBoletaDTO aux:lstDetalle) {
				pstm3.setInt(1, numBoleta);
				pstm3.setInt(2, aux.getCodProducto());
				pstm3.setInt(3, aux.getCanProducto());
				pstm3.setDouble(4, aux.getPrecio());
				pstm3.executeUpdate();
			}
			cn.commit();
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
			rs.close();
			pstm1.close();
			pstm2.close();
			pstm3.close();
			cn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contador;
	}

}
