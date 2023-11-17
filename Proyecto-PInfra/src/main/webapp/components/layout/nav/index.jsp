<%@page import="com.servidor.entidades.Usuario"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%
HttpSession sessionActual = request.getSession(false); // No crear una nueva sesión si no existe
Usuario usuarioLogueado = (Usuario) sessionActual
		.getAttribute("usuarioLogueado");
%>
<header class="encabezado">
	<a class="btnHome" href="/Proyecto-PInfra/index.jsp"> <img
		class="imagenUtec" src="/Proyecto-PInfra/utils/img/utec.png"
		alt="Logo de UTEC">
	</a>
	<nav class="menu">
		<%
		if (usuarioLogueado != null) {
		%>

		<ul class="links">
			<li><a href="/Proyecto-PInfra/pages/gestion/index.jsp">Gestión
					de usuarios</a></li>
			<li><a href="#">Confirmación de usuarios (2)</a></li>
			<li><a href="#">Itrs</a></li>
		</ul>

		<%
		}
		%>
	</nav>
	<%
	if (usuarioLogueado != null) {
	%>
	<div class="btnSesion">
		<p style="font-size: 12px; font-weight: bold;"><%=usuarioLogueado.getNombreCompleto()%></p>
		<a class="btnCerrarSesion" href="/Proyecto-PInfra/CerrarSesion"><svg
				xmlns="http://www.w3.org/2000/svg"
				class="icon icon-tabler icon-tabler-logout" width="20" height="20"
				viewBox="0 0 24 24" stroke-width="2" stroke="currentColor"
				fill="none" stroke-linecap="round" stroke-linejoin="round">
						<path stroke="none" d="M0 0h24v24H0z" fill="none" />
						<path
					d="M14 8v-2a2 2 0 0 0 -2 -2h-7a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2 -2v-2" />
						<path d="M9 12h12l-3 -3" />
						<path d="M18 15l3 -3" /></svg></a>
	</div>
	<%
	} else {
	%>
	<div class="btnSesion">
		<a href="/Proyecto-PInfra/pages/login/index.jsp">Iniciar sesión</a> <a
			href="/Proyecto-PInfra/pages/registro/index.jsp">Registrarme</a>
	</div>
	<%
	}
	%>

</header>