package com.cda.cdapraderaapi.services;

import java.util.List;

import com.cda.cdapraderaapi.jsons.CrearDisponibilidadRest;
import com.cda.cdapraderaapi.jsons.DisponibilidadRest;

public interface DisponibilidadService {

	String crearDisponibilidad(CrearDisponibilidadRest crearDisponibilidadRest);

	List<DisponibilidadRest> buscarLibres();

}
