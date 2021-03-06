package com.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * Clase de persistencia para la tabla Reserva de la base de datos.
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r"),
	@NamedQuery(name="Reserva.findById", query="SELECT r FROM Reserva r where r.idReserva = :id")
})
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entReserva", sequenceName="reserva_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entReserva")
	@Column(name="id_reserva")
	private long idReserva;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	//bi-directional many-to-one association to Estado
	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	//bi-directional many-to-one association to Tarifa
	@ManyToOne
	@JoinColumn(name="id_tarifa")
	private Tarifa tarifa;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Vuelo
	@ManyToOne
	@JoinColumn(name="id_vuelo")
	private Vuelo vuelo;

	public Reserva() {
	}

	public long getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(long idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Tarifa getTarifa() {
		return this.tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vuelo getVuelo() {
		return this.vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

}