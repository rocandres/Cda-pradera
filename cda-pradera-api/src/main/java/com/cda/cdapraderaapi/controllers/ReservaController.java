package com.cda.cdapraderaapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cda.cdapraderaapi.jsons.CrearReservaRest;
import com.cda.cdapraderaapi.jsons.ReservaRest;
import com.cda.cdapraderaapi.responses.ResponseCda;
import com.cda.cdapraderaapi.services.ReservaService;

@RestController
@RequestMapping(path = "/cda")
public class ReservaController {

	@Autowired
	ReservaService reservaService;

	
	
	@ResponseStatus(HttpStatus.OK) 
	@CrossOrigin
	@RequestMapping(value = "CrearReserva", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCda<String> crearReserva(@RequestBody CrearReservaRest crearReservaRest) {
		return new ResponseCda<>("succes", String.valueOf(HttpStatus.OK), "OK",
				reservaService.crearReserva(crearReservaRest));

	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	@RequestMapping(value = "Reservas/{cedula}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCda<List<ReservaRest>> getReservasPersona(@PathVariable("cedula") String cedula) {
		return new ResponseCda<>("succes", String.valueOf(HttpStatus.OK), "OK",
				reservaService.reservaByUsuario(cedula));

	}

}
