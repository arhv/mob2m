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

import com.mob2m.hairdressing.model.dao.ComandasDetailsProductsUsage;
import com.mob2m.hairdressing.model.dao.ComandasMaster;
import com.mob2m.hairdressing.model.dao.ProductsUsage;
import com.mob2m.hairdressing.model.dao.Professionals;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.ComandasDetailsProductsUsageService;
import com.mob2m.hairdressing.service.ComandasDetailsService;
import com.mob2m.hairdressing.service.ComandasMasterService;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.ProductsUsageService;
import com.mob2m.hairdressing.service.ProfessionalsService;
import com.mob2m.hairdressing.service.ServicesService;

@RestController
public class HairdressingControllerComandasDetailsProductsUsage {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@Autowired
	private ServicesService servicesService;

	@Autowired
	private ComandasDetailsService comandasDetailsService;

	@Autowired
	private ComandasDetailsProductsUsageService comandasDetailsSProductsUsageService;

	@Autowired
	private ProfessionalsService professionalsService;

	@Autowired
	private ComandasMasterService comandasMasterService;

	@Autowired
	private ProductsUsageService productsUsageService;

	@RequestMapping(path = "/adicionarcomandadeusodeproduto/{comandaId}/{customerName}", method = RequestMethod.GET)
	public ModelAndView addNewComandaDetailsProductsUsage(@PathVariable("comandaId") Long comandaId,
			@PathVariable("customerName") String customerName, ComandasDetailsProductsUsage comandasDetailsProductsUsage) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasdetailsproductsusage");
		List<ProductsUsage> listProductsUsage = productsUsageService.findAll();
		List<Professionals> listProfessionals = professionalsService.findAll();
		String cancelButton = "/adicionarservicosprodutosdecomanda/" + comandaId;
		ComandasMaster comandasMasterComandaId = comandasMasterService.findOne(comandaId);
		comandasDetailsProductsUsage.setComandasMaster(comandasMasterComandaId);
		mv.addObject("customerName", customerName);
		mv.addObject("comandaId", comandaId);
		mv.addObject("detailsComanda", cancelButton);
		mv.addObject("professionalList", listProfessionals);
		mv.addObject("productsUsageList", listProductsUsage);
		mv.addObject("addComandasDetailsProductsUsage", comandasDetailsProductsUsage);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasDetailsProductsUsage", "none");
		mv.addObject("removeEditComandasDetailsProductsUsage", "all");
		return mv;
	}



	@RequestMapping(path = "/editarcomandadeusodeproduto/{id}/{customerName}/{comandaId}", method = RequestMethod.GET)
	public ModelAndView goDetailsComandaProductsUsage(@PathVariable("id") Long id, @PathVariable("customerName") String customerName,
			@PathVariable("comandaId") Long comandaId) {
		ComandasDetailsProductsUsage comandasDetailsProductsUsage = comandasDetailsSProductsUsageService.findOne(id);
		ModelAndView mv = userAuthentication.getModelViewWithUser("comandasdetailsproductsusage");
		List<ProductsUsage> listProductsUsage = productsUsageService.findAll();
		List<Professionals> listProfessionals = professionalsService.findAll();
		//ComandasMaster comandasMasterCustomer = comandasMasterService.findOne(id);
		//String customerName = comandasMaster.getCustomers().getCustomer_name();
		//Long comandaId = comandasMaster.getId();
		//mv.addObject("customerName", customerName);
		//mv.addObject("comandaId", comandaId);
		String cancelButton = "/adicionarservicosprodutosdecomanda/" + comandaId;
		mv.addObject("customerName", customerName);
		mv.addObject("comandaId", comandaId);
		mv.addObject("detailsComandaProductsUsage", cancelButton);
		mv.addObject("productUsageIdSelected", comandasDetailsProductsUsage.getProductsUsage().getProducts().getId());
		mv.addObject("professionalPrincipalIdSelected", comandasDetailsProductsUsage.getProfessionals().getId());
		mv.addObject("professionalList", listProfessionals);
		mv.addObject("productsUsageList", listProductsUsage);
		mv.addObject("editComandasDetailsProductsUsage", comandasDetailsProductsUsage);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddComandasDetailsProductsUsage", "all");
		mv.addObject("removeEditComandasDetailsProductsUsage", "none");
		return mv;
	}

	@RequestMapping(path = "/salvarcomandadeusodeproduto", method = RequestMethod.POST)
	public RedirectView save(@Valid ComandasDetailsProductsUsage comandasDetailsProductsUsage, BindingResult result) {
		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}

		}

		comandasDetailsSProductsUsageService.save(comandasDetailsProductsUsage);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/comandasabertas");
		return rv;
	}


}
