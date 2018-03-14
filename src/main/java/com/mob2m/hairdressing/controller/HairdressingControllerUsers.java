package com.mob2m.hairdressing.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.dao.User;
import com.mob2m.hairdressing.service.UserService;

@RestController
public class HairdressingControllerUsers {

	@Autowired
	private UserService userService;


	@RequestMapping(path = "${url.usuarios.master.new.user}", method = RequestMethod.GET)
	public ModelAndView addNewUser(User user) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("usuariosmaster");
		mv.addObject("addUser", user);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUsers", "none");
		mv.addObject("removeEditUsers", "all");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

	@RequestMapping(path = "${url.usuarios.master.detalhes}/{id}", method = RequestMethod.GET)
	public ModelAndView goDetalhes(@PathVariable("id") Long id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("usuariosmaster");
		mv.addObject("editUsers", userService.findOne(id));
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUsers", "all");
		mv.addObject("removeEditUsers", "none");
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

	@RequestMapping(path = "${url.usuarios.master}", method = RequestMethod.GET)
	public ModelAndView goUsuariosMaster() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		ModelAndView mv = new ModelAndView("usuariosmaster");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddUsers", "all");
		mv.addObject("removeEditUsers", "all");
		mv.addObject("userList", userService.findAll());
		mv.addObject("userLogged", currentUserName);
		return mv;
	}

	@RequestMapping(path = "${url.usuarios.master.save}", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return addNewUser(user);
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user.setActive(true);
		user.setInsertdate(new Date(System.currentTimeMillis()));
		user.setInsertby(authentication.getName());
		userService.save(user);
		return goUsuariosMaster();
	}

}
