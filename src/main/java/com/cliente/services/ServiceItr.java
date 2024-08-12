package com.cliente.services;

import java.util.ArrayList;
import javax.naming.InitialContext;
import com.servidor.beans.itr.ItrBeanRemote;
import com.servidor.entidades.Itr;

public class ServiceItr {

	private static ItrBeanRemote getService() {
		try {
			ItrBeanRemote itrBean = (ItrBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/ItrBean!com.servidor.beans.itr.ItrBeanRemote");
			return itrBean;
		} catch (Exception e) {
			return null;
		}
	}

	public static Itr crearItr(Itr oItr) {
		try {
			var itrBean = getService();
			return itrBean.crearITR(oItr);
		} catch (Exception e) {
			return null;
		}
	}

	public static Itr actualizarItr(Itr oItr) {
		try {
			var itrBean = getService();
			return itrBean.actualizarITR(oItr);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean eliminarItr(Long id) {
		try {
			var itrBean = getService();
			return itrBean.eliminarITR(id);
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Itr> listarItrs() {
		try {
			var itrBean = getService();
			return itrBean.listarITR();
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Itr> listarItrsFiltro(String filtro) {
		try {
			var itrBean = getService();
			return itrBean.listarITRFiltro(filtro);
		} catch (Exception e) {
			return null;
		}
	}

}
