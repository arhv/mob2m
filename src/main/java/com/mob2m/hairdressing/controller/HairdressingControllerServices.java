package com.mob2m.hairdressing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.service.UserAuthentication;

@RestController
public class HairdressingControllerServices {

	@Autowired
	private UserAuthentication userAuthentication;

	@RequestMapping(path = "${url.cadastro.servicos}", method = RequestMethod.GET)
	public ModelAndView goServicos() {
		return userAuthentication.getModelViewWithUser("servicos");
	}

	@RequestMapping(path = "${url.servicos.detalhes}", method = RequestMethod.GET)
	public ModelAndView goServicosDetalhes() {
		return userAuthentication.getModelViewWithUser("servicosporprofissional");
	}

	@RequestMapping(path = "${url.servicos.promocoes}", method = RequestMethod.GET)
	public ModelAndView goServicosPromocoes() {
		return userAuthentication.getModelViewWithUser("servicospromocoes");
	}
}
