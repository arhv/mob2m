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
public class HairdressingControllerAdmin {


	@Autowired
	private UserService userService;

	@RequestMapping(path = "${url.administrativo.permissoes}", method = RequestMethod.GET)
	public ModelAndView goAdministrativoPermissoes() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("adminpermissoes");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

}
