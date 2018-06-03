package com.mob2m.hairdressing.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;
import com.mob2m.hairdressing.model.dao.Professionals;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.ProfessionalsService;

@RestController
public class HairdressingControllerProfessionals {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private ProfessionalsService professionalsService;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@RequestMapping(path = "/adicionarprofissional", method = RequestMethod.GET)
	public ModelAndView addNewProfessional(Professionals professionals) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("profissionais");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("addProfessionals", professionals);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProfessionals", "none");
		mv.addObject("removeEditProfessionals", "all");
		return mv;
	}

	@RequestMapping(path = "/editarprofissional/{id}", method = RequestMethod.GET)
	public ModelAndView goDetails(@PathVariable("id") Long id) {
		Professionals professionals = professionalsService.findOne(id);
		ModelAndView mv = userAuthentication.getModelViewWithUser("profissionais");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("editProfessionals", professionals);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProfessionals", "all");
		mv.addObject("removeEditProfessionals", "none");
		return mv;
	}

	@RequestMapping(path = "/profissionais", method = RequestMethod.GET)
	public ModelAndView goProfessionals() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("profissionais");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddProfessionals", "all");
		mv.addObject("removeEditProfessionals", "all");
		mv.addObject("professionalsList", professionalsService.findAll());
		//mv.addObject("professionalsListJoined", professionalsService.listAllProfessionalsJoinedCityState());
		return mv;

	}

	@RequestMapping(path = "/salvarprofissional", method = RequestMethod.POST)
	public RedirectView save(@Valid Professionals professionals, BindingResult result) {
		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());

		}

		}

		professionalsService.save(professionals);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/profissionais");
		return rv;

	}

}
