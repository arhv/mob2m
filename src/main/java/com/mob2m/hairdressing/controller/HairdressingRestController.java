package com.mob2m.hairdressing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mob2m.hairdressing.model.Expenses;
import com.mob2m.hairdressing.service.ExpensesService;

@RestController
public class HairdressingRestController {

	@Autowired
	private ExpensesService expenseService;

	@RequestMapping(path = "/expensesAll", method = RequestMethod.GET)
	public List<Expenses> getAllExpenses() {
		return expenseService.findAll();
	}

}
