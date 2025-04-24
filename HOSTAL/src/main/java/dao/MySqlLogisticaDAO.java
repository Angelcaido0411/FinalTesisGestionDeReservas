package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.LogisticaDTO;
import interfaces.LogisticaDAO;
import utils.SqlDBConn;

public class MySqlLogisticaDAO implements LogisticaDAO {
	@Override
	public LogisticaDTO buscarLogistica(int cod) {
		LogisticaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select * from logistica where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new LogisticaDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setCodSuministro(rs.getInt(2));
				obj.setFechaEnvio(rs.getDate(3));
				obj.setFechaEntrega(rs.getDate(4));
				obj.setCantidad(rs.getInt(5));
				obj.setUbicacionOrigen(rs.getString(6));
				obj.setUbicacionDestino(rs.getString(7));
				obj.setEstado(rs.getString(8));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<LogisticaDTO> listarLogistica() {
		List<LogisticaDTO> data=new ArrayList<LogisticaDTO>();
		LogisticaDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select l.id,s.nombre,l.fecha_envio, l.fecha_entrega,l.cantidad_enviada,l.ubicacion_origen,l.ubicacion_destino,"+
			"l.estado from logistica l inner join suministros s "+
					"on s.id=l.suministro_id";
			System.out.println(sql);
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new LogisticaDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNomSuministro(rs.getString(2));
				obj.setFechaEnvio(rs.getDate(3));
				obj.setFechaEntrega(rs.getDate(4));
				obj.setCantidad(rs.getInt(5));
				obj.setUbicacionOrigen(rs.getString(6));
				obj.setUbicacionDestino(rs.getString(7));
				obj.setEstado(rs.getString(8));
				data.add(obj);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

	@Override
	public int registrarLogistica(LogisticaDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="insert into logistica values(null,?,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, obj.getCodSuministro());
			pstm.setDate(2, obj.getFechaEnvio());
			pstm.setDate(3, obj.getFechaEntrega());
			pstm.setInt(4, obj.getCantidad());
			pstm.setString(5, obj.getUbicacionOrigen());
			pstm.setString(6, obj.getUbicacionDestino());
			pstm.setString(7, obj.getEstado());

			estado=pstm.executeUpdate();
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
		return estado;
		
	}

	@Override
	public int actualizarLogistica(LogisticaDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="update logistica set suministro_id=?,fecha_envio=?,fecha_entrega=?,cantidad_enviada=?,ubicacion_origen=?,ubicacion_destino=?,estado=?"
					+ " where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, obj.getCodSuministro());
			pstm.setDate(2, obj.getFechaEnvio());
			pstm.setDate(3, obj.getFechaEntrega());
			pstm.setInt(4, obj.getCantidad());
			pstm.setString(5, obj.getUbicacionOrigen());
			pstm.setString(6, obj.getUbicacionDestino());
			pstm.setString(7, obj.getEstado());
			pstm.setInt(8, obj.getCodigo());
			estado=pstm.executeUpdate();
			
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
		return estado;
	}

	@Override
	public int eliminarLogistica(int cod) {
	    int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	    try {
	        cn = SqlDBConn.getConnection("gestionayudahumanitaria");
	        
	        // Verifica si el miembros existe
	        String checkSql = "select 1 from logistica where id = ?";
	        pstm = cn.prepareStatement(checkSql);
	        pstm.setInt(1, cod);
	        rs = pstm.executeQuery();
	        
	        if (rs.next()) {
	            // El miembro existe, procede a eliminar
	            pstm.close();
	            String sql = "delete from logistica where id = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            estado = pstm.executeUpdate();
	            
	            if (estado > 0) {
	                System.out.println("Logistica eliminado correctamente");
	            } else {
	                System.out.println("No se pudo eliminar la logistica");
	            }
	        } else {
	            System.out.println("No se encontró una logistica con el código especificado");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstm != null) pstm.close();
	            if (cn != null) cn.close();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	        }
	    }
	    return estado;
	}

	@Override
	public List<LogisticaDTO> buscarLogistica(String des) {
		// TODO Auto-generated method stub
		ArrayList<LogisticaDTO> data=new ArrayList<LogisticaDTO>();
		LogisticaDTO bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select l.id,s.nombre,l.fecha_envio,l.fecha_entrega,l.cantidad_enviada,l.ubicacion_origen,l.ubicacion_destino,l.estado" +
			" from logistica l natural join suministros s where s.nombre like ?";
			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (des+"%"));
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new LogisticaDTO();
				bean.setCodigo(rs.getInt(1));
				bean.setNomSuministro(rs.getString(5));
				bean.setFechaEnvio(rs.getDate(2));
				bean.setFechaEntrega(rs.getDate(3));
				bean.setCantidad(rs.getInt(4));
				bean.setUbicacionOrigen(rs.getString(5));
				bean.setUbicacionDestino(rs.getString(5));
				bean.setEstado(rs.getString(5));
				data.add(bean);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}
}
