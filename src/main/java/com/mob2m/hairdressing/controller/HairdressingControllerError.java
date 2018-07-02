package com.mob2m.hairdressing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.service.UserAuthentication;

@RestController
public class HairdressingControllerError implements ErrorController {

	@Autowired
	private UserAuthentication userAuthentication;

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/erro";
	}

	@RequestMapping("/error")
	public ModelAndView handleError() {
		//ModelAndView mv = userAuthentication.getModelViewWithUser("erro");
		ModelAndView mv = new ModelAndView("erro");

		return mv;
	}


}
