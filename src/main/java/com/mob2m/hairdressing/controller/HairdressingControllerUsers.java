package com.mob2m.hairdressing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.dao.User;
import com.mob2m.hairdressing.model.service.StringEncryption;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.UserService;

@RestController
public class HairdressingControllerUsers {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private StringEncryption userEncrypt;

	@RequestMapping(path = "${url.usuarios.master.new.user}", method = RequestMethod.GET)
	public ModelAndView addNewUser(User user) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usuariosmaster");
		mv.addObject("addUser", user);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUsers", "none");
		mv.addObject("removeEditUsers", "all");
		return mv;

	}

	@RequestMapping(path = "${url.usuarios.master.detalhes}/{id}", method = RequestMethod.GET)
	public ModelAndView goDetalhes(@PathVariable("id") Long id) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usuariosmaster");
		mv.addObject("editUsers", userService.findOne(id));
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUsers", "all");
		mv.addObject("removeEditUsers", "none");
		return mv;
	}

	//@RequestMapping(path = "${url.usuarios.master}", method = RequestMethod.GET, produces = { "application/xml", "text/html" })
	@RequestMapping(path = "${url.usuarios.master}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	/*public ModelAndView goUsuariosMaster() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usuariosmaster");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddUsers", "all");
		mv.addObject("removeEditUsers", "all");
		mv.addObject("userList", userService.findAll());
		return mv;
	}*/
	public List<User> goUsuariosMaster() {
		return userService.findAll();
	}

	/*@RequestMapping(path = "${url.usuarios.master.save}", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return addNewUser(user);
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user.setActive(true);
		user.setInsertdate(new Date(System.currentTimeMillis()));
		user.setInsertby(authentication.getName());
		user.setPassword(userEncrypt.getEncrypt(user.getPassword().toString()));
		userService.save(user);
		return goUsuariosMaster();
	}*/

}
