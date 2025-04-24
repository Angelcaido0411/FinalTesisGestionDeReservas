package misServlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ActividadDTO;
import service.ActividadService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletActividad")
public class ServletActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ActividadService serviActividad=new ActividadService();
    /**
     * Default constructor. 
     */
    public ServletActividad() {
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
		}else if(xtipo.equals("buscarActiividad")) {
			buscarActiividad(request,response);
		}
	}

	private void buscarActiividad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String des=request.getParameter("des");
		request.setAttribute("actividades", serviActividad.buscaActividad(des));
		request.getRequestDispatcher("buscarMiembro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("data",serviActividad.listaActividad());
		request.getRequestDispatcher("listarActividad.jsp").forward(request, response);
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
        System.out.println("eliminado : "+cod);
        serviActividad.eliminarActividad(cod);
		listar(request,response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Actividad",serviActividad.buscarActividad(cod));
		request.getRequestDispatcher("actualizarActividad.jsp").forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int equipo,cod;
        java.sql.Date fechaInicio=null, fechaFin=null;
        cod=Integer.parseInt(request.getParameter("txt_cod"));
        String nom=request.getParameter("txt_des");
        String fi=request.getParameter("txt_fecIni");
        String ff=request.getParameter("txt_fecFin");
        equipo=Integer.parseInt(request.getParameter("cbo_equipo"));
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date utilDate1 = formatter.parse(fi);
            fechaInicio = new java.sql.Date(utilDate1.getTime());
            Date utilDate2 = formatter.parse(ff);
            fechaFin = new java.sql.Date(utilDate2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
	    ActividadDTO obj=new ActividadDTO();
	    obj.setCodigo(cod);
	    obj.setDescripcion(nom);
	    obj.setFechaInicio(fechaInicio);
	    obj.setFechaFin(fechaFin);
	    obj.setCodEquipo(equipo);
	    serviActividad.actualizarActividad(obj);
	    listar(request,response);
	}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int equipo;
        java.sql.Date fechaInicio=null, fechaFin=null;
        String nom=request.getParameter("txt_des");
        String fi=request.getParameter("txt_fecIni");
        String ff=request.getParameter("txt_fecFin");
        equipo=Integer.parseInt(request.getParameter("cbo_equipo"));
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	Date utilDate1 = formatter.parse(fi);
            fechaInicio = new java.sql.Date(utilDate1.getTime());
            Date utilDate2 = formatter.parse(ff);
            fechaFin = new java.sql.Date(utilDate2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        ActividadDTO obj=new ActividadDTO();
        obj.setDescripcion(nom);
	    obj.setFechaInicio(fechaInicio);
	    obj.setFechaFin(fechaFin);
	    obj.setCodEquipo(equipo);
	    serviActividad.registrarActividad(obj);
	    listar(request,response);
	}
}
