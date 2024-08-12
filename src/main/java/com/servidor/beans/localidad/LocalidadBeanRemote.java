package com.servidor.beans.localidad;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.servidor.entidades.Localidad;
import com.servidor.exception.ServiciosException;

@Remote
public interface LocalidadBeanRemote {

	Localidad crearLocalidad(Localidad oLocalidad) throws ServiciosException;

	Localidad actualizarLocalidad(Localidad oLocalidad) throws ServiciosException;

	boolean eliminarLocalidad(Long idLocalidad) throws ServiciosException;

	ArrayList<Localidad> listarLocalidades() throws ServiciosException;

	ArrayList<Localidad> listarLocalidadesFiltro(String filtro) throws ServiciosException;

}
