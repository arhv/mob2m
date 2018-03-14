package com.mob2m.hairdressing.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HairdressingControllerProfessionals {
	@RequestMapping(path = "${url.cadastro.profissionais}", method = RequestMethod.GET)
	public ModelAndView goCadastroFornecedores() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		ModelAndView mv = new ModelAndView("cadastroprofissionais");
		mv.addObject("userLogged", name);
		return mv;
	}
}
