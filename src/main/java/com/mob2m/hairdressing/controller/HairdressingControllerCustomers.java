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

import com.mob2m.hairdressing.model.dao.Cities;
import com.mob2m.hairdressing.model.dao.Customers;
import com.mob2m.hairdressing.model.dao.States;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CitiesService;
import com.mob2m.hairdressing.service.CustomersService;
import com.mob2m.hairdressing.service.StatesService;
import com.mob2m.hairdressing.service.UserService;

@RestController
public class HairdressingControllerCustomers {

	@Autowired
	private UserService userService;

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private CustomersService customersService;

	@Autowired
	private CitiesService citiesService;

	@Autowired
	private StatesService statesService;


	public HairdressingControllerCustomers() {

	}

	@RequestMapping(path = "/adicionarcliente", method = RequestMethod.GET)
	public ModelAndView addNewCustomer(Customers customers) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("customers");
		List<States> listStates = statesService.findAll();
		int initState = 26;//iniciar combo com Cidades de SP
		List<Cities> listCitiesNames = citiesService.stateCode(initState);
		int initCity = 9432;//iniciar combo com Cidade de Osasco
		mv.addObject("state", listStates);
		mv.addObject("stateSelected", initState);
		mv.addObject("city", listCitiesNames);
		mv.addObject("citySelected", initCity);
		mv.addObject("addCustomer", customers);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddCustomer", "none");
		mv.addObject("removeEditCustomer", "all");
		return mv;

	}


	@RequestMapping(path = "/clientes", method = RequestMethod.GET)
	public ModelAndView goCustomers(Customers customers) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("customers");
		mv.addObject("customerList", customersService.findAll());
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddCustomer", "all");
		mv.addObject("removeEditCustomer", "all");
		return mv;

	}

	@RequestMapping(path = "/atualizarcliente/{id}", method = RequestMethod.GET)
	public ModelAndView goDetailsRoles(@PathVariable("id") Long id) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("customers");
		Customers listCustomers = customersService.findOne(id);
		List<States> listStates = statesService.findAll();
		//int initValue = 26;//iniciar combo com Cidades de SP
		int initValue = listCustomers.getState_name_id();//iniciar combo com Cidades de SP
		//List<Cities> listCitiesNames = citiesService.stateCode(initValue);
		List<Cities> listCitiesNames = citiesService.stateCode(initValue);
		mv.addObject("state", listStates);
		mv.addObject("city", listCitiesNames);
		mv.addObject("editCustomers", listCustomers);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddCustomer", "all");
		mv.addObject("removeEditCustomer", "none");
		return mv;
	}

	@RequestMapping(path = "/salvarcliente", method = RequestMethod.POST)
	public RedirectView saveUserRole(@Valid Customers customers, BindingResult result) {
		if (result.hasErrors()) {
		//return addNewUserRole(userRoles);
		}
		customersService.save(customers);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/clientes");
		return rv;

	}
}
