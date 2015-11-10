package com.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


/**
 * Clase de persistencia para la tabla Usuario de la base de datos.
 * 
 * @author camilo
 * @version 1.0, Noviembre de 2015
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u"),
	@NamedQuery(name="Usuario.findById", query="SELECT u FROM Usuario u where u.idUsuario = :id"),
	@NamedQuery(name="Usuario.findByDocument", query = "SELECT u FROM Usuario u WHERE u.documento = :documentoUsu")
})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="entUsuario", sequenceName="usuario_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entUsuario")
	@Column(name="id_usuario")
	private long idUsuario;

	private String apellido;

	private String apellido2;

	private String celular;

	private String correo;

	private BigDecimal cuenta;

	private String direccion;

	@Column(name="direccion_postal")
	private String direccionPostal;

	private BigDecimal documento;

	private String pass;
	
	private String nombre;

	private String nombre2;

	private String telefono;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="usuario")
	private List<Reserva> reservas;

	//bi-directional many-to-one association to Banco
	@ManyToOne
	@JoinColumn(name="id_banco")
	private Banco banco;

	//bi-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	//bi-directional many-to-one association to Tipo
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private Tipo tipo;

	public Usuario() {
	}

	public long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido2() {
		return this.apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public BigDecimal getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(BigDecimal cuenta) {
		this.cuenta = cuenta;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccionPostal() {
		return this.direccionPostal;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public BigDecimal getDocumento() {
		return this.documento;
	}

	public void setDocumento(BigDecimal documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre2() {
		return this.nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setUsuario(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setUsuario(null);

		return reserva;
	}

	public Banco getBanco() {
		return this.banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Tipo getTipo() {
		return this.tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}