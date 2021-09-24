package com.cda.cdapraderaapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.cdapraderaapi.jsons.VehiculoRest;

@Service
public interface VehiculoService {

	List<VehiculoRest> listaVehiculos();

}
