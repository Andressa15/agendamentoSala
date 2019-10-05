package com.agendamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.models.Reserva;
import com.agendamento.repository.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	private ReservaRepository reversaRepository;

	public void salvar(Reserva reserva ) {
		reversaRepository.save(reserva);
	}

	public Iterable<Reserva> mostrarTodos(){
		return reversaRepository.findAll();
	}

	public Reserva pegarPorID( int id ) {
		return reversaRepository.findById(id).get();

	}

	public void deletar(int id) {
		reversaRepository.deleteById(id);
	}

	public void atualizar(Reserva reserva , int id) {
		reserva.setId(id);
		reversaRepository.save(reserva );
	}

	public long quantidadeReserva () {
		 return reversaRepository.count();
	}
}

