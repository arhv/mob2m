package com.mob2m.hairdressing.controller;

import java.text.ParseException;
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

import com.mob2m.hairdressing.model.dao.ComandasPaymentsTypes;
import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.ComandasPaymentsTypesService;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;

@RestController
public class HairdressingControllerComandasPaymentsTypes {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@Autowired
	private ComandasPaymentsTypesService comandasPaymentsTypesService;


	@RequestMapping(path = "/adicionartipodepagamentosdecomandas", method = RequestMethod.GET)
	public ModelAndView addNewComandasPaymentsTypes(ComandasPaymentsTypes comandasPaymentsTypes) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandaspaymentstypes");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("addComandasPaymentsTypes", comandasPaymentsTypes);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasPaymentsTypes", "none");
		mv.addObject("removeEditComandasPaymentsTypes", "all");
		return mv;
	}

	@RequestMapping(path = "/editartipodepagamentodecomanda/{id}", method = RequestMethod.GET)
	public ModelAndView goDetailsComanda(@PathVariable("id") Long id) throws ParseException {
		ComandasPaymentsTypes comandasPaymentsTypes = comandasPaymentsTypesService.findOne(id);
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandaspaymentstypes");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("editComandasPaymentsTypes", comandasPaymentsTypes);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasPaymentsTypes", "all");
		mv.addObject("removeEditComandasPaymentsTypes", "none");
		return mv;
	}

	@RequestMapping(path = "/tiposdepagamentosdecomandas", method = RequestMethod.GET)
	public ModelAndView goPaymentsTypes() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandaspaymentstypes");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddComandasPaymentsTypes", "all");
		mv.addObject("removeEditComandasPaymentsTypes", "all");
		mv.addObject("comandasPaymentsTypesList", comandasPaymentsTypesService.findAll());
		return mv;

	}

	@RequestMapping(path = "/salvartipodepagamentodecomanda", method = RequestMethod.POST)
	public RedirectView save(@Valid ComandasPaymentsTypes comandasPaymentsTypes, BindingResult result) {
		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}

		}
		comandasPaymentsTypesService.save(comandasPaymentsTypes);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/tiposdepagamentosdecomandas");
		return rv;
	}


}
