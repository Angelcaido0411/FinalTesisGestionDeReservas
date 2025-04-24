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

import beans.LogisticaDTO;
import service.LogisticaService;

/**
 * Servlet implementation class ServletProducto
 */
@WebServlet("/ServletLogistica")
public class ServletLogistica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LogisticaService serviLogistica=new LogisticaService();
    /**
     * Default constructor. 
     */
    public ServletLogistica() {
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
		}else if(xtipo.equals("buscarLogistica")) {
			buscarLogistica(request,response);
		}
	}

	private void buscarLogistica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String des=request.getParameter("des");
		request.setAttribute("logistica", serviLogistica.buscaLogistica(des));
		request.getRequestDispatcher("buscarLogistica.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("data",serviLogistica.listaLogistica());
		request.getRequestDispatcher("listarLogistica.jsp").forward(request, response);
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
        System.out.println("eliminado : "+cod);
        serviLogistica.eliminarLogistica(cod);
		listar(request,response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cod=Integer.parseInt(request.getParameter("cod"));
		request.setAttribute("Logistica",serviLogistica.buscarLogistica(cod));
		request.getRequestDispatcher("actualizarLogistica.jsp").forward(request, response);
	}
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int suministro,cod,cant;
        java.sql.Date fechaEnvio=null, fechaEntrega=null;
        cod=Integer.parseInt(request.getParameter("txt_cod"));
        String ubiOrigen=request.getParameter("txt_ubiOri");
        String ubiDestino=request.getParameter("txt_ubiDes");
        cant=Integer.parseInt(request.getParameter("txt_cant"));
        String fenvio=request.getParameter("txt_fecEnv");
        String fentrega=request.getParameter("txt_fecEnt");
        String estado=request.getParameter("txt_estado");
        suministro=Integer.parseInt(request.getParameter("cbo_suministro"));
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date utilDate1 = formatter.parse(fenvio);
            fechaEnvio = new java.sql.Date(utilDate1.getTime());
            Date utilDate2 = formatter.parse(fentrega);
            fechaEntrega = new java.sql.Date(utilDate2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
	    LogisticaDTO obj=new LogisticaDTO();
	    obj.setCodigo(cod);
	    obj.setCodSuministro(suministro);
	    obj.setFechaEnvio(fechaEnvio);
	    obj.setFechaEntrega(fechaEntrega);
	    obj.setCantidad(cant);
	    obj.setUbicacionDestino(ubiDestino);
	    obj.setUbicacionOrigen(ubiOrigen);
	    obj.setEstado(estado);
	    serviLogistica.actualizarLogistica(obj);
	    listar(request,response);
	}
	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int suministro,cant;
		java.sql.Date fechaEnvio=null, fechaEntrega=null;
        String ubiOrigen=request.getParameter("txt_ubiOri");
        String ubiDestino=request.getParameter("txt_ubiDes");
        cant=Integer.parseInt(request.getParameter("txt_cant"));
        String fenvio=request.getParameter("txt_fecEnv");
        String fentrega=request.getParameter("txt_fecEnt");
        String estado=request.getParameter("txt_estado");
        suministro=Integer.parseInt(request.getParameter("cbo_suministro"));
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date utilDate1 = formatter.parse(fenvio);
            fechaEnvio = new java.sql.Date(utilDate1.getTime());
            Date utilDate2 = formatter.parse(fentrega);
            fechaEntrega = new java.sql.Date(utilDate2.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        LogisticaDTO obj=new LogisticaDTO();
	    obj.setCodSuministro(suministro);
	    obj.setFechaEnvio(fechaEnvio);
	    obj.setFechaEntrega(fechaEntrega);
	    obj.setCantidad(cant);
	    obj.setUbicacionDestino(ubiDestino);
	    obj.setUbicacionOrigen(ubiOrigen);
	    obj.setEstado(estado);
	    serviLogistica.registrarLogistica(obj);
	    listar(request,response);
	}
}
