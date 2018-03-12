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
public class HairdressingControllerAgenda {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "${url.agenda}", method = RequestMethod.GET)
	public ModelAndView goAgenda() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName(); //get logged in username
		ModelAndView mv = new ModelAndView("agenda");
		mv.addObject("styleValue", "display:none");
		mv.addObject("fragmentRemove", "all");
		mv.addObject("userLogged", name);
		mv.addObject("agenda", ",<br/><br/><h1>Test Agenda</h1>");

		return mv;
	}
}
