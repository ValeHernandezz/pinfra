<%@page import="com.cliente.services.ServiceGenero"%>
<%@page import="com.servidor.entidades.Genero"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.cliente.contexto.helpers.Buscar"%>
<%@page import="com.servidor.entidades.Area"%>
<%@page import="com.cliente.services.ServiceArea"%>
<%@page import="com.cliente.services.ServiceRol"%>
<%@page import="com.servidor.entidades.Rol"%>
<%@page import="com.cliente.services.ServiceUbicacion"%>
<%@page import="com.servidor.entidades.Departamento"%>
<%@page import="com.cliente.services.ServiceItr"%>
<%@page import="com.servidor.entidades.Itr"%>
<%@page import="com.servidor.entidades.Usuario"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
HttpSession sessionActual = request.getSession(false); // No crear una nueva sesión si no existe
Usuario usuarioLogueado = (Usuario) sessionActual.getAttribute("usuarioLogueado");
Usuario oUsuarioAEditar = (Usuario) sessionActual.getAttribute("oUsuarioAEditar");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/Proyecto-PInfra/style.css">
<link rel="stylesheet" type="text/css"
	href="/Proyecto-PInfra/pages/registro/style.css">
<meta name="description"
	content="Página de gestión de constancias de UTEC. Solicita tus constancias y mantente al día.">
<meta name="viewport" content="width=device-width">
<link rel="icon" type="image/ico"
	href="/Proyecto-PInfra/utils/img/faviconapp.ico">
<title>Editar usuario</title>
</head>

