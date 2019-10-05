package com.agendamento.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Apelido nao pode ficar em branco")
	@Size(min = 2, message = "Apelido tem que ter no minimo 2 letras")
	private String apelido;
	
	@NotBlank(message = "Senha nao pode ficar em branco")
	@Size(min = 8, message = "Senha tem que ter no minimo 8 caracter")
	private String senhaCPF;

	@OneToOne(cascade = {CascadeType.ALL})
	private Usuario usuario;

	public Login() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getSenha() {
		return senhaCPF;
	}

	public void setSenha(String senha) {
		this.senhaCPF = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}