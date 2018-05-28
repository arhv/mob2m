package com.mob2m.hairdressing.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;
import com.mob2m.hairdressing.model.dao.UserRoles;
import com.mob2m.hairdressing.model.service.StringEncryption;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.UserCompanyService;
import com.mob2m.hairdressing.service.UserRolesService;
import com.mob2m.hairdressing.service.UserService;

@RestController
public class HairdressingControllerUserRoles {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private StringEncryption userEncrypt;

	@Autowired
	private UserCompanyService userCompanyService;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@Autowired
	private UserRolesService userRolesService;


	public HairdressingControllerUserRoles() {

	}

	@RequestMapping(path = "/administrativo/adicionarniveldepermissao", method = RequestMethod.GET)
	public ModelAndView addNewUserRole(UserRoles userRoles) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usersroles");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<String> optionDisplayRole = getDisplayRole();
		mv.addObject("addUserDisplayRole", optionDisplayRole);
		mv.addObject("addUserRole", userRoles);
		mv.addObject("userRoleList", listCompanySubsidiaries);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUserRole", "none");
		mv.addObject("removeEditUserRole", "all");
		return mv;

	}

	public List <String> getDisplayRole(){
		List<String> optionDisplay = new ArrayList<>();
		optionDisplay.add("NÃO");
		optionDisplay.add("SIM");
		return optionDisplay;
	}


	@RequestMapping(path = "/administrativo/editarniveldepermissao/{id}", method = RequestMethod.GET)
	public ModelAndView goDetailsRoles(@PathVariable("id") Long id) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usersroles");
		UserRoles listUserRolesEdit = userRolesService.findOne(id);
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<String> optionDisplayRole = getDisplayRole();
		mv.addObject("editUserRole", listUserRolesEdit);
		mv.addObject("addUserDisplayRole", optionDisplayRole);
		mv.addObject("editListUserRole", listUserRolesEdit);
		mv.addObject("userRoleList", listCompanySubsidiaries);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUserRole", "all");
		mv.addObject("removeEditUserRole", "none");
		return mv;
	}


	@RequestMapping(path = "/administrativo/niveisdepermissoes", method = RequestMethod.GET)
	public ModelAndView goUserRole(UserRoles userRoles) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usersroles");
		List<UserRoles> listUserRoles = userRolesService.findAll();
		mv.addObject("userRoleList", listUserRoles);
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddUserRole", "all");
		mv.addObject("removeEditUserRole", "all");
		return mv;

	}



	@RequestMapping(path = "/administrativo/salvarniveldepermissao", method = RequestMethod.POST)
	public RedirectView saveUserRole(@Valid UserRoles userRoles, BindingResult result) {
		if (result.hasErrors()) {
		//return addNewUserRole(userRoles);
		}
		userRolesService.save(userRoles);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/administrativo//niveisdepermissoes");
		return rv;

	}
}
