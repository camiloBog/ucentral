package com.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tarifa database table.
 * 
 */
@Entity
@NamedQuery(name="Tarifa.findAll", query="SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tarifa")
	private long idTarifa;

	private BigDecimal asientos;

	private BigDecimal costo;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="tarifa")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	@JoinColumn(name="id_clase")
	private Clase clase;

	//bi-directional many-to-one association to Vuelo
	@ManyToOne
	@JoinColumn(name="id_vuelo")
	private Vuelo vuelo;

	public Tarifa() {
	}

	public long getIdTarifa() {
		return this.idTarifa;
	}

	public void setIdTarifa(long idTarifa) {
		this.idTarifa = idTarifa;
	}

	public BigDecimal getAsientos() {
		return this.asientos;
	}

	public void setAsientos(BigDecimal asientos) {
		this.asientos = asientos;
	}

	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setTarifa(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setTarifa(null);

		return reserva;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Vuelo getVuelo() {
		return this.vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

}