package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.NecesidadesDTO;
import interfaces.NecesidadDAO;
import utils.SqlDBConn;

public class MySqlNecesidadDAO implements NecesidadDAO{
	@Override
	public NecesidadesDTO buscarNecesidad(int cod) {
		NecesidadesDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select * from necesidades where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new NecesidadesDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setCantidad(rs.getInt(3));
				obj.setFecha(rs.getDate(4));
				obj.setUbicacion(rs.getString(5));
				obj.setPrioridad(rs.getString(6));
				obj.setEstado(rs.getString(7));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<NecesidadesDTO> listarNecesidad() {
		List<NecesidadesDTO> data=new ArrayList<NecesidadesDTO>();
		NecesidadesDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select * from necesidades";
			System.out.println(sql);
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new NecesidadesDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setCantidad(rs.getInt(3));
				obj.setFecha(rs.getDate(4));
				obj.setUbicacion(rs.getString(5));
				obj.setPrioridad(rs.getString(6));
				obj.setEstado(rs.getString(7));
				data.add(obj);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

	@Override
	public int registrarNecesidad(NecesidadesDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="insert into necesidades values(null,?,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setInt(2, obj.getCantidad());
			pstm.setDate(3, obj.getFecha());
			pstm.setString(4, obj.getUbicacion());
			pstm.setString(5, obj.getPrioridad());
			pstm.setString(6, obj.getEstado());

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
	public int actualizarNecesidad(NecesidadesDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="update necesidades set descripcion=?,cantidad_requerida=?,fecha_registro=?,ubicacion=?,prioridad=?,estado=?"
					+ " where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setInt(2, obj.getCantidad());
			pstm.setDate(3, obj.getFecha());
			pstm.setString(4, obj.getUbicacion());
			pstm.setString(5, obj.getPrioridad());
			pstm.setString(6, obj.getEstado());
			pstm.setInt(7, obj.getCodigo());
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
	public int eliminarNecesidad(int cod) {
	    int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	    try {
	        cn = SqlDBConn.getConnection("gestionayudahumanitaria");
	        
	        // Verifica si el producto existe
	        String checkSql = "select 1 from necesidades where id = ?";
	        pstm = cn.prepareStatement(checkSql);
	        pstm.setInt(1, cod);
	        rs = pstm.executeQuery();
	        
	        if (rs.next()) {
	            // El producto existe, procede a eliminar
	            pstm.close();
	            String sql = "delete from necesidades where id = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            estado = pstm.executeUpdate();
	            
	            if (estado > 0) {
	                System.out.println("Necesidades eliminado correctamente");
	            } else {
	                System.out.println("No se pudo eliminar las necesidades");
	            }
	        } else {
	            System.out.println("No se encontró una necesidad con el código especificado");
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
	public List<NecesidadesDTO> buscarNecesidad(String des) {
		// TODO Auto-generated method stub
		ArrayList<NecesidadesDTO> data=new ArrayList<NecesidadesDTO>();
		NecesidadesDTO bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select * from necesidades where descripcion like ?";
			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (des+"%"));
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new NecesidadesDTO();
				bean.setCodigo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setCantidad(rs.getInt(3));
				bean.setFecha(rs.getDate(4));
				bean.setUbicacion(rs.getString(5));
				bean.setPrioridad(rs.getString(6));
				bean.setEstado(rs.getString(7));
				data.add(bean);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}
}
