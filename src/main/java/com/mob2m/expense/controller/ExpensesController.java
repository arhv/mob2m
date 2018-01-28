package com.mob2m.expense.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mob2m.expense.model.ExpensesModel;
import com.mob2m.expense.service.ExpensesService;

@Controller
public class ExpensesController {

	@Autowired
	private ExpensesService expensesService;

	//Get all expenses
	@GetMapping("/")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("expensesAll", expensesService.findAll());
		return mv;
	}

	//Add new expense
	@GetMapping("/add")
	public ModelAndView add(ExpensesModel expenseModel) {
		ModelAndView mv = new ModelAndView("/expenseAdd");
		mv.addObject("expenseAdd", expenseModel);
		return mv;
	}

	//Edit expense
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(expensesService.findOne(id));
	}

	//Delete expense
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		expensesService.delete(id);
		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid ExpensesModel expenseModel, BindingResult result) {
		if (result.hasErrors()) {
			return add(expenseModel);
		}
		expensesService.save(expenseModel);
		return findAll();
	}

}
