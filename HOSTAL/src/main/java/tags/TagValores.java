package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagValores extends TagSupport {
private String nombre,elementos,valor="";

@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
	try{
		JspWriter out=pageContext.getOut();
		String data[]=elementos.split(",");
		out.write("<select name='"+nombre+"' style='style=width:120px'>");
		for(String x:data) {
			if(x.equals(valor))
			out.write("<option selected value='"+x+"'>"+x+"</option>");
			else
				out.write("<option value='"+x+"'>"+x+"</option>");
		out.write("</select>");
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
		return SKIP_BODY;
	}
@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}
}
