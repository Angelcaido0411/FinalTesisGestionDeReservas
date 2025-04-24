package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ActividadDTO;
import interfaces.ActividadDAO;
import utils.SqlDBConn;

public class MySqlActividadDAO implements ActividadDAO {
	@Override
	public ActividadDTO buscarActividad(int cod) {
		ActividadDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select * from actividades where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new ActividadDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setFechaInicio(rs.getDate(3));
				obj.setFechaFin(rs.getDate(4));
				obj.setCodEquipo(rs.getInt(5));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<ActividadDTO> listarActividad() {
		List<ActividadDTO> data=new ArrayList<ActividadDTO>();
		ActividadDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select a.id,a.descripcion,a.fecha_inicio, a.fecha_fin,"+
			"e.nombre from actividades a inner join equipos e "+
					"on e.id=a.equipo_id";
			System.out.println(sql);
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new ActividadDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setFechaInicio(rs.getDate(3));
				obj.setFechaFin(rs.getDate(4));
				obj.setNomEquipo(rs.getString(5));
				data.add(obj);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

	@Override
	public int registrarActividad(ActividadDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="insert into actividades values(null,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setDate(2, obj.getFechaInicio());
			pstm.setDate(3, obj.getFechaFin());
			pstm.setInt(4, obj.getCodEquipo());

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
	public int actualizarActividad(ActividadDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="update actividades set descripcion=?,fecha_inicio=?,fecha_fin=?,equipo_id=?"
					+ " where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setDate(2, obj.getFechaInicio());
			pstm.setDate(3, obj.getFechaFin());
			pstm.setInt(4, obj.getCodEquipo());
			pstm.setInt(5, obj.getCodigo());
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
	public int eliminarActividad(int cod) {
	    int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	    try {
	        cn = SqlDBConn.getConnection("gestionayudahumanitaria");
	        
	        // Verifica si el miembros existe
	        String checkSql = "select 1 from actividades where id = ?";
	        pstm = cn.prepareStatement(checkSql);
	        pstm.setInt(1, cod);
	        rs = pstm.executeQuery();
	        
	        if (rs.next()) {
	            // El miembro existe, procede a eliminar
	            pstm.close();
	            String sql = "delete from actividades where id = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            estado = pstm.executeUpdate();
	            
	            if (estado > 0) {
	                System.out.println("Actividad eliminado correctamente");
	            } else {
	                System.out.println("No se pudo eliminar la actividad");
	            }
	        } else {
	            System.out.println("No se encontró una actividad con el código especificado");
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
	public List<ActividadDTO> buscarActividad(String des) {
		// TODO Auto-generated method stub
		ArrayList<ActividadDTO> data=new ArrayList<ActividadDTO>();
		ActividadDTO bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select a.id,a.descripcion,a.fecha_inicio,a.fecha_fin,e.nombre "+
			" from actividades a natural join equipos e where e.nombre like ?";
			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (des+"%"));
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new ActividadDTO();
				bean.setCodigo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setFechaInicio(rs.getDate(3));
				bean.setFechaFin(rs.getDate(4));
				bean.setNomEquipo(rs.getString(5));
				data.add(bean);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}
}
