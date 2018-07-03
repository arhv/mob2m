package com.mob2m.hairdressing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.service.UserAuthentication;

@RestController
public class HairdressingController {

	@Autowired
	private UserAuthentication userAuthentication;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView findAll() {
		return userAuthentication.getModelViewWithUser("home");
	}

	@RequestMapping(path = "${url.home}", method = RequestMethod.GET)
	public ModelAndView findAllHome() {
		return userAuthentication.getModelViewWithUser("home");
	}

	@RequestMapping(path = "/erro", method = RequestMethod.GET)
	public ModelAndView goError() {
		return userAuthentication.getModelViewWithUser("erro");
	}

	@RequestMapping(path = "${url.login}", method = RequestMethod.GET)
	public ModelAndView goLogin() {
		ModelAndView mvLogin = new ModelAndView("login");
		return mvLogin;
		//return userAuthentication.getModelViewWithUser("login");
	}
}
