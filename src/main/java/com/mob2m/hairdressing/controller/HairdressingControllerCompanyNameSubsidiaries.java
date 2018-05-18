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

import com.mob2m.hairdressing.model.dao.Cities;
import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;
import com.mob2m.hairdressing.model.dao.States;
import com.mob2m.hairdressing.model.service.StringEncryption;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CitiesService;
import com.mob2m.hairdressing.service.CompanyNamesService;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.StatesService;
import com.mob2m.hairdressing.service.UserService;

@RestController
public class HairdressingControllerCompanyNameSubsidiaries {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private CompanyNamesService companyNamesService;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@Autowired
	private UserService userService;

	@Autowired
	private StringEncryption userEncrypt;

	@Autowired
	private CitiesService citiesService;

	@Autowired
	private StatesService statesService;

	@RequestMapping(path = "/adicionarunidade", method = RequestMethod.GET)
	public ModelAndView addNewSubsidiaries(CompanySubsidiaries companySubsidiaries) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("company");
		List<States> listStates = statesService.findAll();
		int initValue = 9432;//iniciar combo com Cidades de Osasco
		List<Cities> listCitiesNames = citiesService.stateCode(initValue);
		mv.addObject("state", listStates);
		mv.addObject("city", listCitiesNames);
		mv.addObject("subsidiaryCity", initValue);
		mv.addObject("addSubsidiaries", companySubsidiaries);
		mv.addObject("removeFindAllSubsidiaries", "all");
		mv.addObject("removeAddSubsidiary", "none");
		mv.addObject("removeEditSubsidiary", "all");
		//mv.addObject("removedCheckNewUsernameEmail", "all");
		return mv;
	}

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

	@RequestMapping(path = "/editarunidade/{id}", method = RequestMethod.GET)
	public ModelAndView goUnidades(@PathVariable("id") Long id) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("company");
		CompanySubsidiaries companySubsidiaries = companySubsidiariesService.findOne(id);
		int companySubsidiariesState = Integer.parseInt(companySubsidiaries.getCompanySubsidiaryState());
		int companySubsidiariesCity = Integer.parseInt(companySubsidiaries.getCompanySubsidiaryCity());
		//User user = userService.findOne(id);
		//int userState = Integer.parseInt(user.getState());
		//int userCity = Integer.parseInt(user.getCity());
		List<States> listStates = statesService.findAll();
		List<Cities> listCitiesNames = citiesService.stateCodeSubsidiaries(companySubsidiariesState);
		mv.addObject("companyList", companyNamesService.findOne(Long.valueOf(1)));
		mv.addObject("companySubsidiariesState", companySubsidiariesState);
		mv.addObject("state", listStates);
		mv.addObject("city", listCitiesNames);
		mv.addObject("companySubsidiariesCity", companySubsidiariesCity);
		mv.addObject("editCompanySubsidiaries", companySubsidiariesService.findOne(id));
		mv.addObject("removeFindAllSubsidiaries", "all");
		mv.addObject("removeAddSubsidiary", "all");
		mv.addObject("removeEditSubsidiary", "none");
		//mv.addObject("removedCheckNewUsernameEmail", "all");
		return mv;
	}

	@RequestMapping(path = "/salvarunidade", method = RequestMethod.POST)
	public ModelAndView saveSubsidiary(@Valid CompanySubsidiaries editCompanySubsidiaries, BindingResult result) {

		if (result.hasErrors()) {
		//return addNewUser(user);
		}
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();		
		companySubsidiariesService.save(editCompanySubsidiaries);
		return allSubsidiaries();
	}

}
