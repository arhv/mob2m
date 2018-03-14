package com.mob2m.hairdressing.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HairdressingControllerCustomers {
	@RequestMapping(path = "${url.cadastro.clientes}", method = RequestMethod.GET)
	public ModelAndView goClientes() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		ModelAndView mv = new ModelAndView("cadastroclientes");
		mv.addObject("userLogged", name);
		return mv;
	}
}
