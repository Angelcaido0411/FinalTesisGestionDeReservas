package misServlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UsuarioDTO;
import service.UsuarioService;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet{
	private static final long serialVersionUID = 1L;
	UsuarioService servicio=new UsuarioService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String xtipo=request.getParameter("tipo");
		if(xtipo.equals("sesion"))
			iniciarSesion(request,response);
		else if(xtipo.equals("cerrarSesion"))
			cerrarSesion(request,response);
	}

	private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion=request.getSession();
		sesion.invalidate();
		request.setAttribute("msg", "Iniciar Sesion");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String xlogin=request.getParameter("txt_login");
		String xpass=request.getParameter("txt_pass");
		UsuarioDTO obj=servicio.IniciarSesion(xlogin);
		if(obj!=null) {
			if(obj.getPassword().equals(xpass)) {
				HttpSession sesion=request.getSession();
				sesion.setAttribute("datos", obj);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "¡Contraseña incorrecta!");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "¡El usuario ingresado no existe!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

}
