package com.cda.cdapraderaapi.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cda.cdapraderaapi.entitys.Disponibilidad;
import com.cda.cdapraderaapi.jsons.CrearDisponibilidadRest;
import com.cda.cdapraderaapi.jsons.DisponibilidadRest;
import com.cda.cdapraderaapi.repositories.DisponibilidadRepository;
import com.cda.cdapraderaapi.services.DisponibilidadService;

@Service
public class DisponibilidadServiceImpl implements DisponibilidadService {

	@Autowired
	DisponibilidadRepository disponibilidadRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public String crearDisponibilidad(CrearDisponibilidadRest crearDisponibilidadRest) {
		try {

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date d1 = df.parse(crearDisponibilidadRest.getFecha() + " " + crearDisponibilidadRest.getHora_fin());
			Date d2 = df.parse(crearDisponibilidadRest.getFecha() + " " + crearDisponibilidadRest.getHora_inicio());

			long diff = d1.getTime() - d2.getTime();
			long dia = diff / (24 * 60 * 60 * 1000);
			long hora = (diff / (60 * 60 * 1000) - dia * 24);

			long franjas = hora * 2;

			for (int i = 0; i < franjas; i++) {
				Disponibilidad disponibilidad = new Disponibilidad();
				if (i == 0) {
					disponibilidad.setFecha(sumarHorasFecha(d2, 0));
					disponibilidad.setHora(sumarHorasFecha(d2, 0));

				} else {
					disponibilidad.setFecha(d2);
					disponibilidad.setHora(d2);

				}

				d2 = sumarHorasFecha(d2, 30);
				disponibilidadRepository.save(disponibilidad);

			}

			return "Agenda creada correctamente";
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public Date sumarHorasFecha(Date fecha, int minutos) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.MINUTE, minutos);
		return calendar.getTime();

	}

	@Override
	public List<DisponibilidadRest> buscarLibres() {
		List<Disponibilidad> libresEntity = disponibilidadRepository.findLibres();

		return libresEntity.stream().map(service -> modelMapper.map(service, DisponibilidadRest.class))
				.collect(Collectors.toList());
	}

}
