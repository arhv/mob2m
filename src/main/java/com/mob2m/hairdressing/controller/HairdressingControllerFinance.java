package com.mob2m.hairdressing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.service.UserService;

@RestController
public class HairdressingControllerFinance {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "${url.financeiro}", method = RequestMethod.GET)
	public ModelAndView goFinanceiro() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("fluxodecaixa");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

}
