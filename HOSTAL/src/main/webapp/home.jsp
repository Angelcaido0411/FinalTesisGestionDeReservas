<jsp:include page="validar.jsp"/>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.118.2">
		<title>Home</title>
		<link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sidebars/">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
        <!-- Custom styles for this template -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
       
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
        
        <style>
            .container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh; /* Esto centra verticalmente si el contenido es menor que la altura del viewport */
                background-color: white;
            }
            .background-section {
                background-image: url("https://images.unsplash.com/photo-1664982208621-a3d7dcb01ed2?q=80&w=1740&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
                background-size: cover;
                background-position: center;
                width: 100%; /* Ancho deseado */
                height: 100%; /* Alto deseado */

            }
	        .content {
	            flex-grow: 1;
	            padding: 0px;
	            background-color: silver;
	        }
        </style>
</head>
<body>
<div class="d-flex">
<jsp:include page="encabezado.jsp"/>
	<div class="content">
        <main>
            <div class="container">
                <div class="background-section">
                    <table style="height: 100%; width: 100%;">
                        
                    </table>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>