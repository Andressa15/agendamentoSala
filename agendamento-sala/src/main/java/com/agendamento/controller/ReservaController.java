package com.agendamento.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.models.Reserva;
import com.agendamento.models.Sala;
import com.agendamento.models.Usuario;
import com.agendamento.services.ReservaService;
import com.agendamento.services.SalaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
	@Autowired
	private ReservaService reservaService;

	@GetMapping("/{id}")
	public ResponseEntity<Reserva> buscarPeloID(@PathVariable Integer id) {
		try {
			Reserva reserva = reservaService.pegarPorID(id);
			return ResponseEntity.ok(reserva);
		}catch(Exception e ){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/mostrar")
	public ResponseEntity<?> pesquisar() {
		if (reservaService.quantidadeReserva()  > 0 ) {
			return ResponseEntity.ok(reservaService.mostrarTodos());
		}
		return ResponseEntity.noContent().build();
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable int id, Reserva reserva ) {
		try{
			reservaService.deletar(id);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Reserva reserva) {
		try { 
			reservaService.salvar(reserva);
			return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar (@PathVariable int id,@Valid @RequestBody Reserva reserva){
		try {
			reservaService.atualizar(reserva, id);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}

