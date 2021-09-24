package com.cda.cdapraderaapi.jsons;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrearReservaRest {
	
	@JsonProperty("cedula")
	private String cedula;
	
	@JsonProperty("nombre")
	private String nombre;
	
	@JsonProperty("telefono")
	private String telefono;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("vehiculo")
	private Long vehiculo;
	
	@JsonProperty("disponibildad")
	private Long disponibildad;
	
	@JsonProperty("placa")
	private String placa;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Long vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Long getDisponibildad() {
		return disponibildad;
	}

	public void setDisponibildad(Long disponibildad) {
		this.disponibildad = disponibildad;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	

	

}
