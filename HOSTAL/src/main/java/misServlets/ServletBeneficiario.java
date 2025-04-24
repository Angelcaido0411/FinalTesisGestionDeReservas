package misServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeneficiarioDTO;
import service.BeneficiarioService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletBeneficiario")
public class ServletBeneficiario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BeneficiarioService serviBeneficiario=new BeneficiarioService();
    /**
     * Default constructor. 
     */
    public ServletBeneficiario() {
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
		}else if(xtipo.equals("buscarBeneficiario")) {
			buscarBeneficiario(request,response);
		}
	}

	private void buscarBeneficiario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String des=request.getParameter("des");
		request.setAttribute("beneficiarios", serviBeneficiario.buscaBeneficiario(des));
		request.getRequestDispatcher("buscarBeneficiario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("data",serviBeneficiario.listaBeneficiario());
		request.getRequestDispatcher("listarBeneficiario.jsp").forward(request, response);
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
        System.out.println("eliminado : "+cod);
        serviBeneficiario.eliminarBeneficiario(cod);
		listar(request,response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Beneficiario",serviBeneficiario.buscarBeneficiario(cod));
		request.getRequestDispatcher("actualizarBeneficiario.jsp").forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int necesidad,cod, edad;
        cod=Integer.parseInt(request.getParameter("txt_cod"));
        String nom=request.getParameter("txt_nom");
        edad=Integer.parseInt(request.getParameter("txt_edad"));
        String genero=request.getParameter("txt_genero");
        String ubicacion=request.getParameter("txt_ubicacion");
        necesidad=Integer.parseInt(request.getParameter("cbo_necesidad"));
	    BeneficiarioDTO obj=new BeneficiarioDTO();
	    obj.setCodigo(cod);
	    obj.setNombre(nom);
	    obj.setEdad(edad);
	    obj.setGenero(genero);
	    obj.setUbicacion(ubicacion);
	    obj.setCodNecesidad(necesidad);
	    serviBeneficiario.actualizarBeneficiario(obj);
	    listar(request,response);
	}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int necesidad, edad;
        String nom=request.getParameter("txt_nom");
        edad=Integer.parseInt(request.getParameter("txt_edad"));
        String genero=request.getParameter("txt_genero");
        String ubicacion=request.getParameter("txt_ubicacion");
        necesidad=Integer.parseInt(request.getParameter("cbo_necesidad"));
	    BeneficiarioDTO obj=new BeneficiarioDTO();
	    obj.setNombre(nom);
	    obj.setEdad(edad);
	    obj.setGenero(genero);
	    obj.setUbicacion(ubicacion);
	    obj.setCodNecesidad(necesidad);
	    serviBeneficiario.registrarBeneficiario(obj);
	    listar(request,response);
	}
}
