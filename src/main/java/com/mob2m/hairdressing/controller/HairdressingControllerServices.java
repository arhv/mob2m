package com.mob2m.hairdressing.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;
import com.mob2m.hairdressing.model.dao.Services;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.ServicesService;

@RestController
public class HairdressingControllerServices {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private ServicesService servicesService;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@RequestMapping(path = "/adicionarservico", method = RequestMethod.GET)
	public ModelAndView addNewService(Services services) {		
		ModelAndView mv = userAuthentication.getModelViewWithUser("servicos");
		final Locale brLocale = new Locale("pt", "BR");
		final NumberFormat brFormat = NumberFormat.getCurrencyInstance(brLocale);
		brFormat.format(services.getValue());
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("addServices", services);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddServices", "none");
		mv.addObject("removeEditServices", "all");
		return mv;
	}

	@RequestMapping(path = "/editarservico/{id}", method = RequestMethod.GET)
	public ModelAndView goDetalhes(@PathVariable("id") Long id) {
		Services services = servicesService.findOne(id);		
		ModelAndView mv = userAuthentication.getModelViewWithUser("servicos");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("editServices", services);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddServices", "all");
		mv.addObject("removeEditServices", "none");
		return mv;
	}

	@RequestMapping(path = "/servicos", method = RequestMethod.GET)
	public ModelAndView goServices() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("servicos");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddServices", "all");
		mv.addObject("removeEditServices", "all");
		mv.addObject("servicesList", servicesService.findAll());
		return mv;

	}

	@RequestMapping(path = "/servicos/detalhes", method = RequestMethod.GET)
	public ModelAndView goServicosDetalhes() {
		return userAuthentication.getModelViewWithUser("servicosporprofissional");
	}

	@RequestMapping(path = "/servicos/promocoes", method = RequestMethod.GET)
	public ModelAndView goServicosPromocoes() {
		return userAuthentication.getModelViewWithUser("servicospromocoes");
	}

	@RequestMapping(path = "/salvarservico", method = RequestMethod.POST)
	public ModelAndView save(@Valid Services services, BindingResult result) {
		if (result.hasErrors()) {
		return addNewService(services);
		}			
		servicesService.save(services);
		return goServices();
	}
}
