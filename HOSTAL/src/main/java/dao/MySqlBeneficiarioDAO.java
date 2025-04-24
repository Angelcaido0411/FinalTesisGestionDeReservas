package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.BeneficiarioDTO;
import interfaces.BeneficiarioDAO;
import utils.SqlDBConn;

public class MySqlBeneficiarioDAO implements BeneficiarioDAO {
	@Override
	public BeneficiarioDTO buscarBeneficiario(int cod) {
		BeneficiarioDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select * from beneficiarios where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new BeneficiarioDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setEdad(rs.getInt(3));
				obj.setGenero(rs.getString(4));
				obj.setUbicacion(rs.getString(5));
				obj.setCodNecesidad(rs.getInt(6));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<BeneficiarioDTO> listarBeneficiario() {
		List<BeneficiarioDTO> data=new ArrayList<BeneficiarioDTO>();
		BeneficiarioDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select b.id,b.nombre,b.edad,"+
			"b.genero, b.ubicacion, n.descripcion from beneficiarios b inner join necesidades n "+
					"on n.id=b.necesidad_id";
			System.out.println(sql);
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new BeneficiarioDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setEdad(rs.getInt(3));
				obj.setGenero(rs.getString(4));
				obj.setUbicacion(rs.getString(5));
				obj.setNomNecesidad(rs.getString(6));
				data.add(obj);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

	@Override
	public int registrarBeneficiario(BeneficiarioDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="insert into beneficiarios values(null,?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setInt(2, obj.getEdad());
			pstm.setString(3, obj.getGenero());
			pstm.setString(4, obj.getUbicacion());
			pstm.setInt(5, obj.getCodNecesidad());

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
	public int actualizarBeneficiario(BeneficiarioDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="update beneficiarios set nombre=?,edad=?,genero=?,ubicacion=?,necesidad_id=?"
					+ " where id=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setInt(2, obj.getEdad());
			pstm.setString(3, obj.getGenero());
			pstm.setString(4, obj.getUbicacion());
			pstm.setInt(5, obj.getCodNecesidad());
			pstm.setInt(6, obj.getCodigo());
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
	public int eliminarBeneficiario(int cod) {
	    int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	    try {
	        cn = SqlDBConn.getConnection("gestionayudahumanitaria");
	        
	        // Verifica si el miembros existe
	        String checkSql = "select 1 from beneficiarios where id = ?";
	        pstm = cn.prepareStatement(checkSql);
	        pstm.setInt(1, cod);
	        rs = pstm.executeQuery();
	        
	        if (rs.next()) {
	            // El miembro existe, procede a eliminar
	            pstm.close();
	            String sql = "delete from beneficiarios where id = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            estado = pstm.executeUpdate();
	            
	            if (estado > 0) {
	                System.out.println("Beneficiario eliminado correctamente");
	            } else {
	                System.out.println("No se pudo eliminar el beneficiario");
	            }
	        } else {
	            System.out.println("No se encontró un beneficiario con el código especificado");
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
	public List<BeneficiarioDTO> buscarBeneficiario(String des) {
		// TODO Auto-generated method stub
		ArrayList<BeneficiarioDTO> data=new ArrayList<BeneficiarioDTO>();
		BeneficiarioDTO bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("gestionayudahumanitaria");
			String sql="select b.id,b.nombre,b.edad,b.genero,b.ubicacion,n.descripcion"+
			" from beneficiarios b natural join necesidades n where n.descripcion like ?";
			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (des+"%"));
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new BeneficiarioDTO();
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setEdad(rs.getInt(3));
				bean.setGenero(rs.getString(4));
				bean.setUbicacion(rs.getString(5));
				bean.setNomNecesidad(rs.getString(6));
				data.add(bean);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}
}
