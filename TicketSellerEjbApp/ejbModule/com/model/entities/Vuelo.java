package com.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Clase de persistencia para la tabla Vuelo de la base de datos.
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Entity
@NamedQuery(name="Vuelo.findAll", query="SELECT v FROM Vuelo v")
public class Vuelo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entVuelo", sequenceName="vuelo_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entVuelo")
	@Column(name="id_vuelo")
	private long idVuelo;

	@Column(name="cant_clases")
	private BigDecimal cantClases;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_vuelo")
	private Date fechaVuelo;

	@Temporal(TemporalType.DATE)
	@Column(name="hora_vuelo")
	private Date horaVuelo;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="vuelo")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Tarifa
	@OneToMany(mappedBy="vuelo")
	private List<Tarifa> tarifas;

	//bi-directional many-to-one association to Aeropuerto
	@ManyToOne
	@JoinColumn(name="destino")
	private Aeropuerto aeropuerto1;

	//bi-directional many-to-one association to Aeropuerto
	@ManyToOne
	@JoinColumn(name="origen")
	private Aeropuerto aeropuerto2;

	//bi-directional many-to-one association to Avion
	@ManyToOne
	@JoinColumn(name="id_avion")
	private Avion avion;

	public Vuelo() {
	}

	public long getIdVuelo() {
		return this.idVuelo;
	}

	public void setIdVuelo(long idVuelo) {
		this.idVuelo = idVuelo;
	}

	public BigDecimal getCantClases() {
		return this.cantClases;
	}

	public void setCantClases(BigDecimal cantClases) {
		this.cantClases = cantClases;
	}

	public Date getFechaVuelo() {
		return this.fechaVuelo;
	}

	public void setFechaVuelo(Date fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Date getHoraVuelo() {
		return this.horaVuelo;
	}

	public void setHoraVuelo(Date horaVuelo) {
		this.horaVuelo = horaVuelo;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setVuelo(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setVuelo(null);

		return reserva;
	}

	public List<Tarifa> getTarifas() {
		return this.tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public Tarifa addTarifa(Tarifa tarifa) {
		getTarifas().add(tarifa);
		tarifa.setVuelo(this);

		return tarifa;
	}

	public Tarifa removeTarifa(Tarifa tarifa) {
		getTarifas().remove(tarifa);
		tarifa.setVuelo(null);

		return tarifa;
	}

	public Aeropuerto getAeropuerto1() {
		return this.aeropuerto1;
	}

	public void setAeropuerto1(Aeropuerto aeropuerto1) {
		this.aeropuerto1 = aeropuerto1;
	}

	public Aeropuerto getAeropuerto2() {
		return this.aeropuerto2;
	}

	public void setAeropuerto2(Aeropuerto aeropuerto2) {
		this.aeropuerto2 = aeropuerto2;
	}

	public Avion getAvion() {
		return this.avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

}