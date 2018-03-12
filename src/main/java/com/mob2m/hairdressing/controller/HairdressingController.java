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
public class HairdressingController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView findAll() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		if (currentUserName == "marcos") {
			ModelAndView mv = new ModelAndView("home");
			mv.addObject("userLogged", currentUserName);
			return mv;
		}
		ModelAndView mv = new ModelAndView("financeiro");
		mv.addObject("styleValue", "display:none");
		mv.addObject("fragmentRemove", "all");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

	@RequestMapping(path = "${url.home}", method = RequestMethod.GET)
	public ModelAndView findAllHome() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = auth.getName();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("styleValue", "display:none");
		mv.addObject("fragmentRemove", "all");
		mv.addObject("userLogged", currentUserName);
		mv.addObject("home", ",<br/><br/><h1>Test Home</h1>");
		return mv;
	}

	@RequestMapping(path = "${url.login}", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		ModelAndView mv = new ModelAndView("login");
		//mv.addObject("clientes", );
		return mv;
	}

}
