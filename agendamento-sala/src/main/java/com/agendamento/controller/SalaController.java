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

import com.agendamento.models.Sala;
import com.agendamento.models.Usuario;
import com.agendamento.services.SalaService;

@RestController
@RequestMapping("/sala")
public class SalaController {

	@Autowired
	private SalaService salaService;

	@GetMapping("/{id}")
	public ResponseEntity<Sala> buscarPeloID(@PathVariable Integer id) {
		System.out.println(1);
		try {
			Sala sala = salaService.pegarPorID(id);
			return ResponseEntity.ok(sala);
		}catch(Exception e ){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/mostrar")
	public ResponseEntity<?> pesquisar() {
		System.out.println(2);
		if (salaService.quantidadeSala()  > 0 ) {
			return ResponseEntity.ok(salaService.mostrarTodos());
		}
		return ResponseEntity.noContent().build();
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable int id, Usuario usuario) {
		try{
			salaService.deletar(id);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Sala sala) {
		System.out.println(1);
		try { 
			salaService.salvar(sala);
			return ResponseEntity.status(HttpStatus.CREATED).body(sala);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar (@PathVariable int id,@Valid @RequestBody Sala sala){
		try {
			salaService.atualizar(sala, id);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
