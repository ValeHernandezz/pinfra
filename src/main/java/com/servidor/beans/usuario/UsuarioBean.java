package com.servidor.beans.usuario;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.servidor.entidades.Usuario;
import com.servidor.exception.ServiciosException;
import com.servidor.utils.Respuesta;

@Stateless
public class UsuarioBean implements UsuarioBeanRemote {

	@PersistenceContext
	EntityManager entityManager;

	public UsuarioBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Respuesta login(String nombreUsuario, String clave) throws ServiciosException {
		try {
			// Realizar la consulta para buscar el usuario por nombre de usuario
			// y
			// contraseña
			TypedQuery<Usuario> query = entityManager
					.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario AND u.clave = :clave",
							Usuario.class)
					.setParameter("nombreUsuario", nombreUsuario).setParameter("clave", clave);

			ArrayList<Usuario> lista = (ArrayList<Usuario>) query.getResultList();
			Usuario usuario = lista.get(0);

			if (usuario != null && usuario.getConfirmado().equals("S")) {
				return new Respuesta("success", "Inicio de sesión exitoso", usuario);
			} else {
				return new Respuesta("error", "Tu cuenta aún no ha sido confirmada.\nVuelva a intentarlo más tarde.",
						null);
			}
		} catch (Exception e) {
			return new Respuesta("error", "Nombre de usuario o contraseña no válido.\nVuelva a intentarlo.", null);
		}

	}

	@Override
	public Usuario crearUsuario(Usuario oUsuario) throws ServiciosException {
		try {
			entityManager.persist(oUsuario);
			entityManager.flush();
			return oUsuario;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Usuario actualizarUsuario(Usuario oUsuario) throws ServiciosException {
		try {
			entityManager.merge(oUsuario);
			entityManager.flush();
			return oUsuario;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean eliminarUsuario(Long idUsuario) throws ServiciosException {
		try {
			Usuario oUsuario = entityManager.find(Usuario.class, idUsuario);
			oUsuario.setActivo("N");
			entityManager.flush();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() throws ServiciosException {
		try {
			TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u ", Usuario.class);
			ArrayList<Usuario> lista = (ArrayList<Usuario>) query.getResultList();
			return lista;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<Usuario> listarUsuariosFiltro(String filtro) throws ServiciosException {
		try {
			TypedQuery<Usuario> query = entityManager
					.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE :filtro", Usuario.class)
					.setParameter("filtro", "%" + filtro + "%");

			return (ArrayList<Usuario>) query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

//	@Override
//	public ArrayList<Usuario> listarUsuariosFiltroPersonalizado(String filtro, String campo) throws ServiciosException {
//		try {
//			TypedQuery<Usuario> query = entityManager
//					.createQuery("SELECT u FROM Usuario u WHERE " + campo
//							+ (campo.equals("u.rol.idRol") ? "=" : "LIKE ") + " :filtro", Usuario.class)
//					.setParameter("filtro",
//							(campo.equals("u.rol.idRol") ? Long.parseLong(filtro) : ("%" + filtro + "%")));
//			System.out.println(query.getResultList().size());
//			return (ArrayList<Usuario>) query.getResultList();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}

	public ArrayList<Usuario> listarUsuariosFiltroPersonalizado(String filtro, String campo) throws ServiciosException {
		try {
			System.out.println("------------------------");
			System.out.println("Filtro:" + filtro);
			System.out.println("Campo:" + campo);
			System.out.println("------------------------");
			
			String queryString = "SELECT u FROM Usuario u WHERE ";

			if (campo.equals("u.rol.idRol") || campo.equals("u.mailPersonal")) {
				queryString += "u.rol.idRol = :filtro";
			} else {
				queryString += campo + " LIKE :filtro";
			}

			TypedQuery<Usuario> query = entityManager.createQuery(queryString, Usuario.class).setParameter("filtro",
					campo.equals("u.rol.idRol") ? Long.parseLong(filtro) : ("%" + filtro + "%"));

			return new ArrayList<>(query.getResultList());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public ArrayList<Usuario> listarUsuariosFiltroRol(String filtro) throws ServiciosException {
		try {
			TypedQuery<Usuario> query = entityManager
					.createQuery("SELECT u FROM Usuario u WHERE u.rol.idRol = :filtro", Usuario.class)
					.setParameter("filtro", Long.parseLong(filtro));
			return (ArrayList<Usuario>) query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<Usuario> listarUsuariosPorNombreApellido(String filtro1, String filtro2, String campo)
			throws ServiciosException {
		try {
			TypedQuery<Usuario> query = entityManager.createQuery(
					"SELECT u FROM Usuario u WHERE u.primerNombre LIKE :filtro AND u.primerApellido LIKE :filtro2",
					Usuario.class).setParameter("filtro", "%" + filtro1 + "%")
					.setParameter("filtro2", "%" + filtro2 + "%");

			return (ArrayList<Usuario>) query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean tienePermiso(Long idRol, Long idFuncionalidad) throws ServiciosException {
		try {
			String query = "SELECT COUNT(r) FROM Rol r JOIN r.funcionalidades f WHERE r.idRol = :idRol AND f.idFuncionalidad = :idFuncionalidad";
			Long count = entityManager.createQuery(query, Long.class).setParameter("idRol", idRol)
					.setParameter("idFuncionalidad", idFuncionalidad).getSingleResult();

			return count > 0;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<Usuario> listarUsuariosSinConfirmar(String filtro) throws ServiciosException {
		try {
			TypedQuery<Usuario> query = entityManager
					.createQuery("SELECT u FROM Usuario u WHERE u.confirmado = :filtro AND u.activo = :activo",
							Usuario.class)
					.setParameter("filtro", filtro).setParameter("activo", "S");
			return (ArrayList<Usuario>) query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean comprobarNombreUsuario(String nombreUsuario) throws ServiciosException {
		try {
			TypedQuery<Usuario> query = entityManager
					.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombreUsuario", Usuario.class)
					.setParameter("nombreUsuario", nombreUsuario);

			if (query.getResultList().size() > 0) {
				return true;
			}
			return false;

		} catch (Exception e) {
			return false;
		}
	}

}
