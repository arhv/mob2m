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

import com.mob2m.hairdressing.model.dao.Cities;
import com.mob2m.hairdressing.model.dao.CompanySubsidiaries;
import com.mob2m.hairdressing.model.dao.States;
import com.mob2m.hairdressing.model.dao.Suppliers;
import com.mob2m.hairdressing.model.service.SelectTagLists;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CitiesService;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.StatesService;
import com.mob2m.hairdressing.service.SuppliersService;

@RestController
public class HairdressingControllerSuppliers {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private CitiesService citiesService;

	@Autowired
	private StatesService statesService;

	@Autowired
	private SuppliersService suppliersService;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesServices;

	@Autowired
	private SelectTagLists selectTagLists;

	@RequestMapping(path = "/adicionarfornecedor", method = RequestMethod.GET)
	public ModelAndView addNewSupplier(Suppliers suppliers) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("suppliers");
		List<States> listStates = statesService.findAll();
		int initState = 26;//iniciar combo com Cidades de SP
		int initCity = 9432;//iniciar combo com Cidade de Osasco
		List<Cities> listCitiesNames = citiesService.stateCode(initState);
		mv.addObject("cpfCnpjList", selectTagLists.getDisplayCpfCnpjSelection());
		mv.addObject("state", listStates);
		mv.addObject("stateSelected", initState);
		mv.addObject("city", listCitiesNames);
		mv.addObject("citySelected", initCity);
		mv.addObject("addSupplier", suppliers);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddSupplier", "none");
		mv.addObject("removeEditSupplier", "all");
		return mv;
	}

	@RequestMapping(path = "/fornecedores", method = RequestMethod.GET)
	public ModelAndView allSuppliers() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("suppliers");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddSupplier", "all");
		mv.addObject("removeEditSupplier", "all");
		mv.addObject("supplierList", suppliersService.findAll());

		return mv;
	}

	@RequestMapping(path = "/atualizarfornecedor/{id}", method = RequestMethod.GET)
	public ModelAndView goSuppliersDetails(@PathVariable("id") Long id) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("suppliers");
		List<CompanySubsidiaries> companySubsidiaryList = companySubsidiariesServices.findAll();
		Suppliers supplierList = suppliersService.findOne(id);
		int supplierState = supplierList.getSupplier_state_id();
		int supplierCity = supplierList.getSupplier_city_id();
		List<States> listStates = statesService.findAll();
		List<Cities> listCitiesNames = citiesService.stateCodeSubsidiaries(supplierState);
		if (supplierList.getCpf_cnpj_select() == "CNPJ") {
		mv.addObject("cpfCnpjList", selectTagLists.getDisplayCpfCnpjSelection());
		} else {
		mv.addObject("cpfCnpjList", selectTagLists.getDisplayCnpjCpfSelection());
		}
		mv.addObject("companySubsidiaryList", companySubsidiaryList);
		mv.addObject("state", listStates);
		mv.addObject("city", listCitiesNames);
		mv.addObject("stateSelected", supplierState);
		mv.addObject("citySelected", supplierCity);
		mv.addObject("editSupplier", supplierList);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddSupplier", "all");
		mv.addObject("removeEditSupplier", "none");
		return mv;
	}

	@RequestMapping(path = "/salvarfornecedor", method = RequestMethod.POST)
	public RedirectView saveSupplier(@Valid Suppliers suppliers, BindingResult result) {

		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}
		}
		suppliersService.save(suppliers);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/fornecedores");
		return rv;
		//return allSubsidiaries();
		//return "redirect:/unidades";
	}
}
