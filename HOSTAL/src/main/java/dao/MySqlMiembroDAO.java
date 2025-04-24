package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.MiembrosDTO;
import interfaces.MiembroDAO;
import utils.SqlDBConn;

public class MySqlMiembroDAO implements MiembroDAO {
	@Override
	public MiembrosDTO buscarMiembro(int cod) {
		MiembrosDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select * from miembros where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new MiembrosDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setRol(rs.getString(3));
				obj.setCodEquipo(rs.getInt(4));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<MiembrosDTO> listarMiembro() {
		List<MiembrosDTO> data=new ArrayList<MiembrosDTO>();
		MiembrosDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select m.id,m.nombre,m.rol,"+
			"e.nombre from miembros m inner join equipos e "+
					"on e.id=m.equipo_id";
			System.out.println(sql);
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new MiembrosDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setRol(rs.getString(3));
				obj.setNomEquipo(rs.getString(4));
				data.add(obj);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

	@Override
	public int registrarMiembro(MiembrosDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="insert into miembros values(null,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getRol());
			pstm.setInt(3, obj.getCodEquipo());

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
	public int actualizarMiembro(MiembrosDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="update miembros set nombre=?,rol=?,equipo_id=?"
					+ " where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getRol());
			pstm.setInt(3, obj.getCodEquipo());
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
	public int eliminarMiembro(int cod) {
	    int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	    try {
	        cn = SqlDBConn.getConnection("gestionayudahumanitaria");
	        
	        // Verifica si el miembros existe
	        String checkSql = "select 1 from miembros where id = ?";
	        pstm = cn.prepareStatement(checkSql);
	        pstm.setInt(1, cod);
	        rs = pstm.executeQuery();
	        
	        if (rs.next()) {
	            // El miembro existe, procede a eliminar
	            pstm.close();
	            String sql = "delete from miembros where id = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            estado = pstm.executeUpdate();
	            
	            if (estado > 0) {
	                System.out.println("Miembro eliminado correctamente");
	            } else {
	                System.out.println("No se pudo eliminar el miembro");
	            }
	        } else {
	            System.out.println("No se encontró un miembro con el código especificado");
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
	public List<MiembrosDTO> buscarMiembro(String des) {
		// TODO Auto-generated method stub
		ArrayList<MiembrosDTO> data=new ArrayList<MiembrosDTO>();
		MiembrosDTO bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select m.id,m.nombre,m.rol,e.nombre "+
			" from miembros m natural join equipos e where m.nombre like ?";
			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (des+"%"));
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new MiembrosDTO();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setRol(rs.getString(3));
				bean.setNomEquipo(rs.getString(4));
				data.add(bean);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}
}
