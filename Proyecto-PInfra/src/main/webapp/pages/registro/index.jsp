<%@page import="com.cliente.services.ServiceArea"%>
<%@page import="com.servidor.entidades.Area"%>
<%@page import="com.cliente.services.ServiceRol"%>
<%@page import="com.servidor.entidades.Rol"%>
<%@page import="com.cliente.services.ServiceItr"%>
<%@page import="com.cliente.services.ServiceUbicacion"%>
<%@page import="com.servidor.entidades.Itr"%>
<%@page import="com.servidor.entidades.Departamento"%>
<%@page import="com.servidor.entidades.Localidad"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/style.css">
<link rel="stylesheet" type="text/css"
	href="/Proyecto-PInfra/pages/registro/style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Inicia sesión y ponte al día de tus constanciass.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico"
	href="/Proyecto-PInfra/utils/img/faviconapp.ico">
<title>Registro</title>
</head>

<body>
	<div class="app">
		<!-- Encabezado de la página -->
		<jsp:include page="/components/layout/nav/index.jsp" />

		<!-- Contenido de la página -->
		<main class="contenido">
			<!-- Modificar a gusto -->
			<section class="registroSeccion">
				<div class="registroContenido">
					<h2 class="tituloRegistro">Registro</h2>
					<form class="formularioLogin"
						action="/Proyecto-PInfra/SvCrearUsuario" method="post">
						<div class="formularioContenido">
							<label>Nombres <input type="text" name="nombres"
								placeholder="Ingrese sus nombres..."> <%
 if (request.getSession().getAttribute("errorNombre") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorNombre")%></span>
								<%
								}
								%>
							</label> <label>Apellidos <input type="text" name="apellidos"
								placeholder="Ingrese sus apellidos..."> <%
 if (request.getSession().getAttribute("errorApellido") != null) {
 %> <span
								style="max-width: 300px; font-size: 10px; color: red;"> <%=request.getSession().getAttribute("errorApellido")%>
							</span> <%
 }
 %>
							</label> <label>Cédula <input type="number" name="cedula"
								placeholder="Ingrese su cédula..."> <%
 if (request.getSession().getAttribute("errorCedula") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorCedula")%></span>
								<%
								}
								%>
							</label> <label>Teléfono <input type="number" name="telefono"
								placeholder="Ingrese su teléfono..."> <%
 if (request.getSession().getAttribute("errorTelefono") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorTelefono")%></span>
								<%
								}
								%>
							</label> <label>Mail Personal <input type="text"
								name="mailPersonal" placeholder="Ingrese su mail personal...">
								<%
								if (request.getSession().getAttribute("errorMailPersonal") != null) {
								%> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorMailPersonal")%></span>
								<%
								}
								%>
							</label> <label>Mail Institucional <input type="text"
								name="mailInstitucional"
								placeholder="Ingrese su mail institucional..."> <%
 if (request.getSession().getAttribute("errorMailInstitucional") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorMailInstitucional")%></span>
								<%
								}
								%>
							</label> <label>Contraseña <input type="password" name="clave"
								placeholder="Ingrese su contraseña..."> <%
 if (request.getSession().getAttribute("errorClave") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorClave")%></span>
								<%
								}
								%>
							</label> <label>Fecha de Nacimiento <input type="date" id="fecha"
								name="fechaNacimiento"> <%
 if (request.getSession().getAttribute("errorFechaNacimiento") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorFechaNacimiento")%></span>
								<%
								}
								%>
							</label> <label>Género <select name="genero">
									<option selected>Selecciona un género</option>
									<option value="Femenino">Femenino</option>
									<option value="Masculino">Masculino</option>
									<option value="Otro">Otro</option>
							</select> <%
 if (request.getSession().getAttribute("errorGenero") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorGenero")%></span>
								<%
								}
								%>
							</label> <label>ITR <select name="itr">
									<option selected>Selecciona un ITR</option>
									<%
									for (Itr oItr : ServiceItr.listarItrs()) {
									%>

									<option value="<%=oItr.getNombre()%>"><%=oItr.getNombre()%></option>

									<%
									}
									%>
							</select> <%
 if (request.getSession().getAttribute("errorItr") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorItr")%></span>
								<%
								}
								%>
							</label> <label>Departamento <select name="departamento"
								id="departamentoSelect" onchange="cargarLocalidades()">
									<option selected>Selecciona un departamento</option>
									<%
									for (Departamento oDepartamento : ServiceUbicacion.listarDepartamentos()) {
									%>
									<option value="<%=oDepartamento.getNombre()%>"><%=oDepartamento.getNombre()%></option>
									<%
									}
									%>
							</select> <%
 if (request.getSession().getAttribute("errorDepartamento") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorDepartamento")%></span>
								<%
								}
								%>
							</label> <label>Localidad <select name="localidad"
								id="localidadSelect" disabled>
									<option selected>Selecciona una localidad</option>
							</select> <%
 if (request.getSession().getAttribute("errorLocalidad") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorLocalidad")%></span>
								<%
								}
								%>
							</label> <label>Rol <select name="rol" id="rolSelect"
								onchange="mostrarCampos()">
									<option selected>Seleccione su rol</option>
									<%
									for (Rol oRol : ServiceRol.listarRoles()) {
									%>

									<option value="<%=oRol.getDescripcion()%>"><%=oRol.getDescripcion()%></option>


									<%
									}
									%>
							</select> <%
 if (request.getSession().getAttribute("errorRol") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorRol")%></span>
								<%
								}
								%>
							</label> <label id="areaLabel" style="display: none;">Área <select
								name="area">
									<option selected>Seleccione su área</option>
									<%
									for (Area oArea : ServiceArea.listarAreas()) {
									%>

									<option value="<%=oArea.getDescripcion()%>"><%=oArea.getDescripcion()%></option>


									<%
									}
									%>
							</select> <%
 if (request.getSession().getAttribute("errorArea") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorArea")%></span>
								<%
								}
								%>
							</label> <label id="semestreLabel" style="display: none;">Semestre
								<select name="semestre">
									<option selected>Seleccione su semestre</option>
									<%
									for (int i = 1; i <= 8; i++) {
									%>
									<option value=<%=i%>><%=i%></option>
									<%
									}
									%>
							</select> <%
 if (request.getSession().getAttribute("errorSemestre") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorSemestre")%></span>
								<%
								}
								%>
							</label> <label id="generacionLabel" style="display: none;">Generación
								<select name="generacion">
									<option selected>Seleccione su generación</option>
									<%
									for (int i = 2016; i <= 2023; i++) {
									%>
									<option value=<%=i%>><%=i%></option>
									<%
									}
									%>
							</select> <%
 if (request.getSession().getAttribute("errorGeneracion") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorGeneracion")%></span>
								<%
								}
								%>
							</label>

						</div>

						<div class="btnContenido">
							<button type="submit">Registrarme</button>
							<p class="loguearse">
								¿Ya tienes una cuenta? <a
									href="/Proyecto-PInfra/pages/login/index.jsp">Inicia sesión
									aquí</a>
							</p>
						</div>
					</form>

				</div>
			</section>
		</main>

		<!-- Pie de página -->
		<jsp:include page="/components/layout/footer/index.jsp" />
	</div>
</body>
<script src="/Proyecto-PInfra/utils/script/localidades.js"></script>
<script src="/Proyecto-PInfra/utils/script/mostrarCampos.js"></script>
</html>