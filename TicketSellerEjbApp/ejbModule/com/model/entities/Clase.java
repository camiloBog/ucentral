package com.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * Clase de persistencia para la tabla Clase de la base de datos.
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Entity
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entClase", sequenceName="clase_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entClase")
	@Column(name="id_clase")
	private long idClase;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Tarifa
	@OneToMany(mappedBy="clase")
	private List<Tarifa> tarifas;

	public Clase() {
	}

	public long getIdClase() {
		return this.idClase;
	}

	public void setIdClase(long idClase) {
		this.idClase = idClase;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tarifa> getTarifas() {
		return this.tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public Tarifa addTarifa(Tarifa tarifa) {
		getTarifas().add(tarifa);
		tarifa.setClase(this);

		return tarifa;
	}

	public Tarifa removeTarifa(Tarifa tarifa) {
		getTarifas().remove(tarifa);
		tarifa.setClase(null);

		return tarifa;
	}

}