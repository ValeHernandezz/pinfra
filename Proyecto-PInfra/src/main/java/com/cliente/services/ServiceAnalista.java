package com.cliente.services;

import java.util.ArrayList;
import javax.naming.InitialContext;
import com.servidor.beans.analista.AnalistaBeanRemote;
import com.servidor.entidades.Analista;

public class ServiceAnalista {

	private static AnalistaBeanRemote getService() {
		try {
			AnalistaBeanRemote analistaBean = (AnalistaBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/AnalistaBean!com.servidor.beans.analista.AnalistaBeanRemote");
			return analistaBean;
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean crearAnalista(Analista oAnalista) {
		try {
			var analistaBean = getService();
			return analistaBean.crearAnalista(oAnalista);
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean actualizarAnalista(Analista oAnalista) {
		try {
			var analistaBean = getService();
			return analistaBean.actualizarAnalista(oAnalista);
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Analista> listarAnalistas() {
		try {
			var analistaBean = getService();
			return analistaBean.listarAnalistas();
		} catch (Exception e) {
			return null;
		}
	}

}
