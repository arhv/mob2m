package com.mob2m.hairdressing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CompanyNamesService;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;

@RestController
public class HairdressingControllerCompanyNameSubsidiaries {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private CompanyNamesService companyNamesService;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	/*@RequestMapping(path = "/adicionarunidade", method = RequestMethod.GET)
	public ModelAndView addNewUser(CompanyNames companyNames, CompanySubsidiaries companySubsidiaries) {

		ModelAndView mv = userAuthentication.getModelViewWithUser("company");
		List<States> listStates = statesService.findAll();
		int initValue = 1;//iniciar combo com Cidades do Acre
		List<Cities> listCitiesNames = citiesService.stateCode(initValue);
		mv.addObject("state", listStates);
		mv.addObject("city", listCitiesNames);
		mv.addObject("userCity", initValue);
		mv.addObject("addUser", user1);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddCompany", "none");
		mv.addObject("removeEditCompany", "all");
		mv.addObject("removedCheckNewUsernameEmail", "all");
		return mv;
	}*/

	@RequestMapping(path = "/unidades", method = RequestMethod.GET)
	public ModelAndView allSubsidiaries() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("company");
		mv.addObject("removeFindAllSubsidiaries", "none");
		mv.addObject("removeAddSubsidiary", "all");
		mv.addObject("removeEditSubsidiary", "all");
		//mv.addObject("subsidiariesList", companySubsidiariesService.listSubsidiariesById(Long.valueOf(1)));//Need to refactor if there are more than 1 Company
		mv.addObject("companyList", companyNamesService.findOne(Long.valueOf(1))); //Need to refactor if there are more than 1 Company
		mv.addObject("subsidiariesList", companySubsidiariesService.findAll());
		return mv;
	}

}
