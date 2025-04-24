package misServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EquipoDTO;
import service.EquipoService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletEquipo")
public class ServletEquipo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EquipoService serviEquipo=new EquipoService();
    /**
     * Default constructor. 
     */
    public ServletEquipo() {
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
		}else if(xtipo.equals("buscarEquipo")) {
			buscarEquipo(request,response);
		}
	}

	private void buscarEquipo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String des=request.getParameter("des");
		request.setAttribute("equipos", serviEquipo.buscaEquipo(des));
		request.getRequestDispatcher("buscarEquipo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("data",serviEquipo.listaEquipo());
		request.getRequestDispatcher("listarEquipo.jsp").forward(request, response);
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
        System.out.println("eliminado : "+cod);
        serviEquipo.eliminarEquipo(cod);
		listar(request,response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Equipo",serviEquipo.buscarEquipo(cod));
		request.getRequestDispatcher("actualizarEquipo.jsp").forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int organizacion,cod;
        cod=Integer.parseInt(request.getParameter("txt_cod"));
        String nom=request.getParameter("txt_nom");
        String esp=request.getParameter("txt_especialidad");
        organizacion=Integer.parseInt(request.getParameter("cbo_organizacion"));
	    EquipoDTO obj=new EquipoDTO();
	    obj.setCodigo(cod);
	    obj.setNombre(nom);
	    obj.setEspecialidad(esp);
	    obj.setCodOrganizacion(organizacion);
	    serviEquipo.actualizarEquipo(obj);
	    listar(request,response);
	}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int organizacion;
        String nom=request.getParameter("txt_nom");
        String rol=request.getParameter("txt_especialidad");
        organizacion=Integer.parseInt(request.getParameter("cbo_organizacion"));
        EquipoDTO obj=new EquipoDTO();
        obj.setNombre(nom);
	    obj.setEspecialidad(rol);
	    obj.setCodOrganizacion(organizacion);
	    serviEquipo.registrarEquipo(obj);
	    listar(request,response);
	}
}
