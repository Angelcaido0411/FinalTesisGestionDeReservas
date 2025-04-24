<jsp:include page="validar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://displaytag.sf.net" prefix="displaySession" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.functions.js" type="text/javascript">
</script>
<script type="text/javascript">
function addBoleta(){
	document.getElementById("tipo").value='registra';
	document.getElementById("frmBoleta").action='ServletBoleta';
	document.getElementById("frmBoleta").submit();
}
function addProducto(){
	document.getElementById("tipo").value='ingresa';
	document.getElementById("frmBoleta").action='ServletBoleta';
	document.getElementById("frmBoleta").submit();
}
function verCliente(){
	document.getElementById("tipo").style.display='block';
	document.getElementById("divCliente").style.display='block';
}
function verProducto(){
	document.getElementById("tipo").style.display='block';
	document.getElementById("divProducto").style.display='block';
}
function ocultaCliente(){
	document.getElementById("tipo").style.display='none';
	document.getElementById("divCliente").style.display='none';
}
function ocultaProducto(){
	document.getElementById("tipo").style.display='none';
	document.getElementById("divProducto").style.display='none';
}

</script>
<style>
.black_overlay{
display:none;
position:absolute;
top: 0%;
left: 0%;
width: 100%;
height: 100%;
background-color: aqua;
z-index: 1001;
-moz-opacity: 0.8;
opacity: .80;
filter: alpha(opacity = 80);
}
.white_content{
display: none;
position: absolute;
top: 25%;
left: 25%;
width: 50%;
height: 50%;
padding: 16px;
border: 2px solid orange;
background-color: white;
z-index: 1002;
overflow: auto;
}
</style>
</head>
<body>
<jsp:include page="encabezado.jsp"/>
<h1>Boleta de Venta</h1>
<form id="frmBoleta">
<input type="hidden" name=tipo id="tipo">
<fieldset style="width: 60%">
<legend>Datos del Cliente</legend>
<table>
<tr>
<td>Codigo:</td>
<td><input type="text" name="txt_cod_cli" id="txt_cod_cli" size="5" 
value="${sessionScope.datoCliente[0]}"></td>
</tr>
<tr>
<td>Apellidos y Nombres:</td>
<td><input type="text" name="txt_datos_cli" id="txt_datos_cli" 
value="${sessionScope.datoCliente[1]}">
<input type="button" value="..." onclick="verCliente();"></td>
</tr>
</table>
</fieldset>
<fieldset style="width: 60%">
<legend>Seleccione Producto</legend>
<table>
<tr>
<td>Codigo:</td>
<td><input type="text" name="txt_cod_pro" id="txt_cod_pro" size="5" 
value="${sessionScope.datoProducto[0]}"></td>
<td>Descripcion:</td>
<td><input type="text" name="txt_des_pro" id="txt_des_pro" size="50" 
value="${sessionScope.datoProducto[1]}"></td>
</tr>
<tr>
<td>Precio:</td>
<td><input type="text" name="txt_pre_pro" id="txt_pre_pro" size="5" 
value="${sessionScope.datoProducto[2]}"></td>
<td>Cantidad:</td>
<td><input type="text" name="txt_can_pro" id="txt_can_pro" size="5">
<input type="button" value="..." onclick="verProducto();">
<input type="button"  value="agregar" onclick="addProducto();">&nbsp;&nbsp;
</td>


</tr>

</table>
<input type="button" value="ingresar" onclick="addBoleta();">

</fieldset>
</form>
<displaySession:table name="${sessionScope.boleta}"
class="dataTable" style="width:60%" id="bean">
<displaySession:column property="codigo" title="ID" sortable="true"/>
<displaySession:column property="descripcion" title="DESCRIPCION" sortable="true"/>
<displaySession:column property="stock" title="CANTIDAD" sortable="true"/>
<displaySession:column property="precio" title="PRECIO" sortable="true"/>
<displaySession:column title="IMPORTE">
${bean.stock*bean.precio}
</displaySession:column>
<displaySession:column>
<a href="ServletBoleta?tipo=elimina&id=${bean.codigo}">Eliminar</a>
</displaySession:column>
</displaySession:table>

<div id="fondo" class="black_overlay">
</div>
<div id="divCliente" class="white_content">
<form action="" id="idFormCliente">
<table width="100%" border="2">
<tr>
<td colspan="2" align="center"><b>Buscar Cliente</b></td>
</tr>
<tr>
<td width="180%">Apellidos y Nombres:</td>
<td><input type="text" name="txt_ape" id="txt_ape"
     onkeyup="buscarClienteBoleta()">
     <input type="button" value="Salir"
     onclick="ocultaCliente();"></td>
</tr>
</table>
</form>

<div id="tablaCliente"></div>

</div>

<div id="divProducto" class="white_content">
<form action="" id="idFormProducto">
<table width="100%" border="2">
<tr>
<td colspan="2" align="center"><b>Buscar Producto</b></td>
</tr>
<tr>
<td width="140">Descripcion:</td>
<td><input type="text" name="txt_des" id="txt_des"
     onkeyup="buscarProductoBoleta()">
     <input type="button" value="Salir"
     onclick="ocultaProducto();"></td>
</tr>
</table>
</form>

<div id="tablaProducto"></div>

</div>
</body>
</html>