package com.cliente.contexto.helpers;

import java.util.ArrayList;
import com.cliente.contexto.Fabrica;
import com.cliente.services.ServiceAnalista;
import com.cliente.services.ServiceItr;
import com.cliente.services.ServiceRol;
import com.cliente.services.ServiceUbicacion;
import com.cliente.services.ServiceUsuario;
import com.servidor.entidades.Analista;
import com.servidor.entidades.Estudiante;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Localidad;
import com.servidor.entidades.Tutor;
import com.servidor.entidades.Usuario;

public class Buscar {

	// USUARIO-------------------------------------------
	private static ArrayList<Usuario> buscarUsuarioPorNombreApellido(String filtro, String campo) {
		if (Fabrica.getDiccionarioCampo().size() == 0) {
			Fabrica.cargarDiccionario();
		}

		String filtro1 = null;
		String filtro2 = null;

		try {
			String valor = Fabrica.getDiccionarioCampo().get(campo);

			String[] partes = filtro.split(" ");
			filtro1 = partes[0]; // Nombre
			filtro2 = partes[1]; // Apellido
			return ServiceUsuario.listarUsuariosPorNombreApellido(filtro1, filtro2, valor);
		} catch (Exception e) {
			return null;
		}

	}

	private static ArrayList<Usuario> buscarUsuarioPorCampoYFiltro(String filtro, String campo) {
		if (Fabrica.getDiccionarioCampo().size() == 0) {
			Fabrica.cargarDiccionario();
		}
		try {
			if (campo.equals("Nombre Completo")) {
				return buscarUsuarioPorNombreApellido(filtro, campo);
			}

			String valor = Fabrica.getDiccionarioCampo().get(campo);

			if (campo.equals("Rol")) {
				filtro = String.valueOf(ServiceRol.listarRolesFiltro(filtro).get(0).getIdRol());
			}
			return ServiceUsuario.buscarUsuarioPorCampoYFiltro(filtro, valor);
		} catch (Exception e) {
			return null;
		}
	}

	private static ArrayList<Usuario> usuariosConfirmar(String filtro) {
		var lista = buscarUsuarioPorCampoYFiltro(filtro, "Confirmar");
		return lista;
	}

	private static ArrayList<Usuario> usuariosActivo(String filtro) {
		var lista = buscarUsuarioPorCampoYFiltro(filtro, "Activo");
		return lista;
	}
	// USUARIO-------------------------------------------

	// TUTOR-------------------------------------------
	public static ArrayList<Tutor> tutorPorRol(String filtro) {

		if (Fabrica.getListaDeTutores().size() == 0) {
			Fabrica.cargarListas();
		}

		try {
			ArrayList<Tutor> listaDeResultados = new ArrayList<Tutor>();

			for (Tutor aux : Fabrica.getListaDeTutores()) {
				if (aux.getUsuario().getRol().getDescripcion().equals(filtro)) {
					listaDeResultados.add(aux);
				}
			}

			return listaDeResultados;
		} catch (Exception e) {
			return new ArrayList<Tutor>();
		}
	}

	public static ArrayList<Tutor> tutoresSinConfirmar() {

		if (Fabrica.getListaDeTutores().size() == 0) {
			Fabrica.cargarListas();
		}

		ArrayList<Tutor> listaDeRespuesta = new ArrayList<Tutor>();

		for (var aux : Fabrica.getListaDeTutores()) {
			for (var aux2 : usuariosConfirmar("N")) {
				if (aux2.getDocumento().equals(aux.getUsuario().getDocumento())) {
					listaDeRespuesta.add(aux);
				}
			}

		}
		return listaDeRespuesta;
	}

	public static ArrayList<Tutor> tutorFiltro(String filtro, String campo) {
		System.out.println("------------- Hola desde tutorFiltro ---------------------------------------------");
		if (Fabrica.getListaDeTutores().size() == 0) {
			Fabrica.cargarListas();
		}

		ArrayList<Tutor> listaDeRespuesta = new ArrayList<Tutor>();

		for (var aux : Fabrica.getListaDeTutores()) {
			for (var aux2 : buscarUsuarioPorCampoYFiltro(filtro, campo)) {
				if (aux2.getDocumento().equals(aux.getUsuario().getDocumento())) {
					listaDeRespuesta.add(aux);
				}
			}
		}

		return listaDeRespuesta;
	}

	public static ArrayList<Tutor> listarTutoresActivos(String filtro) {
		if (Fabrica.getListaDeTutores().size() == 0) {
			Fabrica.cargarListas();
		}
		try {

			ArrayList<Tutor> listaDeRespuesta = new ArrayList<Tutor>();

			for (var tutorConDatos : Fabrica.getListaDeTutores()) {

				for (var usuarioActivo : buscarUsuarioPorCampoYFiltro(filtro, "Activo")) {
					if (usuarioActivo.getDocumento().equals(tutorConDatos.getUsuario().getDocumento())) {
						listaDeRespuesta.add(tutorConDatos);
					}
				}

			}
			return listaDeRespuesta;
		} catch (Exception e) {
			return new ArrayList<Tutor>();
		}
	}

