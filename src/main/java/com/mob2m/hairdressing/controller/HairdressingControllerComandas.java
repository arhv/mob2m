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
public class HairdressingControllerComandas {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "${url.comandas}", method = RequestMethod.GET)
	public ModelAndView goComandas() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		ModelAndView mv = new ModelAndView("agenda");
		mv.addObject("userLogged", name);
		return mv;
	}


}
