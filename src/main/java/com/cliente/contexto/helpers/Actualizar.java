package com.cliente.contexto.helpers;

import com.cliente.services.ServiceAnalista;
import com.cliente.services.ServiceEstudiante;
import com.cliente.services.ServiceItr;
import com.cliente.services.ServiceTutor;
import com.cliente.services.ServiceUsuario;
import com.servidor.entidades.Analista;
import com.servidor.entidades.Estudiante;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Tutor;
import com.servidor.entidades.Usuario;

public class Actualizar {

	public static boolean usuario(Usuario oUsuario, Object oTipoUsuario) {
		try {
			var usuarioEditado = ServiceUsuario.actualizarUsuario(oUsuario);

			if (oTipoUsuario instanceof Estudiante) {

				var oEstudiate = (Estudiante) oTipoUsuario;
				oEstudiate.setUsuario(usuarioEditado);

				var oEstudianteCreado = ServiceEstudiante.actualizarEstudiante(oEstudiate);
				return oEstudianteCreado;
			}

			if (oTipoUsuario instanceof Analista) {
				var oAnalista = (Analista) oTipoUsuario;
				oAnalista.setUsuario(usuarioEditado);

				var oAnalistaCreado = ServiceAnalista.actualizarAnalista(oAnalista);
				return oAnalistaCreado;
			}

			if (oTipoUsuario instanceof Tutor) {
				var oTutor = (Tutor) oTipoUsuario;
				oTutor.setUsuario(usuarioEditado);

				var oTutorCreado = ServiceTutor.actualizarTutor(oTutor);
				return oTutorCreado;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean itr(Itr oItr) {
		try {

			return ServiceItr.actualizarItr(oItr) != null ? true : false;

		} catch (Exception e) {
			return false;
		}
	}

}
