package com.mob2m.hairdressing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.service.UserAuthentication;

@RestController
public class HairdressingControllerProducts {

	@Autowired
	private UserAuthentication userAuthentication;

	@RequestMapping(path = "${url.cadastro.produtos}", method = RequestMethod.GET)
	public ModelAndView goProdutos() {
		return userAuthentication.getModelViewWithUser("produtos");
	}

	@RequestMapping(path = "${url.produtos.detalhes}", method = RequestMethod.GET)
	public ModelAndView goProdutosInsumos() {
		return userAuthentication.getModelViewWithUser("produtosdetalhes");
	}

	@RequestMapping(path = "${url.produtos.estoque}", method = RequestMethod.GET)
	public ModelAndView goProdutosRevenda() {
		return userAuthentication.getModelViewWithUser("produtosestoque");
	}


}
