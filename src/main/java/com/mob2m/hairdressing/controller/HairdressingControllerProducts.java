package com.mob2m.hairdressing.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HairdressingControllerProducts {

	@RequestMapping(path = "${url.cadastro.produtos}", method = RequestMethod.GET)
	public ModelAndView goProdutos() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("produtos");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

	@RequestMapping(path = "${url.produtos.detalhes}", method = RequestMethod.GET)
	public ModelAndView goProdutosInsumos() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("produtosdetalhes");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

	@RequestMapping(path = "${url.produtos.estoque}", method = RequestMethod.GET)
	public ModelAndView goProdutosRevenda() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("produtosestoque");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}


}