<body>
	<div class="app">
		<!-- Encabezado de la página -->
		<jsp:include page="/components/layout/nav/index.jsp" />

		<!-- Contenido de la página -->
		<main class="contenido">

			<section class="registroSeccion">
				<div class="registroContenido">
					<h2 class="tituloRegistro">Editar usuario</h2>
					<form class="formularioLogin"
						action="/Proyecto-PInfra/SvEditarUsuario" method="POST">
						<div class="formularioContenido">
							<label>Nombres <input type="text" name="nombres"
								placeholder="Ingrese sus nombres..."
								value="<%=oUsuarioAEditar.getNombres()%>">
							</label> <label>Apellidos <input type="text" name="apellidos"
								placeholder="Ingrese sus apellidos..."
								value="<%=oUsuarioAEditar.getApellidos()%>">
							</label> <label>Cédula <input type="number" name="cedula"
								placeholder="Ingrese su cédula..."
								value="<%=oUsuarioAEditar.getDocumento()%>" disabled>
							</label> <label>Teléfono <input type="number" name="telefono"
								placeholder="Ingrese su teléfono..."
								value="<%=oUsuarioAEditar.getTelefono()%>">
							</label> <label>Mail Personal <input type="text"
								name="mailPersonal" placeholder="Ingrese su mail personal..."
								value="<%=oUsuarioAEditar.getMailPersonal()%>">
							</label> <label>Mail Institucional <input type="text"
								name="mailInstitucional"
								placeholder="Ingrese su mail institucional..."
								value="<%=oUsuarioAEditar.getMailInstitucional()%>" disabled>
							</label> <label>Fecha de Nacimiento <input type="text"
								name="fechaNacimiento"
								placeholder="Ingrese su fecha de nacimiento..."
								value="<%=oUsuarioAEditar.getFechaNacimiento()%>">
							</label> <label>Género <select name="genero">
									<option selected>Selecciona un género</option>
									<%
									for (Genero oGenero : ServiceGenero.listarGeneros()) {
										// Verifica si el Género actual es igual al Género de oUsuarioAEditar
										String opcionSeleccionada = (oUsuarioAEditar != null
										&& oGenero.getNombre().equals(oUsuarioAEditar.getGenero().getNombre())) ? "selected" : "";
									%>

									<option value="<%=oGenero.getNombre()%>"
										<%=opcionSeleccionada%>><%=oGenero.getNombre()%></option>

									<%
									}
									%>
							</select>
							</label> <label>ITR <select name="itr">
									<option selected>Selecciona un ITR</option>
									<%
									for (Itr oItr : ServiceItr.listarItrs()) {
										// Verifica si el ITR actual es igual al ITR de oUsuarioAEditar
										String opcionSeleccionada = (oUsuarioAEditar != null
										&& oItr.getNombre().equals(oUsuarioAEditar.getItr().getNombre())) ? "selected" : "";
									%>

									<option value="<%=oItr.getNombre()%>" <%=opcionSeleccionada%>><%=oItr.getNombre()%></option>

									<%
									}
									%>
							</select>
							</label> <label>Departamento <select name="departamento"
								id="departamentoSelect" onchange="cargarLocalidades()">
									<option selected>Selecciona un departamento</option>
									<%
									for (Departamento oDepartamento : ServiceUbicacion.listarDepartamentos()) {
										// Verifica si el Departamento actual es igual al Departamento de oUsuarioAEditar
										String opcionSeleccionada = (oUsuarioAEditar != null
										&& oDepartamento.getNombre().equals(oUsuarioAEditar.getDepartamento().getNombre())) ? "selected" : "";
									%>
									<option value="<%=oDepartamento.getNombre()%>"
										<%=opcionSeleccionada%>><%=oDepartamento.getNombre()%></option>
									<%
									}
									%>
							</select>
							</label> <label>Localidad <select name="localidad"
								id="localidadSelect" disabled>
									<option selected>Selecciona una localidad</option>
							</select>
							</label> <label>Rol <select name="rol" id="rolSelect"
								onchange="mostrarCampos()">
									<option selected>Seleccione su rol</option>
									<%
									for (Rol oRol : ServiceRol.listarRoles()) {
										// Verifica si el Rol actual es igual al Rol de oUsuarioAEditar
										String opcionSeleccionada = (oUsuarioAEditar != null
										&& oRol.getDescripcion().equals(oUsuarioAEditar.getRol().getDescripcion())) ? "selected" : "";
									%>

									<option value="<%=oRol.getDescripcion()%>"
										<%=opcionSeleccionada%>><%=oRol.getDescripcion()%></option>


									<%
									}
									%>
							</select>
							</label> <label id="areaLabel" style="display: none;">Área <select
								name="area">
									<option selected>Seleccione su área</option>
									<%
									if (oUsuarioAEditar.getRol().getDescripcion().equals("Tutor")
											|| oUsuarioAEditar.getRol().getDescripcion().equals("Encargado")) {
										String opcionDeUsuario = Buscar.tutorFiltro(oUsuarioAEditar.getDocumento().toString(), "Documento").get(0).getArea()
										.getDescripcion();
										for (Area oArea : ServiceArea.listarAreas()) {

											// Verifica si el Area actual es igual al Area de oUsuarioAEditar
											String opcionSeleccionada = (oUsuarioAEditar != null && oArea.getDescripcion().equals(opcionDeUsuario)
											? "selected"
											: "");
									%>

									<option value="<%=oArea.getDescripcion()%>"
										<%=opcionSeleccionada%>><%=oArea.getDescripcion()%></option>
									<%
									}
									}
									%>
							</select>
							</label> <label id="semestreLabel" style="display: none;">Semestre
								<select name="semestre">
									<option selected>Seleccione su semestre</option>

									<%
									if (oUsuarioAEditar.getRol().getDescripcion().equals("Estudiante")) {
										int opcionUsuario = Buscar.estudianteFiltro(oUsuarioAEditar.getDocumento().toString(), "Documento").get(0)
										.getSemestre().intValue();
										for (int i = 1; i <= 8; i++) {
											String opcionSeleccionada = (oUsuarioAEditar != null && i == opcionUsuario) ? "selected" : "";
									%>
									<option value="<%=i%>" <%=opcionSeleccionada%>><%=i%></option>
									<%
									}
									}
									%>

							</select>
							</label> <label id="generacionLabel" style="display: none;">Generación
								<select name="generacion">
									<option selected>Seleccione su generación</option>

									<%
									if (oUsuarioAEditar.getRol().getDescripcion().equals("Estudiante")) {
										int opcionUsuario = Integer.parseInt(
										Buscar.estudianteFiltro(oUsuarioAEditar.getDocumento().toString(), "Documento").get(0).getGeneracion());
										for (int i = 2016; i <= 2023; i++) {
											String opcionSeleccionada = (oUsuarioAEditar != null && i == opcionUsuario) ? "selected" : "";
									%>
									<option value="<%=i%>" <%=opcionSeleccionada%>><%=i%></option>
									<%
									}
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
		<jsp:include page="/components/layout/footer/index.jsp" />
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
    cargarLocalidadSeleccionada('<%=oUsuarioAEditar.getLocalidad().getNombre()%>'); 
 });
    		
</script>
</html>