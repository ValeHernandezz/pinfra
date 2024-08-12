package com.cliente.contexto.helpers;

import com.cliente.services.ServiceItr;
import com.cliente.services.ServiceUsuario;

public class Borrar {

	// USUARIO -----------------------------
	public static boolean darBajaLogicaUsuario(Long idUsuario) {
		try {
			var oUsuarioActualizado = ServiceUsuario.eliminarUsuario(idUsuario);
			if (!oUsuarioActualizado) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// ITR -----------------------------
	public static boolean darBajaLogicaItr(Long idItr) {
		try {
			var oItrActualizado = ServiceItr.eliminarItr(idItr);
			if (oItrActualizado) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
