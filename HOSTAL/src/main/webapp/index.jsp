<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <style>
        body {
            background-image: url("img/homelogin.jpg");
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;          
        }
        .card {
            background-color: rgba(255, 255, 255, 0.5); /* Fondo del formulario */
        }
    </style>
    </head>
	<body>
		<div class="container">
            <div class="d-flex align-items-center justify-content-center" style="height: 100vh;">
                <div class="card col-sm-5">
                    <div class="alert alert-secondary alert-lg text-center">
                        <h1>Login</h1>
                    </div>
                    <br>
                    <div class="text-center">
                        <img src="https://www.pngall.com/wp-content/uploads/5/Hotel-PNG-Images.png" alt="" width="120" height="120" class="rounded me-2 mx-auto">
                    </div>
                    <br>
                    <!-- Mensaje de error -->
                	<%
	                    String msg = (String) request.getAttribute("msg");
	                    if (msg != null) {
	                %>
	                    <div class="alert alert-danger text-center">
	                        <%= msg %>
	                    </div>
	                    <br>
	                <% } %>
                    <form action="ServletUsuario?tipo=sesion" name="frmsesion" method="post" class="row g-3">
                        <div class="row">
                            <div class="col-md-6 mx-auto">
                                <label class="form-label">Usuario</label>
                                <input type="text" class="form-control" name="txt_login" placeholder="Username">
                            </div>
                        </div>
                        <div class="my-4"></div>
                        <div class="row">
                            <div class="col-md-6 mx-auto">
                                <label class="form-label">Contraseña</label>
                                <input type="password" class="form-control" name="txt_pass" placeholder="***********">
                            </div>
                        </div>
                        <div class="my-4">
                            <div class="row">
                                <div class="col-12 text-center">
                                    <button type="submit" value="Iniciar" class="btn btn-dark">Ingresar</button>
                                </div>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
	</body>
</html>