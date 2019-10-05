package com.agendamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agendamento.models.Sala;
@Repository
public interface SalaRepository extends CrudRepository<Sala, Integer> {

	

}
