package com.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pais")
	private long idPais;

	private String nombre;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="pais")
	private List<Ciudad> ciudades;

	public Pais() {
	}

	public long getIdPais() {
		return this.idPais;
	}

	public void setIdPais(long idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ciudad> getCiudades() {
		return this.ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public Ciudad addCiudade(Ciudad ciudade) {
		getCiudades().add(ciudade);
		ciudade.setPais(this);

		return ciudade;
	}

	public Ciudad removeCiudade(Ciudad ciudade) {
		getCiudades().remove(ciudade);
		ciudade.setPais(null);

		return ciudade;
	}

}