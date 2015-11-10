package com.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * Clase de persistencia para la tabla Perfil de la base de datos.
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p"),
	@NamedQuery(name="Perfil.findById", query="SELECT p FROM Perfil p where p.idPerfil = :id")
})
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entPerfil", sequenceName="perfil_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entPerfil")
	@Column(name="id_perfil")
	private long idPerfil;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="perfil")
	private List<Usuario> usuarios;

	public Perfil() {
	}

	public long getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(long idPerfil) {
		this.idPerfil = idPerfil;
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
		usuario.setPerfil(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPerfil(null);

		return usuario;
	}

}