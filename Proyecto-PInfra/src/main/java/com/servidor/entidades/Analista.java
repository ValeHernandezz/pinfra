package com.servidor.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ANALISTAS database table.
 * 
 */
@Entity
@Table(name = "ANALISTAS")
@NamedQuery(name = "Analista.findAll", query = "SELECT a FROM Analista a")
public class Analista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seq_id_analista")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id_analista")
	@Column(name = "ID_ANALISTA")
	private long idAnalista;

	@Lob
	private byte[] firma;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	public Analista() {

	}

	public Analista(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public Analista(long idAnalista) {
		super();
		this.idAnalista = idAnalista;
	}

	public long getIdAnalista() {
		return this.idAnalista;
	}

	public void setIdAnalista(long idAnalista) {
		this.idAnalista = idAnalista;
	}

	public byte[] getFirma() {
		return this.firma;
	}

	public void setFirma(byte[] firma) {
		this.firma = firma;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}