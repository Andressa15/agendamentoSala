package com.agendamento.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Reserva implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private LocalDate periodoAte;

	
	@Column(length = 50)
	private String descricao;
	
	@ManyToOne()
	private Usuario usuario;

	@ManyToOne()  
	@JoinColumn(name = "sala_id")
	private Sala sala;


	public Reserva() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;	
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public LocalDate getPeriodoAte() {
		return periodoAte;
	}

	public void setPeriodoAte(LocalDate periodoAte) {
		this.periodoAte = periodoAte;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}