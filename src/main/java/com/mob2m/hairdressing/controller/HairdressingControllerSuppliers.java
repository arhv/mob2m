package com.mob2m.hairdressing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HairdressingControllerSuppliers {
	@RequestMapping(path = "${url.cadastro.fornecedores}", method = RequestMethod.GET)
	public ModelAndView goCadastroFornecedores() {
		ModelAndView mv = new ModelAndView("cadastrofornecedores");
		return mv;
	}
}
