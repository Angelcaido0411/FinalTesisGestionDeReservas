package tags;

import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.ComboDTO;
import service.ComboService;

public class TagComboDinamico extends TagSupport{
	private String nombre,sql,valor="0";
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public int doStartTag() throws JspException {
		ComboService m=new ComboService();
		ResourceBundle rb=ResourceBundle.getBundle("tags");
		JspWriter out=pageContext.getOut();
		try {
			out.print("<select name='"+nombre+"' style='width:190px'>");
			List<ComboDTO> lista=m.listar(rb.getString(sql));
			for(ComboDTO obj:lista) {
				if(Integer.parseInt(valor)==obj.getCodigo()) {
					out.print("<option selected value='"+obj.getCodigo()+"'>");
					out.print(obj.getNombre());
					out.print("</option>");
				}else {
					out.print("<option value='"+obj.getCodigo()+"'>");
					out.print(obj.getNombre());
					out.print("</option>");}
			}
			
			out.print("</select>");
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
	
}
