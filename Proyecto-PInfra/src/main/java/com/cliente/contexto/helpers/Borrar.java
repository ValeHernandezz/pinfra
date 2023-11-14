package com.cliente.contexto.helpers;

import com.cliente.services.ServiceItr;
import com.cliente.services.ServiceUsuario;
import com.servidor.entidades.Itr;
import com.servidor.entidades.Usuario;

public class Borrar {

	// USUARIO -----------------------------
	public static boolean darBajaLogica(Long idUsuario) {
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
	public static boolean darBajaLogica(Itr oItr) {
		try {
			oItr.setActivo("N");
			var oItrActualizado = ServiceItr.actualizarItr(oItr);
			if (oItrActualizado == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
