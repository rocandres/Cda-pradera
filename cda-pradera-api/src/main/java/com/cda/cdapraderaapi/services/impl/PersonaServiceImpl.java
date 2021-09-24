package com.cda.cdapraderaapi.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.cdapraderaapi.entitys.Persona;
import com.cda.cdapraderaapi.jsons.PersonaRest;
import com.cda.cdapraderaapi.repositories.PersonaRepository;
import com.cda.cdapraderaapi.services.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	PersonaRepository personaRepository;
	
	public static final ModelMapper modelMapper= new ModelMapper();

	@Override
	public PersonaRest getPersonaByID(String cedula) {
		try {
			return modelMapper.map(getPersonEntity(cedula),PersonaRest.class);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	private Persona getPersonEntity(String cedula) {		
		return personaRepository.findById(cedula).orElseThrow();
		
	}
	
	
	

}
