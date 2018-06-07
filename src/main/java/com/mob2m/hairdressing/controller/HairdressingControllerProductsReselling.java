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
import com.mob2m.hairdressing.model.dao.Products;
import com.mob2m.hairdressing.model.dao.ProductsReselling;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.ProductsResellingService;
import com.mob2m.hairdressing.service.ProductsService;

@RestController
public class HairdressingControllerProductsReselling {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private ProductsResellingService productsResellingService;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@Autowired
	private ProductsService productsService;

	@RequestMapping(path = "/adicionarrevenda", method = RequestMethod.GET)
	public ModelAndView addNewProductReselling(ProductsReselling productsReselling) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("productsreselling");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<Products> listProducts = productsService.findAll();
		mv.addObject("productList", listProducts);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("addProductsReselling", productsReselling);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProductsReselling", "none");
		mv.addObject("removeEditProductsReselling", "all");
		return mv;
	}

	@RequestMapping(path = "/editarrevenda/{id}", method = RequestMethod.GET)
	public ModelAndView goDetailsProductsReselling(@PathVariable("id") Long id) {
		ProductsReselling productsReselling = productsResellingService.findOne(id);
		Long companyNameId = productsReselling.getCompanySubsidiaries().getId();
		Long productNameId = productsReselling.getProducts().getId();
		ModelAndView mv = userAuthentication.getModelViewWithUser("productsreselling");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<Products> listProducts = productsService.findAll();
		mv.addObject("companyId", companyNameId);
		mv.addObject("productId", productNameId);
		mv.addObject("productList", listProducts);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("editProductsReselling", productsReselling);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProductsReselling", "all");
		mv.addObject("removeEditProductsReselling", "none");
		return mv;
	}



	@RequestMapping(path = "/revenda", method = RequestMethod.GET)
	public ModelAndView goProductsReselling() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("productsreselling");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddProductsReselling", "all");
		mv.addObject("removeEditProductsReselling", "all");
		mv.addObject("productsResellingList", productsResellingService.findAll());
		return mv;

	}

	@RequestMapping(path = "/salvarrevenda", method = RequestMethod.POST)
	public RedirectView save(@Valid ProductsReselling productsReselling, BindingResult result) {
		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}

		}

		productsResellingService.save(productsReselling);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/revenda");
		return rv;
	}


}
