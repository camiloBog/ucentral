package com.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * Clase de persistencia para la tabla Banco de la base de datos.
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Banco.findAll", query="SELECT b FROM Banco b"),
	@NamedQuery(name="Banco.findById", query="SELECT b FROM Banco b where b.idBanco = :id")
})
public class Banco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entBanco", sequenceName="banco_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entBanco")
	@Column(name="id_banco")
	private long idBanco;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="banco")
	private List<Usuario> usuarios;

	public Banco() {
	}

	public long getIdBanco() {
		return this.idBanco;
	}

	public void setIdBanco(long idBanco) {
		this.idBanco = idBanco;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setBanco(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setBanco(null);

		return usuario;
	}

}