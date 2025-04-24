<jsp:include page="validar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "beans.ProductoDTO" %> 
    <%@taglib prefix="ct" uri="WEB-INF/tag/libreria.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" >
$(document).ready(
		function(){
			$("#frmagregar").validate();
		}
		)


</script>
</head>
<body>
<jsp:include page="encabezado.jsp"/>

<%
ProductoDTO obj=(ProductoDTO)request.getAttribute("Producto");
%>


<form action="ServletProducto?tipo=actualizar" id="frmagregar" method="post">
<input type="hidden" name="txt_cod" value="${requestScope.Producto.codigo}">
<table align="center">
<tr>
<td>Descripcion</td>
<td><input type="text" name="txt_des" class="required"
value="${requestScope.Producto.descripcion}"></td>
</tr>
<tr>
<td>Precio</td>
<td><input type="text" name="txt_pre" 
value="${requestScope.Producto.precio}"></td>
</tr>
<tr>
<td>Stock</td>
<td><input type="text" name="txt_stock" 
value="${requestScope.Producto.stock}"></td>
</tr>
<tr>
<td>Marca</td>
<td>
<ct:cboDinamico sql="SQL_MARCA" nombre="cbo_marca" valor="${requestScope.Producto.codMarca}"></ct:cboDinamico>
</td>
</tr>
<tr>
<td colspan="2" align="right"><input type="submit"
value="Actualizar" class="boton2"></td>
</tr>


</table>

</form>
</body>
</html>