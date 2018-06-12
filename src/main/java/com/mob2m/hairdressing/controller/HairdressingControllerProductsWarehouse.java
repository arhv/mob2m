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
import com.mob2m.hairdressing.model.dao.ProductsWarehouse;
import com.mob2m.hairdressing.model.service.SelectTagLists;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.CompanySubsidiariesService;
import com.mob2m.hairdressing.service.ProductsService;
import com.mob2m.hairdressing.service.ProductsWarehouseService;

@RestController
public class HairdressingControllerProductsWarehouse {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private ProductsWarehouseService productsWarehouseService;

	@Autowired
	private ProductsService productsService;

	@Autowired
	private CompanySubsidiariesService companySubsidiariesService;

	@Autowired
	private SelectTagLists selectTagLists;

	@RequestMapping(path = "/adicionarcontroledeestoque", method = RequestMethod.GET)
	public ModelAndView addNewProductWarehouse(ProductsWarehouse productsWarehouse) {
		ModelAndView mv = userAuthentication.getModelViewWithUser("productswarehouse");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<Products> listProducts = productsService.findAll();
		mv.addObject("productGoal", selectTagLists.getDisplayProductGoal());
		mv.addObject("inOut", selectTagLists.getDisplayInOut());
		mv.addObject("productList", listProducts);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("addProductsWarehouse", productsWarehouse);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProductsWarehouse", "none");
		mv.addObject("removeEditProductsWarehouse", "all");
		return mv;
	}

	@RequestMapping(path = "/editarcontroledeestoque/{id}", method = RequestMethod.GET)
	public ModelAndView goDetailsProductsWarehouse(@PathVariable("id") Long id) {
		ProductsWarehouse productsWarehouse = productsWarehouseService.findOne(id);
		ModelAndView mv = userAuthentication.getModelViewWithUser("productswarehouse");
		List<CompanySubsidiaries> listCompanySubsidiaries = companySubsidiariesService.findAll();
		List<Products> listProducts = productsService.findAll();
		Long companyNameId = productsWarehouse.getCompanySubsidiaries().getId();
		Long productNameId = productsWarehouse.getProducts().getId();
		mv.addObject("productGoal", selectTagLists.getDisplayProductGoal());
		mv.addObject("inOut", selectTagLists.getDisplayInOut());
		mv.addObject("companyId", companyNameId);
		mv.addObject("productId", productNameId);
		mv.addObject("productList", listProducts);
		mv.addObject("companySubsidiaryList", listCompanySubsidiaries);
		mv.addObject("editProductsWarehouse", productsWarehouse);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProductsWarehouse", "all");
		mv.addObject("removeEditProductsWarehouse", "none");
		return mv;
	}

	@RequestMapping(path = "/controledeestoque", method = RequestMethod.GET)
	public ModelAndView goProductsWarehouse() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("productswarehouse");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddProductsWarehouse", "all");
		mv.addObject("removeEditProductsWarehouse", "all");
		mv.addObject("productsWarehouseList", productsWarehouseService.findAll());
		return mv;

	}

	@RequestMapping(path = "/salvarcontroledeestoque", method = RequestMethod.POST)
	public RedirectView save(@Valid ProductsWarehouse productsWarehouse, BindingResult result) {
		if (result.hasErrors()) {
		List<FieldError> errors = result.getFieldErrors();
		for (FieldError error : errors) {
		System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
		}

		}

		productsWarehouseService.save(productsWarehouse);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/controledeestoque");
		return rv;
	}


}
