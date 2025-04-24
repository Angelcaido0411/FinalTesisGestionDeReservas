package misServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ClienteService;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteService serviCliente=new ClienteService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo=request.getParameter("tipo");
		if(tipo.equals("buscarCliente")) {
			buscarCliente(request,response);
		}
	}

	private void buscarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String ape=request.getParameter("ape");
		request.setAttribute("clientes", serviCliente.buscarCliente(ape));
		request.getRequestDispatcher("buscarCliente.jsp").forward(request, response);
		
	}

}
