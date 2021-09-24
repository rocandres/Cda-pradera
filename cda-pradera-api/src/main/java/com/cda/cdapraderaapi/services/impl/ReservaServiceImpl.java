package com.cda.cdapraderaapi.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cda.cdapraderaapi.entitys.Disponibilidad;
import com.cda.cdapraderaapi.entitys.Persona;
import com.cda.cdapraderaapi.entitys.Reserva;
import com.cda.cdapraderaapi.entitys.ReservaUsuarios;
import com.cda.cdapraderaapi.entitys.Vehiculo;
import com.cda.cdapraderaapi.jsons.CrearReservaRest;
import com.cda.cdapraderaapi.jsons.DisponibilidadRest;
import com.cda.cdapraderaapi.jsons.ReservaRest;
import com.cda.cdapraderaapi.repositories.DisponibilidadRepository;
import com.cda.cdapraderaapi.repositories.PersonaRepository;
import com.cda.cdapraderaapi.repositories.ReservaRepository;
import com.cda.cdapraderaapi.repositories.VehiculoRepository;
import com.cda.cdapraderaapi.services.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	DisponibilidadRepository disponibilidadRepository;

	@Autowired
	private VehiculoRepository vehiculoRepository;

	@Autowired
	private JavaMailSender javaMailSender;

	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public String crearReserva(CrearReservaRest crearReservaRest) {
		Persona persona = new Persona();
		Reserva reserva = new Reserva();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dfh = new SimpleDateFormat("HH:mm");

		try {
			if (validarPersona(crearReservaRest.getCedula()) == null) {
				persona.setCedula(crearReservaRest.getCedula());
				persona.setEmail(crearReservaRest.getEmail());
				persona.setNombre(crearReservaRest.getNombre());
				persona.setTelefono(crearReservaRest.getTelefono());

				personaRepository.save(persona);
			} else {
				persona = validarPersona(crearReservaRest.getCedula());
			}

			reserva.setDisponibilidad(validarDisponibilidad(crearReservaRest.getDisponibildad()));
			reserva.setPersona(persona);
			reserva.setVehiculo(validarVehiculo(crearReservaRest.getVehiculo()));
			reserva.setPlaca(crearReservaRest.getPlaca());

			reservaRepository.save(reserva);

			String cuerpoMail = "Se ha realizado el agendamiento con exito para el dia "
					+ df.format(reserva.getDisponibilidad().getFecha()) + "a las "+ dfh.format(reserva.getDisponibilidad().getHora())+" del vehiculo tipo "
					+ reserva.getVehiculo().getDescripcion() + " con placa "+reserva.getPlaca()+" a nombre de "+reserva.getPersona().getNombre();
			sendMail(persona.getEmail(), "Su cita ha sido agendada con exito CDA La Pradera", cuerpoMail);

			return cuerpoMail;

		} catch (Exception e) {
			return "Error realizando reserva";
		}

	}

	public void sendMail(String para, String asunto, String cuerpo) {
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom("cdapradera@gmail.com");
			simpleMailMessage.setTo(para);
			simpleMailMessage.setSubject(asunto);
			simpleMailMessage.setText(cuerpo);

			javaMailSender.send(simpleMailMessage);

		} catch (Exception e) {
			System.out.println("Error enviando mail"+e.getMessage());
		}
		
	}

	public Persona validarPersona(String cedula) {

		try {
			Persona persona = new Persona();
			persona = personaRepository.findById(cedula).orElseThrow();
			return persona;

		} catch (Exception e) {
			return null;
		}

	}

	public Disponibilidad validarDisponibilidad(Long id) {

		try {
			Disponibilidad disponibilidad = new Disponibilidad();
			disponibilidad = disponibilidadRepository.findById(id).orElseThrow();
			return disponibilidad;

		} catch (Exception e) {
			return null;
		}

	}

	public Vehiculo validarVehiculo(Long id) {

		try {
			Vehiculo vehiculo = new Vehiculo();
			vehiculo = vehiculoRepository.findById(id).orElseThrow();
			return vehiculo;

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public List<ReservaRest> reservaByUsuario(String cedula) {
		try {
			Persona persona = validarPersona(cedula);
			if (persona != null) {
				List<Reserva> listaReservas = reservaRepository.findByPersona(persona);
				List<ReservaUsuarios> listareservaUsuarios = new ArrayList<>();

				for (int i = 0; i < listaReservas.size(); i++) {
					ReservaUsuarios reservaUsuario = new ReservaUsuarios();

					reservaUsuario.setCedula(cedula);
					reservaUsuario.setEmail(listaReservas.get(i).getPersona().getEmail());
					reservaUsuario.setFecha(listaReservas.get(i).getDisponibilidad().getFecha());
					reservaUsuario.setHora(listaReservas.get(i).getDisponibilidad().getHora());
					reservaUsuario.setId(listaReservas.get(i).getId());
					reservaUsuario.setNombre(listaReservas.get(i).getPersona().getNombre());
					reservaUsuario.setPlaca(listaReservas.get(i).getPlaca());
					reservaUsuario.setTelefono(listaReservas.get(i).getPersona().getTelefono());
					reservaUsuario.setTipo(listaReservas.get(i).getVehiculo().getDescripcion());

					listareservaUsuarios.add(reservaUsuario);

				}

				return listareservaUsuarios.stream().map(service -> modelMapper.map(service, ReservaRest.class))
						.collect(Collectors.toList());

			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

}
