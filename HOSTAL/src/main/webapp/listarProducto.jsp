<jsp:include page="validar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "beans.ProductoDTO" %> 
    <%@ page import= "java.util.ArrayList" %> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<jsp:include page="encabezado.jsp"/>
<table border="2" align="center" width="75%" class="table">
<thead class="thead-light">
<tr>
<th scope="col">CODIGO</th>
<th scope="col">DESCRIPCION</th>
<th scope="col">PRECIO</th>
<th scope="col">STOCK</th>
<th scope="col">MARCA</th>
<th colspan="2">ACCIONES</th>
</tr>

<c:forEach items="${requestScope.data}" var="f">
<tr>
<td>${f.codigo} </td>
<td>${f.descripcion}</td>
<td>${f.precio}</td>
<td>${f.stock}</td>
<td>${f.nomMarca}</td>
<td align="center"><a href='ServletProducto?tipo=buscar&cod=${f.codigo}'>
<img src='img/actualizar.gif' title='Editar' style="width: 50px;height: 50px"></a></td>
<td align="center"><a href='ServletProducto?tipo=eliminar&cod=${f.codigo}'>
<img src='img/delete.gif' title='Eliminar' style="width: 50px;height: 50px" 
onclick="if(!(confirm('¿Está seguro de eliminar el registro seleccionado?'))) return false"></a>
</td>
</tr>
</c:forEach>

</table>


</body>
</html>