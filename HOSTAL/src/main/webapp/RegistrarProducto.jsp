<jsp:include page="validar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form action="ServletProducto?tipo=registrar" id="frmagregar" method="post">

<table align="center">
<tr>
<td>Descripcion</td>
<td><input type="text" name="txt_des" class="required"></td>
</tr>
<tr>
<td>Precio</td>
<td><input type="text" name="txt_pre" ></td>
</tr>
<tr>
<td>Stock</td>
<td><input type="text" name="txt_stock" ></td>
</tr>
<tr>
<td>Marca</td>
<td>
<ct:cboDinamico nombre="cbo_marca" sql="SQL_MARCA">
</ct:cboDinamico>
</td>
</tr>
<tr>
<td colspan="2" align="right"><input type="submit"
value="Registrar" class="boton2"></td>
</tr>


</table>

</form>
</body>
</html>