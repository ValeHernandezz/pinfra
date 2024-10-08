package com.cliente.services;

import java.util.ArrayList;
import javax.naming.InitialContext;
import com.servidor.beans.usuario.UsuarioBeanRemote;
import com.servidor.entidades.Usuario;
import com.servidor.utils.Respuesta;

public class ServiceUsuario {

	private static UsuarioBeanRemote getService() {
		try {
			UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/UsuarioBean!com.servidor.beans.usuario.UsuarioBeanRemote");
			return usuarioBean;
		} catch (Exception e) {
			return null;
		}
	}

	public static Respuesta login(String nombreUsuario, String clave) {
		try {
			var usuarioBean = getService();
			return usuarioBean.login(nombreUsuario, clave);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static Usuario crearUsuario(Usuario oUsuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.crearUsuario(oUsuario);
		} catch (Exception e) {
			return null;
		}
	}

	public static Usuario actualizarUsuario(Usuario oUsuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.actualizarUsuario(oUsuario);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean eliminarUsuario(Long idUsuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.eliminarUsuario(idUsuario);
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Usuario> listarUsuarios() {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuarios();
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Usuario> listarUsuariosFiltro(String filtro) {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuariosFiltro(filtro);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean tienePermiso(Long idRol, Long idFuncionalidad) {
		try {
			var usuarioBean = getService();
			return usuarioBean.tienePermiso(idRol, idFuncionalidad);
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Usuario> buscarUsuarioPorCampoYFiltro(String filtro, String campo) {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuariosFiltroPersonalizado(filtro, campo);
		} catch (Exception e) {
			return new ArrayList<Usuario>();
		}
	}

	public static ArrayList<Usuario> listarUsuariosPorNombreApellido(String filtro1, String filtro2, String campo) {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuariosPorNombreApellido(filtro1, filtro2, campo);
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Usuario> listarUsuariosFiltroRol(String filtro) {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuariosFiltroRol(filtro);
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Usuario> listarUsuariosSinConfirmar(String filtro) {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuariosSinConfirmar(filtro);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean comprobarNombreUsuario(String nombreUsuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.comprobarNombreUsuario(nombreUsuario);
		} catch (Exception e) {
			return false;
		}
	}

}
