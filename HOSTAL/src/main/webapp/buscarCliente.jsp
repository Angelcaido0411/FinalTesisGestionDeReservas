<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="bordered2" width="100%" border="2">
<tr style="font:bold">
<td style="width: 80px">ID</td>
<td style="width: 245px">Apellidos y Nombres</td>
<td style="width: 70px">Sexo</td>
<td style="width: 70px">DNI</td>
<td style="width: 120px">Direccion</td>
<td style="width: 120px">Distrito</td>
<td style="width: 20px"></td>

</tr>

<c:forEach items="${requestScope.clientes}" var="f">
<tr>
<td>${f.codigo}</td>
<td>${f.apellido} ${f.nombre}</td>
<td>${f.sexo}</td>
<td>${f.dni}</td>
<td>${f.direccion}</td>
<td>${f.nomDistrito}</td>
<td>
<a href="ServletBoleta?tipo=verCliente&codigo=${f.codigo}&datos=${f.apellido} ${f.nombre} ">
<img src="img/edit.gif" style="width: 50px;height: 50px"></a></td>

</tr>

</c:forEach>

</table>

</body>
</html>