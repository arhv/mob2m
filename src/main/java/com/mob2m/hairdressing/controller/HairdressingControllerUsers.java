package com.mob2m.hairdressing.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.mob2m.hairdressing.model.dao.Cities;
import com.mob2m.hairdressing.model.dao.States;
import com.mob2m.hairdressing.model.dao.User;
import com.mob2m.hairdressing.model.dao.UsernameEmail;
import com.mob2m.hairdressing.model.service.StringEncryption;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CitiesService;
import com.mob2m.hairdressing.service.StatesService;
import com.mob2m.hairdressing.service.UserService;

@RestController
public class HairdressingControllerUsers {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private StringEncryption userEncrypt;

	@Autowired
	private CitiesService citiesService;

	@Autowired
	private StatesService statesService;

	@RequestMapping(path = "/adicionar", method = RequestMethod.GET)
	public ModelAndView addNewUser(User user) {
		User user1 = new User();
		ModelAndView mv = userAuthentication.getModelViewWithUser("usuariosmaster");
		//long initState = 26;
		List<States> listStates = statesService.findAll();
		int initValue = 26;//iniciar combo com Cidades de São Paulo
		List<Cities> listCitiesNames = citiesService.stateCode(initValue);
		mv.addObject("state", listStates);
		mv.addObject("city", listCitiesNames);
		mv.addObject("userCity", initValue);
		mv.addObject("addUser", user1);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUsers", "none");
		mv.addObject("removeEditUsers", "all");
		mv.addObject("removedCheckNewUsernameEmail", "all");
		return mv;

	}

	@RequestMapping(path = "/verificaremailusuario", method = RequestMethod.GET)
	public ModelAndView checkNewUserEmailUsername(UsernameEmail usernameEmail) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usuariosmaster");
		mv.addObject("checkUsernameEmail", usernameEmail);
		mv.addObject("removedCheckNewUsernameEmail", "none");
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUsers", "all");
		mv.addObject("removeEditUsers", "all");
		return mv;
	}

	@RequestMapping(path = "/checkuseremail/{email:.+}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String checkUserEmail(@PathVariable("email") String email) {
		System.out.println("Accessing method checkUserEmail = " + email);
		String userEmailExists;
		List<String> checkValidUserEmailfromDatabase = userService.checkValidUserEmail(email);
		System.out.println("Value of checkValidUserEmailfromDatabase = " + checkValidUserEmailfromDatabase.size());
		Gson jsonUsernameExists = new Gson();
		if (checkValidUserEmailfromDatabase.isEmpty()) {
		userEmailExists = jsonUsernameExists.toJson(0);
		} else {
		userEmailExists = jsonUsernameExists.toJson(1);
		}		
		return userEmailExists;		 
	}


	@RequestMapping(path = "/checkusername/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON )
	public String checkUsernameEmail(@PathVariable("username") String username) {
		String usernameExists;
		List<String> checkValidUsernamefromDatabase = userService.checkValidUsername(username);
		Gson jsonUsernameExists = new Gson();
		if (checkValidUsernamefromDatabase.isEmpty()) {
		usernameExists = jsonUsernameExists.toJson(0);
		} else {
		usernameExists = jsonUsernameExists.toJson(1);
		}		
		return usernameExists;		 
	}

	@RequestMapping(path = "/listStates/{listState}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public String getCityList(@PathVariable("listState") int listState) {
		List<Cities> listCitiesNames = citiesService.stateCode(listState);
		Gson jsonConvert = new Gson();
		String listCitiesNameJson = jsonConvert.toJson(listCitiesNames);
		return listCitiesNameJson;
	}

	@RequestMapping(path = "/estadousuario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
	public int getUserState(@PathVariable("id") Long id) {
		User userById = userService.findOne(id);
		int userState = userById.getStateName();
		return userState;
	}

	@RequestMapping(path = "/detalhes/{id}", method = RequestMethod.GET)
	public ModelAndView goDetalhes(@PathVariable("id") Long id) {
		User user = userService.findOne(id);
		int userState = user.getStateName();
		int userCity = user.getCityName();
		List<States> listStates = statesService.findAll();
		List<Cities> listCitiesNames = citiesService.stateCode(userState);
		ModelAndView mv = userAuthentication.getModelViewWithUser("usuariosmaster");
		mv.addObject("userState", userState);
		mv.addObject("state", listStates);
		mv.addObject("city", listCitiesNames);
		mv.addObject("userCity", userCity);
		mv.addObject("editUsers", userService.findOne(id));
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUsers", "all");
		mv.addObject("removeEditUsers", "none");
		mv.addObject("removedCheckNewUsernameEmail", "all");
		return mv;
	}

	@RequestMapping(path = "${url.usuarios.master}", method = RequestMethod.GET)
	//@RequestMapping(path = "${url.usuarios.master}", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	//@ResponseBody
	public ModelAndView goUsuariosMaster() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usuariosmaster");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removedCheckNewUsernameEmail", "all");
		mv.addObject("removeAddUsers", "all");
		mv.addObject("removeEditUsers", "all");
		mv.addObject("userList", userService.findAll());
		return mv;
	}
	/*public List<User> goUsuariosMaster() {
		return userService.findAll();
	}*/

	@RequestMapping(path = "${url.usuarios.master.save}", method = RequestMethod.POST)
	//produces = MediaType.APPLICATION_XML_VALUE)
	//@ResponseBody
	//public ModelAndView save(@Valid @ModelAttribute("user") User user, BindingResult result) {
	//public int save(@RequestBody User user) {
	public ModelAndView save(@Valid User user, BindingResult result) {
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
	}

	@RequestMapping(path = "/atualizarusuario", method = RequestMethod.POST)
	//produces = MediaType.APPLICATION_XML_VALUE)
	//@ResponseBody
	//public ModelAndView save(@Valid @ModelAttribute("user") User user, BindingResult result) {
	//public int save(@RequestBody User user) {
	public ModelAndView saveEdit(@Valid User user, BindingResult result) {
		User returnPasswordObject = (userService.findOne(user.getId()));
		if (result.hasErrors()) {
		if (user.getPassword() == null) {
		String password = returnPasswordObject.getPassword();
		user.setPassword(password);
		} else {
		return addNewUser(user);
		}
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		user.setInsertdate(new Date(System.currentTimeMillis()));
		user.setInsertby(authentication.getName());
		user.setCode_pk_tbl_user(returnPasswordObject.getCode_pk_tbl_user());
		System.out.println("Code_pk_tbl_user: " + returnPasswordObject.getCode_pk_tbl_user());
		int returnUpdate = userService.update(user.getId(), user.getActive(), user.getInsertdate(), user.getInsertby(), user.getEmail(),
				user.getName(), user.getPhonenumber(), user.getAddress(), user.getZipCode(), user.getCityName(), user.getStateName());
		userService.save(user);
		return goUsuariosMaster();
	}
}
