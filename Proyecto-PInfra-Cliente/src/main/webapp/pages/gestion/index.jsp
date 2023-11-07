<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<!-- Tenemos dos hojas de estilo porque mantenmos el estilo y propocion del header, main y footer -->
<!-- Creemos contenido dentro del main con clases personalizadas -->
<!-- pero solo las utilizamos en la hoja de estilo que este en la misma carpeta que este archivo -->
<!-- Nos ayuda a tener más organizado el .css y no todo en un mismo archivo jajaja -->
<link rel="stylesheet" type="text/css" href="./style.css">
<link rel="stylesheet" type="text/css" href="../../style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Crea tus usuarios y gestionalos de una manera sencilla.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico" href="./utils/img/favicon.ico">
<title>Gestión de usuarios</title>
</head>

<body>
	<!-- Encabezado de la página -->
	<header class="encabezado">
		<a class="btnHome" href="../../index.html"> <img
			class="imagenUtec" src="../..//utils/img/utec.png" alt="Logo de UTEC">
		</a>
		<nav class="menu">
			<ul class="links">
				<li><a href="#">Cursos</a></li>
				<li><a href="#">Itrs</a></li>
				<li><a href="#">Sobre nosotros</a></li>
				<!--Temporal mientras
				maquetamos el apartado va a estar visible siempre-->
				<li><a href="./index.jsp">Gestión de usuarios</a></li>
				<!--Temporal mientras
				maquetamos el apartado va a estar visible siempre-->
			</ul>

			<div class="btnSesion">
				<a href="../login/index.jsp">Iniciar sesión</a> <a href="#">Registrarme</a>
			</div>
		</nav>
	</header>

	<!-- Contenido de la página -->
	<main class="contenido">
		<!-- Modificar a gusto -->
		<section>
			<h2>Gestión de constancias</h2>

		</section>
	</main>

	<!-- Pie de página -->
	<footer class="pieDePagina">
		<p>Creado por</p>
		<img class="imagenEquipo" src="../..//utils/img/error404.png"
			alt="Logo de Error404">
	</footer>
</body>

</html>