package com.cda.cdapraderaapi.jsons;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrearDisponibilidadRest {
	
	@JsonProperty("fecha")
	private String fecha;
	
	@JsonProperty("hora_inicio")
	private String hora_inicio;
	
	@JsonProperty("hora_fin")
	private String hora_fin;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public String getHora_fin() {
		return hora_fin;
	}

	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	} 
	
	
	

}
