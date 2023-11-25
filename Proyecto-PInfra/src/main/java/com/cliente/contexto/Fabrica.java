package com.cliente.contexto;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cliente.services.ServiceAnalista;
import com.cliente.services.ServiceEstudiante;
import com.cliente.services.ServiceRol;
import com.cliente.services.ServiceTutor;
import com.cliente.services.ServiceUsuario;
import com.servidor.entidades.Analista;
import com.servidor.entidades.Estudiante;
import com.servidor.entidades.Tutor;
import com.servidor.entidades.Usuario;

public class Fabrica {

	// Atributos de apoyo para uso global de la app
	private static Usuario oUsuarioLogueado = new Usuario();
	private static Map<String, String> diccionarioCampo = new HashMap<>();

	private static ArrayList<Analista> listaDeAnalistas = new ArrayList<Analista>();
	private static ArrayList<Estudiante> listaDeEstudiantes = new ArrayList<Estudiante>();
	private static ArrayList<Tutor> listaDeTutores = new ArrayList<Tutor>();

	// Getters y setter de los atributos globales
	public static ArrayList<Analista> getListaDeAnalistas() {
		return listaDeAnalistas;
	}

	public static Usuario getoUsuarioLogueado() {
		return oUsuarioLogueado;
	}

	public static void setoUsuarioLogueado(Usuario oUsuarioLogueado) {
		Fabrica.oUsuarioLogueado = oUsuarioLogueado;

	}

	public static void setListaDeAnalistas(ArrayList<Analista> listaDeAnalistas) {
		Fabrica.listaDeAnalistas = listaDeAnalistas;
	}

	public static ArrayList<Estudiante> getListaDeEstudiantes() {
		return listaDeEstudiantes;
	}

	public static void setListaDeEstudiantes(ArrayList<Estudiante> listaDeEstudiantes) {
		Fabrica.listaDeEstudiantes = listaDeEstudiantes;
	}

	public static ArrayList<Tutor> getListaDeTutroes() {
		return listaDeTutores;
	}

	public static void setListaDeTutroes(ArrayList<Tutor> listaDeTutroes) {
		Fabrica.listaDeTutores = listaDeTutroes;
	}

	public static Map<String, String> getDiccionarioCampo() {
		return diccionarioCampo;
	}

	public static void setDiccionarioCampo(Map<String, String> diccionarioCampo) {
		Fabrica.diccionarioCampo = diccionarioCampo;
	}

	public static ArrayList<Tutor> getListaDeTutores() {
		return listaDeTutores;
	}

	public static void setListaDeTutores(ArrayList<Tutor> listaDeTutores) {
		Fabrica.listaDeTutores = listaDeTutores;
	}

	// Métodos de apoyo
	public static void cargarDiccionario() {
		diccionarioCampo.put("Nombre Completo", "primerNombre" + " " + "primerApellido");
		diccionarioCampo.put("Nombres", "u.primerNombre");
		diccionarioCampo.put("Apellidos", "u.primerApellido");
		diccionarioCampo.put("Documento", "CAST(u.documento AS string)");
		diccionarioCampo.put("Rol", "u.rol.idRol");
		diccionarioCampo.put("Confirmar", "u.confirmado");
		diccionarioCampo.put("Activo", "u.activo");
		diccionarioCampo.put("Nombre de Usuario", "u.nombreUsuario");
		diccionarioCampo.put("Mail Personal", "u.mailPersonal");
	}

	public static void limpiarListas() {
		listaDeAnalistas.clear();
		listaDeEstudiantes.clear();
		listaDeTutores.clear();
	}

	public static void cargarListas() {
		limpiarListas();
		setListaDeAnalistas(ServiceAnalista.listarAnalistas());
		setListaDeEstudiantes(ServiceEstudiante.listarEstudiantes());
		setListaDeTutroes(ServiceTutor.listarTutores());
	}

	// Metodos para unir servicios o centralizar acciones que pueden escalar
	public static ArrayList<Usuario> buscarUsuarioPorCampoYFiltro(String filtro, String campo) {
		if (diccionarioCampo.size() == 0) {
			cargarDiccionario();
		}
		try {
			if (campo.equals("Nombre Completo")) {
				return buscarUsuarioPorNombreApellido(filtro, campo);
			}
			String valor = diccionarioCampo.get(campo);
			if (campo.equals("Rol")) {
				filtro = String.valueOf(ServiceRol.listarRolesFiltro(filtro).get(0).getIdRol());
			}
			return ServiceUsuario.buscarUsuarioPorCampoYFiltro(filtro, valor);
		} catch (Exception e) {
			return new ArrayList<Usuario>();
		}
	}

	public static ArrayList<Usuario> buscarUsuarioPorNombreApellido(String filtro, String campo) {
		if (diccionarioCampo.size() == 0) {
			cargarDiccionario();
		}

		String filtro1 = null;
		String filtro2 = null;

		try {
			String valor = diccionarioCampo.get(campo);

			String[] partes = filtro.split(" ");
			filtro1 = partes[0]; // Nombre
			filtro2 = partes[1]; // Apellido
			return ServiceUsuario.listarUsuariosPorNombreApellido(filtro1, filtro2, valor);
		} catch (Exception e) {
			return null;
		}

	}

	public static String generarNombreUsuario(String emailInstitucional) {

		String[] partes = emailInstitucional.split("@");
		String nombreDeUsuario = partes[0];
		return nombreDeUsuario;

	}

	public static Date getFechaDesdeString(String fechaString) {

		if (fechaString.equals("") || fechaString == null) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		LocalDate localDate = LocalDate.parse(fechaString, formatter);

		Date fechaNacimiento = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return fechaNacimiento;
	}

	public static void limpiarMensajesDeError(HttpSession sesion) {
		sesion.removeAttribute("errorNombre");
		sesion.removeAttribute("errorApellido");
		sesion.removeAttribute("errorCedula");
		sesion.removeAttribute("errorMailPersonal");
		sesion.removeAttribute("errorMailInstitucional");
		sesion.removeAttribute("errorTelefono");
		sesion.removeAttribute("errorClave");
		sesion.removeAttribute("errorFechaNacimiento");
		sesion.removeAttribute("errorRol");
		sesion.removeAttribute("errorArea");
		sesion.removeAttribute("errorGeneracion");
		sesion.removeAttribute("errorSemestre");
		sesion.removeAttribute("errorDepartamento");
		sesion.removeAttribute("errorGenero");
		sesion.removeAttribute("errorLocalidad");
		sesion.removeAttribute("errorItr");
		sesion.removeAttribute("errorNombreItr");
		sesion.removeAttribute("errorDepartamentoItr");
	}

	public static String getCantidadSinConfirmar() {
		if (ServiceUsuario.listarUsuariosSinConfirmar("N").size() == 0
				|| ServiceUsuario.listarUsuariosSinConfirmar("N") == null) {
			return "";
		}
		return String.valueOf(ServiceUsuario.listarUsuariosSinConfirmar("N").size());
	}

	public static void generarModal(HttpServletRequest request, String urlBtnSi, String tituloModal,
			String descripcionModal, String metodoModal) {
		request.getSession().setAttribute("mostrarModal", true);
		request.getSession().setAttribute("urlBtnSiModal", urlBtnSi);
		request.getSession().setAttribute("tituloModal", tituloModal);
		request.getSession().setAttribute("descripcionModal", descripcionModal);
		request.getSession().setAttribute("metodoModal", metodoModal);
	}
}
