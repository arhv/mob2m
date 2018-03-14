package com.mob2m.hairdressing.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HairdressingControllerServices {
	@RequestMapping(path = "${url.cadastro.servicos}", method = RequestMethod.GET)
	public ModelAndView goServicos() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("servicos");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

	@RequestMapping(path = "${url.servicos.detalhes}", method = RequestMethod.GET)
	public ModelAndView goServicosDetalhes() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("servicosporprofissional");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

	@RequestMapping(path = "${url.servicos.promocoes}", method = RequestMethod.GET)
	public ModelAndView goServicosPromocoes() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("servicospromocoes");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}
}
