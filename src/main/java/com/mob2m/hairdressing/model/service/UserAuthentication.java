package com.mob2m.hairdressing.model.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserAuthentication {
	public ModelAndView getModelViewWithUser(String htmlPage) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView(htmlPage);
		mv.addObject("userLogged", currentUserName);
		return mv;
	}
}
