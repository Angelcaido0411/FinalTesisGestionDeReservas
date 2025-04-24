function buscarClienteBoleta(){
	 ape=document.getElementById("txt_ape").value;
	$.ajax({
		url: 'ServletCliente',
		type: 'GET',
		data: 'tipo=buscarCliente&ape='+ape,
		success:function(datos){
			$("#tablaCliente").html(datos);
		}
	});
	
}

function buscarProductoBoleta(){
	des=document.getElementById("txt_des").value;
	$.ajax({
		url: 'ServletProducto',
		type: 'GET',
		data: 'tipo=buscarProducto&des='+des,
		success:function(datos){
			$("#tablaProducto").html(datos);
		}
	});
	
}
