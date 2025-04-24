<jsp:include page="validar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "beans.LogisticaDTO" %> 
    <%@taglib prefix="ct" uri="WEB-INF/tag/libreria.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.118.2">
		<title>Logistica</title>
		<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sidebars/">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
        <!-- Custom styles for this template -->
        <link href="../sidebars.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
        <link href="../menu.css" rel="stylesheet">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
        <script src="../sidebars.js"></script>
        <script src="../assets/js/color-modes.js"></script>
<script type="text/javascript" >
$(document).ready(
		function(){
			$("#frmagregar").validate();
		}
		)
</script>
		<style>
            .container {
                display: flex;
                flex-direction: column;
                align-items: center;
                min-height: 100vh; /* Esto centra verticalmente si el contenido es menor que la altura del viewport */
                background-color: white;
            }
	        .content {
	            flex-grow: 1;
	            width: 100%;
	            padding: 0px;
	            background-color: silver;
	        }
		    .header-btn {
		        display: flex;
		        justify-content: flex-end;
		        margin-bottom: 10px;
		        width: 100%;
    		}
    		table {
		        width: 75%;
		    }
        </style>
</head>
<body>
<div class="d-flex">
<jsp:include page="encabezado.jsp"/>

<%
LogisticaDTO obj=(LogisticaDTO)request.getAttribute("Logistica");
%>
<div class="content">
<main>
<div class="container">
		<div class="header-btn">
            <a href="ServletLogistica?tipo=listar" class="btn btn-secondary">Regresar</a>
        </div>

<form action="ServletLogistica?tipo=actualizar" id="frmagregar" method="post">
<input type="hidden" name="txt_cod" value="${requestScope.Logistica.codigo}">
<table align="center">


<div class="col-md-12">
<h1 align="center">Actualizar Logistica</h1>
<br><br><br>

<label  for="cbo_suministro"class="form-label">Seleccione el suministro</label>
	<div>
		<ct:cboDinamico sql="SQL_SUMINISTRO" nombre="cbo_suministro" valor="${requestScope.Logistica.codSuministro}"></ct:cboDinamico>
	</div>
<br>

<label class="form-label">Fecha de Envio</label>
<input type="date" class="form-control" name="txt_fecEnv"
value="${requestScope.Logistica.fechaEnvio}">
<br>

<label class="form-label">Fecha de Entrega</label>
<input type="date" class="form-control" name="txt_fecEnt"
value="${requestScope.Logistica.fechaEntrega}">

<br>

<label class="form-label">Cantidad</label>
<input type="text" class="form-control" name="txt_cant"
value="${requestScope.Logistica.cantidad}">

<br>

<label class="form-label">Ubicacion de Origen</label>
<input type="text" class="form-control" name="txt_ubiOri"
value="${requestScope.Logistica.ubicacionOrigen}">

<br>

<label class="form-label">Ubicacion de Destino</label>
<input type="text" class="form-control" name="txt_ubiDes"
value="${requestScope.Logistica.ubicacionDestino}">

<br>

<label class="form-label">Estado</label>
<input type="text" class="form-control" name="txt_estado"
value="${requestScope.Logistica.estado}">

<br>
</div>

<div class="col-12" align="center"><br>
<button type="submit" value="Actualizar" class="btn btn-primary">Actualizar</button>
</div>
</table>
</form>
</div>
</main>
</div>
</div>
</body>
</html>