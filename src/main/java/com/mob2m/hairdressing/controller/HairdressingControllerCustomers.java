package com.mob2m.hairdressing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HairdressingControllerCustomers {
	@RequestMapping(path = "${url.cadastro.clientes}", method = RequestMethod.GET)
	public ModelAndView goClientes() {
		ModelAndView mv = new ModelAndView("cadastroclientes");
		//mv.addObject("clientes", );
		return mv;
	}
}
