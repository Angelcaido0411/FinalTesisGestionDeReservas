package misServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import service.ProductoService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoService serviProducto=new ProductoService();
    /**
     * Default constructor. 
     */
    public ServletProducto() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String xtipo=request.getParameter("tipo");
		if(xtipo.equals("listar")) {
			listar(request,response);
		}else if(xtipo.equals("buscar")) {
			buscar(request,response);
		}else if(xtipo.equals("registrar")) {
			registrar(request,response);
		}else if(xtipo.equals("actualizar")) {
			actualizar(request,response);
		}else if(xtipo.equals("eliminar")) {
			eliminar(request,response);
		}else if(xtipo.equals("buscarProducto")) {
			buscarProducto(request,response);
		}
	}

	private void buscarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String des=request.getParameter("des");
		System.out.println("xd");
		request.setAttribute("productos", serviProducto.buscaProducto(des));
		request.getRequestDispatcher("buscarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("data",serviProducto.listaProducto());
		request.getRequestDispatcher("listarProducto.jsp").forward(request, response);
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
        System.out.println("eliminado : "+cod);
		serviProducto.eliminarProducto(cod);
		listar(request,response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Producto",serviProducto.buscarProducto(cod));
		request.getRequestDispatcher("actualizarProducto.jsp").forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int marca,stock,cod;
        cod=Integer.parseInt(request.getParameter("txt_cod"));
        String des=request.getParameter("txt_des");
        double pre=Double.parseDouble(request.getParameter("txt_pre"));
        stock=Integer.parseInt(request.getParameter("txt_stock"));
        marca=Integer.parseInt(request.getParameter("cbo_marca"));
	    ProductoDTO obj=new ProductoDTO();
	    obj.setCodigo(cod);
	    obj.setDescripcion(des);
	    obj.setPrecio(pre);
	    obj.setStock(stock);
	    obj.setCodMarca(marca);
	    serviProducto.actualizarProducto(obj);
	    listar(request,response);
	}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int marca,stock;
        String des=request.getParameter("txt_des");
        double pre=Double.parseDouble(request.getParameter("txt_pre"));
        stock=Integer.parseInt(request.getParameter("txt_stock"));
        marca=Integer.parseInt(request.getParameter("cbo_marca"));
        ProductoDTO obj=new ProductoDTO();
	    obj.setDescripcion(des);
	    obj.setPrecio(pre);
	    obj.setStock(stock);
	    obj.setCodMarca(marca);
	    serviProducto.registrarProducto(obj);
	    listar(request,response);
	}
	
	}
