package com.agendamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agendamento.models.Reserva;

@Repository
public interface ReservaRepository  extends CrudRepository<Reserva , Integer>{

}
