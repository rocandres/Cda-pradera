package com.cda.cdapraderaapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cda.cdapraderaapi.jsons.CrearDisponibilidadRest;
import com.cda.cdapraderaapi.jsons.DisponibilidadRest;
import com.cda.cdapraderaapi.responses.ResponseCda;
import com.cda.cdapraderaapi.services.DisponibilidadService;

@RestController
@RequestMapping(path = "/cda")
public class DisponibilidadController {

	@Autowired
	DisponibilidadService disponibilidadService;

	@ResponseStatus(HttpStatus.OK)  
	@CrossOrigin
	@RequestMapping(value = "crearDisponibilidad", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCda<String> crearDisponibilidad(@RequestBody CrearDisponibilidadRest crearDisponibilidadRest) {
		return new ResponseCda<>("succes", String.valueOf(HttpStatus.OK), "OK",
				disponibilidadService.crearDisponibilidad(crearDisponibilidadRest));

	}

	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	@RequestMapping(value = "Disponibles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCda<List<DisponibilidadRest>> Disponibles() {
		return new ResponseCda<>("succes", String.valueOf(HttpStatus.OK), "OK", disponibilidadService.buscarLibres());
	}

}
