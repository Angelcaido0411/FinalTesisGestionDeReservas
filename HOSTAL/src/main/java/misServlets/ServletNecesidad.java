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

import beans.NecesidadesDTO;
import service.NecesidadService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletNecesidad")
public class ServletNecesidad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NecesidadService serviNecesidad=new NecesidadService();
    /**
     * Default constructor. 
     */
    public ServletNecesidad() {
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
		}else if(xtipo.equals("buscarNecesidad")) {
			buscarNecesidad(request,response);
		}
	}

	private void buscarNecesidad(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String des=request.getParameter("des");
		request.setAttribute("necesidades", serviNecesidad.buscaNecesidad(des));
		request.getRequestDispatcher("buscarNecesidad.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("data",serviNecesidad.listaNecesidad());
		request.getRequestDispatcher("listarNecesidad.jsp").forward(request, response);
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
        System.out.println("eliminado : "+cod);
        serviNecesidad.eliminarNecesidad(cod);
		listar(request,response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Necesidad",serviNecesidad.buscarNecesidad(cod));
		request.getRequestDispatcher("actualizarNecesidad.jsp").forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cant,cod;
        java.sql.Date fecha=null;
        cod=Integer.parseInt(request.getParameter("txt_cod"));
        String des=request.getParameter("txt_des");
        cant=Integer.parseInt(request.getParameter("txt_cant"));
        String fec=request.getParameter("txt_fecha");
        String ubi=request.getParameter("txt_ubicacion");
        String pri=request.getParameter("txt_prioridad");
        String est=request.getParameter("txt_estado");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	Date utilDate = formatter.parse(fec);
        	fecha = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
	    NecesidadesDTO obj=new NecesidadesDTO();
	    obj.setCodigo(cod);
	    obj.setDescripcion(des);
	    obj.setCantidad(cant);
	    obj.setFecha(fecha);
	    obj.setUbicacion(ubi);
	    obj.setPrioridad(pri);
	    obj.setEstado(est);
	    serviNecesidad.actualizarNecesidad(obj);
	    listar(request,response);
	}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cant;
        java.sql.Date fecha=null;
        String des=request.getParameter("txt_des");
        cant=Integer.parseInt(request.getParameter("txt_cant"));
        String fec=request.getParameter("txt_fecha");
        String ubi=request.getParameter("txt_ubicacion");
        String pri=request.getParameter("txt_prioridad");
        String est=request.getParameter("txt_estado");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	Date utilDate = formatter.parse(fec);
        	fecha = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        NecesidadesDTO obj=new NecesidadesDTO();
        obj.setDescripcion(des);
	    obj.setCantidad(cant);
	    obj.setFecha(fecha);
	    obj.setUbicacion(ubi);
	    obj.setPrioridad(pri);
	    obj.setEstado(est);
	    serviNecesidad.registrarNecesidad(obj);
	    listar(request,response);
	}
}
