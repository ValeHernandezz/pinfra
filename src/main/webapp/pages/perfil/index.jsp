<%@page import="com.cliente.services.ServiceJWT"%>
<%@page import="com.cliente.services.ServiceArea"%>
<%@page import="com.servidor.entidades.Area"%>
<%@page import="com.cliente.contexto.helpers.Buscar"%>
<%@page import="com.cliente.services.ServiceRol"%>
<%@page import="com.servidor.entidades.Rol"%>
<%@page import="com.cliente.services.ServiceUbicacion"%>
<%@page import="com.servidor.entidades.Departamento"%>
<%@page import="com.cliente.services.ServiceItr"%>
<%@page import="com.servidor.entidades.Itr"%>
<%@page import="com.cliente.services.ServiceGenero"%>
<%@page import="com.servidor.entidades.Genero"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Usuario usuarioLogueado = (Usuario) request.getSession().getAttribute("usuarioLogueado");
ServiceJWT.comprobarSesion(request, response, "Perfil");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/style.css">
<link rel="stylesheet" type="text/css"
	href="/Proyecto-PInfra/pages/registro/style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Visualiza tus datos y editalos.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico"
	href="/Proyecto-PInfra/utils/img/faviconapp.ico">
<title>Perfil</title>
</head>

<body>
	<!-- Modal de confirmación de acción -->
	<jsp:include page="/components/modal/index.jsp" />

	<div class="app">
		<!-- Encabezado de la página -->
		<jsp:include page="/components/layout/nav/index.jsp" />

		<!-- Contenido de la página -->
		<main class="contenido">

			<section class="registroSeccion">
				<div class="registroContenido">
					<h2 class="tituloRegistro">Perfil</h2>
					<form class="formularioLogin"
						action="/Proyecto-PInfra/SvEditarPerfil" method="POST">
						<div class="formularioContenido">

							<label>Nombres <input type="text" name="nombres"
								placeholder="Ingrese sus nombres..."
								value="<%=usuarioLogueado.getNombres()%>">
								<%
 if (request.getSession().getAttribute("errorNombre") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorNombre")%></span>
								<%
								}
								%>
							</label> <label>Apellidos <input type="text" name="apellidos"
								placeholder="Ingrese sus apellidos..."
								value="<%=usuarioLogueado.getApellidos()%>">
								<%
 if (request.getSession().getAttribute("errorApellido") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;">
									<%=request.getSession().getAttribute("errorApellido")%>
							</span> <%
 }
 %>
							</label> <label>Cédula <input type="number" name="cedula"
								placeholder="Ingrese su cédula..."
								value="<%=usuarioLogueado.getDocumento()%>" disabled>
							<%
 if (request.getSession().getAttribute("errorCedula") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorCedula")%></span>
								<%
								}
								%>
							</label> <label>Teléfono <input type="number" name="telefono"
								placeholder="Ingrese su teléfono..."
								value="<%=usuarioLogueado.getTelefono()%>">
								<%
 if (request.getSession().getAttribute("errorTelefono") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorTelefono")%></span>
								<%
								}
								%>								
							</label> <label>Mail Personal <input type="text"
								name="mailPersonal" placeholder="Ingrese su mail personal..."
								value="<%=usuarioLogueado.getMailPersonal()%>">
								<%
 if (request.getSession().getAttribute("errorMailPersonal") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorMailPersonal")%></span>
								<%
								}
								%>
							</label> <label>Mail Institucional <input type="text"
								name="mailInstitucional"
								placeholder="Ingrese su mail institucional..."
								value="<%=usuarioLogueado.getMailInstitucional()%>" disabled>
							</label> <label>Contraseña <input type="password" name="clave"
								placeholder="Ingrese su contraseña..."
								value="<%=usuarioLogueado.getClave()%>" /></label> <label>Fecha
								de Nacimiento <input type="date" name="fechaNacimiento"
								value="<%=usuarioLogueado.getFechaNacimiento()%>"> 
								<%
 if (request.getSession().getAttribute("errorFechaNacimiento") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorFechaNacimiento")%></span>
								<%
								}
								%>
							</label> <label>Género <select name="genero">
									<option selected>Selecciona un género</option>
									<%
									for (Genero oGenero : ServiceGenero.listarGeneros()) {
										// Verifica si el Género actual es igual al Género de oUsuarioAEditar
										String opcionSeleccionada = (usuarioLogueado != null
										&& oGenero.getNombre().equals(usuarioLogueado.getGenero().getNombre())) ? "selected" : "";
									%>

									<option value="<%=oGenero.getNombre()%>"
										<%=opcionSeleccionada%>><%=oGenero.getNombre()%></option>

									<%
									}
									%>
							</select>
							<%
 if (request.getSession().getAttribute("errorGenero") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorGenero")%></span>
								<%
								}
								%>
							</label> <label>ITR <select name="itr">
									<option selected>Selecciona un ITR</option>
									<%
									for (Itr oItr : ServiceItr.listarItrs()) {
										// Verifica si el ITR actual es igual al ITR de oUsuarioAEditar
										String opcionSeleccionada = (usuarioLogueado != null
										&& oItr.getNombre().equals(usuarioLogueado.getItr().getNombre())) ? "selected" : "";
									%>

									<option value="<%=oItr.getNombre()%>" <%=opcionSeleccionada%>><%=oItr.getNombre()%></option>

									<%
									}
									%>
							</select>
							<%
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
										// Verifica si el Departamento actual es igual al Departamento de oUsuarioAEditar
										String opcionSeleccionada = (usuarioLogueado != null
										&& oDepartamento.getNombre().equals(usuarioLogueado.getDepartamento().getNombre())) ? "selected" : "";
									%>
									<option value="<%=oDepartamento.getNombre()%>"
										<%=opcionSeleccionada%>><%=oDepartamento.getNombre()%></option>
									<%
									}
									%>
							</select><%
 if (request.getSession().getAttribute("errorDepartamento") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorDepartamento")%></span>
								<%
								}
								%>
							</label> <label>Localidad <select name="localidad"
								id="localidadSelect" disabled>
									<option selected>Selecciona una localidad</option>
							</select><%
 if (request.getSession().getAttribute("errorLocalidad") != null) {
 %> <span style="max-width: 300px; font-size: 10px; color: red;"><%=request.getSession().getAttribute("errorLocalidad")%></span>
								<%
								}
								%>
							</label> <label>Rol <select name="rol" id="rolSelect"
								onchange="mostrarCampos()" disabled>
									<option selected>Seleccione su rol</option>
									<%
									for (Rol oRol : ServiceRol.listarRoles()) {
										// Verifica si el Rol actual es igual al Rol de oUsuarioAEditar
										String opcionSeleccionada = (usuarioLogueado != null
										&& oRol.getDescripcion().equals(usuarioLogueado.getRol().getDescripcion())) ? "selected" : "";
									%>

									<option value="<%=oRol.getDescripcion()%>"
										<%=opcionSeleccionada%>><%=oRol.getDescripcion()%></option>


									<%
									}
									%>
							</select>
							</label> <label id="areaLabel" style="display: none;">Área <select
								name="area" disabled>
									<option selected>Seleccione su área</option>
									<%
									if (usuarioLogueado.getRol().getDescripcion().equals("Tutor")
											|| usuarioLogueado.getRol().getDescripcion().equals("Encargado")) {
										String opcionDeUsuario = Buscar.tutorFiltro(usuarioLogueado.getDocumento().toString(), "Documento").get(0).getArea()
										.getDescripcion();
										for (Area oArea : ServiceArea.listarAreas()) {

											// Verifica si el Area actual es igual al Area de oUsuarioAEditar
											String opcionSeleccionada = (usuarioLogueado != null && oArea.getDescripcion().equals(opcionDeUsuario)
											? "selected"
											: "");
									%>
									<option value="<%=oArea.getDescripcion()%>"
										<%=opcionSeleccionada%>><%=oArea.getDescripcion()%></option>
									<%
									}
									%>
									<input type="hidden" name="areaOculto"
									value="<%=opcionDeUsuario%>">
									<%
									}
									%>
							</select>
							</label> <label id="semestreLabel" style="display: none;">Semestre
								<select name="semestre" disabled>
									<option selected>Seleccione su semestre</option>

									<%
									if (usuarioLogueado.getRol().getDescripcion().equals("Estudiante")) {
										int opcionUsuario = Buscar.estudianteFiltro(usuarioLogueado.getDocumento().toString(), "Documento").get(0)
										.getSemestre().intValue();
										for (int i = 1; i <= 8; i++) {
											String opcionSeleccionada = (usuarioLogueado != null && i == opcionUsuario) ? "selected" : "";
									%>
									<option value="<%=i%>" <%=opcionSeleccionada%>><%=i%></option>
									<%
									}
									%>
									<input type="hidden" name="semestreOculto"
									value="<%=opcionUsuario%>">
									<%
									}
									%>

							</select>
							</label> <label id="generacionLabel" style="display: none;">Generación
								<select name="generacion" disabled>
									<option selected>Seleccione su generación</option>

									<%
									if (usuarioLogueado.getRol().getDescripcion().equals("Estudiante")) {
										int opcionUsuario = Integer.parseInt(
										Buscar.estudianteFiltro(usuarioLogueado.getDocumento().toString(), "Documento").get(0).getGeneracion());
										for (int i = 2016; i <= 2023; i++) {
											String opcionSeleccionada = (usuarioLogueado != null && i == opcionUsuario) ? "selected" : "";
									%>
									<option value="<%=i%>" <%=opcionSeleccionada%>><%=i%></option>
									<%
									}
									%>
									<input type="hidden" name="generacionOculto"
									value="<%=opcionUsuario%>">
									<%
									}
									%>

							</select>
							</label>
						</div>

						<div class="btnContenido">
							<button type="submit">Editar</button>
						</div>
					</form>

				</div>
			</section>
		</main>

		<!-- Pie de página -->
		<footer class="pieDePagina">
			<p>Creado por</p>
			<img class="imagenEquipo"
				src="/Proyecto-PInfra/utils/img/error404.png" alt="Logo de Error404">
		</footer>
	</div>
</body>
<script src="/Proyecto-PInfra/utils/script/localidades.js"></script>
<script src="/Proyecto-PInfra/utils/script/mostrarCampos.js"></script>
<script
	src="/Proyecto-PInfra/utils/script/cargarLocalidadSeleccionada.js"></script>
<script>

document.addEventListener("DOMContentLoaded", function() {
    mostrarCampos();
    cargarLocalidades();
    cargarLocalidadSeleccionada('<%=usuarioLogueado.getLocalidad().getNombre()%>');
					});
</script>
</html>