package listener;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import beans.AuditoriaDTO;
import beans.EmpleadoDTO;
import service.AuditoriaService;

public class EscuchaAtributoSesion implements HttpSessionAttributeListener{

	AuditoriaService servAudi=new AuditoriaService();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String fechalogin=null;
	long tpoinicio,tpofinal;
	String tiempo=null;
	int codEmp;
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		String usuario=null;
		String atributo=arg0.getName();
		if(atributo.equals("datos")) {
			fechalogin=sdf.format(new Date());
			EmpleadoDTO emp=(EmpleadoDTO)arg0.getSession().getAttribute("datos");
			codEmp=emp.getCodigo();
			usuario=emp.getApellidos()+" "+emp.getNombres();
			AuditoriaDTO audi=new AuditoriaDTO(0,emp.getCodigo(),fechalogin,null,usuario,null);
			tpoinicio=System.currentTimeMillis();
			servAudi.registrarSesionLogin(audi);
		}
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		String fechalogout=null;
		String atributo=arg0.getName();
		int tpo,hh,mm,ss;
		if(atributo.equals("datos")) {
			fechalogout=sdf.format(new Date());
			tpofinal=System.currentTimeMillis();
			tpo=(int)(tpofinal-tpoinicio)/1000;
			hh=tpo/3600;
			mm=tpo%3600/60;
			ss=tpo%3600%60;
			tiempo=ceros(hh)+":"+ceros(mm)+":"+ceros(ss);
			AuditoriaDTO audi=new AuditoriaDTO(0, codEmp, fechalogin, fechalogout, null,tiempo);
			servAudi.registrarSesionLogout(audi);
		}
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	String ceros(int x) {
		if(x<10)
			return "0"+x;
		else
			return ""+x;
	}

}
