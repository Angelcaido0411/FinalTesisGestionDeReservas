package misServlets;

import java.io.IOException;
import java.util.ArrayList;

import beans.BoletaDTO;
import beans.DetalleBoletaDTO;
import beans.EmpleadoDTO;
import beans.ProductoDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoletaService;

/**
 * Servlet implementation class ServletBoleta
 */
@WebServlet("/ServletBoleta")
public class ServletBoleta extends HttpServlet {
	BoletaService serviBoleta=new BoletaService();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBoleta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipo=request.getParameter("tipo");
		if(tipo.equals("verCliente")) {
			verCliente(request,response);
		}else if(tipo.equals("verProducto")) {
			verProducto(request,response);
		}else if(tipo.equals("ingresa")) {
			ingresa(request,response);
		}else if(tipo.equals("elimina")) {
			eliminar(request,response);
		}else if(tipo.equals("registra")) {
			registra(request,response);
		}
	}

	private void registra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList<ProductoDTO> boleta=(ArrayList<ProductoDTO>)session.getAttribute("boleta");
		String cliente[]=(String[])session.getAttribute("datoCliente");
		int codCliente=Integer.parseInt(cliente[0]);
		
		EmpleadoDTO codEmpleado=(EmpleadoDTO)session.getAttribute("datos");
		
		BoletaDTO b=new BoletaDTO();
		b.setCodEmpleado(codEmpleado.getCodigo());
		b.setCodCliente(codCliente);
		ArrayList<DetalleBoletaDTO> detalles=new ArrayList<DetalleBoletaDTO>();
		for(ProductoDTO x: boleta) {
			DetalleBoletaDTO det=new DetalleBoletaDTO(0,x.getCodigo(),x.getStock(),x.getPrecio());
			detalles.add(det);
		}
		serviBoleta.registrarBoleta(b, detalles);
		
		session.removeAttribute("boleta");
		session.removeAttribute("datoCliente");
		session.removeAttribute("datoProducto");
		
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Id=request.getParameter("id");
		int codi=Integer.parseInt(Id);
		HttpSession session=request.getSession();
		ArrayList<ProductoDTO> boleta=(ArrayList<ProductoDTO>)session.getAttribute("boleta");
		
		for(int i=0;i<boleta.size();i++) {
			if(boleta.get(i).getCodigo()==codi) {
				boleta.remove(i);
				break;
			}
		}
		
		session.setAttribute("boleta", boleta);
		
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
		
	}

	private void ingresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cod=request.getParameter("txt_cod_pro");
		String des=request.getParameter("txt_des_pro");
		String can=request.getParameter("txt_can_pro");
		String pre=request.getParameter("txt_pre_pro");
		int codi=Integer.parseInt(cod.trim());
		int cant=Integer.parseInt(can.trim());
		double prec=Double.parseDouble(pre.trim());
		ArrayList<ProductoDTO> boleta;
		
		HttpSession session=request.getSession();
		if(session.getAttribute("boleta")==null) {
			boleta=new ArrayList<ProductoDTO>();
		}else {
			boleta=(ArrayList<ProductoDTO>)session.getAttribute("boleta");
		}
		
		ProductoDTO p=new ProductoDTO();
		p.setCodigo(codi);
		p.setDescripcion(des);
		p.setPrecio(prec);
		p.setStock(cant);
		boolean noExiste=true;
		for(int i=0;i<boleta.size();i++) {
			if(boleta.get(i).getCodigo()==codi) {
				boleta.set(i, p);
				noExiste=false;
				break;
			}
		}
		if(noExiste) {
			boleta.add(p);
		}
		
		session.setAttribute("boleta", boleta);
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
	}

	private void verProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo=request.getParameter("codigo");
		String des=request.getParameter("des");
		String pre=request.getParameter("pre");
		String cant=request.getParameter("cant");
		String producto[]=new String[4];
		producto[0]=codigo;
		producto[1]=des;
		producto[2]=pre;
		
		HttpSession session=request.getSession();
		session.setAttribute("datoProducto", producto);
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
		
	}

	private void verCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo=request.getParameter("codigo");
		String datos=request.getParameter("datos");
		String cliente[]=new String[2];
		cliente[0]=codigo;
		cliente[1]=datos;
		
		HttpSession session=request.getSession();
		session.setAttribute("datoCliente", cliente);
		request.getRequestDispatcher("registrarBoleta.jsp").forward(request, response);
		
		
	}

}
