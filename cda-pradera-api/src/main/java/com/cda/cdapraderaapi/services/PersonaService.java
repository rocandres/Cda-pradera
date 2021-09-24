package com.cda.cdapraderaapi.services;

import com.cda.cdapraderaapi.jsons.PersonaRest;

public interface PersonaService {
	
	PersonaRest getPersonaByID(String cedula);

}
