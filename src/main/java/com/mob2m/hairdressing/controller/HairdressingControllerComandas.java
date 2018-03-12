package com.mob2m.hairdressing.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
		ModelAndView mv = new ModelAndView("comandas");
		mv.addObject("styleValue", "display:none");
		mv.addObject("comandas", ",<br/><br/><h1>Test Comandas</h1>");
		return mv;
	}


}
