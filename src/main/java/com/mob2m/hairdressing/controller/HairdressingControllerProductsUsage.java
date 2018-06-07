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
import com.mob2m.hairdressing.model.dao.ProductsUsage;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.ProductsService;
import com.mob2m.hairdressing.service.ProductsUsageService;

@RestController
public class HairdressingControllerProductsUsage {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private ProductsUsageService productsUsageService;

	@Autowired
	private ProductsService productsService;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@RequestMapping(path = "/adicionarconsumodeproduto", method = RequestMethod.GET)
	public ModelAndView addNewProductUsage(ProductsUsage productsUsage) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("productsusage");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<Products> listProducts = productsService.findAll();
		mv.addObject("productList", listProducts);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("addProductsUsage", productsUsage);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProductsUsage", "none");
		mv.addObject("removeEditProductsUsage", "all");
		return mv;
	}

	@RequestMapping(path = "/editarconsumodeproduto/{id}", method = RequestMethod.GET)
	public ModelAndView goDetailsProductsUsage(@PathVariable("id") Long id) {
		ProductsUsage productsUsage = productsUsageService.findOne(id);
		ModelAndView mv = userAuthentication.getModelViewWithUser("productsusage");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<Products> listProducts = productsService.findAll();
		Long companyNameId = productsUsage.getCompanySubsidiaries().getId();
		Long productNameId = productsUsage.getProducts().getId();
		mv.addObject("companyId", companyNameId);
		mv.addObject("productId", productNameId);
		mv.addObject("productList", listProducts);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("editProductsUsage", productsUsage);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProductsUsage", "all");
		mv.addObject("removeEditProductsUsage", "none");
		return mv;
	}



	@RequestMapping(path = "/consumodeprodutos", method = RequestMethod.GET)
	public ModelAndView goProductsUsage() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("productsusage");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddProductsUsage", "all");
		mv.addObject("removeEditProductsUsage", "all");
		mv.addObject("productsUsageList", productsUsageService.findAll());
		return mv;

	}

	@RequestMapping(path = "/salvarconsumodeproduto", method = RequestMethod.POST)
	public RedirectView save(@Valid ProductsUsage productsUsage, BindingResult result) {
		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}

		}

		productsUsageService.save(productsUsage);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/consumodeprodutos");
		return rv;
	}


}
