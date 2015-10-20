package com.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aeropuerto database table.
 * 
 */
@Entity
@NamedQuery(name="Aeropuerto.findAll", query="SELECT a FROM Aeropuerto a")
public class Aeropuerto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_aeropuerto")
	private long idAeropuerto;

	private String iata;

	private String nombre;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="aeropuerto1")
	private List<Vuelo> vuelos1;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="aeropuerto2")
	private List<Vuelo> vuelos2;

	public Aeropuerto() {
	}

	public long getIdAeropuerto() {
		return this.idAeropuerto;
	}

	public void setIdAeropuerto(long idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}

	public String getIata() {
		return this.iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Vuelo> getVuelos1() {
		return this.vuelos1;
	}

	public void setVuelos1(List<Vuelo> vuelos1) {
		this.vuelos1 = vuelos1;
	}

	public Vuelo addVuelos1(Vuelo vuelos1) {
		getVuelos1().add(vuelos1);
		vuelos1.setAeropuerto1(this);

		return vuelos1;
	}

	public Vuelo removeVuelos1(Vuelo vuelos1) {
		getVuelos1().remove(vuelos1);
		vuelos1.setAeropuerto1(null);

		return vuelos1;
	}

	public List<Vuelo> getVuelos2() {
		return this.vuelos2;
	}

	public void setVuelos2(List<Vuelo> vuelos2) {
		this.vuelos2 = vuelos2;
	}

	public Vuelo addVuelos2(Vuelo vuelos2) {
		getVuelos2().add(vuelos2);
		vuelos2.setAeropuerto2(this);

		return vuelos2;
	}

	public Vuelo removeVuelos2(Vuelo vuelos2) {
		getVuelos2().remove(vuelos2);
		vuelos2.setAeropuerto2(null);

		return vuelos2;
	}

}