package tags;

import java.lang.annotation.Documented;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TagMensajes extends TagSupport{
 private String col,tam,tex;

public void setCol(String col) {
	this.col = col;
}

public void setTam(String tam) {
	this.tam = tam;
}

public void setTex(String tex) {
	this.tex = tex;
}
 @Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			JspWriter out=pageContext.getOut();
			out.print("<font color='"+col+"' size='"+tam+"'>");
			out.print(tex);
			out.print(tex);
			out.print("</font>");
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
