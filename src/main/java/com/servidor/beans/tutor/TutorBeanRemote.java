package com.servidor.beans.tutor;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.servidor.entidades.Tutor;
import com.servidor.exception.ServiciosException;

@Remote
public interface TutorBeanRemote {

	boolean crearTutor(Tutor tutor) throws ServiciosException;

	boolean actualizarTutor(Tutor tutor) throws ServiciosException;

	boolean borrarTutor(Long idTutor) throws ServiciosException;

	ArrayList<Tutor> listarTutores() throws ServiciosException;

	ArrayList<Tutor> listarTutoresFiltro(String filtro) throws ServiciosException;
}
