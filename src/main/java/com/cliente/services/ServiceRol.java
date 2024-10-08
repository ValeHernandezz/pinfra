package com.cliente.services;

import java.util.ArrayList;
import javax.naming.InitialContext;
import com.servidor.beans.rol.RolBeanRemote;
import com.servidor.entidades.Rol;

public class ServiceRol {

	private static RolBeanRemote getService() {
		try {
			RolBeanRemote rolBean = (RolBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/RolBean!com.servidor.beans.rol.RolBeanRemote");
			return rolBean;
		} catch (Exception e) {
			return null;
		}
	}

	public static Rol crearRol(Rol oRol) {
		try {
			var rolBean = getService();
			return rolBean.crearRol(oRol);
		} catch (Exception e) {
			return null;
		}
	}

	public static Rol actualizarRol(Rol oRol) {
		try {
			var rolBean = getService();
			return rolBean.actualizarRol(oRol);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean eliminarRol(Long idRol) {
		try {
			var rolBean = getService();
			return rolBean.eliminarRol(idRol);
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Rol> listarRoles() {
		try {
			var rolBean = getService();
			return rolBean.listarRoles();
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Rol> listarRolesFiltro(String filtro) {
		try {
			var rolBean = getService();
			return rolBean.listarRolesFiltro(filtro);
		} catch (Exception e) {
			return null;
		}
	}


}
