package com.servidor.beans.area;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.servidor.entidades.Area;
import com.servidor.exception.ServiciosException;

@Remote
public interface AreaBeanRemote {

	Area crearArea(Area oArea) throws ServiciosException;

	boolean actualizarArea(Area oArea) throws ServiciosException;

	boolean eliminarArea(Long idArea) throws ServiciosException;

	ArrayList<Area> listarAreas() throws ServiciosException;

	ArrayList<Area> listarAreasFiltro(String filtro) throws ServiciosException;

}
