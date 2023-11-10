package com.servidor.beans.analista;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.servidor.entidades.Analista;
import com.servidor.exception.ServiciosException;

@Remote
public interface AnalistaBeanRemote {

	boolean crearAnalista(Analista analista) throws ServiciosException;

	boolean actualizarAnalista(Analista analista) throws ServiciosException;

	boolean borrarAnalista(Long idAnalista) throws ServiciosException;

	ArrayList<Analista> listarAnalistas() throws ServiciosException;

	ArrayList<Analista> listarAnalistasFiltro(String filtro) throws ServiciosException;

}
