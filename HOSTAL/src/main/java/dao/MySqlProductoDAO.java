package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.SqlDBConn;

public class MySqlProductoDAO implements ProductoDAO {

	@Override
	public ProductoDTO buscarProducto(int cod) {
		ProductoDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			String sql="select * from tb_producto where cod_pro=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			rs=pstm.executeQuery();
			if(rs.next()) {
				obj=new ProductoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setPrecio(rs.getDouble(3));
				obj.setStock(rs.getInt(4));
				obj.setCodMarca(rs.getInt(5));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public List<ProductoDTO> listarProducto() {
		List<ProductoDTO> data=new ArrayList<ProductoDTO>();
		ProductoDTO obj=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			String sql="select p.cod_pro,p.des_pro,pre_pro,p.stock_act_pro,"+
			"m.nom_mar from tb_producto p inner join tb_marca m "+
					"on p.cod_mar=m.cod_mar";
			System.out.println(sql);
			pstm=cn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				obj=new ProductoDTO();
				obj.setCodigo(rs.getInt(1));
				obj.setDescripcion(rs.getString(2));
				obj.setPrecio(rs.getDouble(3));
				obj.setStock(rs.getInt(4));
				obj.setNomMarca(rs.getString(5));
				data.add(obj);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

	@Override
	public int registrarProducto(ProductoDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			String sql="insert into tb_producto values(null,?,?,?,?)";
			System.out.println("llego");
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setDouble(2, obj.getPrecio());
			pstm.setInt(3, obj.getStock());
			pstm.setInt(4, obj.getCodMarca());

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
	public int actualizarProducto(ProductoDTO obj) {
		int estado=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			String sql="update tb_producto set des_pro=?,pre_pro=?,stock_act_pro=?,cod_mar=?"
					+ " where cod_pro=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setDouble(2, obj.getPrecio());
			pstm.setInt(3, obj.getStock());
			pstm.setInt(4, obj.getCodMarca());
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
	public int eliminarProducto(int cod) {
	    int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	    try {
	        cn = SqlDBConn.getConnection("bd_consorcio");
	        
	        // Verifica si el producto existe
	        String checkSql = "select 1 from tb_producto where cod_pro = ?";
	        pstm = cn.prepareStatement(checkSql);
	        pstm.setInt(1, cod);
	        rs = pstm.executeQuery();
	        
	        if (rs.next()) {
	            // El producto existe, procede a eliminar
	            pstm.close();
	            String sql = "delete from tb_producto where cod_pro = ?";
	            pstm = cn.prepareStatement(sql);
	            pstm.setInt(1, cod);
	            estado = pstm.executeUpdate();
	            
	            if (estado > 0) {
	                System.out.println("Producto eliminado correctamente");
	            } else {
	                System.out.println("No se pudo eliminar el producto");
	            }
	        } else {
	            System.out.println("No se encontró un producto con el código especificado");
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
	public List<ProductoDTO> buscarProducto(String des) {
		// TODO Auto-generated method stub
		ArrayList<ProductoDTO> data=new ArrayList<ProductoDTO>();
		ProductoDTO bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try {
			cn=SqlDBConn.getConnection("bd_consorcio");
			String sql="select cod_pro,des_pro,pre_pro,stock_act_pro,nom_mar "+
			" from tb_producto natural join tb_marca where des_pro like ?";
			
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, (des+"%"));
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new ProductoDTO();
				bean.setCodigo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setPrecio(rs.getDouble(3));
				bean.setStock(rs.getInt(4));
				bean.setNomMarca(rs.getString(5));
				data.add(bean);
				
			}
	}catch (Exception e) {
		e.printStackTrace();
	}
		return data;
	}

}
