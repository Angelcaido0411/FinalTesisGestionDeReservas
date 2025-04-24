<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Equipos</title>
</head>
<body>
<table class="bordered2" width="100%" border="2">
<tr style="font:bold">
<td style="width: 80px">ID</td>
<td style="width: 245px">Nombre</td>
<td style="width: 70px">Especialidad</td>
<td style="width: 120px">Organizacion</td>
<td style="width: 20px"></td>


</tr>
<c:forEach items="${requestScope.equipos}" var="f">
<tr>
<td>${f.codigo}</td>
<td>${f.nombre}</td>
<td>${f.especialidad}</td>
<td>${f.nomOrganizacion}</td>
<td>
<a href="ServletBoleta?tipo=verProducto&codigo=${f.codigo}&des=${f.descripcion}&pre=${f.precio}">
<img src="img/edit.gif" style="width: 20px;height: 20px"></a></td>

</tr>

</c:forEach>



</table>

</body>
</html>