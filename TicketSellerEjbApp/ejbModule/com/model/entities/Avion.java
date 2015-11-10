package com.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the avion database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Avion.findAll", query="SELECT a FROM Avion a"),
	@NamedQuery(name="Avion.findById", query="SELECT a FROM Avion a where a.idAvion = :id")
})
public class Avion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entAvion", sequenceName="avion_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entAvion")
	@Column(name="id_avion")
	private long idAvion;

	private BigDecimal asientos;

	private String codigo;

	private String modelo;

	//bi-directional many-to-one association to Vuelo
	@OneToMany(mappedBy="avion")
	private List<Vuelo> vuelos;

	public Avion() {
	}

	public long getIdAvion() {
		return this.idAvion;
	}

	public void setIdAvion(long idAvion) {
		this.idAvion = idAvion;
	}

	public BigDecimal getAsientos() {
		return this.asientos;
	}

	public void setAsientos(BigDecimal asientos) {
		this.asientos = asientos;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public List<Vuelo> getVuelos() {
		return this.vuelos;
	}

	public void setVuelos(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public Vuelo addVuelo(Vuelo vuelo) {
		getVuelos().add(vuelo);
		vuelo.setAvion(this);

		return vuelo;
	}

	public Vuelo removeVuelo(Vuelo vuelo) {
		getVuelos().remove(vuelo);
		vuelo.setAvion(null);

		return vuelo;
	}

}