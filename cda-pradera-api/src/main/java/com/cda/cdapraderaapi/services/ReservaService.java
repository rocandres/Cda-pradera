package com.cda.cdapraderaapi.services;

import java.util.List;

import com.cda.cdapraderaapi.jsons.CrearReservaRest;
import com.cda.cdapraderaapi.jsons.ReservaRest;

public interface ReservaService {

	String crearReserva(CrearReservaRest crearReservaRest);
	
	List<ReservaRest> reservaByUsuario(String cedula);

}
