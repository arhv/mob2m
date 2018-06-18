package com.mob2m.hairdressing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mob2m.hairdressing.model.dao.ComandasExpensesServices;
import com.mob2m.hairdressing.repository.ExpensesRepository;

@Service
public class ExpensesService {

	@Autowired
	private ExpensesRepository expensesRepository;

	//Delete an expense
	public void delete(Long id) {
		expensesRepository.delete(id);
	}

	//All expenses
	public List<ComandasExpensesServices> findAll() {
		return expensesRepository.findAll();
	}

	//Query specific ID
	public ComandasExpensesServices findOne(Long id) {
		return expensesRepository.findOne(id);
	}

	//Add new or updated an expense 
	public ComandasExpensesServices save(ComandasExpensesServices expenseData) {
		return expensesRepository.saveAndFlush(expenseData);
	}

}
