package com.agendamento.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.agendamento.models.Login;
import com.agendamento.models.Usuario;
import com.agendamento.services.LoginService;

@Controller
public class LoginControler {

	@Autowired
	private LoginService loginService;

	@GetMapping("/cadastro")
	public ModelAndView exibirFormulario() {
		ModelAndView modelView = new ModelAndView("cadastra.html");
		return modelView;
	}

	@PostMapping("/cadastro")
	public ModelAndView cadastrarLogin(@Valid Usuario usuario, BindingResult bindingUsuario,
			@Valid Login login,BindingResult bindingLogin) {
		ModelAndView modelView = new ModelAndView("cadastro.html");
		if(bindingUsuario.hasErrors() || bindingLogin.hasErrors()) {
			List<String> msgs = new ArrayList<String>();
			if (bindingUsuario.hasErrors() || bindingLogin.hasErrors()) {
				for(ObjectError objerro : bindingUsuario.getAllErrors()) {
					msgs.add(objerro.getDefaultMessage());
				}
				for(ObjectError objerro : bindingLogin.getAllErrors()) {
					msgs.add(objerro.getDefaultMessage());
				}
			}else {
				modelView.addObject("msgs", LoginService.cadastrarLogin(usuario, login));
			}
		}
		return modelView;
	}

}