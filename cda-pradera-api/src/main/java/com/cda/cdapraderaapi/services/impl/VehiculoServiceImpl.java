package com.cda.cdapraderaapi.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.cdapraderaapi.entitys.Vehiculo;
import com.cda.cdapraderaapi.jsons.VehiculoRest;
import com.cda.cdapraderaapi.repositories.VehiculoRepository;
import com.cda.cdapraderaapi.services.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	VehiculoRepository vehiculoRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<VehiculoRest> listaVehiculos() {
		List<Vehiculo> listaVehiculos = vehiculoRepository.findAll();

		return listaVehiculos.stream().map(service -> modelMapper.map(service, VehiculoRest.class))
				.collect(Collectors.toList());
	}

}
