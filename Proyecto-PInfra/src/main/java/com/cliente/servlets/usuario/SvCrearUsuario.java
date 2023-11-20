package com.cliente.servlets.usuario;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cliente.contexto.Fabrica;
import com.cliente.contexto.helpers.Crear;
import com.cliente.contexto.validaciones.ValidacionComboBoxes;
import com.cliente.contexto.validaciones.ValidacionUsuario;
import com.cliente.services.ServiceArea;
import com.cliente.services.ServiceGenero;
import com.cliente.services.ServiceItr;
import com.cliente.services.ServiceRol;
import com.cliente.services.ServiceUbicacion;
import com.servidor.entidades.Analista;
import com.servidor.entidades.Departamento;
import com.servidor.entidades.Estudiante;
import com.servidor.entidades.Genero;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Localidad;
import com.servidor.entidades.Rol;
import com.servidor.entidades.Tutor;
import com.servidor.entidades.Usuario;

@WebServlet(name = "ServletCrearUsuario", urlPatterns = "/SvCrearUsuario")
public class SvCrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Fabrica.limpiarMensajesDeError(request.getSession());
		
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		String cedula = request.getParameter("cedula");
		String telefono = request.getParameter("telefono");
		String mailPersonal = request.getParameter("mailPersonal");
		String mailInstitucional = request.getParameter("mailInstitucional");
		String clave = request.getParameter("clave");
		String fechaNacimiento = (String) request.getParameter("fechaNacimiento");
		String generoTexto = request.getParameter("genero");
		String itrTexto = request.getParameter("itr");
		String departamentoTexto = request.getParameter("departamento");
		String localidadTexto = request.getParameter("localidad");
		String rolTexto = request.getParameter("rol");
		String semestreTexto = request.getParameter("semestre");
		String generacionTexto = request.getParameter("generacion");
		String areaTexto = request.getParameter("area");
		
		String nombres2[] = nombres.split(" ");
		String apellidos2[] = apellidos.split(" ");

		String primerNombre = nombres2.length > 0 ? nombres2[0] : "";
		String segundoNombre = nombres2.length > 1 ? nombres2[1] : "";

		String primerApellido = apellidos2.length > 0 ? apellidos2[0] : "";
		String segundoApellido = apellidos2.length > 1 ? apellidos2[1] : "";
		
		// Le ponemos un rol por defecto para que en la validación no se rompa
		String rolValidacion = rolTexto.equals("Seleccione su rol") ? "estudiante"
				: rolTexto.equals("Estudiante") ? "estudiante" : "funcionario";

		boolean validacionInputs = ValidacionUsuario.validarUnUsuario(clave, cedula,
				Fabrica.getFechaDesdeString(fechaNacimiento), mailInstitucional, mailPersonal, primerApellido,
				primerNombre, segundoApellido, segundoNombre, telefono, rolValidacion, request.getSession());

		boolean validacionComboBoxes = ValidacionComboBoxes.validar(departamentoTexto, generoTexto, localidadTexto,
				itrTexto, generacionTexto, semestreTexto, areaTexto, rolTexto, request.getSession());

		if (!validacionInputs || !validacionComboBoxes) {
			response.sendRedirect("/Proyecto-PInfra/pages/registro/index.jsp");
			return;
		}

		Rol rol = ServiceRol.listarRolesFiltro(rolTexto).get(0);
		Departamento departamento = ServiceUbicacion.listarDepartamentosFiltro(departamentoTexto).get(0);
		Genero genero = ServiceGenero.listarGenerosFiltro(generoTexto).get(0);
		Itr itr = ServiceItr.listarItrsFiltro(itrTexto).get(0);
		Localidad localidad = ServiceUbicacion.listarLocalidadesFiltro(localidadTexto).get(0);
		String nombreUsuario = Fabrica.generarNombreUsuario(mailInstitucional);
		BigDecimal documento = new BigDecimal(cedula);

		Usuario oUsuarioNuevo = new Usuario(clave, documento, Fabrica.getFechaDesdeString(fechaNacimiento),
				mailInstitucional, mailPersonal, nombreUsuario, primerApellido, primerNombre, segundoApellido,
				segundoNombre, telefono, "S", "N", departamento, genero, itr, localidad, rol);

		if (rolTexto.equals("Analista")) {
			boolean oAnalistaCreado = Crear.usuario(oUsuarioNuevo, new Analista());

			if (!oAnalistaCreado) {
				response.sendRedirect("/Proyecto-PInfra/pages/registro/index.jsp");
				return;
			}
		}

		if (rolTexto.equals("Tutor") || rolTexto.equals("Encargado")) {
			boolean oTutorCreado = Crear.usuario(oUsuarioNuevo,
					new Tutor(ServiceArea.listarAreasFiltro(areaTexto).get(0)));

			if (!oTutorCreado) {
				response.sendRedirect("/Proyecto-PInfra/pages/registro/index.jsp");
				return;
			}
		}

		if (rolTexto.equals("Estudiante")) {
			boolean oEstudianteCreado = Crear.usuario(oUsuarioNuevo,
					new Estudiante(generacionTexto, new BigDecimal(semestreTexto)));

			if (!oEstudianteCreado) {
				response.sendRedirect("/Proyecto-PInfra/pages/registro/index.jsp");
				return;
			}
		}
		
		response.sendRedirect("index.jsp");
	}

}
