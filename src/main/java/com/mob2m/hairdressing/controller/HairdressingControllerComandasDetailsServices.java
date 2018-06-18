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

import com.mob2m.hairdressing.model.dao.ComandasDetailsServices;
import com.mob2m.hairdressing.model.dao.ComandasMaster;
import com.mob2m.hairdressing.model.dao.Services;
import com.mob2m.hairdressing.model.dao.User;
import com.mob2m.hairdressing.model.service.ComandasPayments;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.ComandasDetailsProductsUsageService;
import com.mob2m.hairdressing.service.ComandasDetailsService;
import com.mob2m.hairdressing.service.ComandasMasterService;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.ProfessionalsService;
import com.mob2m.hairdressing.service.ServicesService;
import com.mob2m.hairdressing.service.UserService;

@RestController
public class HairdressingControllerComandasDetailsServices {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@Autowired
	private ServicesService servicesService;

	@Autowired
	private ComandasDetailsService comandasDetailsService;

	@Autowired
	private ComandasDetailsProductsUsageService comandasDetailsProductsUsageService;

	@Autowired
	private ProfessionalsService professionalsService;

	@Autowired
	private ComandasMasterService comandasMasterService;

	@Autowired
	private ComandasPayments comandasPayments;

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/adicionarcomandadeservicos/{comandaId}/{customerName}", method = RequestMethod.GET)
	public ModelAndView addNewComandaDetailsServices(@PathVariable("comandaId") Long comandaId, @PathVariable("customerName") String customerName,
			ComandasDetailsServices comandasDetailsServices) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasdetailsservices");
		List<Services> listServices = servicesService.findAll();
		List<User> listProfessionals = userService.findAll();
		String cancelButton = "/adicionarservicosprodutosdecomanda/" + comandaId;
		ComandasMaster comandasMasterComandaId = comandasMasterService.findOne(comandaId);
		comandasDetailsServices.setComandasMaster(comandasMasterComandaId);
		mv.addObject("customerName", customerName);
		mv.addObject("comandaId", comandaId);
		mv.addObject("detailsComanda", cancelButton);
		mv.addObject("professionalList", listProfessionals);
		mv.addObject("serviceList", listServices);
		mv.addObject("addComandasDetailsServices", comandasDetailsServices);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasDetailsServices", "none");
		mv.addObject("removeEditComandasDetailsServices", "all");
		return mv;
	}

	@RequestMapping(path = "/adicionarservicosprodutosdecomanda/{id}", method = RequestMethod.GET)
	public ModelAndView addNewComandaServicesProducts(@PathVariable("id") Long id) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasdetailsservices");
		ComandasMaster comandasMasterCustomer = comandasMasterService.findOne(id);
		String customerName = comandasMasterCustomer.getCustomers().getCustomer_name();
		Long customerNameId = comandasMasterCustomer.getCustomers().getId();
		Long comandaId = comandasMasterCustomer.getId();
		mv.addObject("customerName", customerName);
		mv.addObject("customerNameId", customerNameId);
		mv.addObject("comandaId", comandaId);
		mv.addObject("sumAllcomandaId", comandasPayments.getSumDetailsServices(id));
		mv.addObject("sumAllcomandaIdProductUsage", comandasPayments.getSumDetailsProductsUsage(id));
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddComandasDetailsServices", "all");
		mv.addObject("removeEditComandasDetailsServices", "all");
		mv.addObject("comandasDetailsServicesList", comandasPayments.getComandasDetailsServicesListById(id));
		mv.addObject("comandasDetailsProductsUsageList", comandasPayments.getComandasDetailsProductsUsageListById(id));
		return mv;
	}

	@RequestMapping(path = "/editarcomandadeservicos/{id}/{customerName}/{comandaId}", method = RequestMethod.GET)
	public ModelAndView goDetailsComanda(@PathVariable("id") Long id, @PathVariable("customerName") String customerName,
			@PathVariable("comandaId") Long comandaId) {
		ComandasDetailsServices comandasDetailsServices = comandasDetailsService.findOne(id);
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasdetailsservices");
		List<Services> listServices = servicesService.findAll();
		List<User> listProfessionals = userService.findAll();

		String cancelButton = "/adicionarservicosprodutosdecomanda/" + comandaId;
		mv.addObject("customerName", customerName);
		mv.addObject("comandaId", comandaId);
		mv.addObject("detailsComanda", cancelButton);
		mv.addObject("serviceIdSelected", comandasDetailsServices.getServices().getId());
		mv.addObject("professionalPrincipalIdSelected", comandasDetailsServices.getProfessionals().getId());
		mv.addObject("professionalAux1IdSelected", comandasDetailsServices.getProfessionals1().getId());
		mv.addObject("professionalAux2IdSelected", comandasDetailsServices.getProfessionals2().getId());
		mv.addObject("professionalList", listProfessionals);
		mv.addObject("serviceList", listServices);
		mv.addObject("editComandasDetailsServices", comandasDetailsServices);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasDetailsServices", "all");
		mv.addObject("removeEditComandasDetailsServices", "none");

		return mv;
	}

	@RequestMapping(path = "/salvarcomandadeservicos", method = RequestMethod.POST)
	public RedirectView save(@Valid ComandasDetailsServices comandasDetailsServices, BindingResult result) {
		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}

		}		


		comandasDetailsService.save(comandasDetailsServices);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/comandasabertas");
		return rv;
	}


}
