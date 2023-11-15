<%@page import="com.servidor.entidades.Usuario"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.cliente.contexto.utils.CargarDatos"%>
<%
CargarDatos.empezar();
%>
<%
HttpSession sessionActual = request.getSession(false); // No crear una nueva sesión si no existe
Usuario usuarioLogueado = (Usuario) sessionActual
		.getAttribute("usuarioLogueado");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Solicita tus constancias y mantente al día.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico" href="/Proyecto-PInfra/utils/img/faviconapp.ico">
<title>Gestión de constancias UTEC</title>
</head>

<body>
	<div class="app">
		<!-- Encabezado de la página -->
		<header class="encabezado">
			<a class="btnHome" href="/Proyecto-PInfra/index.jsp"><img class="imagenUtec"
				src="/Proyecto-PInfra/utils/img/utec.png" alt="Logo de UTEC"> </a>

			<nav class="menu">
				<%
				if (usuarioLogueado != null) {
				%>

				<ul class="links">
					<li><a href="#">Cursos</a></li>
					<li><a href="#">Itrs</a></li>
					<li><a href="/Proyecto-PInfra/pages/gestionDeUsuarios/index.jsp">Gestión
							de usuarios</a></li>
				</ul>

				<%
				}
				%>
			</nav>
			<%
			if (usuarioLogueado != null) {
			%>
			<!-- Mostrar nombre de usuario y botón de cerrar sesión -->
			<div class="btnSesion">
				<p style="font-size: 12px; font-weight: bold;"><%=usuarioLogueado.getNombreUsuario()%></p>
				<a href="/Proyecto-PInfra/CerrarSesion">Cerrar sesión</a>
			</div>
			<%
			} else {
			%>
			<!-- Mostrar enlaces de inicio de sesión y registro -->
			<div class="btnSesion">
				<a href="/Proyecto-PInfra/pages/login/index.jsp">Iniciar sesión</a>
				<a href="/Proyecto-PInfra/pages/registro/index.jsp">Registrarme</a>
			</div>
			<%
			}
			%>

		</header>

		<!-- Contenido de la página -->
		<main class="contenido">

			<section class="inicioContenido">
				<div class="informacion">
					<div class="informacionPrincipal">
						<h1>Tu acceso rápido y sencillo a documentos académicos</h1>
						<p>Nuestra plataforma está diseñada para simplificar tus
							trámites académicos. Olvídate de las complicaciones y papeleos.
							Aquí, te ofrecemos la manera más fácil y rápida de obtener tus
							constancias de prueba, transporte, créditos, exámenes y más.</p>
						<div>
							<a class="btnSaberMas" href="#">Saber más</a>
						</div>
					</div>
					<div class="estadistica">
						<div class="estadisticaItem">
							<span>3.455</span>
							<p>estudiantes matriculados en 2022</p>
						</div>
						<div class="estadisticaItem">
							<span>84% </span>
							<p>es la primera generación universitaria en su familia</p>
						</div>
						<div class="estadisticaItem">
							<span>100%</span>
							<p>de egresados con certificación de inglés</p>
						</div>
					</div>
				</div>

				<div>
					<img class="imageninicio" src="/Proyecto-PInfra/utils/img/imagenInicio.png"
						alt="Imagen de estudiantes">
				</div>
			</section>
		</main>

		<!-- Pie de página -->
		<footer class="pieDePagina">
			<p>Creado por</p>
			<img class="imagenEquipo" src="/Proyecto-PInfra/utils/img/error404.png"
				alt="Logo de Error404">
		</footer>
	</div>
</body>

</html>