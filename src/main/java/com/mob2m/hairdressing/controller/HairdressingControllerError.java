package com.mob2m.hairdressing.controller;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView handleError(HttpServletRequest request) {
		//ModelAndView mv = userAuthentication.getModelViewWithUser("erro");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

		ModelAndView mv = new ModelAndView("erro");
		mv.addObject("statusCodeDetail", statusCode);
		mv.addObject("errorDetail", exception);

		return mv;
	}
	/*@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		return String.format(
				"<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>" + "<div>Exception Message: <b>%s</b></div><body></html>",
				statusCode, exception == null ? "N/A" : exception.getMessage());
	}*/


}