	public static ArrayList<Tutor> tutoresITR(String itr) {
		if (Fabrica.getListaDeTutores().size() == 0) {
			Fabrica.cargarListas();
		}
		ArrayList<Tutor> listaDeRespuesta = new ArrayList<Tutor>();

		for (var tutorConDatos : Fabrica.getListaDeTutores()) {

			if (tutorConDatos.getUsuario().getItr().getNombre().toUpperCase().contains(itr.toUpperCase())) {
				listaDeRespuesta.add(tutorConDatos);
			}

		}

		return listaDeRespuesta;
	}
	// TUTOR-------------------------------------------

	// ESTUDIANTE----------------------------------------
	public static ArrayList<Estudiante> estudiantesSinConfirmar() {

		if (Fabrica.getListaDeEstudiantes().size() == 0) {
			Fabrica.cargarListas();
		}

		ArrayList<Estudiante> listaDeRespuesta = new ArrayList<Estudiante>();

		for (var aux : Fabrica.getListaDeEstudiantes()) {

			for (var aux2 : usuariosConfirmar("N")) {
				if (aux2.getDocumento().equals(aux.getUsuario().getDocumento())) {
					listaDeRespuesta.add(aux);
				}
			}

		}
		return listaDeRespuesta;
	}

	public static ArrayList<Estudiante> estudianteFiltro(String filtro, String campo) {

		if (Fabrica.getListaDeEstudiantes().size() == 0) {
			Fabrica.cargarListas();
		}

		ArrayList<Estudiante> listaDeRespuesta = new ArrayList<Estudiante>();

		for (var aux : Fabrica.getListaDeEstudiantes()) {

			for (var aux2 : buscarUsuarioPorCampoYFiltro(filtro, campo)) {
				if (aux2.getDocumento().equals(aux.getUsuario().getDocumento())) {
					listaDeRespuesta.add(aux);
				}
			}
		}

		return listaDeRespuesta;
	}

	public static ArrayList<Estudiante> estudiantesActivos(String filtro) {

		if (Fabrica.getListaDeEstudiantes().size() == 0) {
			Fabrica.cargarListas();
		}

		try {
			ArrayList<Estudiante> listaDeRespuesta = new ArrayList<Estudiante>();

			for (var tutorConDatos : Fabrica.getListaDeEstudiantes()) {

				for (var usuarioActivo : usuariosActivo(filtro)) {
					if (usuarioActivo.getDocumento().equals(tutorConDatos.getUsuario().getDocumento())) {
						listaDeRespuesta.add(tutorConDatos);
					}
				}

			}
			return listaDeRespuesta;
		} catch (Exception e) {
			return new ArrayList<Estudiante>();
		}
	}

	public static ArrayList<Estudiante> estudianteITR(String itr) {
		if (Fabrica.getListaDeEstudiantes().size() == 0) {
			Fabrica.cargarListas();
		}
		ArrayList<Estudiante> listaDeRespuesta = new ArrayList<Estudiante>();

		for (var estudianteConDatos : Fabrica.getListaDeEstudiantes()) {

			if (estudianteConDatos.getUsuario().getItr().getNombre().toUpperCase().contains(itr.toUpperCase())) {
				listaDeRespuesta.add(estudianteConDatos);
			}

		}

		return listaDeRespuesta;
	}

	public static ArrayList<Estudiante> estudianteGeneracion(String filtro) {
		if (Fabrica.getListaDeEstudiantes().size() == 0) {
			Fabrica.cargarListas();
		}
		ArrayList<Estudiante> listaDeRespuesta = new ArrayList<Estudiante>();

		for (var estudianteConDatos : Fabrica.getListaDeEstudiantes()) {

			if (estudianteConDatos.getGeneracion().toUpperCase().contains(filtro.toUpperCase())) {
				listaDeRespuesta.add(estudianteConDatos);
			}

		}

		return listaDeRespuesta;
	}

	public static ArrayList<Estudiante> estudianteSemestre(String filtro) {
		if (Fabrica.getListaDeEstudiantes().size() == 0) {
			Fabrica.cargarListas();
		}
		ArrayList<Estudiante> listaDeRespuesta = new ArrayList<Estudiante>();

		for (var estudianteConDatos : Fabrica.getListaDeEstudiantes()) {

			if (String.valueOf(estudianteConDatos.getSemestre()).contains(filtro)) {
				listaDeRespuesta.add(estudianteConDatos);
			}

		}

		return listaDeRespuesta;
	}
	// ESTUDIANTE----------------------------------------

