package com.cda.cdapraderaapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cda.cdapraderaapi.jsons.VehiculoRest;
import com.cda.cdapraderaapi.responses.ResponseCda;
import com.cda.cdapraderaapi.services.VehiculoService;

@RestController
@RequestMapping(path = "/cda")
public class VehiculoController {

	@Autowired
	VehiculoService vehiculoService;

	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	@RequestMapping(value = "Vehiculos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCda<List<VehiculoRest>> Vehiculos() {
		return new ResponseCda<>("succes", String.valueOf(HttpStatus.OK), "OK", vehiculoService.listaVehiculos());
	}

}
