package com.cliente.services;

import java.util.ArrayList;
import javax.naming.InitialContext;
import com.servidor.beans.genero.GeneroBeanRemote;
import com.servidor.entidades.Genero;

public class ServiceGenero {

	private static GeneroBeanRemote getService() {
		try {
			GeneroBeanRemote generoBean = (GeneroBeanRemote) InitialContext
					.doLookup("ejb:/Proyecto-PInfra/GeneroBean!com.servidor.beans.genero.GeneroBeanRemote");
			return generoBean;
		} catch (Exception e) {
			return null;
		}
	}

	public static Genero crearGenero(Genero oGenero) {
		try {
			var generoBean = getService();
			return generoBean.crearGenero(oGenero);
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Genero> listarGeneros() {
		try {
			var generoBean = getService();
			return generoBean.listarGeneros();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static ArrayList<Genero> listarGenerosFiltro(String filtro){
		try {
			var generoBean = getService();
			return generoBean.listarGenerosFiltro(filtro);			
		} catch (Exception e) {
			return null;
		}
	}

}
