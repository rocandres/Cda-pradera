package com.cda.cdapraderaapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cda.cdapraderaapi.jsons.PersonaRest;
import com.cda.cdapraderaapi.responses.ResponseCda;
import com.cda.cdapraderaapi.services.PersonaService;

@RestController
@RequestMapping(path = "/cda")
public class PersonaController {

	@Autowired
	PersonaService personaService;

	@ResponseStatus(HttpStatus.OK)
	@CrossOrigin
	@RequestMapping(value = "persona/"
			+ "{cedula}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseCda<PersonaRest> getPersonaById(@PathVariable("cedula") String cedula) {
		System.out.println("Cedula:"+cedula);
		return new ResponseCda<>("Succes", String.valueOf(HttpStatus.OK), "Ok", personaService.getPersonaByID(cedula));
	}

}
