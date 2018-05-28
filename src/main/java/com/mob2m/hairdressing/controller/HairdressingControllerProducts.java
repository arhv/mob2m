package com.mob2m.hairdressing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mob2m.hairdressing.model.dao.Products;
import com.mob2m.hairdressing.model.service.UserAuthentication;
import com.mob2m.hairdressing.service.ProductsService;

@RestController
public class HairdressingControllerProducts {

	@Autowired
	private UserAuthentication userAuthentication;

	@Autowired
	private ProductsService productsService;

	@RequestMapping(path = "/adicionarproduto", method = RequestMethod.GET)
	public ModelAndView addNewProduct(Products products) {		
		ModelAndView mv = userAuthentication.getModelViewWithUser("produtos");		
		mv.addObject("addProducts", products);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProducts", "none");
		mv.addObject("removeEditProducts", "all");
		return mv;
	}

	@RequestMapping(path = "/editarproduto/{id}", method = RequestMethod.GET)
	public ModelAndView goDetails(@PathVariable("id") Long id) {
		Products products = productsService.findOne(id);		
		ModelAndView mv = userAuthentication.getModelViewWithUser("produtos");		
		mv.addObject("editProducts", products);
		mv.addObject("removeFindAll", "all");
		mv.addObject("removeAddProducts", "all");
		mv.addObject("removeEditProducts", "none");
		return mv;
	}

	@RequestMapping(path = "/detalhesprodutos/{id}", method = RequestMethod.GET)
	public ModelAndView goProductDetails() {
		return userAuthentication.getModelViewWithUser("produtos");
	}

	@RequestMapping(path = "/produtos", method = RequestMethod.GET)
	public ModelAndView goProducts() {
		ModelAndView mv = userAuthentication.getModelViewWithUser("produtos");
		mv.addObject("removeFindAll", "none");
		mv.addObject("removeAddProducts", "all");
		mv.addObject("removeEditProducts", "all");
		mv.addObject("productsList", productsService.findAll());
		return mv;

	}

	@RequestMapping(path = "${url.produtos.estoque}", method = RequestMethod.GET)
	public ModelAndView goProductsSales() {
		return userAuthentication.getModelViewWithUser("produtosestoque");
	}

	@RequestMapping(path = "/detalhesinsumos", method = RequestMethod.GET)
	public ModelAndView goProductsUsage() {
		return userAuthentication.getModelViewWithUser("produtosdetalhes");
	}

	@RequestMapping(path = "/salvarproduto", method = RequestMethod.GET)
	public RedirectView save(@Valid Products products, BindingResult result) {
		if (result.hasErrors()) {
		//return addNewProduct(products);
		}
		productsService.save(products);
		RedirectView rv = new RedirectView();
		rv.setContextRelative(true);
		rv.setUrl("/produtos");
		return rv;
		//return goServices();
	}


}
