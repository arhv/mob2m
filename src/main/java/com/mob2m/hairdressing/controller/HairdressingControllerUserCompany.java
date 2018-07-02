package com.mob2m.hairdressing.controller;

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
import com.mob2m.hairdressing.model.dao.User;
import com.mob2m.hairdressing.model.dao.UserCompany;
import com.mob2m.hairdressing.model.dao.UserRoles;
import com.mob2m.hairdressing.model.service.StringEncryption;
import com.mob2m.hairdressing.model.service.StringList;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.UserCompanyService;
import com.mob2m.hairdressing.service.UserRolesService;
import com.mob2m.hairdressing.service.UserService;

@RestController
public class HairdressingControllerUserCompany {

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

	public HairdressingControllerUserCompany() {

	}


	@RequestMapping(path = "/administrativo/adicionarpermissao", method = RequestMethod.GET)
	public ModelAndView addNewUserCompany(UserCompany userCompany) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usercompany");
		List<User> listUserService = userService.findAll();
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<UserRoles> listUserRoles = userRolesService.findAll();
		mv.addObject("addUserCompany", userCompany);
		mv.addObject("usernameList", listUserService);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("userCompanyRoleLevel", listUserRoles);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUserCompany", "none");
		mv.addObject("removeEditUserCompany", "all");
		return mv;

	}


	@RequestMapping(path = "/administrativo/editarpermissao/{id}", method = RequestMethod.GET)
	public ModelAndView goDetails(@PathVariable("id") Long id) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usercompany");
		UserCompany listUserCompany = userCompanyService.findOne(id);
		List<User> listUserService = userService.findAll();
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<UserRoles> listUserRoles = userRolesService.findAll();
		mv.addObject("editUserCompany", listUserCompany);
		mv.addObject("usernameList", listUserService);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("userCompanyRoleLevel", listUserRoles);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddUserCompany", "all");
		mv.addObject("removeEditUserCompany", "none");
		return mv;
	}


	@RequestMapping(path = "/administrativo/permissoes", method = RequestMethod.GET)
	public ModelAndView goUserCompany(UserCompany userCompany) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("usercompany");
		mv.addObject("userCompanyList", userCompanyService.findAll());
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddUserCompany", "all");
		mv.addObject("removeEditUserCompany", "all");
		return mv;

	}



	@RequestMapping(path = "/administrativo/salvarpermissao", method = RequestMethod.POST)
	public RedirectView savePermission(@Valid UserCompany userCompany, BindingResult result) {
		if (result.hasErrors()) {
		//return addNewUserRole(userRoles);
		}

		Long usernameId = userCompany.getUser().getId();
		User user = userService.findOne(usernameId);
		String username_string = user.getUsername();
		userCompany.setUsername_string(username_string);;
		userCompany.setUser_role_string(StringList.USER_ROLE_STRING);
		userCompanyService.save(userCompany);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/administrativo/permissoes");
		return rv;

	}
}
