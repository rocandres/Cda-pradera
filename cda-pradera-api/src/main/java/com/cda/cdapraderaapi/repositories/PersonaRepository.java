package com.cda.cdapraderaapi.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cda.cdapraderaapi.entitys.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,String>{
	
	
	Optional<Persona> findById(String cedula);
	
}
