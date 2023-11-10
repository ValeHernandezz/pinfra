package com.servidor.beans.usuario;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.servidor.entidades.Usuario;
import com.servidor.exception.ServiciosException;
import com.servidor.utils.Respuesta;

@Remote
public interface UsuarioBeanRemote {

	Respuesta login(String nickname, String clave) throws ServiciosException;

	Usuario crearUsuario(Usuario oUsuario) throws ServiciosException;

	Usuario actualizarUsuario(Usuario oUsuario) throws ServiciosException;

	boolean eliminarUsuario(Long idUsuario) throws ServiciosException;

	ArrayList<Usuario> listarUsuarios() throws ServiciosException;

	ArrayList<Usuario> listarUsuariosFiltro(String filtro) throws ServiciosException;

	ArrayList<Usuario> listarUsuariosFiltroRol(String filtro) throws ServiciosException;

	ArrayList<Usuario> listarUsuariosFiltroPersonalizado(String filtro, String campo) throws ServiciosException;

	ArrayList<Usuario> listarUsuariosPorNombreApellido(String filtro1, String filtro2, String campo)
			throws ServiciosException;

	boolean tienePermiso(Long idRol, Long idFuncionalidad) throws ServiciosException;

}
