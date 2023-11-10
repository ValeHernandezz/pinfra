package com.servidor.beans.itr;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.servidor.entidades.Itr;
import com.servidor.exception.ServiciosException;

@Remote
public interface ItrBeanRemote {
	Itr crearITR(Itr oITR) throws ServiciosException;

	Itr actualizarITR(Itr oITR) throws ServiciosException;

	boolean eliminarITR(Long idITR) throws ServiciosException;

	ArrayList<Itr> listarITR() throws ServiciosException;

	ArrayList<Itr> listarITRFiltro(String filtro) throws ServiciosException;
}
