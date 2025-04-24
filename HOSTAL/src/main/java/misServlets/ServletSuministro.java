package misServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.SuministroDTO;
import service.SuministroService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletSuministro")
public class ServletSuministro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SuministroService serviSuministro=new SuministroService();
    /**
     * Default constructor. 
     */
    public ServletSuministro() {
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
		}else if(xtipo.equals("buscarSuministro")) {
			buscarSuministro(request,response);
		}
	}

	private void buscarSuministro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String des=request.getParameter("des");
		
		// Lógica de búsqueda en el servicio
	    if (des != null && !des.isEmpty()) {
	        request.setAttribute("suministros", serviSuministro.buscaSuministro(des));
	    } else {
	        // Si no hay búsqueda, lista todos los suministros
	        request.setAttribute("suministros", serviSuministro.listaSuministro());
	    }
		request.getRequestDispatcher("buscarSuministro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("data",serviSuministro.listaSuministro());
		request.getRequestDispatcher("listarSuministro.jsp").forward(request, response);
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
        System.out.println("eliminado : "+cod);
		serviSuministro.eliminarSuministro(cod);
		listar(request,response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Suministro",serviSuministro.buscarSuministro(cod));
		request.getRequestDispatcher("actualizarSuministro.jsp").forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stock,cod;
        cod=Integer.parseInt(request.getParameter("txt_cod"));
        String nom=request.getParameter("txt_nom");
        String des=request.getParameter("txt_des");
        stock=Integer.parseInt(request.getParameter("txt_stock"));
	    SuministroDTO obj=new SuministroDTO();
	    obj.setCodigo(cod);
	    obj.setNombre(nom);
	    obj.setDescripcion(des);
	    obj.setStock(stock);
	    serviSuministro.actualizarSuministro(obj);
	    listar(request,response);
	}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int stock;
        String nom=request.getParameter("txt_nom");
        String des=request.getParameter("txt_des");
        stock=Integer.parseInt(request.getParameter("txt_stock"));
        SuministroDTO obj=new SuministroDTO();
	    obj.setNombre(nom);
	    obj.setDescripcion(des);
	    obj.setStock(stock);
	    serviSuministro.registrarSuministro(obj);
	    listar(request,response);
	}
}
