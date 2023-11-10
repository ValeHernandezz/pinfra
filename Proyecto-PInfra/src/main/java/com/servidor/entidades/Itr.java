package com.servidor.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the ITRS database table.
 * 
 */
@Entity
@Table(name = "ITRS")
@NamedQuery(name = "Itr.findAll", query = "SELECT i FROM Itr i")
public class Itr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_id_itr")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_itr")
	@Column(name = "ID_ITR")
	private long idItr;

	private String activo;

	private String nombre;

	// bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name = "ID_DEPARTAMENTO")
	private Departamento departamento;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "itr")
	private List<Usuario> usuarios;

	public Itr() {

	}

	public Itr(String nombre, Departamento departamento, String activo) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
		this.activo = activo;
	}

	public long getIdItr() {
		return this.idItr;
	}

	public void setIdItr(long idItr) {
		this.idItr = idItr;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setItr(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setItr(null);

		return usuario;
	}

}