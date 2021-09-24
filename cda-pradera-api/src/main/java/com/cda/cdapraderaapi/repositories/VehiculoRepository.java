package com.cda.cdapraderaapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cda.cdapraderaapi.entitys.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
	 
	List<Vehiculo> findAll();

}
