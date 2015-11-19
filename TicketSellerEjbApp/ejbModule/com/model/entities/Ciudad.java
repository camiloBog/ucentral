package com.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * Clase de persistencia para la tabla Ciudad de la base de datos.
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c"),
	@NamedQuery(name="Ciudad.findById", query="SELECT c FROM Ciudad c where c.idCiudad = :id"),
	@NamedQuery(name="Ciudad.findByName", query="SELECT c FROM Ciudad c where c.nombre = :name"),
	@NamedQuery(name="Ciudad.findByCountryId", query="SELECT c FROM Ciudad c where c.pais = :idPais")
})
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entCiudad", sequenceName="ciudad_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entCiudad")
	@Column(name="id_ciudad")
	private long idCiudad;

	private String nombre;

	//bi-directional many-to-one association to Aeropuerto
	@OneToMany(mappedBy="ciudad")
	private List<Aeropuerto> aeropuertos;

	//bi-directional many-to-one association to Pais
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pais;

	public Ciudad() {
	}

	public long getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Aeropuerto> getAeropuertos() {
		return this.aeropuertos;
	}

	public void setAeropuertos(List<Aeropuerto> aeropuertos) {
		this.aeropuertos = aeropuertos;
	}

	public Aeropuerto addAeropuerto(Aeropuerto aeropuerto) {
		getAeropuertos().add(aeropuerto);
		aeropuerto.setCiudad(this);

		return aeropuerto;
	}

	public Aeropuerto removeAeropuerto(Aeropuerto aeropuerto) {
		getAeropuertos().remove(aeropuerto);
		aeropuerto.setCiudad(null);

		return aeropuerto;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

}