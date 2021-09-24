package com.cda.cdapraderaapi.entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID",unique = true,nullable = false)
	private Long id;
	
	@Column(name = "PLACA",nullable = false)
	private String placa;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="PERSONA",nullable = false)
	private Persona persona;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="VEHICULO",nullable = false)
	private Vehiculo vehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="DISPONIBILIDAD",nullable = false)
	private Disponibilidad disponibilidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Disponibilidad getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Disponibilidad disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	
	

}
