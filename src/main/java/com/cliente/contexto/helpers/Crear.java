package com.cliente.contexto.helpers;

import java.util.ArrayList;

import com.cliente.services.ServiceAnalista;
import com.cliente.services.ServiceEstudiante;
import com.cliente.services.ServiceTutor;
import com.cliente.services.ServiceUsuario;
import com.servidor.entidades.Analista;
import com.servidor.entidades.Estudiante;
import com.servidor.entidades.Tutor;
import com.servidor.entidades.Usuario;

public class Crear {

	// USUARIO-----------------------------
	public static boolean usuario(Usuario oUsuario, Object oTipoUsuario) {
		try {
			var oUsuarioCreado = ServiceUsuario.crearUsuario(oUsuario);

			if (oTipoUsuario instanceof Estudiante) {

				var oEstudiate = (Estudiante) oTipoUsuario;
				oEstudiate.setUsuario(oUsuarioCreado);

				var oEstudianteCreado = ServiceEstudiante.crearEstudiante(oEstudiate);
				return oEstudianteCreado;
			}

			if (oTipoUsuario instanceof Analista) {
				var oAnalista = (Analista) oTipoUsuario;
				oAnalista.setUsuario(oUsuarioCreado);
				var oAnalistaCreado = ServiceAnalista.crearAnalista(oAnalista);
				return oAnalistaCreado;
			}

			if (oTipoUsuario instanceof Tutor) {
				var oTutor = (Tutor) oTipoUsuario;
				oTutor.setUsuario(oUsuarioCreado);

				var oTutorCreado = ServiceTutor.crearTutor(oTutor);
				return oTutorCreado;
			}

			return false;
		} catch (Exception e) {
			return false;
		}
	}

	// USUARIO-----------------------------
}
