package com.mob2m.hairdressing.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HairdressingControllerProducts {

	@RequestMapping(path = "${url.cadastro.produtos}", method = RequestMethod.GET)
	public ModelAndView goProdutos() {
		ModelAndView mv = new ModelAndView("produtos");
		return mv;
	}

	@RequestMapping(path = "${url.produtos.consumo}", method = RequestMethod.GET)
	public ModelAndView goProdutosInsumos() {
		ModelAndView mv = new ModelAndView("produtosconsumo");
		//mv.addObject("clientes", );
		return mv;
	}

	@RequestMapping(path = "${url.produtos.revenda}", method = RequestMethod.GET)
	public ModelAndView goProdutosRevenda() {
		ModelAndView mv = new ModelAndView("produtosrevenda");
		//mv.addObject("clientes", );
		return mv;
	}


}
