package com.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * Clase de persistencia para la tabla Estado de la base de datos.
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e"),
	@NamedQuery(name="Estado.findById", query="SELECT e FROM Estado e where e.idEstado = :id")
})
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entEstado", sequenceName="estado_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entEstado")
	@Column(name="id_estado")
	private long idEstado;

	private String descripcion;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="estado")
	private List<Reserva> reservas;

	public Estado() {
	}

	public long getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setEstado(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setEstado(null);

		return reserva;
	}

}