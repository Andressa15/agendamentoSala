package com.agendamento.services;
import com.agendamento.models.Login;
import com.agendamento.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agendamento.repository.LoginRepository;
@Service
public class LoginService {

	@Autowired
	private static LoginRepository loginRepository;

	public static String cadastrarLogin(Usuario usuario, Login login) {
		login.setUsuario(usuario);
		loginRepository.save(login);
		return "Login cadastrado";
	}
}
