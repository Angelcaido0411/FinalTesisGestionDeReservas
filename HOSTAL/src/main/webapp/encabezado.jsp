<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" data-bs-theme="auto">
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
    <link href="../sidebars.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
    <link href="../menu.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="../sidebars.js"></script>
    <script src="../assets/js/color-modes.js"></script>
    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* Esto centra verticalmente si el contenido es menor que la altura del viewport */
        }
        .sidebar {
            height: 100vh; /* Altura del viewport */
        }
    </style>
</head>
<body>
    <div class="d-flex flex-column flex-shrink-0 p-3 text-bg-dark sidebar" style="width: 280px;">
        <a href="encabezado.jsp" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
            <img src="https://www.pngall.com/wp-content/uploads/5/Hotel-PNG-Images.png" alt="" width="50" height="50" class="rounded-cube me-2">
            <span class="fs-4"><strong>CALIFORNIA SAC</strong></span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="home.jsp" class="nav-link active">
                	<i class="bi bi-house"></i>
                    &nbspHome
                </a>
            </li>
            <li>
                <a href="ServletSuministro?tipo=listar" class="nav-link text-white" aria-current="page">
                    <i class="bi bi-calendar2-check"></i>
                     &nbspReserva
                </a>
            </li>
            <li>
                <a href="ServletMiembro?tipo=listar" class="nav-link text-white">
                    <i class="bi bi-key"></i>
                    &nbspHabitaciones
                </a>
            </li>
            <li>
                <a href="ServletEquipo?tipo=listar" class="nav-link text-white">
                    <i class="bi bi-people"></i> 
                     &nbspClientes
                </a>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://cdn.icon-icons.com/icons2/4076/PNG/512/account_username_people_avatar_profile_person_user_icon_258905.png" alt="" width="32" height="32" class="rounded-circle me-2">
                <strong>Admin</strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
                <!--<li><a class="dropdown-item" href="#">New project...</a></li>
                <li><a class="dropdown-item" href="#">Settings</a></li>
                <li><a class="dropdown-item" href="#">Profile</a></li>
                <li><hr class="dropdown-divider"></li>-->
                <li><a class="dropdown-item" href="ServletUsuario?tipo=cerrarSesion">Sign out</a></li>
            </ul>
        </div>
    </div>
</body>
</html>
