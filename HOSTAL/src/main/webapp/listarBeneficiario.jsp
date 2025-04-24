<jsp:include page="validar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ page import= "beans.BeneficiarioDTO" %> 
    <%@ page import= "java.util.ArrayList" %> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.118.2">
		<title>Beneficiarios</title>
		<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sidebars/">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
        <!-- Custom styles for this template -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
       
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
        <style>
		    .container {
		        display: flex;
		        flex-direction: column;
		        align-items: center;
		        min-height: 100vh;
		        background-color: white;
		    }
		    .content {
		        flex-grow: 1;
		        width: 100%;
		        padding: 0px;
		        background-color: silver;
		    }
		    .header-btn {
		    	padding: 10px;
		        display: flex;
		        justify-content: flex-end;
		        margin-bottom: 10px;
		        width: 100%;
		    }
		    table {
		        width: 100%;
		        table-layout: fixed;
		    }
		    th, td {
		        text-align: center;
		        vertical-align: middle;
		        overflow: hidden;
		        white-space: nowrap;
		        text-overflow: ellipsis;
		    }
		    thead th {
		        position: sticky;
		        top: 0;
		        background-color: #f8f9fa;
		        z-index: 1;
		    }
		</style>
</head>
<body>
<div class="d-flex">
<jsp:include page="encabezado.jsp"/>
<div class="content">
	<main>
    <div class="container">
	<div class="header-btn">
        <a href="registrarBeneficiario.jsp" class="btn btn-primary">Agregar</a>
</div>
                <br>
                <div class="table-responsive">
                    <table class="table table-bordered table-striped">
                        <thead class="thead-light">
                            <tr class="text-center">
<th scope="col" width=5%>CODIGO</th>
<th scope="col" width=20%>NOMBRE</th>
<th scope="col" width=5%>EDAD</th>
<th scope="col" width=10%>GENERO</th>
<th scope="col" width=10%>UBICACION</th>
<th scope="col" width=38%>NECESIDAD</th>
<th colspan="2" width=12%>ACCIONES</th>
</tr>
</thead>
<tbody>
<c:forEach items="${requestScope.data}" var="f">
<tr>
<td>${f.codigo} </td>
<td>${f.nombre}</td>
<td>${f.edad}</td>
<td>${f.genero}</td>
<td>${f.ubicacion}</td>
<td>${f.nomNecesidad}</td>
<td align="center"><a href='ServletBeneficiario?tipo=buscar&cod=${f.codigo}'>
<img src='img/editar.ico' title='Editar' style="width: 50px;height: 50px"></a></td>
<td align="center"><a href='ServletBeneficiario?tipo=eliminar&cod=${f.codigo}'>
<img src='img/eliminar.ico' title='Eliminar' style="width: 50px;height: 50px" 
onclick="if(!(confirm('¿Está seguro de eliminar el registro seleccionado?'))) return false"></a>
</td>
</tr>
 </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>
