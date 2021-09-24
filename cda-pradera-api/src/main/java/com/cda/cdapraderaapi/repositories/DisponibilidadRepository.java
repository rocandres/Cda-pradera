package com.cda.cdapraderaapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cda.cdapraderaapi.entitys.Disponibilidad;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long> {
	
	List<Disponibilidad> findAll();
	
	Optional<Disponibilidad> findById(Long id);
	
	@Query(value = "SELECT dis FROM Disponibilidad dis WHERE id NOT IN (SELECT res.disponibilidad FROM Reserva res )")
	List<Disponibilidad> findLibres();
		

}