	// ANALISTA----------------------------------------
	public static ArrayList<Analista> analistasSinCsonfirmar() {

		if (Fabrica.getListaDeAnalistas().size() == 0) {
			Fabrica.cargarListas();
		}

		ArrayList<Analista> listaDeRespuesta = new ArrayList<Analista>();

		var lista = usuariosConfirmar("N");

		for (var aux : Fabrica.getListaDeAnalistas()) {

			for (var aux2 : lista) {
				if (aux2.getDocumento().equals(aux.getUsuario().getDocumento())) {
					listaDeRespuesta.add(aux);
				}
			}

		}
		return listaDeRespuesta;
	}

	public static ArrayList<Analista> analistaFiltro(String filtro, String campo) {

		if (Fabrica.getListaDeAnalistas().size() == 0) {
			Fabrica.cargarListas();
		}

		ArrayList<Analista> listaDeRespuesta = new ArrayList<Analista>();

		var lista = buscarUsuarioPorCampoYFiltro(filtro, campo);

		for (var aux : Fabrica.getListaDeAnalistas()) {

			for (var aux2 : lista) {
				if (aux2.getDocumento().equals(aux.getUsuario().getDocumento())) {
					listaDeRespuesta.add(aux);
				}
			}
		}

		return listaDeRespuesta;
	}

	public static ArrayList<Analista> analistasSinConfirmar() {

		if (Fabrica.getListaDeAnalistas().size() == 0) {
			Fabrica.cargarListas();
		}

		ArrayList<Analista> listaDeRespuesta = new ArrayList<Analista>();

		for (var aux : Fabrica.getListaDeAnalistas()) {
			for (var aux2 : usuariosConfirmar("N")) {
				if (aux2.getDocumento().equals(aux.getUsuario().getDocumento())) {
					listaDeRespuesta.add(aux);
				}
			}

		}
		return listaDeRespuesta;
	}

	public static ArrayList<Analista> analistasActivos(String filtro) {
		if (Fabrica.getListaDeAnalistas().size() == 0) {
			Fabrica.cargarListas();
		}
		try {

			ArrayList<Analista> listaDeRespuesta = new ArrayList<Analista>();

			for (var analistaConDatos : Fabrica.getListaDeAnalistas()) {

				for (var usuarioActivo : usuariosActivo(filtro)) {
					if (usuarioActivo.getDocumento().equals(analistaConDatos.getUsuario().getDocumento())) {
						listaDeRespuesta.add(analistaConDatos);
					}
				}

			}
			return listaDeRespuesta;
		} catch (Exception e) {
			return new ArrayList<Analista>();
		}
	}

	public static ArrayList<Analista> analistaITR(String itr) {
		if (Fabrica.getListaDeAnalistas().size() == 0) {
			Fabrica.cargarListas();
		}
		ArrayList<Analista> listaDeRespuesta = new ArrayList<Analista>();

		for (var analistaConDatos : Fabrica.getListaDeAnalistas()) {

			if (analistaConDatos.getUsuario().getItr().getNombre().toUpperCase().contains(itr.toUpperCase())) {
				listaDeRespuesta.add(analistaConDatos);
			}

		}

		return listaDeRespuesta;
	}

	public static Analista analistaPorId(Long id) {

		ArrayList<Analista> listaDeRespuesta = new ArrayList<Analista>();

		for (var analistaConDatos : ServiceAnalista.listarAnalistas()) {

			if (analistaConDatos.getIdAnalista() == id) {
				listaDeRespuesta.add(analistaConDatos);
				break;
			}

		}

		return listaDeRespuesta.get(0);
	}
	// ANALISTA----------------------------------------

	// ITR ----------------------------------------

	public static Itr itrPorId(Long idItr) {

		Itr respuesta = null;

		for (var itr : ServiceItr.listarItrs()) {
			if (itr.getIdItr() == idItr) {
				respuesta = itr;
				break;
			}
		}

		return respuesta;

	}

	public static Itr itrPorNombre(String nombre) {

		Itr respuesta = null;

		for (var itr : ServiceItr.listarItrs()) {
			if (itr.getNombre().equals(nombre)) {
				respuesta = itr;
				break;
			}
		}

		return respuesta;

	}

	public static ArrayList<Itr> itrsActivos(String actividad) {

		ArrayList<Itr> respuesta = new ArrayList<Itr>();

		for (var itr : ServiceItr.listarItrs()) {
			if (itr.getActivo().equals(actividad)) {
				respuesta.add(itr);
			}
		}

		return respuesta;

	}
	// ITR ----------------------------------------

	// LOCALIDAD -------------------
	public static ArrayList<Localidad> localidadPorDepartamento(String filtro) {
		ArrayList<Localidad> listaDeRespuesta = new ArrayList<Localidad>();

		for (var aux : ServiceUbicacion.listarLocalidades()) {
			if (aux.getDepartamento().getNombre().equals(filtro)) {
				listaDeRespuesta.add(aux);
			}
		}

		return listaDeRespuesta;
	}
	// LOCALIDAD -------------------
}
