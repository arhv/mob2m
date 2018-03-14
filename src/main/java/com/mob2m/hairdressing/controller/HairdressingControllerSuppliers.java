package com.mob2m.hairdressing.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HairdressingControllerSuppliers {
	@RequestMapping(path = "${url.cadastro.fornecedores}", method = RequestMethod.GET)
	public ModelAndView goCadastroFornecedores() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("cadastrofornecedores");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}
}
