package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagMeses extends TagSupport{
@Override
public int doStartTag() throws JspException {
	// TODO Auto-generated method stub
	try {
	JspWriter out=pageContext.getOut();
	out.print("<select name='cboMes' style='width:120px'>");
	out.print("<option value='1'>Enero</option>");
	out.print("<option value='2'>Febrero</option>");
	out.print("<option value='3'>Marzo</option>");
	out.print("<option value='4'>Abril</option>");
	out.print("<option value='5'>Mayo</option>");
	out.print("<option value='6'>Junio</option>");
	}catch (Exception e) {
		// TODO: handle exception
	}
	return SKIP_BODY;
}
@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}
}
