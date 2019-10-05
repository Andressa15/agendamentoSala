package com.agendamento.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.models.Sala;
import com.agendamento.repository.SalaRepository;

@Service
public class SalaService {
	@Autowired
	private SalaRepository salaRepository;

	public void salvar(Sala sala) {
		salaRepository.save(sala);
	}

	public Iterable<Sala>  mostrarTodos(){
		return salaRepository.findAll();		
	}

	public Sala pegarPorID( int id ) {
		return salaRepository.findById(id).get();
	}

	public void deletar(int id) {
		salaRepository.deleteById(id);
	}

	public void atualizar(Sala sala, int id) {
		sala.setId(id);
		salaRepository.save(sala);
	}

	public long quantidadeSala() {
		 return salaRepository.count();
	}
}

