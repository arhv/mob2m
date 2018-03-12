package com.mob2m.hairdressing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HairdressingControllerServices {
	@RequestMapping(path = "${url.cadastro.servicos}", method = RequestMethod.GET)
	public ModelAndView goServicos() {
		ModelAndView mv = new ModelAndView("servicos");
		return mv;
	}

	@RequestMapping(path = "${url.servicos.detalhes}", method = RequestMethod.GET)
	public ModelAndView goServicosDetalhes() {
		ModelAndView mv = new ModelAndView("servicosdetalhes");
		return mv;
	}

	@RequestMapping(path = "${url.servicos.promocoes}", method = RequestMethod.GET)
	public ModelAndView goServicosPromocoes() {
		ModelAndView mv = new ModelAndView("servicospromocoes");
		//mv.addObject("clientes", );
		return mv;
	}
}
