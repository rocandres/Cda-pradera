package com.cda.cdapraderaapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.cdapraderaapi.entitys.Persona;
import com.cda.cdapraderaapi.entitys.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	Optional<Reserva> findById(Long id);
	
	List<Reserva> findByPersona(Persona persona);

}
