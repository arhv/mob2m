package com.mob2m.hairdressing.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class UserAuthentication {

	@Autowired
	UserViewPermissions userViewPermissions;

	public ModelAndView getModelViewWithUser(String htmlPage) {
		ModelAndView mv = new ModelAndView(htmlPage);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		if (currentUserName == null) {
		ModelAndView mvError = new ModelAndView("/login");
		return mvError;
		}
		ModelAndView mv1 = userViewPermissions.getUserDetails(currentUserName, mv);
		mv1.addObject("userLogged", currentUserName);
		return mv1;
	}

}
