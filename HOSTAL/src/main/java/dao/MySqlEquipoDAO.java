package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.EquipoDTO;
import interfaces.EquipoDAO;
import utils.SqlDBConn;

public class MySqlEquipoDAO implements EquipoDAO {
	@Override
	public EquipoDTO buscarEquipo(int cod) {
		EquipoDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select * from equipos where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new EquipoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setEspecialidad(rs.getString(3));
				obj.setCodOrganizacion(rs.getInt(4));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<EquipoDTO> listarEquipo() {
		List<EquipoDTO> data=new ArrayList<EquipoDTO>();
		EquipoDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select e.id,e.nombre,e.especialidad,"+
			"o.nombre from equipos e inner join organizaciones o "+
					"on o.id=e.organizacion_id";
			System.out.println(sql);
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new EquipoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setEspecialidad(rs.getString(3));
				obj.setNomOrganizacion(rs.getString(4));
				data.add(obj);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

	@Override
	public int registrarEquipo(EquipoDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="insert into equipos values(null,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getEspecialidad());
			pstm.setInt(3, obj.getCodOrganizacion());

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
	public int actualizarEquipo(EquipoDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="update equipos set nombre=?,especialidad=?,organizacion_id=?"
					+ " where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getEspecialidad());
			pstm.setInt(3, obj.getCodOrganizacion());
			pstm.setInt(4, obj.getCodigo());
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
	public int eliminarEquipo(int cod) {
	    int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	    try {
	        cn = SqlDBConn.getConnection("gestionayudahumanitaria");
	        
	        // Verifica si el miembros existe
	        String checkSql = "select 1 from equipos where id = ?";
	        pstm = cn.prepareStatement(checkSql);
	        pstm.setInt(1, cod);
	        rs = pstm.executeQuery();
	        
	        if (rs.next()) {
	            // El miembro existe, procede a eliminar
	            pstm.close();
	            String sql = "delete from equipos where id = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            estado = pstm.executeUpdate();
	            
	            if (estado > 0) {
	                System.out.println("Equipo eliminado correctamente");
	            } else {
	                System.out.println("No se pudo eliminar el equipo");
	            }
	        } else {
	            System.out.println("No se encontró un equipo con el código especificado");
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
	public List<EquipoDTO> buscarEquipo(String des) {
		// TODO Auto-generated method stub
		ArrayList<EquipoDTO> data=new ArrayList<EquipoDTO>();
		EquipoDTO bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select e.id,e.nombre,e.especialidad,o.nombre "+
			" from equipos e natural join organizaciones o where e.nombre like ?";
			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (des+"%"));
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new EquipoDTO();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setEspecialidad(rs.getString(3));
				bean.setNomOrganizacion(rs.getString(4));
				data.add(bean);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}
}
