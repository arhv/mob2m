package com.mob2m.hairdressing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.service.UserAuthentication;

@RestController
public class HairdressingControllerOthers {

	@Autowired
	private UserAuthentication userAuthentication;

	@RequestMapping(path = "${url.outros}", method = RequestMethod.GET)
	public ModelAndView goOutros() {
		return userAuthentication.getModelViewWithUser("adminoutros");
	}

}
