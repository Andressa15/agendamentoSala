package com.agendamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.agendamento.models.Login;
@Repository
public interface LoginRepository  extends CrudRepository<Login , Integer> {

}
