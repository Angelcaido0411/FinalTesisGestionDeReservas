package misServlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MiembrosDTO;

import service.MiembroService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletMiembro")
public class ServletMiembro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MiembroService serviMiembro=new MiembroService();
    /**
     * Default constructor. 
     */
    public ServletMiembro() {
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
		}else if(xtipo.equals("buscarMiembro")) {
			buscarMiembro(request,response);
		}
	}

	private void buscarMiembro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String des=request.getParameter("des");
		request.setAttribute("miembros", serviMiembro.buscaMiembro(des));
		request.getRequestDispatcher("buscarMiembro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("data",serviMiembro.listaMiembro());
		request.getRequestDispatcher("listarMiembro.jsp").forward(request, response);
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
        System.out.println("eliminado : "+cod);
		serviMiembro.eliminarMiembro(cod);
		listar(request,response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Miembro",serviMiembro.buscarMiembro(cod));
		request.getRequestDispatcher("actualizarMiembro.jsp").forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int equipo,cod;
        cod=Integer.parseInt(request.getParameter("txt_cod"));
        String nom=request.getParameter("txt_nom");
        String rol=request.getParameter("txt_rol");
        equipo=Integer.parseInt(request.getParameter("cbo_equipo"));
	    MiembrosDTO obj=new MiembrosDTO();
	    obj.setCodigo(cod);
	    obj.setNombre(nom);
	    obj.setRol(rol);
	    obj.setCodEquipo(equipo);
	    serviMiembro.actualizarMiembro(obj);
	    listar(request,response);
	}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int equipo;
        String nom=request.getParameter("txt_nom");
        String rol=request.getParameter("txt_rol");
        equipo=Integer.parseInt(request.getParameter("cbo_equipo"));
        MiembrosDTO obj=new MiembrosDTO();
        obj.setNombre(nom);
	    obj.setRol(rol);
	    obj.setCodEquipo(equipo);
	    serviMiembro.registrarMiembro(obj);
	    listar(request,response);
	}
}
