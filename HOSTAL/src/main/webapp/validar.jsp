
<%
if(session.getAttribute("datos")==null){
pageContext.forward("ServletUsuario?tipo=cerrarSesion");}
%>